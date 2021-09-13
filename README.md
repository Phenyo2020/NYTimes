# NYTimes

Kotlin Assessment

This is a simple news feed application based on Retrofit and CardView, The description of this project is to first send a api request on the server for news json data , then shows into CardView, after that whenever we click on any news item it will show the article on that news...

## Built using
- [Kotlin] - First class and official programming language for Android development.
- [Android Architecture Components] - Collection of libraries that help you design robust, testable, and maintainable apps.
- [Retrofit] - A type-safe HTTP client for Android and Java.
- [GSON Converter] - A Converter which uses Gson for serialization to and from JSON.
- [ViewModel] - Stores UI-related data that isn't destroyed on UI changes. 
- Glide Loading and caching images
- API for Flash News App is from  [https://developer.nytimes.com/get-started]

  ## Architecture
This app uses [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture.

## Installation
This app is only compatible with Android Jelly Bean and higher.

The apk file is available for download under the [releases] tab.

You will require latest version of Android Studio 3.0 (or newer) to be able to build the app
To build this project, use the "gradlew build" command or use "Import Project" in Android Studio 

STEPS

The app can be installed and tested in 5 steps:

1. Install Android Studio on your machine.

2. Create an Android Virtual Device (AVD) in your Android Studio.
 
3. Clone the NYTimes repo to your local machine.

4. Open the cloned local project in Android Studio.

5. Run the app.

## Testing
The architecture components are highly testable. Following table shows how to test various parts of the app

|  Component |     Test     |        Mock        |
|:----------:|:------------:|:------------------:|
|     UI     |   Espresso   |      ViewModel     |
|  ViewModel |     JUnit    |     Repository     |
| Repository |     JUnit    |    WebService      |
|            | Instrumented |                    |
| WebService | Instrumented |    MockWebServer   |

Thank you for the opportunity 🙏 😊

