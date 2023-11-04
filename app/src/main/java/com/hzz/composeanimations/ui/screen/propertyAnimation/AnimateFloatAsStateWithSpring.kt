package com.hzz.composeanimations.ui.screen.propertyAnimation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun AnimateFloatAsStateWithSpring(modifier: Modifier = Modifier) {
    val startAnimation = remember { mutableStateOf(false) }

    //创建y轴的动画数值
    val yAnimValue = animateDpAsState(
        //targetValue为动画的目标数值
        targetValue = if (startAnimation.value) 200.dp else 0.dp,
        //animationSpec动画的可选插值器，目前的结尾弹跳效果就是spring这个插值器实现的
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessMedium
        ),
        label = ""
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Surface(color = Color.Gray, modifier = Modifier
            .graphicsLayer {
                translationY = yAnimValue.value.toPx()
            }
            .size(50.dp)
            .align(Alignment.Center)
            .clickable {
                //点击启动动画
                startAnimation.value = !startAnimation.value
            }) {

        }
    }
}