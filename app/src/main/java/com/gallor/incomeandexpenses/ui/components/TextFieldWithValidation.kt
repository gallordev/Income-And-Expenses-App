package com.gallor.incomeandexpenses.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gallor.incomeandexpenses.R
import com.gallor.incomeandexpenses.ui.theme.IncomeAndExpensesTheme
import com.gallor.incomeandexpenses.ui.utils.TextFieldState
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun myNeatColors(
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    disabledTextColor: Color = textColor.copy(ContentAlpha.disabled),
    backgroundColor: Color = Color.Transparent,
    cursorColor: Color = MaterialTheme.colorScheme.primary,
    errorCursorColor: Color = MaterialTheme.colorScheme.error,
    focusedBorderColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = ContentAlpha.high),
    unfocusedBorderColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.disabled),
    disabledBorderColor: Color = unfocusedBorderColor.copy(alpha = ContentAlpha.disabled),
    errorBorderColor: Color = MaterialTheme.colorScheme.error,
    leadingIconColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = TextFieldDefaults.IconOpacity),
    disabledLeadingIconColor: Color = leadingIconColor.copy(alpha = ContentAlpha.disabled),
    errorLeadingIconColor: Color = leadingIconColor,
    trailingIconColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = TextFieldDefaults.IconOpacity),
    disabledTrailingIconColor: Color = trailingIconColor.copy(alpha = ContentAlpha.disabled),
    errorTrailingIconColor: Color = MaterialTheme.colorScheme.error,
    focusedLabelColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = ContentAlpha.high),
    unfocusedLabelColor: Color = MaterialTheme.colorScheme.onSurface.copy(ContentAlpha.medium),
    disabledLabelColor: Color = unfocusedLabelColor.copy(ContentAlpha.disabled),
    errorLabelColor: Color = MaterialTheme.colorScheme.error,
    placeholderColor: Color = MaterialTheme.colorScheme.onSurface.copy(ContentAlpha.medium),
    disabledPlaceholderColor: Color = placeholderColor.copy(ContentAlpha.disabled)
) = TextFieldDefaults.outlinedTextFieldColors(
    textColor = textColor,
    disabledTextColor = disabledTextColor,
    backgroundColor = backgroundColor,
    cursorColor = cursorColor,
    errorCursorColor = errorCursorColor,
    focusedBorderColor = focusedBorderColor,
    unfocusedBorderColor = unfocusedBorderColor,
    disabledBorderColor = disabledBorderColor,
    errorBorderColor = errorBorderColor,
    leadingIconColor = leadingIconColor,
    disabledLeadingIconColor = disabledLeadingIconColor,
    errorLeadingIconColor = errorLeadingIconColor,
    trailingIconColor = trailingIconColor,
    disabledTrailingIconColor = disabledTrailingIconColor,
    errorTrailingIconColor = errorTrailingIconColor,
    focusedLabelColor = focusedLabelColor,
    unfocusedLabelColor = unfocusedLabelColor,
    disabledLabelColor = disabledLabelColor,
    errorLabelColor = errorLabelColor,
    placeholderColor = placeholderColor,
    disabledPlaceholderColor = disabledPlaceholderColor
)

@Composable
fun TextFieldWithValidation(
    labelStringRes: Int? = null,
    textFieldState: TextFieldState = remember { TextFieldState(validator = ::basicValidation) },
    imeAction: ImeAction = ImeAction.Next,
    maxLines: Int = 1,
    onImeAction: () -> Unit = {}
) {
    OutlinedTextField(
        value = textFieldState.text,
        onValueChange = { textFieldState.text = it },
        maxLines = maxLines,
        leadingIcon = { Icon(Icons.Filled.EuroSymbol, null)},
        colors = myNeatColors(),
        label = {
//            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = labelStringRes?.let { stringResource(id = it) } ?: "",
                    style = MaterialTheme.typography.bodyMedium
                )
//            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .onFocusChanged { focusState ->
                textFieldState.onFocusChange(focusState.isFocused)
                if (!focusState.isFocused) {
                    textFieldState.enableShowErrors()
                }
            },
        textStyle = MaterialTheme.typography.bodyLarge,
        isError = textFieldState.showErrors(),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = imeAction),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
            }
        )
    )
    textFieldState.getError()?.let { error -> TextFieldError(textError = error) }

}

