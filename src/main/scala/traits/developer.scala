package com.example.traits


// Composition using a trait
class Developer(val name: String,
	val languages: Set[String],
	val years: Int,
	var books: Set[String]) extends Reader