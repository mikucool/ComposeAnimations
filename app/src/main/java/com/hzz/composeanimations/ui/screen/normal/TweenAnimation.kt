package com.hzz.composeanimations.ui.screen.normal

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp


/**
 * tween for animation
 */
@Composable
fun ColorAnimation(modifier: Modifier = Modifier) {
    val color = remember { Animatable(Color.Gray) }
    LaunchedEffect(true) {
        color.animateTo(
            targetValue = Color.Green,
            //delayMillis = 动画开始延迟时间 ， durationMillis = 动画持续时间 ， easing = 动画数值曲线
            animationSpec = tween(
                durationMillis = 3000,
                delayMillis = 1000,
                easing = FastOutSlowInEasing
            )
        )
    }

    Box(modifier = modifier.fillMaxSize()) {
        Surface(
            color = color.value,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.Center)
        ) {}
    }
}


@Composable
fun RotationAnimation(modifier: Modifier = Modifier) {
    val zRotationAnimation1 = remember { androidx.compose.animation.core.Animatable(0f) }
    val zRotationAnimation2 = remember { androidx.compose.animation.core.Animatable(0f) }

    // 有限次数
    LaunchedEffect(true) {
        zRotationAnimation1.animateTo(
            360f,
            //iterations 重复次数
            animationSpec = repeatable(iterations = 2, animation = tween(durationMillis = 1000, easing = LinearEasing))
        )
    }

    // 无限重复
    LaunchedEffect(true) {
        zRotationAnimation2.animateTo(
            360f,
            animationSpec = infiniteRepeatable(animation = tween(durationMillis = 1000))
        )
    }

    Row(modifier = modifier.fillMaxSize().padding(36.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Surface(
            color = Color.Green,
            modifier = Modifier.size(100.dp).graphicsLayer {
                rotationZ = zRotationAnimation1.value
            }
        ) {}

        Surface(
            color = Color.Green,
            modifier = Modifier.size(100.dp).graphicsLayer {
                rotationZ = zRotationAnimation2.value
            }
        ) {}
    }
}