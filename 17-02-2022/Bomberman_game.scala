// https://www.hackerrank.com/challenges/bomber-man/copy-from/256479216

// Hackerrank - Medium Level - 40

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
import Array._

object Result {

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    def bomberMan(n: Int, grid: Array[String]): Array[String] = 
    {
    // Write your code here
        var timer=Array.ofDim[Int](0,0)
        var resultant=Array[String]()

        for(i<-0 to grid.length-1)
        {
            var timer_i=Array[Int]()
            for(j<-grid(i))
            {
                if(j=='.')
                    timer_i=timer_i++Array(0)
                else
                    timer_i=timer_i++Array(3)
            }
            //timer_i.foreach(print)
            timer=timer++Array(timer_i)
        }
        //print(timer.length,timer(0).length)
        if(n>=1)
        {
            for(i<-0 to timer.length-1)
            {
                for(j<-0 to timer(0).length-1)
                {
                    if(timer(i)(j)!=0)
                        timer(i)(j)-=1
                }
            }
        }
        if(n>=2)
        {
            for(i<-0 to timer.length-1)
            {
                for(j<-0 to timer(0).length-1)
                {
                    if(timer(i)(j)==0)
                        timer(i)(j)=3
                    else
                        timer(i)(j)-=1
                }
            }
        }
        if(n>=3 | n%4==3)
        {
            println("d")
            for(i<-0 to timer.length-1)
            {
                for(j<-0 to timer(0).length-1)
                {
                    if(timer(i)(j)==1)
                    {
                        timer(i)(j)=0
                        if(j+1<timer(0).length)
                        {
                            if(timer(i)(j+1)!=1)
                                timer(i)(j+1)=0
                        }
                        if(j-1>=0){
                            if(timer(i)(j-1)!=1)
                                timer(i)(j-1)=0
                            }
                        if(i+1<timer.length){ 
                            if(timer(i+1)(j)!=1)
                                timer(i+1)(j)=0
                            }
                        if(i-1>=0){
                            if(timer(i-1)(j)!=1)
                                timer(i-1)(j)=0
                            }
                            
                        
                    }
                    else if(timer(i)(j)!=0)
                    {
                        timer(i)(j)-=1
                    }
                }
            }
        }
        if((n>=4 | (n>0 & n%4==0)) & n%4!=3)
        {
            println("d")
            for(i<-0 to timer.length-1)
            {
                for(j<-0 to timer(0).length-1)
                {
                    if(timer(i)(j)==0)
                        timer(i)(j)=3
                    else
                        timer(i)(j)-=1
                }
            }
        }
        if((n>=5 | (n>1 & n%4==1)) & n%4!=3 & n%4!=0)
        {
            println("d")
            for(i<-0 to timer.length-1)
            {
                for(j<-0 to timer(0).length-1)
                {
                    if(timer(i)(j)==1)
                    {
                        timer(i)(j)=0
                        if(j+1<timer(0).length)
                        {
                            if(timer(i)(j+1)!=1)
                                timer(i)(j+1)=0
                        }
                        if(j-1>=0){
                            if(timer(i)(j-1)!=1)
                                timer(i)(j-1)=0
                            }
                        if(i+1<timer.length){
                            if(timer(i+1)(j)!=1)
                                timer(i+1)(j)=0
                            }
                        if(i-1>=0){
                            if(timer(i-1)(j)!=1)
                                timer(i-1)(j)=0
                            }   
                    }
                    else if(timer(i)(j)!=0)
                    {
                        timer(i)(j)-=1
                    }
                }
            }
        }
        if(( (n>=6) | (n>2 & n%4==2)) & n%4!=3 & n%4!=0 & n%4!=1)
        {
            println("d")
            for(i<-0 to timer.length-1)
            {
                for(j<-0 to timer(0).length-1)
                {
                    if(timer(i)(j)==0)
                        timer(i)(j)=3
                    else
                        timer(i)(j)-=1
                }
            }
        }
        for(i<-0 to timer.length-1)
        {
            for(j<-0 to timer(0).length-1)
            {
                print(timer(i)(j))
            }
            println()
        }
        for(i<-0 to timer.length-1)
        {
            var res=""
            for(j<-0 to timer(0).length-1)
            {
                if(timer(i)(j)==0)
                    res+="."
                else
                    res+="O"
            }
            resultant=resultant++Array(res)
        }
        resultant
    }
    

}

object Solution {
    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

        val r = firstMultipleInput(0).toInt

        val c = firstMultipleInput(1).toInt

        val n = firstMultipleInput(2).toInt

        val grid = Array.ofDim[String](r)

        for (i <- 0 until r) {
            val gridItem = StdIn.readLine
            grid(i) = gridItem
        }

        val result = Result.bomberMan(n, grid)

        printWriter.println(result.mkString("\n"))

        printWriter.close()
    }
}
