package com.hzz.composeanimations.ui.screen.normal

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun FallOffKeyFramesAnimation(modifier: Modifier = Modifier) {
    val yAnimation1 = remember { Animatable(0f) }
    LaunchedEffect(true) {
        delay(2000)
        yAnimation1.animateTo(
            targetValue = 300f,
            animationSpec = keyframes {
                durationMillis = 3000
                /*
                    简单说明下面代码意思：
                    下面代码实现了先以100毫秒从0f移动到100f的位置，然后以2800毫秒从100f移动到200f的位置，再接着以100毫秒从200f移动到最后的300f位置
                 */
                0f at 0 with FastOutLinearInEasing //从0f位置0毫秒开始以FastOutLinearInEasing数值曲线运行到下一个阶段
                100f at 100 with LinearEasing //经过了100毫秒运动到100f此位置，现在从100f位置以LinearEasing数值曲线运行到下一个阶段
                200f at 2900 with FastOutLinearInEasing //经过了2800毫秒运动到200f此位置，现在从200f位置以LinearEasing数值曲线运行到300f结束
            }
        )
    }

    Row(modifier = Modifier.fillMaxSize()) {
        Surface(
            color = Color.Green,
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .size(40.dp)
                .graphicsLayer {
                    translationY = yAnimation1.value
                }
        ) {}
    }
}