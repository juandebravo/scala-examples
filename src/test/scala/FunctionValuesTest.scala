package com.example.test

import com.example.functions.Calculator

import org.scalatest.Suite

class FunctionValuesTest extends Suite {

    def testSum() {
        val value = Calculator.sum(1, 2, 3, 4)
        assert(value == 10)
    }

    def testMult() {
        val value = Calculator.mult(1, 2, 3)
        assert(value == 6)
    }

    def testCurrying() {
    	val value = new Calculator(10)
    	val foo = value.execute(10){ (i, j) => i+j }
        assert(foo == 20)
    }

    def testCurryingCompanion() {
    	val foo = Calculator.execute(1, 2, 3, 4, 5, 6){ (i, j) => i+j }
        assert(foo == 21)
    }

    def testPartiallyApplied() {
    	val ten = Calculator.sum_func(10, _: Int)
    	assert(ten(10) == 20)
    }

    def testClosure() {
    	assert(Calculator.executeClosure(1,2,3) == 6)
    }

    def testMethodNameConvention() {
        val value = new Calculator(10)
        assert(value.add(2) == 12)
        assert((2 add_: value) == 12)

        assert((2 +: value) == 12)
    }

    def testUnaryMethods() {
        val value = new Calculator(-10)
        assert(+value == 10)
        assert(-value == 10)
        assert(~value == -1/10)
    }

}
