package com.hzz.composeanimations.ui.screen.visibility

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun VisibilityScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        DefaultAnimation()
//        FadeAnimation()
//        SlideAnimation()
//        VerticalSlideAnimation()
//        HorizontalSlideAnimation()
//        ScaleAnimation()
//        ExpandAndShrinkAnimation()
//        HorizontalExpandAndShrinkAnimation()
    }
}