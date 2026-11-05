package apodaca.saul.thecheezery_apodacasaul.views.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import apodaca.saul.thecheezery_apodacasaul.model.data.salties
import apodaca.saul.thecheezery_apodacasaul.model.domain.Product
import apodaca.saul.thecheezery_apodacasaul.ui.theme.HelloBunny
import apodaca.saul.thecheezery_apodacasaul.ui.theme.Less_Purple
import apodaca.saul.thecheezery_apodacasaul.ui.theme.Pinky
import apodaca.saul.thecheezery_apodacasaul.views.components.CartItemRow

@Composable
fun CartScreen(
    cartItems: List<Product>,
    totalAmount: Double,
    onRemoveItem: (Product) -> Unit = {}
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 25.dp)
            .padding(top = 15.dp, bottom = 30.dp)
    ) {
        Text(
            text = "My Order",
            fontFamily = HelloBunny,
            fontSize = 70.sp,
            color = Pinky,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            if (cartItems.isEmpty()) {
                item {
                    Text(
                        text = "Add some products to your order!",
                        color = Color.DarkGray,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }
            }
            items(cartItems) { item ->
                CartItemRow(
                    product = item,
                    onRemove = { onRemoveItem(item) }
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Total ",
                fontSize = 40.sp,
                fontWeight = FontWeight.Normal,
                color = Color.DarkGray
            )

            Text(
                text = "$$totalAmount",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Less_Purple
            )
        }
    }
}

@Preview
@Composable
fun CartScreenPreview(){
    CartScreen(cartItems = salties, totalAmount = 28.0)
}
