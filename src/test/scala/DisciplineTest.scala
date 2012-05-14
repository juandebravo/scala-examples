package com.example.test
 
import com.example.companion.Discipline
import org.scalatest.Suite
 
class DisciplineTest extends Suite {

    def testDiscipleInstance() {
        assert(Discipline("functional-languages").isInstanceOf[Discipline])
    }
 
    def testgetDisciple() {
        assert(Discipline("functional-languages").toString() == "discipline name functional-languages")
    }

}
