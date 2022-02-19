package com.gallor.incomeandexpenses.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.gallor.incomeandexpenses.ui.components.myNeatColors

open class DropdownMenuState(
    val optionList: List<String>
) {
    var isExpanded: Boolean by mutableStateOf(false)
        private set

    var selectedOptionText: String by mutableStateOf("")
        private set

    fun onExpandedChange() {
        isExpanded = !isExpanded
    }

    fun onExpandedChange(value: Boolean) {
        isExpanded = value
    }

    fun setSelectedOption(value: String){
        selectedOptionText = value
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropdownMenu(
    labelStringRes: Int? = null,
    dropdownMenuState: DropdownMenuState= remember {
        DropdownMenuState(listOf("Option 1", "Option 2"))
    },
    onValueChange: (String) -> Unit = {}
) {
    ExposedDropdownMenuBox(
        expanded = dropdownMenuState.isExpanded,
        onExpandedChange = { dropdownMenuState.onExpandedChange() }
    ) {
        OutlinedTextField(
            readOnly = true,
            value = dropdownMenuState.selectedOptionText,
            onValueChange = onValueChange,
            maxLines = 1,
            leadingIcon = { androidx.compose.material3.Icon(Icons.Filled.AttachMoney, null) },
            label = {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = labelStringRes?.let { stringResource(id = it) } ?: "dasdasddsada",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = dropdownMenuState.isExpanded
                )
            },
            colors = myNeatColors(),
            modifier = Modifier.fillMaxWidth()
        )
        ExposedDropdownMenu(
            expanded = dropdownMenuState.isExpanded,
            onDismissRequest = {
                dropdownMenuState.onExpandedChange(false)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            dropdownMenuState.optionList.forEach { selectedOption ->
                DropdownMenuItem(
                    onClick = {
                        dropdownMenuState.setSelectedOption(selectedOption)
                        dropdownMenuState.onExpandedChange(false)
                    }
                ) {
                    Text(text = selectedOption, color = MaterialTheme.colorScheme.onSurface)
                }
            }
        }
    }
}

//                                ExposedDropdownMenuBox(
//                                    expanded = expanded,
//                                    onExpandedChange = { expanded = !expanded },
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                ) {
//                                    OutlinedTextField(
//                                        readOnly = true,
//                                        value = selectedOptionText,
//                                        onValueChange = { },
//                                        label = {
//                                            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
//                                                Text(
//                                                    text = "Label",
//                                                    style = MaterialTheme.typography.bodyMedium
//                                                )
//                                            }
//                                        },
//                                        trailingIcon = {
//                                            ExposedDropdownMenuDefaults.TrailingIcon(
//                                                expanded = expanded
//                                            )
//                                        },
//                                        colors = ExposedDropdownMenuDefaults.textFieldColors(),
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                    )
//                                    ExposedDropdownMenu(
//                                        expanded = expanded,
//                                        onDismissRequest = {
//                                            expanded = false
//                                        },
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//
//                                    ) {
//                                        options.forEach { selectionOption ->
//                                            DropdownMenuItem(
//                                                onClick = {
//                                                    selectedOptionText = selectionOption
//                                                    expanded = false
//                                                },
//
//                                                modifier = Modifier
//                                                    .fillMaxWidth()
//                                            ) {
//                                                Text(text = selectionOption, modifier = Modifier
//                                                    .fillMaxWidth())
//                                            }
//                                        }
//                                    }
//                                }


//open class TextFieldState(
//    private val validator: (String) -> Boolean = { true },
//    private val errorFor: (String) -> String = { "Invalid Input" }
//) {
//    var text: String by mutableStateOf("")
//    // was the TextField ever focused
//    var isFocusedDirty: Boolean by mutableStateOf(false)
//    var isFocused: Boolean by mutableStateOf(false)
//    private var displayErrors: Boolean by mutableStateOf(false)
//
//    open val isValid: Boolean
//        get() = validator(text)
//
//    fun onFocusChange(focused: Boolean) {
//        isFocused = focused
//        if (focused) isFocusedDirty = true
//    }
//
//    fun enableShowErrors() {
//        // only show errors if the text was at least once focused
//        if (isFocusedDirty) {
//            displayErrors = true
//        }
//    }
//
//    fun showErrors() = !isValid && displayErrors
//
//    open fun getError(): String? {
//        return if (showErrors()) {
//            errorFor(text)
//        } else {
//            null
//        }
//    }
//}