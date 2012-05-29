package com.example.test

import com.example.actors._

import org.scalatest.FunSuite

class ActorsTest extends FunSuite {

    test("6 is a perfect number") {
        assert(Calculator.isPerfect(6) == true)
    }

}
