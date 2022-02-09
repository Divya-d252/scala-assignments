//6.	Binary Search in Scala (Iterative, Recursion, Tail Recursion Approaches)?

import scala.annotation.tailrec
import scala.util.control.Breaks._
object _6Binary_search {
  def main(args: Array[String]): Unit = {
    var array=Array(2,4,6,7,8,10,12)

    var number=8
    //binary search iterative
    var i=0
    var j=array.length-1
    var index=(-1)
    breakable {
      while (i <= j) {
        var mid = (i + j) / 2
        if (number == array(mid)) {
          index = mid
          break
        }
        else if (number < array(mid)) {
          j = mid - 1
        }
        else {
          i = mid + 1
        }
      }
    }
    if(index!=(-1))
      println(s"There at $index - Iterative")
    else
      println("Element not found - Iterative")
    // Binary search - recursion
    var recursive_binary=BinarySearch(array,0,array.length-1,number)
    if(recursive_binary!=(-1))
      println(s"There at $recursive_binary - Recursive")
    else
      println("Element not found - Recursive")
    // Binary search - tailrec
    var tailrec_binary=BinarySearchTailrec(array,0,array.length-1,number)
    if(tailrec_binary!=(-1))
      println(s"There at $tailrec_binary - Tailrec")
    else
      println("Element not found - Tailrec")
  }
  def BinarySearch(array: Array[Int], start: Int, end: Int,number:Int): Int ={

    //println(start,end)
    if(start<=end) {
      var mid=((start+end)/2).toInt
      if (array(mid) == number) {
        mid
      }
      else if (array(mid) > number) {
        BinarySearch(array, start, mid - 1, number)
      }
      else {
        BinarySearch(array, mid + 1, end, number)
      }
    }
    else
    -1
  }
  @tailrec
  def BinarySearchTailrec(array: Array[Int], start: Int, end: Int,number:Int): Int ={
    if(start<=end){
      var mid=(start+end)/2
      array(mid) match {
        case a if(array(mid)==number) => mid
        case a if(array(mid) > number) => BinarySearchTailrec(array, start, mid-1, number)
        case a if(array(mid) < number) => BinarySearchTailrec(array,mid+1,end,number)
      }
    }
    else{
      -1
    }
  }
}
