package com.example.presentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardApp()
        }
    }
}

@Composable
fun BusinessCardApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray) ,// Adding a background color
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileSection()
            Spacer(modifier = Modifier.height(32.dp))
            ContactSection()
        }
    }
}
//Create a function to place the profile
@Composable
fun ProfileSection() {
    // Image
    Image(
        painter = painterResource(R.drawable.profile), // Use drawable resource
        contentDescription = "Profile Image",
        modifier = Modifier.size(150.dp),
        contentScale = ContentScale.Crop
    )

    Spacer(modifier = Modifier.height(16.dp))

    // Name
    Text(
        text = "Luis Fernando Hernández Mercado",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(8.dp))

    // Title
    Text(
        text = "Ingeniero en Sistemas Computacionales",
        fontSize = 18.sp,
        color = Color.Gray
    )
}
//Create a function to place the contact information
@Composable
fun ContactSection() {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        ContactRow(icon = Icons.Default.Phone, text = "833 181 4545")
        Spacer(modifier = Modifier.height(8.dp))
        ContactRow(icon = Icons.Default.Email, text = "L20070531@cdmadero.tecnm.mx")
        // Add more contact details as needed
    }
}
//Create a function to organize the icon and the contact information
@Composable
fun ContactRow(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardApp()
}