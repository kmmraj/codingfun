package com.test

import java.lang.IllegalArgumentException

fun main() {
    val intArray = intArrayOf(9,4,9,6,7,4,6,8)
    print("Result is ${firstNonRepeatingInt(intArray)}")
}

fun firstNonRepeatingInt(intArray: IntArray): Int {
    val distinctValueMap = HashMap<Int,Int>()
    intArray.forEach {
        val intValue = it
        if(distinctValueMap.containsKey(it)) {
            var count = distinctValueMap.get(intValue)
            count?.let {
                distinctValueMap.put(intValue,count+1)
            }
        } else {
            distinctValueMap.put(intValue,1)
        }
    }

    distinctValueMap.forEach{
        if(it.value == 1) {
            return it.key
        }
    }
    throw IllegalArgumentException("Not valid results")
}
