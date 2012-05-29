package com.example.test

import com.example.traits._
import com.example.traits.decorating._

import org.scalatest.Suite

class CollectionsTest extends Suite {

    def testCollectionFilter() {
        // Create an instance with the list of checks that we need to validate if
        // a developer is senior
        // Traits are binding from right (first executed) to left
        // FunctionalCheck uses Set#filter method
        val functionalDeveloper = new Check(2, 8) with LanguagesCheck with ExperienceCheck with FunctionalCheck

        val toni = new Developer("Toni", Set("Haskell", "Scala"), 12, Set("Lean Startup"))
        assert(functionalDeveloper.check(toni) == true)
    }

    def testCollectionMerge() {
        val toni = new Developer("Toni", Set("Haskell", "Scala"), 12, Set("Lean Startup"))
        val juan = new Developer("Juan", Set("Scala", "Ruby"), 12, Set("Crafting Rails applications"))
        val books = toni.books ++ juan.books
        val languages = toni.languages ++ juan.languages
        assert(books.size == 2)
        assert(languages.size == 3)
    }

    def testCollectionIntersect() {
        val toni = new Developer("Toni", Set("Haskell", "Scala"), 12, Set("Lean Startup"))
        val juan = new Developer("Juan", Set("Scala", "Ruby"), 12, Set("Crafting Rails applications"))
        val languages = toni.languages ** juan.languages
        assert(languages.size == 1)
    }

    def testCollectionMap() {
        val developer = new Developer("DHH", Set("Haskell", "Scala"), 12, Set("Lean Startup"))
        val books = developer.books.map("Book -" + _)
        assert(books.filter(_ startsWith "Book -").size == developer.books.size)
    }
}

class MapTest extends Suite {

    def testFilterKeys() {
        val cities = Map("Madrid" -> "28*",
                         "Barcelona" -> "08*",
                         "Valladolid" -> "47*",
                         "Malaga" -> "41*")

        // filter keys
        assert(cities.filterKeys(_ contains "Ma").size == 2)


    }

    def testFilter() {
        val cities = Map("Madrid" -> "28*",
                         "Barcelona" -> "08*",
                         "Valladolid" -> "47*",
                         "Malaga" -> "41*")

        // filter
        assert((cities.filter { element =>
            val (key, value) = element
            (key contains "Ma") && (value contains "28")}).size == 1)
    }

    def testApply() {
        val cities = Map("Madrid" -> "28*",
                         "Barcelona" -> "08*",
                         "Valladolid" -> "47*",
                         "Malaga" -> "41*")

        // apply method
        assert(cities("Madrid") == "28*")
    }
}

class ListTest extends Suite {
    def testAppendElement() {
        val names = List("john", "matthew", "george")
        // append as first element. Work always in head as it is much more efficient
        val names_1 = "peter" :: names
        assert(names_1.size == 4)
        assert(names_1(0) == "peter")
    }

    def testAppendList() {
        val names = List("john", "matthew")
        // append as first element. Work always in head as it is much more efficient
        val names_1 = List("peter", "george") ::: names
        assert(names_1.size == 4)
        assert(names_1.head == "peter")
        assert(names_1(1) == "george")
    }

    def testFoldLeft() {
        val names = List("john", "matthew", "george")

        assert(names.foldLeft(0){_+_.size} == 17)

        // this is the same operation
        assert((0 /: names) {_+_.size} == 17)
        // method name convention /: => in reality is a List method
        assert((names./:(0)) {_+_.size} == 17)
    }

    def testFoldRight() {
        val names = List("john", "matthew", "george")
        assert(names.foldRight(0){_.size+_} == 17)
    }

    def testForLoop() {
        // list comprehension
        val values = for(i <- 1 to 10; if i % 2 == 0)
            yield i*2

        assert(values == Vector(4, 8, 12, 16, 20))
    }

    def testForLoopDefineVariable() {
        val names = Vector("John", "Mathew", "George", "Peter")

        // list comprehension
        val initialLetters = for(name <- names; initialLetter = name(0)) yield initialLetter

        print(initialLetters)
        assert(initialLetters == Vector('J', 'M', 'G', 'P'))
    }
}
