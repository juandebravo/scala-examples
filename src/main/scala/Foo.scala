
package com.example

object Foo {

    def getRange(x:Int, y:Int): String = {
  		if (x == y) x.toString()
  		else if (x < y) x.toString() + getRange(x+1, y)
  		else x.toString() + getRange(x-1, y)
    }

    def findMaxNoSyntaxSugar(temperatures: List[Int]) = {
    	temperatures.foldLeft(Integer.MIN_VALUE) { (highest, value) =>
    		if (highest < value) highest
    		else value
    	}
    }

    def findMax(temperatures: List[Int]) = {
    	temperatures.foldLeft(Integer.MIN_VALUE) { Math.max }
    }

}
