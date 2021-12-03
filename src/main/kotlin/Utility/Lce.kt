package Utility

sealed class Lce<out T>{
    object Loading : Lce<Nothing>() // 1
    data class Content<T>(val data: T) : Lce<T>() // 2
    data class Error(val error: Throwable) : Lce<Nothing>() // 3
}
