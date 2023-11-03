package com.hzz.composeanimations.ui.screen.effect

import androidx.compose.animation.AnimatedVisibility
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
fun DefaultEffect(modifier: Modifier = Modifier) {
    val imageVisible = remember { mutableStateOf(true) }

    //这边用一个协程，以1500毫秒反复显示与隐藏
   LaunchedEffect(true) {
       for (i in 0..10) {
           delay(1500)
           imageVisible.value = !imageVisible.value
       }

   }

    Box(modifier = modifier.fillMaxSize()) {
        AnimatedVisibility(visible = imageVisible.value, modifier = Modifier.align(Alignment.Center)) {
            Image(
                painter = painterResource(id = R.drawable.miku),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
            )
        }
    }
}