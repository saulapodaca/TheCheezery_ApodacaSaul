package apodaca.saul.thecheezery_apodacasaul.views.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material3.Button
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import apodaca.saul.thecheezery_apodacasaul.R
import apodaca.saul.thecheezery_apodacasaul.ui.theme.Dusty_white
import java.nio.file.WatchEvent

@Composable
fun LoginScreen(innerPadding: PaddingValues){

    var user by remember { mutableStateOf("") }
    var password = remember { TextFieldState() }

    Box(
        modifier = Modifier.background(Color.White)
    ){
        Column(
            modifier = Modifier.padding(innerPadding)
                .padding(40.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(R.drawable.grupo1),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.size(30.dp))

            TextField(
                value = user,
                label = {
                    Text("Correo Electrónico")
                },
                onValueChange = { it -> user = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(Modifier.size(15.dp))

            SecureTextField(
                state= password, label = {
                    Text("Contraseña")
                }, textObfuscationMode = TextObfuscationMode.RevealLastTyped,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(Modifier.size(30.dp))

            Button(
                onClick = {}
            ) {
                Text("Entrar")
            }
        }
    }

}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen(PaddingValues())
}