// https://www.hackerrank.com/challenges/and-product/problem?h_r=internal-search

// Hackerrank - Medium difficulty

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
     * Complete the 'andProduct' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. LONG_INTEGER a
     *  2. LONG_INTEGER b
     */

    def andProduct(a: Long, b: Long): Long = {
    // Write your code here
        var number1=a
        var number2=b
        while(number2>number1){
            number2=number2&(number2-1)
        }
        number2
    }

}

object Solution {
    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val n = StdIn.readLine.trim.toInt

        for (nItr <- 1 to n) {
            val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

            val a = firstMultipleInput(0).toLong

            val b = firstMultipleInput(1).toLong

            val result = Result.andProduct(a, b)

            printWriter.println(result)
        }

        printWriter.close()
    }
}
