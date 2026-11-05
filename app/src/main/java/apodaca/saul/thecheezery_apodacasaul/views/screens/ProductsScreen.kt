package apodaca.saul.thecheezery_apodacasaul.views.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import apodaca.saul.thecheezery_apodacasaul.R
import apodaca.saul.thecheezery_apodacasaul.model.data.salties
import apodaca.saul.thecheezery_apodacasaul.model.domain.Product
import apodaca.saul.thecheezery_apodacasaul.ui.theme.HelloBunny
import apodaca.saul.thecheezery_apodacasaul.ui.theme.Pinky
import apodaca.saul.thecheezery_apodacasaul.views.components.ProductItem

@Composable
fun ProductsScreen(
    innerPadding: PaddingValues,
    title: String,
    products: List<Product>,
    onAddToCart: (Product) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .padding(innerPadding)
            .padding(25.dp)
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title,
                    fontFamily = HelloBunny,
                    fontSize = 90.sp,
                    color = Pinky,
                    textAlign = TextAlign.Center
                )
            }
        }
        // Dynamic product list
        items(products) { product ->
            ProductItem(
                product = product,
                onAddToCart = onAddToCart
            )
        }
    }
}

@Preview
@Composable
fun ProductsScreenPreview() {
    ProductsScreen(PaddingValues(), "Salties", salties)
}
