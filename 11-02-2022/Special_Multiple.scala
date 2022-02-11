// https://www.hackerrank.com/challenges/special-multiple/copy-from/255927229

// Medium Level - 30 points

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
import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._

object Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER n as parameter.
     */

    def solve(n: Int): String = {
    // Write your code here
        //var s=n.toBinaryString
        var result=""
        //var check_array=ArrayBuffer[String]()
        breakable
        {
            for(i<-1 to 9000)
            {
                var check=i.toBinaryString.replace("1","9")
                //check_array+=check
                
                if(check.toLong%n==0)
                {
                result=check
                break   
                }
            }
        }
        result
    }

}

object Solution {
    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val t = StdIn.readLine.trim.toInt

        for (tItr <- 1 to t) {
            val n = StdIn.readLine.trim.toInt

            val result = Result.solve(n)

            printWriter.println(result)
        }

        printWriter.close()
    }
}
