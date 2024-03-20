package com.feature.upcoming_matches.screen

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.core.common.base.BaseFragment
import com.core.common.extension.showSnackbar
import com.feature.upcoming_matches.databinding.FragmentUpcomingMatchesBinding
import com.feature.upcoming_matches.event.UpcomingMatchesEvent
import com.feature.upcoming_matches.state.UpcomingMatchesState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UpcomingMatchesFragment :
    BaseFragment<FragmentUpcomingMatchesBinding>(FragmentUpcomingMatchesBinding::inflate) {

    private val viewModel: UpcomingMatchesViewModel by viewModels()
    private val rvUpcomingMatchesAdapter by lazy { UpcomingMatchesRecyclerAdapter() }

    override fun bind() {
        setUpRecycler()

    }

    override fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.upcomingMatchesState.collect {
                    handleUpcomingMatchesState(it)
                }
            }
        }
    }


    private fun handleUpcomingMatchesState(state: UpcomingMatchesState) = with(binding) {
        progressBar.isVisible = state.isLoading

        state.upcomingMatches.let {
            rvUpcomingMatchesAdapter.submitList(it)
        }

        state.errorMessage?.let {
            root.showSnackbar(message = it)
            viewModel.onEvent(UpcomingMatchesEvent.ResetErrorMessage)
        }
    }

    private fun setUpRecycler() = with(binding) {
        rvUpcomingMatches.adapter = rvUpcomingMatchesAdapter
        viewModel.onEvent(UpcomingMatchesEvent.FetchUpcomingMatches)
    }
}