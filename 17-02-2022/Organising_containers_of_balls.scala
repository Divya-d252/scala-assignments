// https://www.hackerrank.com/challenges/organizing-containers-of-balls/copy-from/256606672

// Hackerrank - Medium Difficulty Level

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
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    def organizingContainers(container: Array[Array[Int]]): String = 
    {
    // Write your code here
        var containers=Array[Long]()
        var balls_in_container=Array[Long]()
        for(i<-0 to container.length-1)
        {
            var sum_container:Long=0
            var sum_balls:Long=0
            for(j<-0 to container.length-1)
            {
                sum_container+=container(i)(j)
                sum_balls+=container(j)(i)
            }
            containers=containers++Array(sum_container)
            balls_in_container=balls_in_container++Array(sum_balls)
        }
        containers=containers.sorted
        balls_in_container=balls_in_container.sorted
        //containers.foreach(println)
        //balls_in_container.foreach(println)
        
        if(containers.sameElements(balls_in_container))
            "Possible"
        else
            "Impossible"

    }

}

object Solution {
    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val q = StdIn.readLine.trim.toInt

        for (qItr <- 1 to q) {
            val n = StdIn.readLine.trim.toInt

            val container = Array.ofDim[Int](n, n)

            for (i <- 0 until n) {
                container(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
            }

            val result = Result.organizingContainers(container)

            printWriter.println(result)
        }

        printWriter.close()
    }
}
