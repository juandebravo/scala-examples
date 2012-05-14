package com.example.classes

// Simple class definition with one parameter in primary constructor
class Vehicle(val year: Int)

class Motorcycle(override val year: Int) extends Vehicle(year) {
	private var country: String = _

	print("This is executed when a new Motorcycle instance is created")

	// auxiliary constructor
	def this(year: Int, country: String) {
		// first line in an auxiliary constructor definition should be a call to the primary
		// constructor or other auxiliary constructor
		this(year)
		this.country = country
	}

	// override is required to avoid typos
	override def toString() : String = {
		"This motorcycle was bought on " + this.year + " in " + this.country
	}
}

// if we overwrite a constructor, we need to indicate the parameters being overwritten
class Car(override val year: Int) extends Vehicle(year) {
	// by default, an attribute is defined as public
	private var milesDriven: Int = _ // default value

	def this(year: Int, milesDriven: Int) {
		this(year)
		this.milesDriven = milesDriven
	}

	private def checkMiles() = {
		if(milesDriven > 1000)
			print("Check your fuel")
	}

	// simple method definition, no argument
	def miles() = milesDriven

	// simple method definition, one argument
	// this method is returning void due to lack of "="
	def drive(distance: Int) {
		milesDriven += Math abs distance // not using "." nor parens
	}

	// operator overloading
	def +(distance: Int) {
		milesDriven += Math abs distance
	}

	// Not allow any other Car instance to check our engine
	protected[this] def checkEngine() {}

}

// overwrite Car constructor
class Mercedes(override val year:Int) extends Car(year) {

	// visible to the class, its derived classes and the current package
	protected[classes] var brand: String = _ // default value

	def this(year: Int, brand: String) {
		this(year)
		this.brand = brand
		checkEngine()
	}

	// return type inference (instead of including ": Boolean" in method definition)
	def hasSameBranding(other: Mercedes) = {
		brand == other.brand // protected visibility
	}
}

class Renault(override val year:Int) extends Car(year) {
	// visible to the class and its derived classes
	protected var brand: String = _ // default value

	// constructor
	def this(year: Int, brand: String) {
		this(year)
		this.brand = brand
	}

	def hasSameBranding(other: Mercedes) = {
		brand == other.brand // protected visibility
	}
}

class Train(val year: Int) {
	var numCars :Int = _

	// Variance f Parameterized Type
	def addCars[T <: Car](cars: Array[T]) = {
		cars.foreach(car => this.numCars=this.numCars+1)
		this.numCars
	}
}