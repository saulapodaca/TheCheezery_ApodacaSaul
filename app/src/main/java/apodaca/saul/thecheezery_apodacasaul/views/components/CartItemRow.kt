package apodaca.saul.thecheezery_apodacasaul.views.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import apodaca.saul.thecheezery_apodacasaul.R
import apodaca.saul.thecheezery_apodacasaul.model.data.salties
import apodaca.saul.thecheezery_apodacasaul.model.domain.Product
import apodaca.saul.thecheezery_apodacasaul.ui.theme.Very_purple

@Composable
fun CartItemRow(
    product: Product,
    onRemove: () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = product.name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "$${product.price}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Very_purple
        )

        Spacer(modifier = Modifier.width(15.dp))

        IconButton(
            onClick = onRemove,
            modifier = Modifier.size(35.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.delete),
                contentDescription = "Remove ${product.name}",
                tint = Very_purple,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
fun CartItemRowPreview(){
    CartItemRow(salties[0], {})
}
