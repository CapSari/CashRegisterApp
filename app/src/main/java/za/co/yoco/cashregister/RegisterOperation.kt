package za.co.yoco.cashregister

sealed class RegisterOperation(val symbol: String) {
    object Add: RegisterOperation("ADD")
    object Delete: RegisterOperation("DEL")
}