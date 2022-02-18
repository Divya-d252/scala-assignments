// https://www.hackerrank.com/challenges/non-divisible-subset/problem

// Hackerrank Medium Level

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
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    def nonDivisibleSubset(k: Int, array: Array[Int]): Int =
    {
    // Write your code here
        var remainder_array=Array[Int]()
        for(i<-0 to k-1)
        {
            remainder_array=remainder_array++Array(0)
        }
        for(i<-0 to array.length-1)
        {
            remainder_array(array(i)%k)+=1
        }
        remainder_array.foreach(print)
        var count=0
        for(i<-0 to (k/2))
        {
            if(i==0)
            {
                if(remainder_array(i)!=0)
                    count+=1
            }
            else if(i==(k-i))
            {
                if(remainder_array(i)!=0)
                    count+=1
            }
            else
            {
                count+=Array(remainder_array(i),remainder_array(k-i)).max
            }
        }
        count
    }
}

object Solution {
    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

        val n = firstMultipleInput(0).toInt

        val k = firstMultipleInput(1).toInt

        val s = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

        val result = Result.nonDivisibleSubset(k, s)

        printWriter.println(result)

        printWriter.close()
    }
}
