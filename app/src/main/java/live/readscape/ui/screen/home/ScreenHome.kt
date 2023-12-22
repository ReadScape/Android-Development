package live.readscape.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import live.readscape.BottomBar
import live.readscape.R

@Composable
fun ScreenHome(
    navController: NavController
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        HorizontalGrid()
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HorizontalGrid() {
    val category = listOf("All", "Mystery", "Travel", "Adventure", "Fan Fiction")
    Scaffold(
        bottomBar = { BottomBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            Text(
                modifier = Modifier.padding(bottom = 10.dp),
                text = "Best Seller",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )

            LazyRow(
                modifier = Modifier
                    .width(390.dp)
                    .height(265.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                items(10) {
                    Column(
                        Modifier
                            .width(125.dp)
                            .fillMaxHeight()
                    ) {
                        Image(
                            modifier = Modifier
                                .width(125.dp)
                                .height(187.dp)
                                .clip(RoundedCornerShape(10.dp)),
                            painter = painterResource(id = R.drawable.book1),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds
                        )

                        Text(
                            text = "To Kill a Mockingbird",
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF333333),
                                letterSpacing = 0.15.sp,
                            )
                        )

                        Text(
                            text = "Harper Lee",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF333333),
                                letterSpacing = 0.25.sp,
                            )
                        )
                    }
                }


            }

            Text(
                modifier = Modifier.padding(bottom = 10.dp),
                text = "Recommended For You",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(category) { item ->
                    Box(
                        modifier = Modifier
                            .height(36.dp)
                            .defaultMinSize(67.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(30.dp))
                            .background(color = Color(0xFF403648))
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = item,
                            style = TextStyle(color = Color.White),
                            modifier = Modifier.clickable {}
                        )
                    }
                }
            }

            LazyRow(
                modifier = Modifier
                    .width(390.dp)
                    .height(265.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                items(10) {
                    Column(
                        Modifier
                            .width(125.dp)
                            .fillMaxHeight()
                    ) {
                        Image(
                            modifier = Modifier
                                .width(125.dp)
                                .height(187.dp)
                                .clip(RoundedCornerShape(10.dp)),
                            painter = painterResource(id = R.drawable.book1),
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds
                        )

                        Text(
                            text = "To Kill a Mockingbird",
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF333333),
                                letterSpacing = 0.15.sp,
                            )
                        )

                        Text(
                            text = "Harper Lee",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF333333),
                                letterSpacing = 0.25.sp,
                            )
                        )
                    }
                }


            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyHorizontalGridPreview() {
    HorizontalGrid()
}