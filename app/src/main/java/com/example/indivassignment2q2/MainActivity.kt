package com.example.indivassignment2q2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.indivassignment2q2.ui.theme.IndivAssignment2Q2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndivAssignment2Q2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ToggleCard(
                            initialMessage = "Press to toggle message", // initial message
                            toggledMessage = "Message was toggled", // Added toggled message
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ToggleCard(
    initialMessage: String,
    toggledMessage: String, // New parameter for the toggled message
    modifier: Modifier = Modifier
) {
    // Remembers if the card is flipped (toggled) or not.
    // 'rememberSaveable' keeps this state even if the screen rotates or the app temporarily closes.
    // Starts as 'false' (not toggled).
    var isToggled by rememberSaveable { mutableStateOf(false) }

    // if statement to determine which message to display based on the toggle state
    val currentMessage = if (isToggled) toggledMessage else initialMessage

    Card(
        modifier = modifier
            .clickable {
                // When the card is clicked, toggle the state.
                isToggled = !isToggled
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp) //elevation for visual feedback
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = currentMessage, // Display the current message based on state
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToggleCardPreviewStep2() {
    IndivAssignment2Q2Theme {
        ToggleCard(
            initialMessage = "Tap to see a fun fact!",
            toggledMessage = "Compose is declarative!" // Example toggled message for preview
        )
    }
}
