package com.example.test

import com.example.loops.MainLoop
import org.scalatest.Suite

class LoopTest extends Suite {

    def testDefaultLoop() {
        val value = MainLoop getSum(1, 3)
        assert(value == 6)
    }

    def testForEachLoop() {
        val value = MainLoop getSumForEach(1, 3)
        assert(value == 6)
    }

    def testForEachLoopNoArguments() {
        val value = MainLoop getSumForEachNoArguments(1, 3)
        assert(value == 6)
    }

    def testRecursive() {
        val value = MainLoop getSumRecursive(1, 3)
        assert(value == 6)
    }


}
