package live.readscape.ui.screen.splash

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.runBlocking
import live.readscape.data.retrofit.ApiConfig

@Composable
fun ScreenLogIn(
    navController: NavHostController
) {
    MyLogin(navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyLogin(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            MyLoginTopbar(
                onClick = {
                    navController.navigateUp()
                }
            )
        },
        content = { pd ->
            MyLoginContent(pd)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyLoginTopbar(
    onClick : () -> Unit
) {
    Column {
        TopAppBar(
            navigationIcon = {
                IconButton( onClick = { onClick() } ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
            title = {
                Text(
                    text = "Login",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
        )
        MySpacer()
    }
}

@Composable
fun MyLoginContent(
    pd: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(pd)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        MyLoginForm()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyLoginForm() {
    var userName by rememberSaveable { mutableStateOf("hammam") }
    var userPassword by rememberSaveable { mutableStateOf("sfr") }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(
            text = "Please fill the form",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )
        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it.trim() },
            label = { Text(text = "Username") },
            modifier = Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = userPassword,
            onValueChange = { userPassword = it.trim() },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(
                onDone = {

                }
            ),
            singleLine = true,
            modifier = Modifier
                .padding(bottom = 30.dp)
                .fillMaxWidth()
        )
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = { login(userName, userPassword) }
        ) {
            Text(text = "Login")
        }
    }
}

private fun login(
    userName: String,
    userPassword: String
) {
    runBlocking {
        try {
            val response =  ApiConfig.getApiService().login(userName, userPassword)
            if( response.error == 0) {
                Log.d("Logku", "Berhasil tersambung dan sukses login")
            } else {
                Log.d("Logku", "Berhasil tersambung tapi gagal login")
            }
        } catch (e : Exception) {
            Log.d("Logku", "Gagal tersambung")
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun MyLoginPreview() {
    MyLogin(navController = rememberNavController())
}