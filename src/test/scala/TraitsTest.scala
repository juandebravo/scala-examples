package com.example.test

import com.example.traits.Developer
import com.example.traits.Human
import com.example.traits.Reader
import com.example.traits.decorating.Check
import com.example.traits.decorating.LanguagesCheck
import com.example.traits.decorating.ExperienceCheck

import org.scalatest.Suite

class TraitsTest extends Suite {

    def testCallTraitMethod() {
        val developer = new Developer("Toni",
                                        Set("Haskell", "Scala"),
                                        12,
                                        Set("Scala is awesome"))
        assert(developer.readBook("Scala is awesome") == true)
    }

    def testCallObjectTraitMethod() {
        // Selective mixin
        // Mix in traits selectively at an instance level
        val human = new Human(Set("The portrait of Dorian Gray")) with Reader
        assert(human.readBook("The portrait of Dorian Gray") == true)
    }

    def testDecoratingWithTraits() {
        // Create an instance with the list of checks that we need to validate if
        // a developer is senior
        // Traits are binding from right (first executed) to left
        val seniorDeveloper = new Check(2, 8) with LanguagesCheck with ExperienceCheck
        val juniorDeveloper = new Check(1, 2) with LanguagesCheck with ExperienceCheck

        val toni = new Developer("Toni", Set("Haskell", "Scala"), 12, Set("Scala is awesome"))
        assert(seniorDeveloper.check(toni) == true)

        val marcos = new Developer("Marcos", Set("Java"), 2, Set("I like Java"))
        assert(seniorDeveloper.check(marcos) == false)
        assert(juniorDeveloper.check(marcos) == true)
    }

}
