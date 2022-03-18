package com.dhilip.testtflite

import android.content.Context
import android.util.Log
import org.tensorflow.lite.Interpreter
import java.nio.MappedByteBuffer
import java.io.IOException

import org.tensorflow.lite.support.common.FileUtil

class MLProvider {

    lateinit var interpreter: Interpreter

    fun loadInterpreter(context: Context) {
        val buffer = FileUtil.loadMappedFile(context, "SampleMLModel.tflite")
        interpreter = Interpreter(buffer)
    }

    fun predictValue(input: Float): Float {
        val inputVal = FloatArray(1)
        inputVal[0] = input
        val output = Array(1) {
            FloatArray(
                1
            )
        }
        interpreter.run(inputVal, output)
        Log.d("MLProvider :", " " + output[0][0])
        return output[0][0]
    }
}