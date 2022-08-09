package com.example.myapplication

import java.lang.IllegalArgumentException

fun main() {
    val prices = mutableListOf<Int>(5,100,20,66,16)
    val result = decryptData(prices, 50, 1, 3)
    println(result)

}

fun decryptData(
    prices: MutableList<Int>,
    discount: Int,
    offset: Int,
    readLength: Int
): List<Int> {
    if (prices.any { it <= 0 }) throw IllegalArgumentException("Prices should be positive")
    if (discount < 1 || discount > 99) throw IllegalArgumentException("Discount should be beyond 1 to 99")
    if (offset < 0) throw IllegalArgumentException("Offset should be positive or zero")
    if (readLength <= 0) throw IllegalArgumentException("Read length should be positive")
    val result = prices.drop(offset).take(readLength).map {
        it - (it * discount / 100)
    }
    return result
}


