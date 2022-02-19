package com.gallor.incomeandexpenses.ui.account

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ramcosta.composedestinations.annotation.Destination

sealed class AccountListEvent {
    data class AddAccount(val email: String, val password: String) : AccountListEvent()
    object EditAccount : AccountListEvent()
    object DeleteAccount : AccountListEvent()
    object NavigateBack : AccountListEvent()
}

@Composable
fun AccountListScreen(
    onNavigationEvent: (AccountListEvent) -> Unit
) {

    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
//            items(accounts.value) { account ->
//                AccountItem(
//                    account = account,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(16.dp)
//                )
//            }
        }
    }
}