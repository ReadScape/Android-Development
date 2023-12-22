package live.readscape.ui.screen.story

import androidx.compose.runtime.Composable
import androidx.compose.material3.Text

@Composable
fun ScreenStoryDetail(
    id: String
    //onNavigateToStory: () -> Unit
) {
    Text(text = id)
}