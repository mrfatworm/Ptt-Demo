package com.mrfatworm.pttdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrfatworm.pttdemo.login.LoginViewModel
import com.mrfatworm.pttdemo.ui.theme.PttDemoTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PttDemoTheme {
                val snackBarHostState = remember { SnackbarHostState() }
                val coroutineScope = rememberCoroutineScope()
                val messageBoxState = remember { false }
                Scaffold(modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(hostState = snackBarHostState) }) { innerPadding ->
                    LoginScreen(modifier = Modifier.padding(innerPadding), showMessageBox = {})
                    if (messageBoxState) {
                        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = koinViewModel(),
    showMessageBox: (String) -> Unit = {}
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically)
    ) {
        Text(
            text = "歡迎來到 Ptt 神的幼苗!"
        )

        TextField(value = username,
            onValueChange = { newText -> username = newText },
            placeholder = { Text("帳號") })

        TextField(value = password,
            onValueChange = { newText -> password = newText },
            placeholder = { Text("密碼") })

        Button(onClick = { viewModel.loginUser(username, password) }) {
            Text(text = "登入")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PttDemoTheme {
        LoginScreen()
    }
}