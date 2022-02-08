// https://www.hackerrank.com/challenges/candies/problem?h_r=internal-search

// Hackerrank Medium difficulty - 50

import scala.collection.mutable.ArrayBuffer
object Candies {
  def main(args: Array[String]): Unit = {
    println(candies(2,Array(1,2,3,3,4)))
  }
  def candies(n: Int, arr: Array[Int]): Long = {
    // Write your code here
    var iterate_asc=ArrayBuffer[Long]()
    var iterate_desc=ArrayBuffer[Long]()
    var resultant_array=ArrayBuffer[Long]()
    iterate_asc+=1
    var count:Long=1
    for(i<-1 to arr.length-1){
      if(arr(i)>arr(i-1)){
        count+=1
      }

      else{
        count=1
      }
      iterate_asc+=count
    }
    count=1
    iterate_desc+=1
    for(i<-arr.length-2 to 0 by -1){
      println(arr(i),arr(i+1))
      if(arr(i)>arr(i+1)){
        count+=1
      }

      else{
        count=1
      }
      iterate_desc+=count
    }

    iterate_asc.foreach(print)
    println()
    iterate_desc.foreach(print)
    for(i<-0 to arr.length-1) {
      //resultant_array+=(iterate_asc(i),iterate_desc(i))
      if(iterate_asc(i)>iterate_desc(arr.length-1-i))
        resultant_array+=iterate_asc(i)
      else
        resultant_array+=iterate_desc(arr.length-i-1)
    }
    println()
    resultant_array.foreach(print)
    println()
    resultant_array.sum
  }
}
