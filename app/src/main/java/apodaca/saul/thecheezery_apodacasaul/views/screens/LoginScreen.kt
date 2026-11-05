package apodaca.saul.thecheezery_apodacasaul.views.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import apodaca.saul.thecheezery_apodacasaul.R

@Composable
fun LoginScreen(
    innerPadding: PaddingValues,
    email: String = "",
    emailError: String? = null,
    passwordError: String? = null,
    loginError: String? = null,
    onEmailChange: (String) -> Unit = {},
    onLoginClick: (String) -> Unit = {}
){
    val password = rememberTextFieldState()

    Box(
        modifier = Modifier.background(Color.White)
            .padding(innerPadding)
            .fillMaxSize()
            .imePadding()
            .verticalScroll(rememberScrollState())
    ){
        Column(
            modifier = Modifier
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
                value = email,
                label = {
                    Text("Email address")
                },
                onValueChange = onEmailChange,
                singleLine = true,
                isError = emailError != null,
                supportingText = emailError?.let { message -> { Text(message) } },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(Modifier.size(15.dp))

            SecureTextField(
                state= password,
                label = {
                    Text("Password")
                },
                textObfuscationMode = TextObfuscationMode.RevealLastTyped,
                isError = passwordError != null,
                supportingText = passwordError?.let { message -> { Text(message) } },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(Modifier.size(30.dp))

            Button(
                onClick = { onLoginClick(password.text.toString()) }
            ) {
                Text("Sign in")
            }

            loginError?.let { message ->
                Text(
                    text = message,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }

}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen(PaddingValues())
}
