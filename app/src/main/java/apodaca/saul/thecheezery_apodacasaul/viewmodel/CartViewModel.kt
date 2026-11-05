package apodaca.saul.thecheezery_apodacasaul.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import apodaca.saul.thecheezery_apodacasaul.model.domain.Product

class CartViewModel : ViewModel() {
    var cartItems by mutableStateOf<List<Product>>(emptyList())
        private set

    val totalAmount: Double
        get() = cartItems.sumOf { it.price }

    fun addProduct(product: Product) {
        if (product.isAvailable) {
            cartItems = cartItems + product
        }
    }

    fun removeProduct(product: Product) {
        val index = cartItems.indexOf(product)
        if (index != -1) {
            cartItems = cartItems.toMutableList().apply { removeAt(index) }
        }
    }
}
