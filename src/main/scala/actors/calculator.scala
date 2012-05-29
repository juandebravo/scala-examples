package com.example.actors

import scala.actors.Actor._

class Calculator {

}

object Calculator  {

    def sumOfFactors(number: Int) = {
        (0 /: (1 to number)) { (sum, i) => if(number % i == 0) sum + i else sum }
    }

    def sumOfFactorsInRange(from: Int, upper: Int, number: Int) = {
        (0 /: (from to upper)) { (sum, i) => if(number % i == 0) sum + i else sum }
    }

    def sumOfFactorsRecursive(from: Int, number: Int): Int = {
        if (from == number)
            number
        else {
            if(number % from == 0)
                from + sumOfFactorsRecursive(from+1, number)
            else
                sumOfFactorsRecursive(from+1, number)
        }
    }

    def isPerfect(number: Int) = 2 * number == sumOfFactors(number)

    def isPerfectR(number: Int) = 2 * number == sumOfFactorsRecursive(1, number)

    def isPerfectConcurrent(number: Int) = {
        val RANGE = 1000000
        val numberOfPartitions = (number.toDouble / RANGE).ceil.toInt

        val caller = self

        for(i <- 0 until numberOfPartitions) {
            val lower = i * RANGE + 1
            val upper = number min (i+1) * RANGE

            actor {
                caller ! sumOfFactorsInRange(lower, upper, number)
            }
        }

        val sum = (0 /: (0 until numberOfPartitions)) { (partialSum, i) =>
            receive {
                case sumInRange: Int => partialSum + sumInRange
            }
        }

        2 * number == sum
    }

    def countPerfectNumbersInRange(start: Int, end: Int, isPerfectFinder: Int => Boolean) = {
        val numberOfPerfectNumbers = (0 /: (start to end)) { (count, num) =>
            if(isPerfectFinder(num)) count +1 else count
        }
        numberOfPerfectNumbers
    }


}