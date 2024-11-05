package za.co.yoco.cashregister

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    var state by mutableStateOf(RegisterState())
        private set

    private var cumulativeTotal = 0.0

    fun onAction(action: RegisterActions) {
        when (action) {
            is RegisterActions.Number -> enterNumber(action.number)
            is RegisterActions.Add -> enterAdd()
            is RegisterActions.Delete -> enterDelete()
            is RegisterActions.Calculate -> enterCalculate(action.calculate)
        }
    }

    private fun enterCalculate(calculate: RegisterOperation) {

        if (state.number1.isNotBlank()) {
            state = state.copy(operation = calculate)
        }
    }

    private fun enterDelete() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )

            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }

    }

    private fun enterAdd() {
        val number1 = state.number1.toDoubleOrNull()
        if (number1 != null) {
            cumulativeTotal += number1
            state = state.copy(
                addedValues = state.addedValues + "R $number1",
                cumulativeTotal = String.format(
                    "R %.2f",
                    cumulativeTotal
                ),
                number1 = ""
            )
        }
    }

    private fun enterNumber(number: Int) {
        if (state.number1.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            number1 = state.number1 + number
        )
    }


    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}

