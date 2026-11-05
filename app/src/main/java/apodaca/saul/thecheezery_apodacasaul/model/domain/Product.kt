package apodaca.saul.thecheezery_apodacasaul.model.domain

data class Product(
    val name: String = "",
    val price: Double = 0.0,
    val image: Int,
    val description: String = "",
    val isAvailable: Boolean = true
)