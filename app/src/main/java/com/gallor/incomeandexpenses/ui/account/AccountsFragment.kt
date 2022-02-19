package com.gallor.incomeandexpenses.ui.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import com.gallor.incomeandexpenses.R
import com.gallor.incomeandexpenses.ui.components.TextFieldWithValidation
import com.gallor.incomeandexpenses.ui.theme.IncomeAndExpensesTheme
import com.gallor.incomeandexpenses.ui.utils.DropdownMenu
import com.gallor.incomeandexpenses.ui.utils.LocalBackPressedDispatcher
import com.gallor.incomeandexpenses.ui.utils.TextFieldState
import com.google.accompanist.insets.ExperimentalAnimatedInsets
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ViewWindowInsetObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountsFragment : Fragment() {

    private val viewModel by viewModels<AccountListViewModel>()

    @OptIn(
        ExperimentalAnimatedInsets::class,
        androidx.compose.material.ExperimentalMaterialApi::class
    )
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
//                    AccountListScreen(onNavigationEvent = { event ->
//                        when (event) {
//                            is AccountListEvent.AddAccount -> {
//
//                            }
//                            AccountListEvent.DeleteAccount -> {
//
//                            }
//                            AccountListEvent.EditAccount -> {
//
//                            }
//                            AccountListEvent.NavigateBack -> {
//
//                            }
//                        }
//                    })

                    Column(modifier = Modifier.fillMaxSize()) {
                        Surface {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 16.dp)
                            ) {
                                TextFieldWithValidation(R.string.label_account_name)
                                TextFieldWithValidation(R.string.label_description)
                                DropdownMenu(R.string.label_currency)
                                "Balance"
                            }
                        }
                    }

                }
            }
        }
    }
}