//Problem link- https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_r=internal-search

// Hackerrank Medium Difficulty - 50 points

import scala.collection.mutable.Map
object Sherlock_Anagrams {
  def main(args: Array[String]): Unit = {
   println(sherlockAndAnagrams("ifailuhkqq"))
  }
  def sherlockAndAnagrams(string: String): Int = {
    // Write your code here

    var mapped_string=Map[String,Int]()
    var count=0
    for(i<-0 to string.length-1){
      for(j<-i+1 to string.length) {
        var substring = string.slice(i, j).sorted
        //println(substring)
        if (mapped_string.contains(substring)) {
          mapped_string(substring)+=1
        }
        else{
          mapped_string(substring)=1
        }
      }
    }
    for(value<-mapped_string.values){
      count+=(value*(value-1))/2
    }
    count
  }
}
