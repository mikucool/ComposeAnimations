package com.hzz.composeanimations.ui.screen.animatedContent

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
fun VerticalAnimatedContent(modifier: Modifier = Modifier) {
    val data = remember { mutableStateOf(0) }
    Box(modifier = modifier.fillMaxSize()) {
        AnimatedContent(
            targetState = data.value,
            transitionSpec = {
                slideInVertically { fullHeight -> return@slideInVertically -fullHeight } with
                        slideOutVertically { fullHeight -> return@slideOutVertically fullHeight }
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
