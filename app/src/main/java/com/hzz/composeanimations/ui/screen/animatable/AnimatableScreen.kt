package com.hzz.composeanimations.ui.screen.animatable

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ANIMATABLEScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
//        ColorAnimation()
//        FallOffSpringAnimation()
//        FallOffKeyFramesAnimation()
        RotationAnimation()
    }

}

