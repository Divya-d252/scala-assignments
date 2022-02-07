// https://www.hackerrank.com/challenges/one-week-preparation-kit-recursive-digit-sum/problem?h_r=internal-search

// Hackerrank Medium difficulty - 100 points
import scala.io.StdIn.readLine
object SuperDigit {
  def main(args: Array[String]): Unit = {
    println(superDigit(readLine(),10000))
  }
  def superDigit(string: String, k_multiplier: Int): Int = {
    // Write your code here

    var resultant=(string.map(_.toInt-48).sum).toString.map(_.toInt-48).sum
    //println(resultant)
    resultant=((resultant)*k_multiplier).toString.map(_.toInt-48).sum

    while(resultant>9){
      var str_traversal=resultant.toString
      resultant=str_traversal.map(_.toInt-48).sum
      //println(result)
    }
    resultant
  }

}
