package com.example.forgot_password.screen

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.core.common.base.BaseFragment
import com.core.common.extension.DeepLinkDestination
import com.core.common.extension.deepLinkNavigateTo
import com.example.forgot_password.databinding.FragmentForgotPasswordBinding
import com.example.forgot_password.event.ForgotPasswordEvent
import com.example.forgot_password.extension.showSnackBar
import com.example.forgot_password.state.ForgotPasswordState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ForgotPasswordFragment :
    BaseFragment<FragmentForgotPasswordBinding>(FragmentForgotPasswordBinding::inflate) {

    private val viewModel: ForgotPasswordViewModel by viewModels()

    override fun bind() {}

    override fun bindViewActionListeners() {
        binding.apply {
            sendCodeBtn.setOnClickListener {
                viewModel.onEvent(ForgotPasswordEvent.ForgotPassword(emailEt.text.toString()))
            }

            backBtn.setOnClickListener {
                viewModel.onEvent(ForgotPasswordEvent.OnItemClick)
            }

            dontHaveAccTv.setOnClickListener {
                viewModel.onEvent(ForgotPasswordEvent.OnItemClick)
            }
        }

    }

    override fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.forgotPasswordState.collect {
                    handleForgotPasswordState(state = it)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiEvent.collect {
                    handleNavigationEvents(event = it)
                }
            }
        }
    }

    private fun handleForgotPasswordState(state: ForgotPasswordState) = binding.apply {
        progress.visibility =
            if (state.isLoading) View.VISIBLE else View.GONE

        state.errorMessage?.let {
            root.showSnackBar(message = it)
            viewModel.onEvent(ForgotPasswordEvent.ResetErrorMessage)
        }
    }

    private fun handleNavigationEvents(event: ForgotPasswordViewModel.ForgotPasswordUiEvent) {
        when (event) {
            ForgotPasswordViewModel.ForgotPasswordUiEvent.NavigateToLogin -> findNavController().popBackStack()
        }
    }
}