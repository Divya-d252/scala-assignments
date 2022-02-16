// https://www.hackerrank.com/challenges/special-palindrome-again/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings

// Hackerrank - Medium level

import java.io._
import java.math._
import java.security._
import java.text._
//import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.mutable.ArrayBuffer

object Solution {

    // Complete the substrCount function below.
    def substrCount(n: Int, s: String): Long = {
        //var consecutive_count=Map("a"->2,"b"->3,"a"->1)
        var consecutive_count=ArrayBuffer(ArrayBuffer("",0))
        var sequence=""
        var count=0
        
        for(i<-0 to s.length-1){
            //println(s(i),sequence)
            if(s(i).toString==sequence)
            {
                count+=1
                consecutive_count(consecutive_count.length-1)(1)=count
            }
            else{
                count=1
                consecutive_count+=ArrayBuffer(s(i).toString,count)
                sequence=s(i).toString       
            }    
        }   
        consecutive_count=consecutive_count.slice(1,consecutive_count.length)
        //consecutive_count.foreach(println)
        var resultant=0
        for(i<-consecutive_count)
        {
            var integer=i(1).toString.toInt
            resultant+=(integer.toInt*(integer.toInt+1))/2
        }
        for(i<-1 to consecutive_count.length-2){
            if(consecutive_count(i-1)(0)==consecutive_count(i+1)(0))
            {
                if(consecutive_count(i)(1)==1)
                {
                    if(consecutive_count(i-1)(1).toString.toInt<consecutive_count(i+1)(1).toString.toInt)
                        resultant+=consecutive_count(i-1)(1).toString.toInt
                    else
                        resultant+=consecutive_count(i+1)(1).toString.toInt
                }
            }
        }
        resultant
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val n = stdin.readLine.trim.toInt

        val s = stdin.readLine

        val result = substrCount(n, s)

        printWriter.println(result)

        printWriter.close()
    }
}
