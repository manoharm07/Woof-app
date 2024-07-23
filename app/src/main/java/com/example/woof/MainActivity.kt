package com.example.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.woof.model.WoofCard
import com.example.woof.model.dogs
import com.example.woof.theme.ui.WoofTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDark by remember { mutableStateOf(true) }
            val toggleDark : () -> Unit = {
                isDark = !isDark
            }
            WoofTheme(
                dynamicColor = isDark
            ){
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                WoofApp(isDark,toggleDark)   // if fun toggleDark(): Unit{ } then WoofApp(isDark, { toggleDark()})
                }
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WoofAppBar(
    isDark : Boolean,
    toggleDark : ()->Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,


                ){
                Row(
                    modifier = Modifier
                        .padding(start = 80.dp)
                        .animateContentSize(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioNoBouncy,
                                stiffness = Spring.StiffnessMedium
                            )
                        )
                ){
                    Image(
                        modifier = Modifier
                            .size(64.dp)
                            .padding(8.dp)
                            .clip(shape = RoundedCornerShape(8.dp)),
                        painter = painterResource(id = R.drawable.ic_woof_logo),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,

                        )
                    Text(
                        text = stringResource(id = R.string.app_name),
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color(0xFF5204FC),
                        modifier = Modifier
                            .padding(16.dp),
                    )
                }
                IconButton(
                    onClick = {toggleDark()},
                    modifier = Modifier
                ) {
                    Icon(
                        imageVector = Icons.Filled.Refresh,
                        contentDescription = stringResource(id = R.string.expand_button_content_description)
                    )
                }
            }
        }
    )
}

@Composable
fun WoofApp(
    isDark: Boolean,
    toggleDark : ()->Unit
) {

    Scaffold(
        topBar = {
            WoofAppBar(isDark,toggleDark)
        }
    ) { it ->
        LazyColumn(
            contentPadding = it,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            items(dogs){
                WoofCard(
                    it,
                    modifier = Modifier
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WoofTheme(darkTheme = true,
        dynamicColor = true
    ) {

        WoofApp(isDark = true,
            toggleDark ={}
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun Greeting(){
    WoofTheme(darkTheme = false,
        dynamicColor = false
    ){
        WoofApp(isDark = false,
            toggleDark = {})
    }
}




