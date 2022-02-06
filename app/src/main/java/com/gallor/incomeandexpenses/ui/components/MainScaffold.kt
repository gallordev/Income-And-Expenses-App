package com.gallor.incomeandexpenses.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.gallor.incomeandexpenses.ui.theme.IncomeAndExpensesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    content: @Composable () -> Unit
) {
    IncomeAndExpensesTheme {
        NavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                MainDrawer()
            },
            content = content
        )
    }
}