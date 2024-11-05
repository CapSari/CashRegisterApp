package za.co.yoco.cashregister

data class RegisterState(
    val number1: String = "",
    val number2: String = "",
    val cumulativeTotal: String = "0.0",
    val operation: RegisterOperation? = null,
    val addedValues: List<String> = emptyList()

) {
}