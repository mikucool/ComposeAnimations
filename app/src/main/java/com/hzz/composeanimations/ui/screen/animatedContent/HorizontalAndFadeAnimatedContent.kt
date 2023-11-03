package com.hzz.composeanimations.ui.screen.animatedContent

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HorizontallyAnimatedContent() {
    val data = remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AnimatedContent(
            targetState = data.value,
            transitionSpec = {
                // 注意 “+” 运算符重载
                slideInHorizontally(initialOffsetX = { fullWidth -> return@slideInHorizontally -fullWidth }) +
                        fadeIn(initialAlpha = 0f, animationSpec = tween(1000)) with
                        slideOutHorizontally(targetOffsetX = { fullWidth -> return@slideOutHorizontally fullWidth }) +
                        fadeOut(targetAlpha = 0f, animationSpec = tween(1000))
            },
            modifier = Modifier.align(Alignment.Center),
            label = ""
        ) {
            Text(text = "${data.value}", fontSize = 100.sp, modifier = Modifier.clickable {
                data.value++
            })
        }
    }
}