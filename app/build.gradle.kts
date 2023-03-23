plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.mlkitsample"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.example.mlkitsample"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("androidx.compose.ui:ui:1.3.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.3")
    implementation("androidx.compose.material3:material3:1.0.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.camera:camera-camera2:1.3.0-alpha04")
    implementation("androidx.camera:camera-lifecycle:1.3.0-alpha04")
    implementation("androidx.camera:camera-view:1.3.0-alpha04")
    implementation("androidx.camera:camera-mlkit-vision:1.3.0-alpha04")
    implementation("com.google.mlkit:face-detection:16.1.5")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.3.3")

    debugImplementation("androidx.compose.ui:ui-tooling:1.3.3")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.3.3")
}
