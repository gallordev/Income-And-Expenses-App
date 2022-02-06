package com.gallor.incomeandexpenses.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.gallor.incomeandexpenses.R
import com.gallor.incomeandexpenses.databinding.ContentMainBinding
import com.gallor.incomeandexpenses.ui.account.AccountListScreen
import com.gallor.incomeandexpenses.ui.components.MainScaffold
import com.gallor.incomeandexpenses.ui.theme.IncomeAndExpensesTheme
import com.gallor.incomeandexpenses.ui.utils.BackPressHandler
import com.gallor.incomeandexpenses.ui.utils.LocalBackPressedDispatcher
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ProvideWindowInsets(consumeWindowInsets = false) {
                CompositionLocalProvider(
                    LocalBackPressedDispatcher provides this.onBackPressedDispatcher
                ) {
                    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                    val drawerOpen by viewModel.drawerShouldBeOpened.collectAsState()

                    if (drawerOpen) {
                        LaunchedEffect(Unit) {
                            drawerState.open()
                            viewModel.resetOpenDrawerAction()
                        }
                    }

                    val scope = rememberCoroutineScope()
                    if (drawerState.isOpen) {
                        BackPressHandler {
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    }
                    
                    MainScaffold(
                        drawerState = drawerState
                    ) {
                        AndroidViewBinding(ContentMainBinding::inflate)
                    }


                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController().navigateUp() || super.onSupportNavigateUp()
    }

    private fun findNavController(): NavController {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        return navHostFragment.navController
    }

}
