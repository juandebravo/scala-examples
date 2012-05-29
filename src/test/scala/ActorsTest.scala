package com.example.test

import com.example.actors._

import org.scalatest.Suite

class ActorsTest extends Suite {

    def testisPerfect() {
        assert(Calculator.isPerfect(6) == true)
    }

    def testisPerfectLong() {
        val startTime = System.nanoTime()
        assert(Calculator.isPerfect(33550336) == true)
        println(System.nanoTime()-startTime)
    }

    def testisPerfectLongRecursive() {
        val startTime2 = System.nanoTime()
        assert(Calculator.isPerfectR(33550336) == true)
        println(System.nanoTime()-startTime2)
    }

    def testisPerfectActor() {
        val startTime2 = System.nanoTime()
        assert(Calculator.isPerfectConcurrent(33550336) == true)
        println(System.nanoTime()-startTime2)
    }

    def testisPerfectRangeActor() {
        val startNumber = 33550300
        val endNumber = 33550300 //33550400
        val startTime2 = System.nanoTime()
        //val number1 = Calculator.countPerfectNumbersInRange(startNumber, endNumber, Calculator.isPerfect)
        println("Range NO actors => " + (System.nanoTime()-startTime2))
        val startTime = System.nanoTime()
        //val number2 = Calculator.countPerfectNumbersInRange(startNumber, endNumber, Calculator.isPerfectConcurrent)
        println("Range actors => " +(System.nanoTime()-startTime))
    }

}
