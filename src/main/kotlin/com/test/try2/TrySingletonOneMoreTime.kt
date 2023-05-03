package com.test.try2

object TrySingletonOneMoreTime {
    val member:String = "SingletonValue"
}

fun main() {
    val trySingleton: TrySingletonOneMoreTime = TrySingletonOneMoreTime
    print(trySingleton.member)
}