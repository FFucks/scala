package com.ffucks

object Basics extends App {

  //defining a value
  val meaningOfLife: Int = 42 // const int meaniongOfLife = 42;

  //meaningOfLife = 43 // this is not allowed

  // Int, Boolean, Char, Double, Float, String
  val aBoolean = false // type is optional

  //Strings and string operations
  val aString = "I love Scala"
  val alphaComposite = "I" + " " + "love" + " " + "Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  //expressions = structures that can be reduced to a value
  val anExpression = 2 + 3

  //if expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999 // meaningOfLife > 43 ? 56 : 999 in Java
  val chainedIfExpression =
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0  //it still a single expression

  //code blocks
  val aCodeBlock = {
    //definitions
    val aLocalValue = 67

    //value of the block is the value of the last expression
    aLocalValue + 3 // it is the return value

  }

}
