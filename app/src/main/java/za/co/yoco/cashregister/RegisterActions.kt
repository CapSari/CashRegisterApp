package za.co.yoco.cashregister

sealed class RegisterActions {
    data class Number(val number: Int) : RegisterActions()
    object  Add : RegisterActions()
    object  Delete : RegisterActions()
    data class  Calculate ( val calculate: RegisterOperation): RegisterActions()
}