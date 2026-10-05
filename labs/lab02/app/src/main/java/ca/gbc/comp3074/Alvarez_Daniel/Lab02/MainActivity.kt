package ca.gbc.comp3074.Alvarez_Daniel.Lab02// package ca.gbc.comp3074.Alvarez_Daniel.Lab02
import ca.gbc.comp3074.Alvarez_Daniel.Lab02.ui.theme.Lab02Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.gbc.comp3074.Alvarez_Daniel.Lab02.ui.theme.Lab02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab02Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterApp(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CounterApp(modifier: Modifier = Modifier, name: String){
    var count by remember { mutableIntStateOf(0) }
    var stepSize by remember { mutableIntStateOf(1) }
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color(0xFF4094A2))
        .padding(top = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
        {
            Image(
                painter = painterResource(id = R.drawable.bunny_logo),
                contentDescription = "Counter app logo",
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(70.dp))

            Text(
                text = "$count",
                fontSize = 32.sp
            )
            Spacer(modifier = Modifier.height(56.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp),
                horizontalArrangement = Arrangement.spacedBy(56.dp))
            {
                Button(onClick = {count -= stepSize},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32)),
                    modifier = Modifier.weight(1f))
                { Text("-") }

                Button(onClick = {count += stepSize},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD72026)),
                    modifier = Modifier.weight(1f))
                { Text("+")}
            }
            Spacer(modifier = Modifier.height(24.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp),
                horizontalArrangement = Arrangement.spacedBy(56.dp))
            {
                Button(onClick = {
                    count = 0
                    stepSize = 1},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE52FC6)
                    ),
                    modifier = Modifier.weight(1f))
                {
                    Text("Reset")
                }

                Button(onClick = {stepSize = 2 },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF36AB67)
                    ),
                    modifier = Modifier.weight(1f))
                {
                    Text("Step")
                }
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
    Lab02Theme {
        Greeting("Android")
    }
}