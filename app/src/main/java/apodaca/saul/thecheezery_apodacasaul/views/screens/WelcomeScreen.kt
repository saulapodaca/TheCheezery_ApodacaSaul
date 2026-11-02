package apodaca.saul.thecheezery_apodacasaul.views.screens

import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import apodaca.saul.thecheezery_apodacasaul.R
import apodaca.saul.thecheezery_apodacasaul.ui.theme.Brighter_Pink
import apodaca.saul.thecheezery_apodacasaul.ui.theme.Dusty_white
import apodaca.saul.thecheezery_apodacasaul.ui.theme.Purple_grey

@Composable
fun WelcomeScreen(innerPadding: PaddingValues){
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
    ) {
        Image(
            painterResource(R.drawable.the_cheezery),
            contentDescription = "welcome image",
            modifier = Modifier.fillMaxWidth()
        )
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Purple_grey)
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome to The Cheezery",
                color = Dusty_white,
                fontFamily = FontFamily.SansSerif,
                fontSize = 25.sp
            )

            Spacer(modifier = Modifier.size(30.dp))

            Text(
                text = "Home of the most wonderful desserts ever seen (and tasted) by the human being",
                color = Dusty_white,
                fontFamily = FontFamily.SansSerif,
                fontSize = 15.sp)
            //

            Spacer(modifier = Modifier.size(30.dp))

            Button(
                onClick = {}
            ) {
                Text("Get started!")
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen(PaddingValues())
}