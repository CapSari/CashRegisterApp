package za.co.yoco.cashregister

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import za.co.yoco.cashregister.ui.theme.CashRegisterTheme
import za.co.yoco.cashregister.ui.theme.SecondaryTextColor
import za.co.yoco.cashregister.ui.theme.SecondaryTextColorOnBackground

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CashRegisterTheme {
                val viewModel = viewModel<RegisterViewModel>()
                val state = viewModel.state
                val buttonSpacing = 0.5.dp

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(SecondaryTextColorOnBackground)
                ) {
                    Register(
                        state = state,
                        onAction = viewModel::onAction,
                        buttonSpacing = buttonSpacing,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    )
                    Computation(
                        cumulativeTotal = state.cumulativeTotal,
                        addedValues = state.addedValues.mapNotNull { value ->
                            value.removePrefix("R").toDoubleOrNull()},
                            modifier = Modifier
                            .fillMaxWidth()
                            .background(SecondaryTextColor)
                            .weight(1f),
                        onClick = {}
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CashRegisterPreview() {
    CashRegisterTheme {
        Column(
            modifier = Modifier.fillMaxSize().background(SecondaryTextColorOnBackground)
        ) {
            Register(
                state = RegisterState(),
                onAction = {},
                buttonSpacing = 0.5.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            Computation(
                cumulativeTotal = "R 2000.00",
                addedValues = listOf(10.00,20.00,30.00),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(SecondaryTextColor)
                    .weight(1f),
                onClick = {}
            )
        }
    }
}
