package live.readscape.ui.screen.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import live.readscape.BottomBar
import live.readscape.R
import org.w3c.dom.Comment

@Composable
fun ScreenFeed(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        MyFeed(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyFeed(navController: NavController) {
    Scaffold(bottomBar = { BottomBar() }) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(
                        17.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.Top,
                ) {
                    items(5) {
                        Image(
                            modifier = Modifier
                                .width(59.dp)
                                .height(59.dp),
                            painter = painterResource(id = R.drawable.ellipse1),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds
                        )
                    }
                }
            }

            item {
                Card(
                    modifier = Modifier
                        .shadow(
                            elevation = 7.199999809265137.dp,
                            spotColor = Color(0x40000000),
                            ambientColor = Color(0x40000000)
                        )
                        .fillMaxHeight()
                        .background(
                            color = Color(0xFFFFFFFF),
                        )
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(33.dp)
                                .height(33.dp)
                                .clip(CircleShape),
                            painter = painterResource(id = R.drawable.ellipse1),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds
                        )
                        Column {
                            Text(
                                modifier = Modifier.padding(horizontal = 10.dp),
                                text = "Alexei", style = TextStyle(
                                    fontSize = 11.sp,
                                    lineHeight = 16.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF000000),
                                    letterSpacing = 0.5.sp,
                                )
                            )

                            Text(
                                modifier = Modifier.padding(horizontal = 10.dp),
                                text = "3 minutes ago", style = TextStyle(
                                    fontSize = 11.sp,
                                    lineHeight = 16.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF000000),
                                    letterSpacing = 0.5.sp,
                                )
                            )
                        }
                    }
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = "uhuy",
                            style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight(400))
                        )
                    }

                    Divider(modifier = Modifier, thickness = 2.dp, color = Color(0xFFA4A4A4))

                    LazyRow(
                        modifier = Modifier.padding(10.dp),
                        horizontalArrangement = Arrangement.spacedBy(
                            3.dp,
                            Alignment.CenterHorizontally
                        )
                    ) {
                        items(3) {
                            Image(
                                modifier = Modifier.clip(CircleShape),
                                painter = painterResource(id = R.drawable.ellipse1),
                                contentDescription = "Profile"
                            )
                        }
                        item {
                            Text(text = "+1k Like")
                        }

                        item {
                            Row(
                                modifier = Modifier
                                    .align(Alignment.End)
                                    .padding(horizontal = 10.dp),
                                horizontalArrangement = Arrangement.spacedBy(
                                    3.dp, alignment = Alignment.CenterHorizontally
                                )
                            ) {
                                Row(modifier = Modifier.clickable { }) {
                                    Icon(Icons.Default.FavoriteBorder, contentDescription = "like")
                                    Text(text = "Like")
                                }

                                Row(modifier = Modifier.clickable { }) {
                                    Icon(
                                        painter = painterResource(R.drawable.chat_buble),
                                        contentDescription = "Comment"
                                    )
                                    Text(text = "Comment")
                                }

                                Row(modifier = Modifier.clickable { }) {
                                    Icon(
                                        painter = painterResource(R.drawable.ios_share),
                                        contentDescription = "Share"
                                    )
                                    Text(text = "Share")
                                }

                            }
                        }
                    }
                    Divider(modifier = Modifier, thickness = 2.dp, color = Color(0xFFA4A4A4))

                    CommentSection()

                }
            }

        }
    }
}

@Composable
fun CommentSection() {
    var comment by rememberSaveable { mutableStateOf("spontan") }
    CommentForm(comment, onCommentChange = { comment = it }) {
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentForm(comment: String, onCommentChange: (String) -> Unit, onClick: () -> Unit) {
    Row(modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)) {
        OutlinedTextField(
            modifier = Modifier
                .height(58.dp)
                .width(300.dp),
            value = comment,
            onValueChange = onCommentChange,
            label = { Text(text = "Comment") },
            shape = RoundedCornerShape(50.dp)
        )

        IconButton(modifier = Modifier.offset(y = 10.dp), onClick = {}) {
            Icon(
                painter = painterResource(R.drawable.send),
                contentDescription = "Send",
            )

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CircleRowPreview() {
    MyFeed(navController = rememberNavController())
}
