package com.example.basic_types

object PersonDB {

	val database_info = """This database is
		|an in-memory dataBase
		|used just as an example""".stripMargin('|')

	private val dataBase = Map(
		0 -> ("Juan", "de Bravo", "Ruby"),
		1 -> ("Toni", "Cebrián", "Haskell"),
		2 -> ("Ivan", "Montes", "JavaScript")
	)

	def getPersonInfo(id: Int) = dataBase(id)

	def getDatabaseInfo() = database_info

}