package za.co.yoco.cashregister

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.remember
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.tooling.preview.Preview
import za.co.yoco.cashregister.ui.theme.PrimaryTextColor

@Composable
fun Computation(
    addedValues: List<Double>,
    modifier: Modifier = Modifier,
    cumulativeTotal: String,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        addedValues.forEachIndexed { index, value ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RectangleShape)
                    .clickable { onClick() }
                    .fillMaxWidth()
                    .padding(top = 0.dp)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = if (index == 0) 120.dp else 16.dp,
                            end = 16.dp
                        ),
                    text = String.format("R %.2f", value),
                    textAlign = TextAlign.End,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
            }
        }

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
            thickness = 1.dp,
            color = Color.White
        )

        Text(
            text = cumulativeTotal,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            maxLines = 1,
            color = Color.White
        )
    }
}
@Preview(showBackground = true)
@Composable
fun ComputationPreview() {
    val sampleAddedValues = listOf(100.00, 200.50, 300.75)
    val sampleCumulativeTotal = "R 600.25"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Computation(
            addedValues = sampleAddedValues,
            cumulativeTotal = sampleCumulativeTotal,
            modifier = Modifier.fillMaxWidth().padding(end = 16.dp),
            onClick = { }
        )
    }
}