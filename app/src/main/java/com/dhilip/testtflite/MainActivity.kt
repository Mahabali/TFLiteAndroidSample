package com.dhilip.testtflite

import android.os.Bundle
import android.widget.SeekBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dhilip.testtflite.ui.theme.TestTFLiteTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import java.text.DecimalFormat

class MainActivity : ComponentActivity() {
    private var resultText = mutableStateOf("0")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTFLiteTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(topBar = {
                        TopAppBar(
                            title = { Text("Test TFLite") },
                            backgroundColor = MaterialTheme.colors.primary
                        )
                    }) {
                        Column(Modifier.padding(5.dp)) {
                            Spacer(modifier = Modifier.height(26.dp))
                            Spacer(modifier = Modifier.height(56.dp))
                            Slider(onValueChange = { value: Float -> runPrediction(input = value) })
                            Spacer(modifier = Modifier.height(26.dp))
                            TextFormat(text = "Output : ${resultText.value}")
                        }
                    }

                }

            }
        }
    }

    override fun onResume() {
        super.onResume()

    }
    // Prediction and update
    private fun runPrediction(input: Float) {
        val mlProvider = MLProvider()
        mlProvider.loadInterpreter(this)
        val result = mlProvider.predictValue(input);
        this.resultText.value = formatValue(result)
    }
}


@Composable
fun TextFormat(text: String) {
    Text(
        text = "$text",
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun Slider(onValueChange: (Float) -> Unit) {
    Spacer(modifier = Modifier.padding(10.dp))
    var sliderValue by remember {
        mutableStateOf(value = 0.0f)
    }
    val text = "Input Value : " + formatValue(sliderValue)
    TextFormat(text = text)
    Row(modifier = Modifier.padding(5.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = "0", modifier = Modifier.padding(5.dp))
        androidx.compose.material.Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = 0f..30f,
            modifier = Modifier.fillMaxWidth(0.90f),
            onValueChangeFinished = { onValueChange(sliderValue) })
        Text(text = "30", modifier = Modifier.padding(5.dp))
    }

}

// format to 2 decimals
fun formatValue(input: Float): String {
    val df = DecimalFormat("#.##")
    return df.format(input)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestTFLiteTheme {
        Column(Modifier.padding(5.dp)) {
            TextFormat("Android")
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}