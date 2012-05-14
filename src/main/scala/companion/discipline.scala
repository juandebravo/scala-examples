package com.example.companion

class Discipline private(val name: String) {
	override def toString() : String = "discipline name " + name
}

// Companion object. Provide class-level convenience methods
// It can create new instances even though constructor is private
object Discipline {
	private val disciplines = Map(
		"dynamic-languages" -> new Discipline("dynamic-languages"),
		"functional-languages" -> new Discipline("functional-languages"),
		"java-sucks" -> new Discipline("java-sucks")
	)

	// syntax sugar. This method is invoked directly calling Discipline(<discipline_string>)
	def apply(discipline: String) = if (disciplines.contains(discipline)) disciplines(discipline) else null
}