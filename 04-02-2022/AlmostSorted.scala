import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._
object Almost_Sorted {
  def main(args: Array[String]): Unit = {
    almostSorted(Array(5,4))
  }
  def almostSorted(arr: Array[Int]) {
    // Write your code here
    var flag = 0
    var arr_sorted = arr.sorted
    var arr_check = arr.toArray

    if (arr_sorted.sameElements(arr)) {
      println("yes")
      flag = 1
    }
    if (flag == 0) {

      var increment = 0
      var decrement = arr.length - 1
      breakable {
        for (i <- 0 to arr.length - 2) {
          if (arr(i) < arr(i + 1)) {
            increment = i + 1
            //println("d",c)
          } else
            break
        }
      }
      breakable {
        for (j <- arr.length - 1 to 1 by -1) {
          if (arr(j) > arr(j - 1))
            decrement = j - 1
          else
            break
        }
      }
//      println(increment)
//      println(decrement)
      arr_check = swap(arr_check, increment, decrement)
      if (arr_sorted.sameElements(arr_check)) {
        println("yes")
        println("swap " + (increment+ 1) + " " + (decrement + 1))
        flag = 1
      }
      breakable {
        if (flag == 1)
          break
        //println("rev")
        //arr.foreach(print)
        var arr3 = arr.toArray

        arr3 = arr3.slice(0, increment) ++ arr3.slice(increment, decrement + 1).reverse ++ arr3.slice(decrement + 1, arr3.length)
        if (arr_sorted.sameElements(arr3)) {
          println("yes")
          println("reverse " + (increment+ 1) + " " + (decrement+ 1))
          flag = 1
        }
      }
      if (flag == 0)
        println("no")
    }
  }
  def swap(arrayBuffer:Array[Int],i:Int,j:Int): Array[Int] ={
    var temp=arrayBuffer(i)
    arrayBuffer(i)=arrayBuffer(j)
    arrayBuffer(j)=temp

    arrayBuffer
  }

}
