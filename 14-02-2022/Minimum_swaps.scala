// https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&isFullScreen=false&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

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
import scala.util.control.Breaks._

object Solution {

    // Complete the minimumSwaps function below.
    def minimumSwaps(arr: Array[Int]): Int = {
        var swap_count=0
        var len=arr.length
        var i=0
        while(i<len){
            breakable{
                if(arr(i)==(i+1))
                {
                    break
                }
                var temp=arr(i)
                arr(i)=arr(temp-1)
                arr(temp-1)=temp
                swap_count+=1
                i-=1
            }
            i+=1
        }
        swap_count
    }
    

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val n = stdin.readLine.trim.toInt

        val arr = stdin.readLine.split(" ").map(_.trim.toInt)
        val res = minimumSwaps(arr)

        printWriter.println(res)

        printWriter.close()
    }
}
