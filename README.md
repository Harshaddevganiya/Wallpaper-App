// All dependencies for Wallpaper - App





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


// Download wallpaper code for  wallpaper-App

        binding.btnDownload.setOnClickListener {

            val result:Deferred<Bitmap?> = GlobalScope.async {
                urlImage.toBitmap()
            }

            GlobalScope.launch(Dispatchers.Main){

                saveImage(result.await())
            }
        }

    }

    fun URL.toBitmap() : Bitmap? {
        return try {
            BitmapFactory.decodeStream(openStream())
        }catch (e:IOException){
            null
        }
    }

    private fun saveImage(image:Bitmap?){

        val random1 = Random().nextInt(528985)
        val random2 = Random().nextInt(952663)

        val name="AMOLED -${random1 + random2}"

        val data:OutputStream
        try {
            val resolver=contentResolver
            val contentValues= contentValuesOf()
            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME,"$name.jpg")
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE,"image/jpg")
            contentValues.put(
                MediaStore.MediaColumns.RELATIVE_PATH,
                Environment.DIRECTORY_PICTURES+File.separator+"Amoled Wallpaper"
            )
            val imageUri=
                resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,contentValues)
            data = resolver.openOutputStream(Objects.requireNonNull(imageUri)!!)!!
            image?.compress (Bitmap.CompressFormat.JPEG,188, data)
            Objects.requireNonNull<OutputStream?>(data)

            Toast.makeText( this, "Image Save", Toast.LENGTH_SHORT).show()

        } catch (e: Exception) {

            Toast.makeText(this, "Image Not Save", Toast.LENGTH_SHORT).show()
        }
    } 
