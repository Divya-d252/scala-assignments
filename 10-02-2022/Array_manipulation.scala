//https://www.hackerrank.com/challenges/crush/copy-from/255725506

//Hackerrank - Hard
import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.immutable._
import scala.collection.mutable._
import scala.collection.concurrent._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._

object Result {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    def arrayManipulation(n: Int, queries: Array[Array[Int]]): Long = {
    // Write your code here
        var array=("0"*n).toArray.map(_.toInt-48)
        for(i<-0 to queries.length-1)
        {
            array(queries(i)(0)-1)+=queries(i)(2)
            if(queries(i)(1)<array.length)
                array(queries(i)(1))-=queries(i)(2)
            //array.foreach(println)
        }
         //array.filter(_>0).sum
         var resultant_max:Long=0
         var result:Long=0
         for(i<-0 to array.length-1)
         {
            result+=array(i)
            if(result>resultant_max)
            {
                resultant_max=result
            }
         }
         resultant_max
         
    }

}

object Solution {
    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

        val n = firstMultipleInput(0).toInt

        val m = firstMultipleInput(1).toInt

        val queries = Array.ofDim[Int](m, 3)

        for (i <- 0 until m) {
            queries(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
        }

        val result = Result.arrayManipulation(n, queries)

        printWriter.println(result)

        printWriter.close()
    }
}
