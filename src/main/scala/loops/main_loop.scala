package com.example.loops

object MainLoop {

	def getSum(index_from: Int, index_to: Int): Int = {
		var value = 0
		for(i <- index_from to index_to) {
			value = value + i
		}
		value
	}

	def getSumForEach(index_from: Int, index_to: Int): Int = {
		(index_from to index_to).foldLeft(0) { (value, index) => value + index }
	}

	def getSumForEachNoArguments(index_from: Int, index_to: Int): Int = {
		(index_from to index_to).foldLeft(0) { _+_ }
	}

	def getSumRecursive(index_from: Int, index_to: Int): Int = {
		if(index_from == index_to)
			index_from
		else
			index_from + getSumRecursive(index_from+1, index_to)
	}
}