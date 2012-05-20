package com.example.traits

// Trait:
// - behavior that can be mixed in or assimilated into a class hierarchy.
// - Interface with partial implementation

// constructor cannot take any argument
trait Reader {
	// must be declared in the class where mixes in
	var books: Set[String]

	def readBook(book: String) = true
}