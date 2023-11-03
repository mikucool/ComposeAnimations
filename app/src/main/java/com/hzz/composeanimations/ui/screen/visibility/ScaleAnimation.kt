package com.hzz.composeanimations.ui.screen.visibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.spring
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
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
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hzz.composeanimations.R
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ScaleAnimation(modifier: Modifier = Modifier) {
    val imageVisible = remember { mutableStateOf(true) }
    LaunchedEffect(true) {
        for (i in 0..50) {
            delay(1500)
            imageVisible.value = !imageVisible.value
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        AnimatedVisibility(
            visible = imageVisible.value,
            modifier = Modifier
                .align(Alignment.Center),
            enter = scaleIn(animationSpec = spring(),initialScale = 0.1f, transformOrigin = TransformOrigin.Center),
            exit = scaleOut(animationSpec = spring(),targetScale = 0.1f, transformOrigin = TransformOrigin.Center)
        ) {
            Image(
                painter = painterResource(id = R.drawable.miku),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
        }
    }
}