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
import androidx.compose.material3.AlertDialog
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
import androidx.compose.runtime.remember
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
import kotlinx.coroutines.runBlocking
import live.readscape.data.response.SignupResponse
import live.readscape.data.retrofit.ApiConfig

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
            MySignupContent(
                pd,
                goBack = {
                    navController.navigateUp()
                }
            )
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
    pd: PaddingValues,
    goBack: () -> Unit
) {
    var userName by rememberSaveable { mutableStateOf("hammam") }
    var userMail by rememberSaveable { mutableStateOf("hammam@ahqof.com") }
    var userPassword by rememberSaveable { mutableStateOf("12345678") }
    var privacyPolicy: Boolean by rememberSaveable { mutableStateOf(false) }
    var shareData: Boolean by rememberSaveable { mutableStateOf(true) }

    var signupResponse: SignupResponse by remember { mutableStateOf( SignupResponse(1,"tes") ) }
    var showDialog: Boolean by rememberSaveable { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .padding(pd)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){
        MySignupForm(
            userName, userMail, userPassword,
            onUserNameChange = { userName = it },
            onUserMailChange = { userMail = it },
            onUserPasswordChange = { userPassword = it },
        )
        Spacer( modifier = Modifier.weight(1f) )
        MySpacer()
        MySignupOption(
            privacyPolicy, shareData,
            onPrivacyPolicyChange = { privacyPolicy = it },
            onShareDataChange = { shareData = it }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            onClick = {
                signupResponse = signup(userName, userMail, userPassword, privacyPolicy, shareData)
                showDialog = true
            }
        ) {
            Text(text = "Create account")
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Signup") },
            text = { Text(signupResponse.message)},
            confirmButton = {
                Button(
                    onClick = {
                        showDialog = false
                        if(signupResponse.error == 0) {
                            goBack()
                        }
                    }
                ) {
                    Text("OK")
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySignupForm(
    userName: String,
    userMail: String,
    userPassword: String,
    onUserNameChange: (String) -> Unit,
    onUserMailChange: (String) -> Unit,
    onUserPasswordChange: (String) -> Unit,
) {

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
            onValueChange = { onUserNameChange(it.trim()) },
            label = { Text(text = "Username") },
            modifier = Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = userMail,
            onValueChange = { onUserMailChange(it.trim()) },
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
            onValueChange = { onUserPasswordChange(it.trim()) },
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
fun MySignupOption(
    privacyPolicy: Boolean,
    shareData: Boolean,
    onPrivacyPolicyChange: (Boolean) -> Unit,
    onShareDataChange: (Boolean) -> Unit
) {


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
                onCheckedChange = { onPrivacyPolicyChange(it) }
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
                onCheckedChange = { onShareDataChange(it) }
            )
        }
    }
}

private fun signup(
    userName: String,
    userMail: String,
    userPassword: String,
    privacyPolicy: Boolean,
    shareData: Boolean,
) : SignupResponse {
    val result: SignupResponse = runBlocking {
        try {
//            delay(10000)
            ApiConfig.getApiService().signUp(userName, userMail, userPassword, privacyPolicy, shareData)
        } catch (e : Exception) {
            SignupResponse(1, "Gagal koneski")
        }
    }
    return result
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