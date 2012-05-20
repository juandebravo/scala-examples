package com.example.traits.decorating

import com.example.traits.Developer

// General check
abstract class Check(val languages: Int, val years: Int) {
    def check(developer: Developer) : Boolean = true
}

// when extending an abstract class, this trait may be mixed in only with
// classes that extend Check
trait LanguagesCheck extends Check {
    // use the method of Check inside the trait
    override def check(developer: Developer) = {
        if(developer.languages.size >= this.languages) super.check(developer) else false
    }
}

trait ExperienceCheck extends Check {
    override def check(developer: Developer) = {
        if(developer.years >= this.years) super.check(developer) else false
    }
}

trait FunctionalCheck extends Check {
    override def check(developer: Developer) = {
        if(developer.books.filter(_ contains "Scala").size > 0 ||
        	developer.languages.filter(_ contains "Scala").size > 0)
        	super.check(developer)
        else
        	false
    }
}