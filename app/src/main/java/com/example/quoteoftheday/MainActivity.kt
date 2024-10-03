package com.example.quoteoftheday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quoteoftheday.ui.theme.QuoteOfTheDayTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuoteOfTheDayTheme {
                val viewModel: QuoteViewModel by viewModels()
                Display(viewModel)
            }
        }
    }
}

@Composable
fun Display(viewModel: QuoteViewModel) {
    var quote by remember { mutableStateOf(viewModel.getRandomQuote()) }
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),

        contentAlignment = Alignment.Center
    ) {
        Card(modifier = Modifier.border(1.dp, Color.Black, shape = RoundedCornerShape(12.dp))) {
            Column(
                verticalArrangement = Arrangement.Center, modifier = Modifier.padding(16.dp),
            ) {
                Text(text = quote.text, )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "- ${quote.author}", fontStyle = FontStyle.Italic, style = typography.labelMedium,)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { quote = viewModel.getRandomQuote() }) {
                    Text("Get Another Quote")
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuoteOfTheDayTheme { }
}