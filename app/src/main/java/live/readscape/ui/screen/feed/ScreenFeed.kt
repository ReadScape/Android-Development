package live.readscape.ui.screen.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import live.readscape.R

@Composable
fun ScreenFeed() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircleRow()
    }
}

@Composable
fun CircleRow() {
    LazyColumn() {
        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(17.dp, Alignment.CenterHorizontally),
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
                    .width(352.dp)
                    .height(239.dp)
                    .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 15.dp))
            ) {
                Row(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .width(33.dp)
                            .height(33.dp),
                        painter = painterResource(id = R.drawable.ellipse1),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds
                    )

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
                }

            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun CircleRowPreview() {
    CircleRow()
}
