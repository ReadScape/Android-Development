package live.readscape.ui.screen.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import live.readscape.R

@Composable
fun ScreenProfile(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        MyProfile(navController)
    }

}

@Composable
fun MyProfile(navController: NavController) {
    Column {
        Banner()
        ProfileMenu()
    }
}

@Composable
fun Banner(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
    }
    Row(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.offset(x = 12.dp, y = (-50).dp)) {
            Image(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(100.dp)
                    .border(BorderStroke(5.dp, Color.White), CircleShape),
                painter = painterResource(R.drawable.user),
                contentDescription = "user profile",
                contentScale = ContentScale.Crop,
            )

            Text(
                text = "Alexei Fernandes",
                style = TextStyle(fontWeight = FontWeight(500), fontSize = 16.sp)
            )

            Text(text = "Harry Potter Enthusiast")
        }

        Icon(modifier = Modifier
            .clickable { }
            .align(Alignment.CenterVertically)
            .padding(horizontal = 100.dp),
            painter = painterResource(R.drawable.edit),
            contentDescription = "profile edit")
    }
}

@Composable
fun ProfileMenu() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card( modifier = Modifier.width(340.dp)
        ) {
            Spacer(modifier = Modifier. padding(vertical = 15.dp))
            Row(modifier = Modifier.padding(horizontal = 15.dp)) {
                Icon(
                    painter = painterResource(R.drawable.account_circle),
                    contentDescription = "Profile Information"
                )
                Text(text = "Profile Information", modifier = Modifier.padding(horizontal = 10.dp))
            }
            Spacer(modifier = Modifier. padding(vertical = 5.dp))
            Divider()
            Spacer(modifier = Modifier. padding(vertical = 5.dp))
            Row(modifier = Modifier.padding(horizontal = 15.dp)) {
                Icon(
                    painter = painterResource(R.drawable.story),
                    contentDescription = "story"
                )
                Text(text = "Your Story", modifier = Modifier.padding(horizontal = 10.dp))
            }
            Spacer(modifier = Modifier. padding(vertical = 5.dp))
            Divider()
            Spacer(modifier = Modifier. padding(vertical = 5.dp))
            Row(modifier = Modifier.padding(horizontal = 15.dp)) {
                Icon(
                    painter = painterResource(R.drawable.setting),
                    contentDescription = "setting"
                )
                Text(text = "Setting and Privacy", modifier = Modifier.padding(horizontal = 10.dp))
            }
            Spacer(modifier = Modifier. padding(vertical = 15.dp))

        }
    }

    Spacer(modifier = Modifier.padding(vertical = 15.dp))

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card( modifier = Modifier.width(340.dp)
        ) {
            Spacer(modifier = Modifier. padding(vertical = 15.dp))
            Row(modifier = Modifier.padding(horizontal = 15.dp)) {
                Icon(
                    painter = painterResource(R.drawable.notifications),
                    contentDescription = "Profile Information"
                )
                Text(text = "Notifications", modifier = Modifier.padding(horizontal = 10.dp))
            }
            Spacer(modifier = Modifier. padding(vertical = 5.dp))
            Divider()
            Spacer(modifier = Modifier. padding(vertical = 5.dp))
            Row(modifier = Modifier.padding(horizontal = 15.dp)) {
                Icon(
                    painter = painterResource(R.drawable.history),
                    contentDescription = "Profile Information"
                )
                Text(text = "Account History", modifier = Modifier.padding(horizontal = 10.dp))
            }
            Spacer(modifier = Modifier. padding(vertical = 5.dp))
            Divider()
            Spacer(modifier = Modifier. padding(vertical = 5.dp))
            Row(modifier = Modifier.padding(horizontal = 15.dp)) {
                Icon(
                    painter = painterResource(R.drawable.logout),
                    contentDescription = "Profile Information"
                )
                Text(text = "Log out", modifier = Modifier.padding(horizontal = 10.dp))
            }
            Spacer(modifier = Modifier. padding(vertical = 15.dp))

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ScreenProfilePreview() {
    ScreenProfile(navController = rememberNavController())
}