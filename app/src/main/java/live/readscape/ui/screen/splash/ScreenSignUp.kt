package live.readscape.ui.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScreenSignUp(
    navController: NavHostController
) {
    MySignup()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySignup() {
    var userName by rememberSaveable { mutableStateOf(" ") }
    var userMail by rememberSaveable { mutableStateOf(" ") }
    var userPassword by rememberSaveable { mutableStateOf(" ") }
    var privacyPolicy: Boolean by rememberSaveable { mutableStateOf(false) }
    var shareData: Boolean by rememberSaveable { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ){
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
                modifier = Modifier.padding(bottom = 20.dp)
                    .fillMaxWidth()
            )
            OutlinedTextField(
                value = userMail,
                onValueChange = { userMail = it.trim() },
                label = { Text(text = "Email Address") },
                modifier = Modifier.padding(bottom = 5.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "Please to confirm the email later",
                fontSize = 12.sp,
                modifier = Modifier.padding(bottom = 15.dp)
                    .padding(horizontal = 10.dp)
            )
            OutlinedTextField(
                value = userPassword,
                onValueChange = { userPassword = it.trim() },
                label = { Text(text = "Password") },
                modifier = Modifier.padding(bottom = 5.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "Use at least 8 character",
                fontSize = 12.sp,
                modifier = Modifier.padding(bottom = 15.dp)
                    .padding(horizontal = 10.dp)

            )
        }

        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
        )
        
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
                modifier = Modifier.fillMaxWidth()
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
                modifier = Modifier.fillMaxWidth()
                    .padding(bottom = 40.dp)
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
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {}
            ) {
                Text(text = "Create account")
            }

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MySignupPreview() {
    MySignup()
}