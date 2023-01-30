package com.example.login_form

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login_form.ui.theme.Login_FormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login_FormTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginForm()
                }
            }
        }
    }
}

@Composable
fun LoginForm()
{
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible: Boolean by remember { mutableStateOf(false) }
    val reusableModifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
    Column(

    )
    {
        Text(
            text = "Login",
            modifier = reusableModifier,
            fontSize= 40.sp,
            color = MaterialTheme.colors.primary
        )
        OutlinedTextField(
            value = username,
            onValueChange = {username = it},
            label = { Text(text = "Username")},
            modifier = reusableModifier,
            trailingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email icon") }
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it},
            label = { Text(text = "Password")},
            modifier = reusableModifier,
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock icon") }
        )
        Button(onClick = { /*TODO*/ }, modifier = reusableModifier) {
            Text(text = "Submit")
            
        }
        
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Login_FormTheme {
        LoginForm()
    }
}