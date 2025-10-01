package com.ffucks

object ObjectOriented extends App {
  //class and instance
  class Animal {
    //define fields
    val age: Int = 0

    //define methods
    def eat() = println("I'm eating")
  }

  val anAnimal = new Animal


  //inheritance
  class Dog(val name: String) extends Animal //Constructor definition after the class name

  val aDog = new Dog("Lassie")

  //constructor arguments are NOT FIELDS: need to put val or var to make them fields
  aDog.name

  //sybtyping polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hashi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  //abstract class
  abstract class WalkingAnimal {
    val hasLegs = true //by default public, can restrict using private or protected
    def walk(): Unit
  }

  // "interface" = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat" // can have fields too
  }

  trait Philosopher {
    def ?!(thought: String): Unit // ?! is a valid method name
  }

  //scala offer single class inheritance and multiple trait inheritance ("mixing")
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println(s"I'm eating ${animal.toString}")
    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog //infix notation = object method argument, only available for methods with ONE argument
  aCroc ?! "What if we could fly?"

  //operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherMath = 1.+(2) //its equivalent

  //anonymous classes
  val dinossaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I'm a dinossaur so I can eat pretty much anything")
  }

  /*
      What you tell to the compiler
     class Carnivore_Anonymous_31213 extends Carnivore {
       override def eat(animal: Animal): Unit = println("I'm a dinossaur so I can eat pretty much anything")
     }

      val dinossaur = new Carnivore_Anonymous_31213
   */

  //singleton object
  object MySingleton { //the only instance of this object
    val mySpecialValue = 53278
    def mySpecialMethod(): Int = 5327
    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // equivalent to MySingleton.apply(65)

  object Animal { //companions - companion object
    //companions can access each other's private fields/methods
    //singleton Animal and instances of the class Animal are different things
    val canLiveIndefinitely = false
  }

  val animalsCanLIveForever = Animal.canLiveIndefinitely // "static" fields/methods

  /*
   case classes = lightweight data structures with boilerplate
  - sensible equals and hashcode
  - serialization
  - companion with apply
  - pattern matching
   */

  case class Person(name: String, age: Int)

  //may be constructed without new
  val bob = Person("Bob", 54) // Person.apply("Bob", 54)


  //exceptions
  try {
    //code that can throw
    val x: String = null
    x.length
  } catch { //catch(Exception e) in Java
    case e: Exception => "some faulty error message"
  } finally {
    //execute some code no matter what
    //optional
  }


  //generics
  abstract class MyList[T] {
    def dea: T
    def tail: MyList[T]
  }

  //using generic with a concrete type
  val aList: List[Int] = List(1, 2, 3) // List.apply(1,2,3)
  val first = aList.head
  val rest = aList.tail
  val aStringList: List[String] = List("hello", "Scala")
  val firstString = aStringList.head // String

  //Point #1: in Scala we usually operate with IMMUTABLE values/objects
  //Any modification to an object must return ANOTHER object
  /*
    Benefits:
    1) works miracles in multithreaded/distributed environments
    2) helps making sense of the code ("reasoning about")
   */
  val reverseList = aList.reverse //returns a NEW list

  //Point #2: Scala is closest to the OOP ideal

}