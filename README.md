# Wallpaper-App

dependencies {


   //multidex
    implementation'androidx.multidex:multidex:2.0.1'

    //animation
    def lottieVersion = "3.4.0"
    implementation "com.airbnb.android:lottie:$lottieVersion"

    //firebase
    implementation platform('com.google.firebase:firebase-bom:31.3.0')
    implementation 'com.google.firebase:firebase-analytics-ktx'

    //glide
    implementation 'com.github.bumptech.glide:glide:4.15.1'

    //couroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    //round Image
    implementation 'com.makeramen:roundedimageview:2.3.0'
    
    }
