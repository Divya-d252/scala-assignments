// https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?isFullScreen=true

// Hackerrank - Medium

import scala.collection.mutable.Map
object Sherlock_Valid_String {
  def main(args: Array[String]): Unit = {
    println(isValid("abcdefghhgfedecba"))
  }
  def isValid(s: String): String = {
    // Write your code here

    var character_map=Map[Char,Int]()
    for(i<-0 to s.length-1){
      if(character_map.contains(s(i))){
        character_map(s(i))+=1
      }
      else{
        character_map(s(i))=1
      }
    }

    //println(character_map.valuesIterator.)
    var valid_String_map=Map[Int,Int]()
    for(i<-character_map.values){
      if(valid_String_map.contains(i)){
        valid_String_map(i)+=1
      }
      else{
        valid_String_map(i)=1
      }
      //println(i+" "+character_map(i))
    }
    for(i<-valid_String_map.keys){
      println(i+" "+valid_String_map(i))
    }
    println(valid_String_map.size)
    if(valid_String_map.size==1){
      "YES"
    }
    else if(valid_String_map.size>2){
      "NO"
    }
    else{
      var min_key_holder=0
      var max_key_holder=0
      for(i<-valid_String_map.keys){
        if(valid_String_map(i)==valid_String_map.valuesIterator.max)
          max_key_holder=i
        else
          min_key_holder=i
      }
      if(valid_String_map.valuesIterator.min==1){
        if(min_key_holder==max_key_holder+1 | min_key_holder==1){
          "YES"
        }
        else{
          "NO"
        }
      }
      else{
        "NO"
      }
    }
  }
}
