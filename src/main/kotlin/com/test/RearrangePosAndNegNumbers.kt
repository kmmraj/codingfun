package com.test

class RearrangePosAndNegNumbers {



    fun reArrangeNumbers(intArrayOne: IntArray): IntArray {
        val intArrayTwo = IntArray(intArrayOne.size)
       // intArrayOne.sort()
        var indx = 0
        val length =  intArrayOne.size

        // sorting
//        while (indx < length-1) {
            for (indx in 0 until length -1 step  1) {
            var secIndx = 0
            for (secIndx in 0 until length-indx-1 step 1) {
//            while (secIndx < length-indx-1) {
                if (intArrayOne[secIndx] > intArrayOne[secIndx + 1]) {
                    val temp = intArrayOne[secIndx]
                    intArrayOne[secIndx] = intArrayOne[secIndx + 1]
                    intArrayOne[secIndx + 1] = temp
                }
               // secIndx++
            }
//           indx++
        }
        var posIndx = 0
        var negIndx = intArrayOne.size
        var indxTwo = 0
        var startMode = true
        while(posIndx < intArrayOne.size && negIndx > 0 && indxTwo < intArrayTwo.size) {
            if(startMode){
                intArrayTwo[indxTwo++] = intArrayOne[posIndx++]
            } else {
               intArrayTwo[indxTwo++] = intArrayOne[--negIndx]
            }
            startMode = !startMode

        }

        while(posIndx < intArrayOne.size && indxTwo < intArrayTwo.size) {
            intArrayTwo[indxTwo++] = intArrayOne[posIndx++]
        }

        while( negIndx > 0 && indxTwo < intArrayTwo.size) {
            intArrayTwo[indxTwo++] = intArrayOne[--negIndx]
        }

        return intArrayTwo
    }
}

fun main() {
    val intArrayOne = intArrayOf(1,-2, -7, 4,-9,11, -8,14,-15,21,22,0)
//    val intArrayOne = intArrayOf(1,-2, -7, 4)

    val finalResult: IntArray = RearrangePosAndNegNumbers().reArrangeNumbers(intArrayOne)
    finalResult.forEach { print("$it,") }

}
