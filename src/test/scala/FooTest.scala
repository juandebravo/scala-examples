package com.example.test

import com.example.Foo
import org.scalatest.Suite

class FooTest extends Suite {

    def testgetRange() {
        assert("2345" == Foo.getRange(2, 5))
    }

    def testgetRangeSameNumber() {
        assert("2" == Foo.getRange(2, 2))
    }

    def testgetRangeXGreaterThanY() {
        assert("98765" == Foo.getRange(9, 5))
    }

    def testfindMaxListOfTemperatures() {
    	assert(10 == Foo.findMax(List(1, 2, 3, 10)))
    }

    def testfindMaxNoSyntaxSugarListOfTemperatures() {
    	assert(10 == Foo.findMax(List(1, 2, 3, 10)))
    }

}
