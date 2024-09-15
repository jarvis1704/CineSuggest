package com.biprangshu.cinesuggest.onboarding

import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PageIndicator(
    modifier: Modifier= Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor: Color = Color.Red,
    unselectedColor: Color= Color.LightGray
){
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)){
        repeat(pageSize){
            page ->
            Box(modifier = Modifier.size(14.dp).width(24.dp).height(2.dp).background(if (page==selectedPage) selectedColor else unselectedColor, shape = RoundedCornerShape(50)))
        }

    }

}