package com.hzz.composeanimations.ui.screen.animatable

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hzz.composeanimations.ui.theme.ComposeAnimationsTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
 * spring for animation
 */
@Composable
fun FallOffSpringAnimation(modifier: Modifier = Modifier) {
    val yAnimation1 = remember { Animatable(0f) }
    val yAnimation2 = remember { Animatable(0f) }
    val yAnimation3 = remember { Animatable(0f) }
    val yAnimation4 = remember { Animatable(0f) }

    LaunchedEffect(true) {
        delay(2000)
        launch {
            yAnimation1.animateTo(
                200f,
                //dampingRatio = 阻尼比 , stiffness = 刚度
                //DampingRatioHighBouncy = 阻尼比高弹性  , StiffnessHigh = 刚度高
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessHigh
                )
            )
        }

        launch {
            yAnimation2.animateTo(
                200f,
                //DampingRatioHighBouncy = 阻尼比高弹性  , StiffnessMediumLow = 刚度中低
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessMediumLow
                )
            )
        }

        launch {
            yAnimation3.animateTo(
                200f,
                //DampingRatioMediumBouncy = 阻尼比中弹性  , StiffnessMedium = 刚度中
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMediumLow
                )
            )
        }
        launch {
            //DampingRatioNoBouncy = 阻尼比无弹性  , StiffnessVeryLow = 刚度非常低
            yAnimation4.animateTo(
                200f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessVeryLow
                )
            )
        }

    }

    Row(
        modifier = modifier
            .fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Surface(
            color = Color.Green,
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .size(40.dp)
                .graphicsLayer {
                    translationY = yAnimation1.value
                }
        ) {}

        Surface(
            color = Color.Green,
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .size(40.dp)
                .graphicsLayer {
                    translationY = yAnimation2.value
                }
        ) {}

        Surface(
            color = Color.Green,
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .size(40.dp)
                .graphicsLayer {
                    translationY = yAnimation3.value
                }
        ) {}

        Surface(
            color = Color.Green,
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .size(40.dp)
                .graphicsLayer {
                    translationY = yAnimation4.value
                }
        ) {}
    }
}

@Composable
@Preview(showSystemUi = true)
fun FallOffAnimationPreview() {
    ComposeAnimationsTheme {
        // A surface container using the 'background' color from the theme
        FallOffSpringAnimation()
    }
}