package com.gallor.incomeandexpenses.ui.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import com.gallor.incomeandexpenses.R
import com.gallor.incomeandexpenses.ui.theme.IncomeAndExpensesTheme
import com.gallor.incomeandexpenses.ui.utils.LocalBackPressedDispatcher
import com.google.accompanist.insets.ExperimentalAnimatedInsets
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ViewWindowInsetObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountsFragment : Fragment() {

    private val viewModel by viewModels<AccountListViewModel>()

    @OptIn(ExperimentalAnimatedInsets::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(inflater.context).apply {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        val windowInsets = ViewWindowInsetObserver(this)
            .start(windowInsetsAnimationsEnabled = true)
        setContent {
            CompositionLocalProvider(
                LocalBackPressedDispatcher provides requireActivity().onBackPressedDispatcher,
                LocalWindowInsets provides windowInsets,
            ) {
                IncomeAndExpensesTheme {
                    AccountListScreen(viewModel)
                }
            }
        }
    }
}