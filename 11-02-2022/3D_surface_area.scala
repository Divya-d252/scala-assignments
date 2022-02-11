// https://www.hackerrank.com/challenges/3d-surface-area/copy-from/255818426

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
     * Complete the 'surfaceArea' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY A as parameter.
     */

    def surfaceArea(A: Array[Array[Int]]): Int = {
        // Write your code here
        var surface_area=2*(A.length*A(0).length)
        println(A.length-1,A(0).length-1)
        for(i<-0 to A.length-1){
        
            for(j<-0 to A(0).length-1){
            
                println(i,j,A(i)(j))
                
                if(j==0) {
                    surface_area+=A(i)(j)
                }
                if(j==A(0).length-1){
                    surface_area+=A(i)(j)
                }
                
                if(j!=0) 
                {
                    if(A(i)(j)>A(i)(j-1))
                        surface_area+=A(i)(j)-A(i)(j-1)
                }
                if(j!=A(0).length-1)
                {
                    if(A(i)(j)>A(i)(j+1))
                        surface_area+=A(i)(j)-A(i)(j+1)
                }
                
                if(i==0)
                {
                    surface_area+=A(i)(j)
                }
                if(i==A.length-1)
                {
                    surface_area+=A(i)(j)
                }
                
                if(i!=0) 
                {
                    if(A(i)(j)>A(i-1)(j))
                        surface_area+=A(i)(j)-A(i-1)(j)
                }
                if(i!=A.length-1)
                {
                    if(A(i)(j)>A(i+1)(j))
                        surface_area+=A(i)(j)-A(i+1)(j)
                }
                //println(i,j,A(i)(j))
                println(surface_area)
            }
        }
        surface_area
    }

}

object Solution {
    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

        val H = firstMultipleInput(0).toInt

        val W = firstMultipleInput(1).toInt

        val A = Array.ofDim[Int](H, W)

        for (i <- 0 until H) {
            A(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
        }

        val result = Result.surfaceArea(A)

        printWriter.println(result)

        printWriter.close()
    }
}
