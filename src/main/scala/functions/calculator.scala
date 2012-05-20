package com.example.functions

class Calculator(val initialValue: Int) {
	// Currying: transforms a function that takes more than one parameter
	// into a function that takes multiple parameters list
	def execute(number: Int)(operation: (Int, Int) => Int) : Int = {
		operation(number, initialValue)
	}

	def add(number: Int) = initialValue + number

	// cannot end a method name with ":"" unless we proceed it with underscore or its an operator
	// this method may be used like this: number add_: Calculator instance
	def add_:(number: Int) = this.add(number)

	// operator does not need to end with "_" before ":"
	// 2 +: (Calculator instance)
	def +:(number: Int) = this.add(number)

	// unary operators:
    //      val a = new Calculator(-10)
    //      +a => 10
	def unary_+ = initialValue.abs

	def unary_- = -initialValue

	def unary_~ = 1/initialValue
}

object Calculator {

	// method definition
	def sum_func(i: Int, j: Int) = i+j

	// method definition
	val mult_func = { (i: Int, j: Int) => i*j }

	private def exec(initialValue: Int, args: Int*)(codeBlock: (Int, Int) => Int) : Int = {
		//args.foldLeft(initialValue) { (value, index) => codeBlock(value, index) }
		(initialValue /: args) { codeBlock }
	}

	def sum(args: Int*) = {
		// args is defined as an Array, so we need to explode the array to discrete values
		// method (last parameter) using curly braces
		this.exec(0, args: _*) { sum_func }
	}

	def mult(args: Int*) = {
		// args is defined as an Array, so we need to explode the array to discrete values
		// method (last parameter) using parens
		this.exec(1, args: _*)(mult_func)
	}

	def evens(args: Array[Int]) = {
		args.filter(x => x % 2 == 0)
	}

	def odds(args: Array[Int]) = {
		args.filter(x => x % 2 == 1)
	}

	def execute(numbers: Int*)(operation: (Int, Int) => Int) : Int = {
		//numbers.foldLeft(0) { (value, index) => operation(value, index) }
		//numbers.foldLeft(0) { operation(_, _) }
		numbers.foldLeft(0) { operation }
	}

	def executeClosure(numbers: Int*) = {
		var product = 1
		numbers.foreach { product*=_ }
		product
	}
}