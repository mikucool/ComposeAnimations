package com.hzz.composeanimations.ui.screen.propertyAnimation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

@Composable
fun PropertyAnimationWithCanvas(modifier: Modifier = Modifier) {
    //-400.dp 到 -1500.dp 动画范围值
    val yPosition = remember { mutableStateOf((-400).dp) }
    //y轴动画数值
    val yAnimValue = animateDpAsState(
        targetValue = yPosition.value,
        animationSpec = tween(durationMillis = 15_000, easing = LinearEasing),
        label = ""
    )
    val rotation = remember { mutableStateOf(0f) }
    //旋转动画，请注意这里使用的是animateFloatAsState
    val rotateAnimValue = animateFloatAsState(
        targetValue = rotation.value,
        animationSpec = tween(durationMillis = 5000, easing = LinearEasing),
        label = ""
    )

    LaunchedEffect(true) {
        var isFront = true
        val angleList = listOf(0f, 45f, 90f, 135f)
        var count = 0
        while (isActive) {
            isFront = !isFront
            if (isFront) {
                yPosition.value = (-400).dp
            } else {
                yPosition.value = (-1500).dp
            }
            delay(15_000)
            count++
            if (count > 2){
                count = 0
                rotation.value = angleList.random()
            }
        }
    }

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .rotate(rotateAnimValue.value)
    ) {
        val itemHeight = size.height / 30
        for (index in 0..200) {
            if (index % 2 == 0) {
                //黑色
                drawLine(
                    color = Color.Black,
                    start = Offset(-500f, itemHeight * index + yAnimValue.value.toPx()),
                    end = Offset(size.width + 500f, itemHeight * index + yAnimValue.value.toPx()),
                    strokeWidth = itemHeight
                )
            } else {
                //白色
                drawLine(
                    color = Color.White,
                    start = Offset(-500f, itemHeight * index + yAnimValue.value.toPx()),
                    end = Offset(size.width + 500f, itemHeight * index + yAnimValue.value.toPx()),
                    strokeWidth = itemHeight
                )
            }
        }
    }

}