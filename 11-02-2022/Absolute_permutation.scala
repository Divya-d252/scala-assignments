// https://www.hackerrank.com/challenges/absolute-permutation/copy-from/255818212

// Hackerrank Medium - 40 points

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

object Result {

    /*
     * Complete the 'absolutePermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     */

    def absolutePermutation(n: Int, k: Int): Array[Int] = {
        // Write your code here
        var resultant_array=ArrayBuffer[Int]()
        if(k==0)
        {
            for(i<-1 to n)
                resultant_array+=i
            resultant_array.toArray
        }
        else if(n%k==0 & (n/k)%2==0){
            var loop=(n/(k*2))
            var counter=1
            while(loop>0){
                for(i<-counter+k to counter+(2*k)-1)
                    resultant_array+=i
                for(i<-counter to counter+k-1)
                    resultant_array+=i
                counter=counter+2*k
                loop-=1
            }
            resultant_array.toArray
        }
        else{
            Array(-1)
        }

    }

}

object Solution {
    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val t = StdIn.readLine.trim.toInt

        for (tItr <- 1 to t) {
            val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

            val n = firstMultipleInput(0).toInt

            val k = firstMultipleInput(1).toInt

            val result = Result.absolutePermutation(n, k)

            printWriter.println(result.mkString(" "))
        }

        printWriter.close()
    }
}
