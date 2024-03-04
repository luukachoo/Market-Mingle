package com.feature.live_matches.screen

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.core.common.base.BaseFragment
import com.core.common.extension.showSnackbar
import com.feature.live_matches.databinding.FragmentLivesBinding
import com.feature.live_matches.event.LivesFragmentEvent
import com.feature.live_matches.state.LiveState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LivesFragment : BaseFragment<FragmentLivesBinding>(FragmentLivesBinding::inflate) {

    private val viewModel: LivesFragmentViewModel by viewModels()
    private val livesAdapter by lazy { LivesRecyclerAdapter() }

    override fun bind() {
        setUpRecycler()
    }

    override fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.liveState.collect {
                    handleLiveState(it)
                }
            }
        }
    }


    override fun bindViewActionListeners() {
        super.bindViewActionListeners()
    }

    private fun handleLiveState(state: LiveState) = with(binding) {
        progressBar.isVisible = state.isLoading

        state.liveMatches?.let {
            livesAdapter.submitList(it)
        }

        state.errorMessage?.let {
            root.showSnackbar(message = it)
            viewModel.onEvent(LivesFragmentEvent.ResetErrorMessage)
        }
    }


    private fun setUpRecycler() = with(binding) {
        rvMatches.adapter = livesAdapter
        viewModel.onEvent(LivesFragmentEvent.FetchLiveMatches)
    }

}