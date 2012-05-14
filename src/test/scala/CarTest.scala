package com.example.test

import com.example.classes.Vehicle
import com.example.classes.Motorcycle
import com.example.classes.Car
import com.example.classes.Mercedes
import com.example.classes.Renault
import com.example.classes.Train
import org.scalatest.Suite

class CarTest extends Suite {

    def testConstructorVehicule() {
        val vehicle = new Vehicle(1975)
        assert(vehicle.year == 1975)
    }

    def testToString() {
        val motorcycle = new Motorcycle(1975, "Spain")
        assert(motorcycle.toString == "This motorcycle was bought on 1975 in Spain")
    }

    def testConstructor() {
    	val car = new Car(1975)
        assert(car.year == 1975)
    }

    def testSecondConstructor() {
    	val car = new Car(1975, 1000)
        assert(car.year == 1975)
        assert(car.miles == 1000)
    }

    def testMilesDrive() {
    	val car = new Car(1975)
        assert(car.miles() == 0)
    }

    def testDrive() {
    	val car = new Car(1975)
    	car.drive(500)
        assert(car.miles() == 500)
    }

    def testVariance() {
        val train = new Train(1975)
        val cars = Array(new Car(1978), new Mercedes(1978, "S210"))
        assert(train.addCars(cars) == 2)
    }

    def testAdd() {
        val car = new Car(1975)
        car.drive(400)
        car+100
        assert(car.miles() == 500)
    }

    def testVisibilityPrivate() {
        val car = new Car(1975)
        // raises exception due to private method called
        //car.checkMiles()
    }

    def testVisibilityProtected() {
        val mercedes_1 = new Mercedes(1975, "S210")
        val mercedes_2 = new Mercedes(1975, "S210")
        assert(mercedes_1.hasSameBranding(mercedes_2) == true)
    }

    def testVisibilityGrainedProtected() {
        val mercedes_1 = new Mercedes(1975, "S210")
        val renault = new Renault(1975, "25")
        assert(renault.hasSameBranding(mercedes_1) == false)
    }
}
