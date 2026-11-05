package apodaca.saul.thecheezery_apodacasaul.navigation

import kotlinx.serialization.Serializable

@Serializable
object Welcome

@Serializable
object Login

@Serializable
object Menu

@Serializable
data class Products(val category: String)

@Serializable
object Cart

