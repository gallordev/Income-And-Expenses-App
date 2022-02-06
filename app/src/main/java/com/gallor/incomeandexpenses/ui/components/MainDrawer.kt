package com.gallor.incomeandexpenses.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.ColumnInfo
import com.gallor.incomeandexpenses.R
import com.gallor.incomeandexpenses.ui.theme.IncomeAndExpensesTheme
import com.google.accompanist.insets.statusBarsHeight

@Composable
fun ColumnScope.MainDrawer() {
    Spacer(Modifier.statusBarsHeight())
    DrawerHeader()
    DividerItem()
    DrawerItemHeader("Main")
    DrawerItem("Accounts", true)
    DrawerItem("Operations", false)
}

@Composable
private fun DrawerHeader() {
    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
        AppIcon(
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Text(
            "Income And Expenses",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
    }
}

@Composable
fun DividerItem(modifier: Modifier = Modifier) {
    Divider(
        modifier = modifier,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
    )
}

@Composable
private fun DrawerItemHeader(text: String) {
    Box(
        modifier = Modifier
            .heightIn(min = 52.dp)
            .padding(horizontal = 28.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun DrawerItem(text: String, selected: Boolean) {
    val background = if (selected) {
        Modifier.background(MaterialTheme.colorScheme.primaryContainer)
    } else {
        Modifier
    }
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .clip(CircleShape)
            .then(background),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val iconTint = if (selected) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.onSurfaceVariant
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_app),
            tint = iconTint,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
            contentDescription = null
        )
        Text(
            text,
            style = MaterialTheme.typography.bodyMedium,
            color = if (selected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurface
            },
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}

@Composable
@Preview
fun DrawerPreview() {
    IncomeAndExpensesTheme() {
        Surface {
            Column {
                MainDrawer()
            }
        }
    }
}

@Composable
@Preview
fun DrawerPreviewDark() {
    IncomeAndExpensesTheme(useDarkTheme = true) {
        Surface {
            Column {
                MainDrawer()
            }
        }
    }
}