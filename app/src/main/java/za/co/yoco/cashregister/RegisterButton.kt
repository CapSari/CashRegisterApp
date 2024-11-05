package za.co.yoco.cashregister

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import za.co.yoco.cashregister.ui.theme.PrimaryTextColor

@Composable
fun RegisterButton(
    symbol : String,
    modifier: Modifier,
    onClick: () -> Unit
){
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RectangleShape)
            .clickable{ onClick()}
            .then(modifier)
            .padding(18.dp)

    ){
       Text(
           text = symbol,
           fontSize = 24.sp,
           fontWeight = FontWeight.SemiBold,
           color = PrimaryTextColor
       )
    }

}