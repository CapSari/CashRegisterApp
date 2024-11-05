package za.co.yoco.cashregister

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import za.co.yoco.cashregister.ui.theme.CurrentAmountBgColor
import za.co.yoco.cashregister.ui.theme.SecondaryTextColorOnBackground

@Composable
fun Register(
    state: RegisterState,
    buttonSpacing: Dp = 1.dp,
    onAction: (RegisterActions) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(SecondaryTextColorOnBackground)
                .align(Alignment.BottomCenter)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 0.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = if (state.number1.isBlank()) "R 0.00" else "R " + state.number1,
                    textAlign = TextAlign.End,
                    fontSize = 54.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 80.dp, end = 40.dp, bottom = 22.dp),
                    fontWeight = FontWeight.Light,
                    maxLines = 2,
                    color = Color.Black
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    RegisterButton(
                        symbol = "1",
                        modifier = Modifier
                            .weight(1f)
                            .background(CurrentAmountBgColor),
                        onClick = {
                            onAction(RegisterActions.Number(1))
                        }
                    )
                    RegisterButton(
                        symbol = "2",
                        modifier = Modifier
                            .weight(1f)
                            .background(CurrentAmountBgColor),
                        onClick = {
                            onAction(RegisterActions.Number(2))
                        }
                    )
                    RegisterButton(
                        symbol = "3",
                        modifier = Modifier
                            .weight(1f)
                            .background(CurrentAmountBgColor),
                        onClick = {
                            onAction(RegisterActions.Number(3))
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(buttonSpacing))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    RegisterButton(
                        symbol = "4",
                        modifier = Modifier
                            .weight(1f)
                            .background(CurrentAmountBgColor),
                        onClick = {
                            onAction(RegisterActions.Number(4))
                        }
                    )
                    RegisterButton(
                        symbol = "5",
                        modifier = Modifier
                            .weight(1f)
                            .background(CurrentAmountBgColor),
                        onClick = {
                            onAction(RegisterActions.Number(5))
                        }
                    )
                    RegisterButton(
                        symbol = "6",
                        modifier = Modifier
                            .weight(1f)
                            .background(CurrentAmountBgColor),
                        onClick = {
                            onAction(RegisterActions.Number(6))
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(buttonSpacing))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    RegisterButton(
                        symbol = "7",
                        modifier = Modifier
                            .weight(1f)
                            .background(CurrentAmountBgColor),
                        onClick = {
                            onAction(RegisterActions.Number(7))
                        }
                    )
                    RegisterButton(
                        symbol = "8",
                        modifier = Modifier
                            .weight(1f)
                            .background(CurrentAmountBgColor),
                        onClick = {
                            onAction(RegisterActions.Number(8))
                        }
                    )
                    RegisterButton(
                        symbol = "9",
                        modifier = Modifier
                            .weight(1f)
                            .background(CurrentAmountBgColor),
                        onClick = {
                            onAction(RegisterActions.Number(9))
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(buttonSpacing))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    RegisterButton(
                        symbol = "DELL",
                        modifier = Modifier
                            .weight(1f)
                            .background(CurrentAmountBgColor),
                        onClick = {
                            onAction(RegisterActions.Delete)
                        }
                    )
                    RegisterButton(
                        symbol = "0",
                        modifier = Modifier
                            .weight(1f)
                            .background(CurrentAmountBgColor),
                        onClick = {
                            onAction(RegisterActions.Number(0))
                        }
                    )
                    RegisterButton(
                        symbol = "ADD",
                        modifier = Modifier
                            .weight(1f)
                            .background(CurrentAmountBgColor),
                        onClick = {
                            onAction(RegisterActions.Add)
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    val sampleState = RegisterState(number1 = "2000.00")

    Register(
        state = sampleState,
        onAction = {},
        buttonSpacing = 0.dp,
        modifier = Modifier.fillMaxWidth()
    )
}
