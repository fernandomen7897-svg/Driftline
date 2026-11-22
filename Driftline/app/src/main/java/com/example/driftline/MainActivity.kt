package com.example.driftline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { DriftlineApp() }
    }
}

@Composable
fun DriftlineApp() {
    var entered by remember { mutableStateOf(false) }
    var name by remember { mutableStateOf("") }
    val amber = Color(0xFFFF8A3D)

    Box(
        modifier = Modifier.fillMaxSize().background(
            Brush.verticalGradient(listOf(Color(0xFF5B2A86), Color(0xFF2E1A47)))
        ),
        contentAlignment = Alignment.Center
    ) {
        if (!entered) {
            Card(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 22.dp),
                shape = RoundedCornerShape(26.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(modifier = Modifier.padding(horizontal = 28.dp, vertical = 30.dp)) {
                    Text("Driftline", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3A2250))
                    Spacer(Modifier.height(6.dp))
                    Text("A quiet place for your notes", color = Color.Gray, fontSize = 14.sp)
                    Spacer(Modifier.height(24.dp))
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Your name (optional)") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = amber)
                    )
                    Spacer(Modifier.height(18.dp))
                    Button(
                        onClick = { entered = true },
                        modifier = Modifier.fillMaxWidth().height(58.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = amber)
                    ) {
                        Text("Continue as Guest", fontSize = 17.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(Modifier.height(10.dp))
                    Text(
                        "No account or server needed \u2014 everything stays on this device.",
                        color = Color.Gray, fontSize = 12.sp, textAlign = TextAlign.Center
                    )
                }
            }
        } else {
            val greeting = if (name.isBlank()) "Welcome" else "Welcome, $name"
            Card(
                modifier = Modifier.fillMaxWidth().padding(22.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(greeting, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color(0xFF3A2250))
                    Spacer(Modifier.height(10.dp))
                    Text("Your journal is empty for now.", fontSize = 16.sp, color = Color(0xFF8A5A2D))
                    Spacer(Modifier.height(16.dp))
                    OutlinedButton(onClick = { entered = false }) { Text("Back") }
                }
            }
        }
        Text("DRIFTLINE  \u2022  v1.0", modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 28.dp), color = Color(0xFFD8C6E8), fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}
