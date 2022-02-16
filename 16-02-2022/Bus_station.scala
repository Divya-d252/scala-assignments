// https://www.hackerrank.com/challenges/bus-station/copy-from/255949286

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
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Map

object Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    def solve(arr: Array[Int]): Array[Int] = {
    // Write your code here
        var cummulative=ArrayBuffer[Int]()
        var resultant=ArrayBuffer[Int]()
        var map=Map[Int,Int]()
        var total=arr.sum
        var sum=0
        for(i<-0 to arr.length-1)
        {
            sum+=arr(i)
            cummulative+=(sum)
            if(total%cummulative(i)==0)
                map(cummulative(i))=0
        }
        //map=map.sortBy(x=>x(0))
        for(i<-map.keys)
        {
            for(j<-0 to cummulative.length-1)
            {
                if(cummulative(j)%i==0)
                    map(i)+=1
            }
            print(total,i,map(i))
            if(map(i)==total/i)
                resultant+=i
        }
        resultant.sorted.toArray
    }
}

object Solution {
    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val aCount = StdIn.readLine.trim.toInt

        val a = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

        val result = Result.solve(a)

        printWriter.println(result.mkString(" "))

        printWriter.close()
    }
}
