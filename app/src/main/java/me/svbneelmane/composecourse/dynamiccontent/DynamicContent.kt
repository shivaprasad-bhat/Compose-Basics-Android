package me.svbneelmane.composecourse.dynamiccontent

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

val nameList: ArrayList<String> = arrayListOf("John", "Doe", "Shiva", "Prasad", "Gorge")

class DynamicContent : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen()
        }
    }
}

@Composable
fun Screen() {
    GreetingList(names = nameList)
}

@Composable
fun GreetingList(names: List<String>) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        // Dynamically add the UI elements
        for (name in names) {
            Greetings(name = name)
        }

        Button(onClick = {
            Log.e("ButtonClick","Button Add New Name clicked")
            nameList.add("New Name")
        }) {
            Text(text = "Add New Name")
        }
    }
}

@Composable
fun Greetings(name: String) {
    Text(text = "Hello $name", color = Color.Black)
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Screen()
}