private fun basicValidation(value: String) = value.isNotBlank()

@Composable
fun TextFieldError(textError: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = textError,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.error
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun NewAccountScreenPreview() {

    ProvideWindowInsets(consumeWindowInsets = false) {
        IncomeAndExpensesTheme {
            Column(modifier = Modifier.fillMaxSize()) {
                Surface {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp)
                    ) {
                        TextFieldWithValidation(
                            labelStringRes = R.string.label_account_name,
                            textFieldState = remember {
                                TextFieldState(validator = ::basicValidation).apply {
                                    text = "Conejo"
                                }
                            }
                        )
                        TextFieldWithValidation(labelStringRes = R.string.label_account_name)
                        val options =
                            listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
                        var expanded by remember { mutableStateOf(false) }
                        var selectedOptionText by remember { mutableStateOf(options[0]) }
                        ExposedDropdownMenuBox(
                            expanded = expanded,
                            onExpandedChange = { expanded = !expanded }
                        ) {
                            TextField(
                                readOnly = true,
                                value = selectedOptionText,
                                onValueChange = { },
                                label = { Text("Label") },
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(
                                        expanded = expanded
                                    )
                                },
                                colors = ExposedDropdownMenuDefaults.textFieldColors()
                            )
                        }
                    }
                }
            }

        }
    }

}


//@Composable
//fun textFieldColors(
//    textColor: Color = LocalContentColor.current.copy(LocalContentAlpha.current),
//    disabledTextColor: Color = textColor.copy(ContentAlpha.disabled),
//    backgroundColor: Color =
//        MaterialTheme.colorScheme.onSurface.copy(alpha = TextFieldDefaults.BackgroundOpacity),
//    cursorColor: Color = MaterialTheme.colorScheme.primary,
//    errorCursorColor: Color = MaterialTheme.colorScheme.error,
//    focusedIndicatorColor: Color =
//        MaterialTheme.colorScheme.primary.copy(alpha = ContentAlpha.high),
//    unfocusedIndicatorColor: Color =
//        MaterialTheme.colorScheme.onSurface.copy(
//            alpha = TextFieldDefaults.UnfocusedIndicatorLineOpacity
//        ),
//    disabledIndicatorColor: Color = unfocusedIndicatorColor.copy(alpha = ContentAlpha.disabled),
//    errorIndicatorColor: Color = MaterialTheme.colorScheme.error,
//    leadingIconColor: Color =
//        MaterialTheme.colorScheme.onSurface.copy(alpha = TextFieldDefaults.IconOpacity),
//    disabledLeadingIconColor: Color = leadingIconColor.copy(alpha = ContentAlpha.disabled),
//    errorLeadingIconColor: Color = leadingIconColor,
//    trailingIconColor: Color =
//        MaterialTheme.colorScheme.onSurface.copy(alpha = TextFieldDefaults.IconOpacity),
//    focusedTrailingIconColor: Color =
//        MaterialTheme.colorScheme.primary.copy(alpha = ContentAlpha.high),
//    disabledTrailingIconColor: Color = trailingIconColor.copy(alpha = ContentAlpha.disabled),
//    errorTrailingIconColor: Color = MaterialTheme.colorScheme.error,
//    focusedLabelColor: Color =
//        MaterialTheme.colorScheme.primary.copy(alpha = ContentAlpha.high),
//    unfocusedLabelColor: Color = MaterialTheme.colorScheme.onSurface.copy(ContentAlpha.medium),
//    disabledLabelColor: Color = unfocusedLabelColor.copy(ContentAlpha.disabled),
//    errorLabelColor: Color = MaterialTheme.colorScheme.error,
//    placeholderColor: Color = MaterialTheme.colorScheme.onSurface.copy(ContentAlpha.medium),
//    disabledPlaceholderColor: Color = placeholderColor.copy(ContentAlpha.disabled)
//): TextFieldDefaults.text


