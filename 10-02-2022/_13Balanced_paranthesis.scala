//Given a string containing just the characters ‘(‘, ‘)’, ‘{‘, ‘}’, ‘[‘ and ‘]’, determine if the input string is valid.
//Example:
//()()([]({}))[] valid: true
//()({]) valid: false
//[]{}() valid: true
//[(}{)] valid: false

// https://www.hackerrank.com/challenges/balanced-brackets/problem

import scala.collection.mutable.Stack
object _13Balanced_paranthesis {
  def main(args: Array[String]): Unit = {
    println("Valid paranthesis? "+ valid_paranthesis("()()([]({}))[]"))
  }
  def valid_paranthesis(string:String):Boolean={
    var stack=Stack[String]()
    //stack.push(string(0).toString)

    for(i<-0 to string.length-1){

     // println(i,stack(0),string(i))

      if(string(i)=='[' | string(i)=='{' | string(i)=='('){
        stack.push(string(i).toString)
      }
      else if(stack.isEmpty){
        return false
      }
      else if(string(i)==']' & stack(0)=='['.toString){
        stack.pop()
      }
      else if(string(i)=='}' & stack(0)=='{'.toString){
        stack.pop()
      }
      else if(string(i)==')' & stack(0)=='('.toString){
        stack.pop()
      }
      else{
        return false
      }

    }
    if(stack.isEmpty)
      true
    else
      false
  }
}
