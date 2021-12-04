# Weather Desktop App
### Made with Compose Multiplatform

Weather App is a desktop application made with Compose 
Multiplatform and Ktor Client. This is a simple application
to demonstrate the how to work with Ktor Client on desktop 
applications and how to work with Jetpack Compose. The code 
structure is similar to that of android and this project is
still in development phase to include more features and 
explore new ways to make desktop applications. 

### Tech-Stack
* Compose Multiplatform
* Ktor Client

### Languages 
* Kotlin

### APIs 
* Open Weather API 

### How to run 
There are a few steps to run this project on your local machine.

Steps are - 
* Clone the repository 
* Open the project in Intellij 
* Let the gradle build ( Kotlin DSL )
* Head over to [WeatherAPI.com](https://www.weatherapi.com/)
* Create your account and get the API key 
* Insert the API key in HttpRoutes file in Remote Package
* You can change the weather location in the code. 
* Open WeatherServiceImpl
* Change the value of the parameter `q` to `<your_location>`
* Run Main.kt file