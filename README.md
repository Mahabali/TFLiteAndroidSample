# TensorFlowForMobile

This is a simple tutorial for implementing machine learning with custom model in mobile apps. This tutorial consists of 3 parts


## Repos
  Simple TensorFlow Model for computing y= 2x+1. There are 3 repos
  
1. [Tensorflow model](https://github.com/Mahabali/TensorFlowForMobile)
2. [TensorflowLite Model for Android](https://github.com/Mahabali/TFLiteAndroidSample). 
3. [CoreML model for iOS (using CoreML tools)](https://github.com/Mahabali/CoreMLSampleiOS)

## Model Info

This model is used to calculate 2x+1 value for the given input. Accuracy is 98%.


## Android Project Info
Android project uses Jeptack Compose and TensorflowLite. Code is meant to be kept simple. Do not use this for production.

## How to use

1. Go to colab.google.com
2. Clone and Open the jupyter notebook(ipynb) in this [repo](https://github.com/Mahabali/TensorFlowForMobile)
3. Click 'Connect' and wait till you get a free connection to google compute python backend
4. Run the code
5. Download SampleTFLiteModel.tflite and replace the existing 'SampleTFLiteModel.tflite' in 'ml' folder
6. Run the android app
7. Select the input via Slider in the emulator
8. Output in displayed below

Alternatively, I have included my training model in this repo and so you can do steps #6-#8 .

## Screenshot
![Screenshot](https://github.com/Mahabali/TFLiteAndroidSample/blob/main/Screenshot.png)
