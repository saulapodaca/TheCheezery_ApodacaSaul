package apodaca.saul.thecheezery_apodacasaul.viewmodel

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import apodaca.saul.thecheezery_apodacasaul.model.domain.User
import apodaca.saul.thecheezery_apodacasaul.model.data.Users

class UserViewModel : ViewModel() {
    private val users = Users()

    var email by mutableStateOf("")
        private set

    var emailError by mutableStateOf<String?>(null)
        private set

    var passwordError by mutableStateOf<String?>(null)
        private set

    var loginError by mutableStateOf<String?>(null)
        private set

    var currentUser by mutableStateOf<User?>(null)
        private set

    fun onEmailChange(value: String) {
        email = value
        emailError = null
        loginError = null
    }

    fun login(password: String): Boolean {
        loginError = null
        val cleanEmail = email.trim()
        emailError = when {
            cleanEmail.isEmpty() -> "Enter your email address"
            !Patterns.EMAIL_ADDRESS.matcher(cleanEmail).matches() -> "Enter a valid email address"
            else -> null
        }
        passwordError = if (password.isBlank()) "Enter your password" else null

        if (emailError != null || passwordError != null) return false

        email = cleanEmail
        val user = users.loginService(cleanEmail, password)
        if (user == null) {
            loginError = "Incorrect email or password"
            return false
        }

        users.saveUser(user.email, user.name)
        currentUser = users.getCurrentUser()
        return true
    }
}
