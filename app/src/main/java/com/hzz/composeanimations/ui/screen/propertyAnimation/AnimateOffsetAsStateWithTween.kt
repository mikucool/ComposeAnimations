package com.hzz.composeanimations.ui.screen.propertyAnimation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hzz.composeanimations.R
import kotlinx.coroutines.delay

@Composable
fun AnimateOffsetAsStateWithTween(modifier: Modifier = Modifier) {
    val position = remember { mutableStateOf(Offset(0f, 0f)) }
    val duration = remember { mutableStateOf(3000) }

    //动画数值
    val animValue = animateOffsetAsState(
        targetValue = position.value,
        animationSpec = tween(durationMillis = duration.value, easing = LinearEasing),
        label = ""
    )
    //移动位置集合
    val startList = listOf(
        //第一个参数是坐标，第二个参数延迟时间
        Offset(-100f, -100f) to 1000,//左上
        Offset(-100f, 100f) to 1000,//左下
        Offset(100f, 100f) to 1000,//右下
        Offset(100f, -100f) to 1000,//右上
    )
    LaunchedEffect(true) {
        delay(2000)
        for (item in startList) {
            position.value = item.first
            duration.value = item.second
            delay(duration.value.toLong())
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.miku),
            contentDescription = null,
            modifier = Modifier
                .graphicsLayer {
                    translationX = animValue.value.x
                    translationY = animValue.value.y
                }
                .size(100.dp)
                .align(Alignment.Center)
        )
    }
}