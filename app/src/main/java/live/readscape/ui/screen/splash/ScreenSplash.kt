package live.readscape.ui.screen.splash

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import live.readscape.R

@Composable
fun ScreenSplash(
    navController: NavHostController
) {
    MySplash()
}

@Composable
fun MySplash() {

    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier.padding(20.dp)
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.logo_readscape),
                contentDescription = stringResource(R.string.logo_readscape),
                modifier = Modifier
                    .padding(bottom = 80.dp)
                    .padding(horizontal = 20.dp)
            )
            Text(
                text = stringResource(R.string.logo_title),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 80.dp)
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {}
            ) {
                Text(text = stringResource(R.string.sign_up))
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = MaterialTheme.colorScheme.primary
                ),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                modifier = Modifier.fillMaxWidth(),
                onClick = {}
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Image(
                        painter = painterResource(id = R.drawable.android_neutral_rd_na_1x),
                        contentDescription = stringResource(R.string.icon_google),
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                    Text(text = stringResource(R.string.continue_with_google))
                }
            }
            Button(
                colors = ButtonDefaults.outlinedButtonColors(),
                onClick = {}
            ) {
                Text(text = stringResource(R.string.log_in))
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MySplashPreview() {
    MySplash()
}