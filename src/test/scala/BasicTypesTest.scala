package com.example.test

import com.example.basic_types.PersonDB
import org.scalatest.Suite

class TupleTest extends Suite {

    def testRetrieveTuple() {
        val value = PersonDB.getPersonInfo(1)
        assert(value._1 == "Toni")
        assert(value._2 == "Cebrián")
    }

    def testMultiLineString() {
        assert(PersonDB.getDatabaseInfo() == "This database is\nan in-memory dataBase\nused just as an example")
    }


}
