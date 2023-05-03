package com.test

fun main(args: Array<String>) {
    secondLowValueByScan()
}

fun secondLowValueBySort() {
    val intArrOne = intArrayOf(35,2,5,3,7,9,22,99,15,1)
    intArrOne.sort()
    print(intArrOne[1])
}

fun secondLowValueByScan() {
    val intArrOne = intArrayOf(35,2,5,3,7,9,22,99,15,1)
    var smallestValue =  intArrOne[0]
    var secondSmallestValue = intArrOne[0]
    intArrOne.forEach {
        if (it < smallestValue ) {
            secondSmallestValue = smallestValue
            smallestValue = it
        }
    }
    println(smallestValue)

//    var tempVal = intArrOne[0]
//    intArrOne.forEach {
//        if(it > smallestValue && it < secondSmallestValue) secondSmallestValue = it
//    }
    println(secondSmallestValue)
}
