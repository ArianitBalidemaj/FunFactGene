package com.example.funfactgene

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.funfactgene.ui.theme.FunFactGeneTheme
import kotlin.random.Random
import androidx.compose.ui.Alignment
import androidx.compose.material3.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.foundation.background

val customFontFamily = FontFamily(Font(R.font.oswaldbold))
val customFontFamily2 = FontFamily(Font(R.font.oswaldregular))

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FunFactGeneTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FunFactGen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun FunFactGen(modifier: Modifier = Modifier) {
    val facts = listOf(
        "Honey never spoils. Archaeologists have found pots of honey in ancient Egyptian tombs that are over 3,000 years old and still edible.",
        "A group of flamingos is called a 'flamboyance.'",
        "Bananas are berries, but strawberries aren't.",
        "Octopuses have three hearts and blue blood.",
        "The shortest war in history lasted only 38 to 45 minutes between Britain and Zanzibar on August 27, 1896."
    )

    var currentFactIndex by remember { mutableStateOf(Random.nextInt(facts.size)) }

    fun getNextFact() {
        currentFactIndex = (currentFactIndex + 1) % facts.size
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(
                colors = listOf(Color(0xFF005148), Color(0xFFA3EBA3))
            ))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = facts[currentFactIndex],
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontFamily = customFontFamily2,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(
            onClick = { getNextFact() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(text = "Next Fact", fontSize = 18.sp, fontFamily = customFontFamily,)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FunFactGeneTheme {
        FunFactGen()
    }
}