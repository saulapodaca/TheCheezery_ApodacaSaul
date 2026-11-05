package apodaca.saul.thecheezery_apodacasaul.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import apodaca.saul.thecheezery_apodacasaul.R
import apodaca.saul.thecheezery_apodacasaul.model.data.coldDrinks
import apodaca.saul.thecheezery_apodacasaul.model.domain.Product
import apodaca.saul.thecheezery_apodacasaul.ui.theme.DisabledGrey
import apodaca.saul.thecheezery_apodacasaul.ui.theme.Less_Purple
import apodaca.saul.thecheezery_apodacasaul.ui.theme.PurpleGrey40
import apodaca.saul.thecheezery_apodacasaul.ui.theme.Very_purple

@Composable
fun ProductItem(
    product: Product,
    onAddToCart: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = product.image),
            contentDescription = product.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(15.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = product.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = Less_Purple
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = product.description,
                fontSize = 12.sp,
                color = Color.DarkGray,
                lineHeight = 15.sp,
                maxLines = 3
            )
        }
        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = "$${product.price}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Very_purple
        )

        Spacer(modifier = Modifier.width(10.dp))

        FilledIconButton(
            onClick = { onAddToCart(product) },
            enabled = product.isAvailable,
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = Very_purple,
                contentColor = Color.White,
                disabledContainerColor = DisabledGrey,
                disabledContentColor = PurpleGrey40
            ),
            modifier = Modifier.size(44.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.add_cart),
                contentDescription = "Add ${product.name} to cart",
                modifier = Modifier.size(22.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ProductItem(coldDrinks[0], {})
}
