package za.co.yoco.cashregister

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RegisterViewModelTest {

    private lateinit var viewModel: RegisterViewModel

    @Before
    fun setup() {
        viewModel = RegisterViewModel()
    }

    @Test
    fun `adding single digit to update values on amount text`() {
        inputNumber(5)
        assertEquals("5", viewModel.state.number1)
    }

    @Test
    fun `adding amount value to cumulative total and update total amount and resets amount value`() {
        inputNumber(5)
        addValue()

        assertEquals("R 5.00", viewModel.state.cumulativeTotal)
        assertEquals("", viewModel.state.number1)
    }

    @Test
    fun `adding multiple amount values accumulates cumulative total and addedValues`() {
        inputNumber(5)
        addValue()
        inputNumber(3)
        addValue()

        assertEquals("R 8.00", viewModel.state.cumulativeTotal)
        assertEquals("R 5.0R 3.0", viewModel.state.addedValues.joinToString(""))
    }


    @Test
    fun `delete removes last digit from amount value`() {
        inputNumber(7)
        inputNumber(4)
        deleteLastEntry()

        assertEquals("7", viewModel.state.number1)
    }

    @Test
    fun `calculate sets operation if amount value is present`() {
        inputNumber(9)
        calculateOperation(RegisterOperation.Add)

        assertEquals(RegisterOperation.Add, viewModel.state.operation)
    }

    private fun inputNumber(number: Int) {
        viewModel.onAction(RegisterActions.Number(number))
    }

    private fun addValue() {
        viewModel.onAction(RegisterActions.Add)
    }

    private fun deleteLastEntry() {
        viewModel.onAction(RegisterActions.Delete)
    }

    private fun calculateOperation(operation: RegisterOperation) {
        viewModel.onAction(RegisterActions.Calculate(operation))
    }
}
