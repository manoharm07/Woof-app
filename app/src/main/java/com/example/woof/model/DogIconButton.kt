package com.example.woof.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.woof.R

@Composable
fun DogIconButton(
    expanded : Boolean,
    onClick : () -> Unit,
    modifier : Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = stringResource(id = R.string.expand_button_content_description)
        )
//        Icon(
//            painter = painterResource(id = R.drawable.ic_woof_logo),
//            contentDescription = null)
    }
}

@Preview
@Composable
fun Greet(){
    DogIconButton(expanded = true, onClick = {  })
}