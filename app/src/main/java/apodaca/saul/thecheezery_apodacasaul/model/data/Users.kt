package apodaca.saul.thecheezery_apodacasaul.model.data

import apodaca.saul.thecheezery_apodacasaul.model.domain.User

class Users {
    private var currentUser: User? = null

    val validUsers = listOf(
        User("saul@ejemplo.com", "123456", "Saulin Pirulin"),
        User("alex@gmail.com", "123456", "Axel Garces"),
        User("potter@gmail.com", "123456", "Harry Popotter")
    )

    fun getUserByMail(email: String): User? {
        return validUsers.firstOrNull { it.email.equals(email, ignoreCase = true) }
    }

    fun loginService(email: String, password: String): User? {
        return getUserByMail(email)?.takeIf { it.password == password }
    }

    fun saveUser(email: String, name: String) {
        currentUser = getUserByMail(email)?.takeIf { it.name == name }
    }

    fun logout() {
        currentUser = null
    }

    fun isLoggedIn(): Boolean = currentUser != null

    fun getCurrentUser(): User? = currentUser
}
