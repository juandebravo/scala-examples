package com.example.test

import com.example.classes._

// We're including the method purchase to Vehicle instances
import com.example.classes.PurchaseObject._

import org.scalatest.Suite

class PurchaseTest extends Suite {

    def testPurchaseVehicule() {
        val vehicle = new Vehicle(1975)
        assert(vehicle.purchase() == true)
    }

    def testPurchaseCar() {
        val car = new Car(1975)
        assert(car.purchase() == true)
    }
}
