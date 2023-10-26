package live.readscape.ui.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController

@Composable
fun ScreenSignUp(
    navController: NavHostController
) {
    MySignup(navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySignup(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            MySignupTopbar(
                onClick = {
                    navController.navigateUp()
                }
            )
        },
        content = { pd ->
            MySignupContent(pd)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySignupTopbar(
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
                    text = "Create Account",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
        )
        MySpacer()
    }
}

@Composable
fun MySignupContent(
    pd: PaddingValues
) {
    Column (
        modifier = Modifier
            .padding(pd)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){
        MySignupForm()
        Spacer( modifier = Modifier.weight(1f) )
        MySpacer()
        MySignupOption()
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            onClick = {}
        ) {
            Text(text = "Create account")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySignupForm() {
    var userName by rememberSaveable { mutableStateOf(" ") }
    var userMail by rememberSaveable { mutableStateOf(" ") }
    var userPassword by rememberSaveable { mutableStateOf("") }

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
            value = userMail,
            onValueChange = { userMail = it.trim() },
            label = { Text(text = "Email Address") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {

                }
            ),
            singleLine = true,
            modifier = Modifier
                .padding(bottom = 5.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Please to confirm the email later",
            fontSize = 12.sp,
            modifier = Modifier
                .padding(bottom = 15.dp)
                .padding(horizontal = 10.dp)
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
                .padding(bottom = 5.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Use at least 8 character",
            fontSize = 12.sp,
            modifier = Modifier
                .padding(bottom = 15.dp)
                .padding(horizontal = 10.dp)

        )
    }
}

@Composable
fun MySignupOption() {
    var privacyPolicy: Boolean by rememberSaveable { mutableStateOf(false) }
    var shareData: Boolean by rememberSaveable { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ){
        Text(
            text = "By tapping 'Create Account', you agree to the Term of Use",
            modifier = Modifier.padding(bottom = 20.dp)
        )
        Text(
            text = "Term of Use",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Text(
            text = "To learn about how app collects, uses, shares, and protects your personal data, pleas see the Privacy Policy",
            modifier = Modifier.padding(bottom = 20.dp)
        )
        Text(
            text = "Privacy Policy",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp)
        ){
            Text(
                text = "Please send me news and offers",
                modifier = Modifier.weight(1f)
            )
            Checkbox(
                checked = privacyPolicy,
                onCheckedChange = { privacyPolicy = it }
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Text(
                text = "Share my registration data with app's content providers for marketing purpose",
                modifier = Modifier.weight(1f)
            )
            Checkbox(
                checked = shareData,
                onCheckedChange = { shareData = it }
            )
        }
    }
}

@Composable
fun MySpacer() {
    Spacer(
        modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
    )
}

@Preview(showSystemUi = true)
@Composable
fun MySignupPreview() {
    MySignup(navController = rememberNavController())
}