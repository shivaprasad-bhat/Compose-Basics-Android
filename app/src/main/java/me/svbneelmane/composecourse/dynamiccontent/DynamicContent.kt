package me.svbneelmane.composecourse.dynamiccontent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

val nameList: List<String> = listOf("John", "Doe", "Shiva", "Prasad", "Gorge")

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
    Column{
        // Dynamically add the UI elements
        for (name in names) {
            Greetings(name = name)
        }
    }
}

@Composable
fun Greetings(name: String) {
    Text(text = "Hello $name")
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Screen()
}