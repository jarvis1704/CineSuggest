package com.biprangshu.cinesuggest.onboarding

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun OnBoardingButton(
    text: String,
    onClick: () -> Unit,
){
    Button(onClick = onClick, colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = Color.Red.copy(alpha = 0.5f)), shape = RoundedCornerShape(35), modifier = Modifier.width(200.dp)) {
        Text(text = text, style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold))
    }
}