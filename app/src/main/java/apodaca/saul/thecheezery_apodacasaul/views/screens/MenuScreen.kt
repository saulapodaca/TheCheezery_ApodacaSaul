package apodaca.saul.thecheezery_apodacasaul.views.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import apodaca.saul.thecheezery_apodacasaul.R
import apodaca.saul.thecheezery_apodacasaul.ui.theme.Brighter_Pink
import apodaca.saul.thecheezery_apodacasaul.views.components.MenuColumnCard

@Composable
fun MenuScreen(
    innerPadding: PaddingValues,
    onCartClick: () -> Unit = {},
    onCategoryClick: (String) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(innerPadding)
            .padding(30.dp)
            .fillMaxSize()
    ) {
        IconButton(
            onClick = onCartClick,
            modifier = Modifier
                .size(55.dp)
                .align(Alignment.TopEnd)
                .background(color = Brighter_Pink, shape = CircleShape)
        ) {
            Icon(
                painter = painterResource(R.drawable.cart),
                contentDescription = "Shopping cart",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.grupo2),
                contentDescription = "TheCheezery Logo",
                modifier = Modifier
                    .fillMaxWidth(0.75f)
            )

            Spacer(Modifier.size(35.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                MenuColumnCard(
                    modifier = Modifier.weight(1f),
                    items = listOf("Hot drinks", "Salties", "Combos"),
                    onItemClick = onCategoryClick
                )

                MenuColumnCard(
                    modifier = Modifier.weight(1f),
                    items = listOf("Cold drinks", "Sweets", "Add new product"),
                    onItemClick = onCategoryClick
                )
            }
        }
    }
}

@Preview
@Composable
fun MenuScreenPreview() {
    MenuScreen(PaddingValues())
}
