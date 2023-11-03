package com.hzz.composeanimations.ui.screen.animatedVisibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.hzz.composeanimations.R
import kotlinx.coroutines.delay

@Composable
fun SlideAnimation(modifier: Modifier = Modifier) {
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
            modifier = Modifier.align(Alignment.Center),
            enter = slideIn { IntOffset(-100, -100) },
            exit = slideOut { IntOffset(100, 100) }
        ) {
            Image(
                painter = painterResource(id = R.drawable.miku),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
        }
    }
}

@Composable
fun HorizontalSlideAnimation(modifier: Modifier = Modifier) {
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
            modifier = Modifier.align(Alignment.Center),
            enter = slideInHorizontally(initialOffsetX = { fullWidth ->
                return@slideInHorizontally -(fullWidth / 2)
            }),
            exit = slideOutHorizontally(targetOffsetX = { fullWidth ->
                return@slideOutHorizontally fullWidth / 2
            })
        ) {
            Image(
                painter = painterResource(id = R.drawable.miku),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
        }
    }
}


@Composable
fun VerticalSlideAnimation(modifier: Modifier = Modifier) {
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
            enter = slideInVertically(initialOffsetY = { fullHeight ->
                return@slideInVertically -(fullHeight / 2)
            }),
            exit = slideOutVertically(targetOffsetY = { fullHeight ->
                return@slideOutVertically fullHeight / 2
            })
        ) {
            Image(
                painter = painterResource(id = R.drawable.miku),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
        }
    }
}

