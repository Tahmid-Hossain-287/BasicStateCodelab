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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by remember { mutableStateOf(0) }
        var showTask by rememberSaveable { mutableStateOf(false) }
        if (count > 0) {
            // This text is present if the button has been clicked
            // at least once; absent otherwise
            Text("You've had $count glasses.")
        }
        Row {
            Button(onClick = { count++ }, Modifier.padding(top = 8.dp), enabled = (count < 10)) {
                Text("Add one")
            }
            Button(
                onClick = {
                    count = 0
                    showTask = false
                },
                Modifier.padding(top = 8.dp)
            ) {
                Text("Clear water count")
            }
        }

        if (count >= 10) {
            showTask = true
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