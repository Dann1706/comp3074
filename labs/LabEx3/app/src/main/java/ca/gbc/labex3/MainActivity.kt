package ca.gbc.labex3

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.gbc.labex3.ui.theme.LabEx3Theme
import org.w3c.dom.Text


data class Message(
    val sender : String,
    val text : String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabEx3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        MessageList()
                    }
                }
            }
        }
    }
}


@Composable
fun MessageCard(message: Message){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(60.dp)
                .border(2.dp, Color.Red, CircleShape)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column{
            Text(
                text = message.sender,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                shape = RoundedCornerShape(16.dp),
                tonalElevation = 2.dp
            ) {
                Text(
                    text = message.text,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun MessageList() {
    val messages = listOf(
        Message("Joe", "Hi"),
        Message("Jim", "How are you?"),
        Message("Joe", "Test..1..2..3"),
        Message("Joe", "I HATE coding!!!!"),
        Message("Joe", "Hi"),
        Message("Jim", "How are you?"),
        Message("Joe", "Test..1..2..3"),
        Message("Joe", "I HATE coding!!!!"),
        Message("Joe", "Hi"),
        Message("Jim", "How are you?"),
        Message("Joe", "Test..1..2..3"),
        Message("Joe", "I HATE coding!!!!")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(messages) { message ->
            MessageCard(message = message)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabEx3Theme {
        Greeting("Android")
    }
}