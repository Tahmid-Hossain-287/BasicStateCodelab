package com.example.basicstatecodelab

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf( 0 )}
    var showTask by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Text(
            text = "You've had $count glasses of water.",
            modifier = modifier.padding(16.dp)
        )
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = { count++ },
                modifier = Modifier.padding(16.dp),
                enabled = (count < 10)
            ) {
                Text("Add glass")
            }
            Button(
                onClick = { count-- },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Subtract glass")
            }
            if (count >= 10) {
                showTask = true
            }
        }
        if (showTask) {
            WellnessTaskItem(
                taskName = "Go workout",
                onClose = {
                    showTask = false
                    count = 0
                },
                modifier
            )
        }
    }
}