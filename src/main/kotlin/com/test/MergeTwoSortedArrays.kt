package com.test

fun main() {
    val intArrayOne = intArrayOf(1,4,9,11,14)
    val intArrayTwo = intArrayOf(2,4,7,13,19,21)
//    val finalResult: IntArray = mergeTwoSortedArrays(intArrayOne, intArrayTwo)
    val finalResult: IntArray = mergeTwoByInsert(intArrayOne, intArrayTwo)
    finalResult.forEach { print("$it,") }
   // print("Result is ${finalResult.toString()}")
}

fun mergeTwoSortedArrays(intArrayOne: IntArray, intArrayTwo: IntArray): IntArray {
    val totalSize = intArrayOne.size+intArrayTwo.size
    var mergedArray = IntArray(0)
    mergedArray = mergedArray.plus(intArrayOne)
    mergedArray = mergedArray.plus(intArrayTwo)
    mergedArray.sort()
    return mergedArray
}


fun mergeTwoByInsert(intArrayOne: IntArray, intArrayTwo: IntArray): IntArray {
    val totalSize = intArrayOne.size+intArrayTwo.size
    val mergedArray = IntArray(totalSize)
    var indxOne = 0
    var indxTwo = 0
    var indxMerged = 0

   while (indxOne < intArrayOne.size && indxTwo < intArrayTwo.size) {
       if ( intArrayOne[indxOne] < intArrayTwo [indxTwo]) {
           mergedArray[indxMerged++] = intArrayOne[indxOne++]
       } else {
           mergedArray[indxMerged++] = intArrayTwo[indxTwo++]
       }
   }

    while(indxOne < intArrayOne.size) {
        mergedArray[indxMerged++] = intArrayOne[indxOne++]
    }
    while(indxTwo < intArrayTwo.size) {
        mergedArray[indxMerged++] = intArrayTwo[indxTwo++]
    }

    return mergedArray
}

fun IntArray.toString() : String{
    var finalString = ""
    forEach {
        finalString += it
    }
    return finalString
}
