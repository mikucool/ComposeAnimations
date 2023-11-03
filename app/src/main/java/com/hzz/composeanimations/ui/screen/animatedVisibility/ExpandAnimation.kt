package com.hzz.composeanimations.ui.screen.animatedVisibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
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
import androidx.compose.ui.unit.dp
import com.hzz.composeanimations.R
import kotlinx.coroutines.delay

@Composable
fun ExpandAndShrinkAnimation(modifier: Modifier = Modifier) {
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
            enter = expandIn(),
            exit = shrinkOut()
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
fun HorizontalExpandAndShrinkAnimation(modifier: Modifier = Modifier) {
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
            enter = expandHorizontally(),
            exit = shrinkHorizontally()
        ) {
            Image(
                painter = painterResource(id = R.drawable.miku),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
        }
    }
}