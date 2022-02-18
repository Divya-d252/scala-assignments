// https://www.hackerrank.com/challenges/pairs/problem

// Hackerrank - Medium Level

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

    def pairs(k: Int, arr: Array[Int]): Int = 
    {
    
    // Write your code here
        var arr_sorted=arr.sorted
        var start=0
        var end=1
        var num_pairs=0
        while(end<=arr.length-1)
        {
            var difference=arr_sorted(end)-arr_sorted(start)
            if(difference==k)
            {
                num_pairs+=1
                end+=1
            }
            else if(difference>k)
            {
                start+=1
            }
            else
            {
                end+=1
            }
        }
        num_pairs
    }
}

object Solution {
    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

        val n = firstMultipleInput(0).toInt

        val k = firstMultipleInput(1).toInt

        val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

        val result = Result.pairs(k, arr)

        printWriter.println(result)

        printWriter.close()
    }
}
