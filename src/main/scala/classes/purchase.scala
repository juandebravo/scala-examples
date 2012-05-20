package com.example.classes

// We need to include this file to inject the purchase method to Vehicle instances

class PurchaseObject(vehicle: Vehicle) {
	// define a method that can be injected to a Vehicle instance
	def purchase() = true
}

object PurchaseObject {
	// implicit conversion, basic concept to create a PurchaseObject from a Vehicle instance
	// and inject the purchase method
	implicit def convertVehicle2PurchaseObject(vehicle: Vehicle) = new PurchaseObject(vehicle)
}