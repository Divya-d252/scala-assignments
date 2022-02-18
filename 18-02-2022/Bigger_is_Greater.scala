// https://www.hackerrank.com/challenges/bigger-is-greater/copy-from/256444156

// hackerrank - Medium Level

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
import scala.util.control.Breaks._

object Result {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    def biggerIsGreater(w: String): String = {
    
    // Write your code here
        var str=""
        if(w.length==1)
        {
            str="no answer"
        }
        var set1=""
        breakable
        {
            for(i<-w.length-1 to 1 by -1)
            {
                if(!set1.contains(w(i)))
                {
                    set1+=w(i).toString
                }
                if(i==w.length-1 & w(i)>w(i-1))
                {
                    str=w.slice(0,i-1)++w(i).toString++w(i-1).toString
                    break
                }
                else if(i==1 & w(i)<=w(i-1))
                {
                    str="no answer"
                    break
                }
                else if(w(i)>w(i-1))
                {
                    if(!set1.contains(w(i-1)))
                    {
                        set1+=w(i-1)
                    }
                    var sorted_string=set1.sorted
                    var next_higher_element=sorted_string(sorted_string.indexOf(w(i-1))+1)
                    //print(set1)
                    var w_modified=w.slice(i-1,w.length)
                    var w_unique=""
                    var count=0
                    for(i<-0 to w_modified.length-1)
                    {
                        if(count!=0 | w_modified(i)!=next_higher_element){
                            w_unique+=w_modified(i).toString
                        }
                        if(count==0 & w_modified(i)==next_higher_element){
                            count+=1
                        } 
                    }
                    //print(w_modified,w_unique)
                    str=w.slice(0,i-1)++next_higher_element.toString++w_unique.sorted
                    break
                }
            }
        }
        str
    }
}

object Solution {
    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val T = StdIn.readLine.trim.toInt

        for (TItr <- 1 to T) {
            val w = StdIn.readLine

            val result = Result.biggerIsGreater(w)

            printWriter.println(result)
        }

        printWriter.close()
    }
}
