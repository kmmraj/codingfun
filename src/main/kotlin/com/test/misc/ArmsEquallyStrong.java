package com.test.misc;
//Call two arms equally strong if the heaviest weights they each are able to lift are equal.
//
//Call two people equally strong if their strongest arms are equally strong (the strongest arm can be both the right and the left), and so are their weakest arms.
//
//Given your and your friend's arms' lifting capabilities find out if you two are equally strong.
//
//Example
//
//For yourLeft = 10, yourRight = 15, friendsLeft = 15, and friendsRight = 10, the output should be
//solution(yourLeft, yourRight, friendsLeft, friendsRight) = true;
//For yourLeft = 15, yourRight = 10, friendsLeft = 15, and friendsRight = 10, the output should be
//solution(yourLeft, yourRight, friendsLeft, friendsRight) = true;
//For yourLeft = 15, yourRight = 10, friendsLeft = 15, and friendsRight = 9, the output should be
//solution(yourLeft, yourRight, friendsLeft, friendsRight) = false.
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] integer yourLeft
//
//A non-negative integer representing the heaviest weight you can lift with your left arm.
//
//Guaranteed constraints:
//0 ≤ yourLeft ≤ 20.
//
//[input] integer yourRight
//
//A non-negative integer representing the heaviest weight you can lift with your right arm.
//
//Guaranteed constraints:
//0 ≤ yourRight ≤ 20.
//
//[input] integer friendsLeft
//
//A non-negative integer representing the heaviest weight your friend can lift with his or her left arm.
//
//Guaranteed constraints:
//0 ≤ friendsLeft ≤ 20.
//
//[input] integer friendsRight
//
//A non-negative integer representing the heaviest weight your friend can lift with his or her right arm.
//
//Guaranteed constraints:
//0 ≤ friendsRight ≤ 20.
//
//[output] boolean
//
//true if you and your friend are equally strong, false otherwise.
public class ArmsEquallyStrong {

    boolean solution(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
        // TC#5 : yourLeft: 10 yourRight: 15 friendsLeft: 5 friendsRight: 20
        // TC#4 : yourLeft: 10 yourRight: 5 friendsLeft: 5 friendsRight: 10
        double yourRatio = 0;
        if (yourLeft != 0 && yourRight != 0) {
            if (yourLeft > yourRight) {
                yourRatio = yourLeft / yourRight;
            } else {
                yourRatio = yourRight / yourLeft;
            }
        }
        double friendRatio = 0;
        if (friendsLeft != 0 && friendsRight != 0) {
            if (friendsLeft > friendsRight) {
                friendRatio = friendsLeft / friendsRight;
            } else {
                friendRatio = friendsRight / friendsLeft;
            }
        }

        System.out.println("yourRatio is " + yourRatio + " friendRatio is " +friendRatio);

        return (yourLeft + yourRight) == (friendsLeft + friendsRight)
                && friendRatio == yourRatio;
        //    && friendRatio <= 4.0 && yourRatio <= 4.0;
    }

    boolean workingSolution(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
        int yourWeakest = Math.min(yourLeft, yourRight);
        int yourStrongest = Math.max(yourLeft, yourRight);
        int friendsWeakest = Math.min(friendsLeft, friendsRight);
        int friendsStrongest = Math.max(friendsLeft, friendsRight);
        return yourStrongest == friendsStrongest && yourWeakest == friendsWeakest;
    }

    public static void main(String[] args) {
        ArmsEquallyStrong armsEquallyStrong = new ArmsEquallyStrong();
        System.out.println(armsEquallyStrong.solution(10, 15, 5, 20));
        System.out.println(armsEquallyStrong.solution(10, 5, 5, 10));
        System.out.println(armsEquallyStrong.solution(10, 15, 5, 20));
        System.out.println(armsEquallyStrong.solution(10, 15, 5, 20));
        System.out.println(armsEquallyStrong.solution(10, 15, 5, 20));
        System.out.println(armsEquallyStrong.solution(10, 15, 5, 20));
        System.out.println(armsEquallyStrong.solution(10, 15, 5, 20));
        System.out.println(armsEquallyStrong.solution(10, 15, 5, 20));
        System.out.println(armsEquallyStrong.solution(10, 15, 5, 20));
        System.out.println(armsEquallyStrong.solution(10, 15, 5, 20));
    }
}
