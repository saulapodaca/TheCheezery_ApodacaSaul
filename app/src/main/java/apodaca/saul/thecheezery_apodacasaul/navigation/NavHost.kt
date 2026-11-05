package apodaca.saul.thecheezery_apodacasaul.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import apodaca.saul.thecheezery_apodacasaul.model.data.coldDrinks
import apodaca.saul.thecheezery_apodacasaul.model.data.hotDrinks
import apodaca.saul.thecheezery_apodacasaul.model.data.salties
import apodaca.saul.thecheezery_apodacasaul.model.data.sweets
import apodaca.saul.thecheezery_apodacasaul.views.screens.CartScreen
import apodaca.saul.thecheezery_apodacasaul.views.screens.LoginScreen
import apodaca.saul.thecheezery_apodacasaul.views.screens.MenuScreen
import apodaca.saul.thecheezery_apodacasaul.views.screens.ProductsScreen
import apodaca.saul.thecheezery_apodacasaul.views.screens.WelcomeScreen
import apodaca.saul.thecheezery_apodacasaul.viewmodel.UserViewModel
import apodaca.saul.thecheezery_apodacasaul.viewmodel.CartViewModel

@Composable
fun MyApp(
    innerPadding: PaddingValues,
    userViewModel: UserViewModel = viewModel(),
    cartViewModel: CartViewModel = viewModel()
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Welcome) {
        composable<Welcome> {
            WelcomeScreen(
                innerPadding = innerPadding,
                onGetStarted = { navController.navigate(Login) { launchSingleTop = true } }
            )
        }

        composable<Login> {
            LoginScreen(
                innerPadding = innerPadding,
                email = userViewModel.email,
                emailError = userViewModel.emailError,
                passwordError = userViewModel.passwordError,
                loginError = userViewModel.loginError,
                onEmailChange = userViewModel::onEmailChange,
                onLoginClick = { password ->
                    if (userViewModel.login(password)) {
                        navController.navigate(Menu) {
                            popUpTo<Welcome> { inclusive = true }
                            launchSingleTop = true
                        }
                    }
                }
            )
        }

        composable<Menu> {
            MenuScreen(
                innerPadding = innerPadding,
                onCartClick = { navController.navigate(Cart) { launchSingleTop = true } },
                onCategoryClick = { category ->
                    when (category) {
                        "Hot drinks", "Cold drinks", "Salties", "Sweets" ->
                            navController.navigate(Products(category)) { launchSingleTop = true }
                    }
                }
            )
        }

        composable<Products> { backStackEntry ->
            val category = backStackEntry.toRoute<Products>().category
            val products = when (category) {
                "Hot drinks" -> hotDrinks
                "Cold drinks" -> coldDrinks
                "Salties" -> salties
                "Sweets" -> sweets
                else -> emptyList()
            }
            ProductsScreen(
                innerPadding = innerPadding,
                title = category,
                products = products,
                onAddToCart = cartViewModel::addProduct
            )
        }

        composable<Cart> {
            Box(modifier = Modifier.padding(innerPadding)) {
                CartScreen(
                    cartItems = cartViewModel.cartItems,
                    totalAmount = cartViewModel.totalAmount,
                    onRemoveItem = cartViewModel::removeProduct
                )
            }
        }
    }
}

