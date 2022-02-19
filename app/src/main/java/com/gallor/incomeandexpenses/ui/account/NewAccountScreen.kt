package com.gallor.incomeandexpenses.ui.account

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.gallor.incomeandexpenses.R
import com.gallor.incomeandexpenses.ui.theme.IncomeAndExpensesTheme
import com.gallor.incomeandexpenses.ui.utils.TextFieldState
import java.util.regex.Pattern

@Composable
fun NewAccountScreen() {
    val textFieldState = remember { TextFieldState() }
    val focusRequester = remember { FocusRequester() }
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = textFieldState.text,
            onValueChange = { textFieldState.text = it },
            label = {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = stringResource(id = R.string.label_account_name),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    textFieldState.onFocusChange(focusState.isFocused)
                    if (!focusState.isFocused) {
                        textFieldState.enableShowErrors()
                    }
                },
            textStyle = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
@Preview
fun NewAccountScreenPreview() {
    IncomeAndExpensesTheme {
        NewAccountScreen()
    }
}

