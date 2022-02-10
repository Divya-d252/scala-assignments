// https://www.hackerrank.com/challenges/matrix-rotation-algo/problem

// Hackerrank - Hard Level

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
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    def matrixRotation(matrix: Array[Array[Int]], r: Int) {
    // Write your code here
        var rows=matrix.length
        var columns=matrix(0).length
        var num_layers=if(rows<columns) (rows/2) else (columns/2)
        //println(rows,columns,num_layers)
        
        for(i<-0 to num_layers-1)
        {
            var rotation_matrix=ArrayBuffer[Int]()
            rotation_matrix=rotation_matrix++matrix(i).slice(i,columns-i)
            
            for(j<-i+1 to rows-i-2){
                rotation_matrix+=matrix(j)(columns-i-1)
            }
            
            rotation_matrix=rotation_matrix++matrix(rows-i-1).slice(i,columns-i).reverse
            
            for(j<-rows-i-2 to i+1 by -1){
                rotation_matrix+=matrix(j)(i)
            }
            //rotation_matrix.foreach(println)
            
            var rotations=r%rotation_matrix.length
            rotation_matrix=rotation_matrix.slice(rotations,rotation_matrix.length)++rotation_matrix.slice(0,rotations)
            //rotation_matrix.foreach(println)
            
            var index=0
            for(j<-i to columns-i-1){
                matrix(i)(j)=rotation_matrix(index)
                //println("d"+i+" "+j+" "+matrix(i)(j))
                index+=1
            }
            for(j<-i+1 to rows-i-2){
                matrix(j)(columns-i-1)=rotation_matrix(index)
                //println("d"+j+" "+(columns-i-1)+" "+matrix(j)(columns-i-1))
                index+=1
            }
            for(j<-columns-i-1 to i by -1){
                matrix(rows-i-1)(j)=rotation_matrix(index)
                //println("d"+(rows-i-1)+" "+j+" "+matrix(rows-i-1)(j))
                index+=1
            }
            for(j<-rows-i-2 to i+1 by -1){
                matrix(j)(i)=rotation_matrix(index)
                //println("d"+j+" "+i+" "+matrix(j)(i))
                index+=1
            }
        }
        for(i<-0 to matrix.length-1)
        {
            for(j<-0 to matrix(0).length-1)
            {
                print(matrix(i)(j)+" ")
            }
            println()
        }

    }

}

object Solution {
    def main(args: Array[String]) {
        val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

        val m = firstMultipleInput(0).toInt

        val n = firstMultipleInput(1).toInt

        val r = firstMultipleInput(2).toInt

        val matrix = Array.ofDim[Int](m, n)

        for (i <- 0 until m) {
            matrix(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
        }

        Result.matrixRotation(matrix, r)
    }
}
