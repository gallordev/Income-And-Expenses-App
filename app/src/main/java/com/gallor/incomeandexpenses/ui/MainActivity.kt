package com.gallor.incomeandexpenses.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.gallor.incomeandexpenses.ui.account.AccountListScreen
import com.gallor.incomeandexpenses.ui.theme.IncomeAndExpensesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IncomeAndExpensesTheme {
                // A surface container using the 'background' color from the theme
                AccountListScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IncomeAndExpensesTheme {
        Greeting("Android")
    }
}