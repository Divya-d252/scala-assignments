// https://www.hackerrank.com/challenges/richie-rich/problem?h_r=internal-search

// Hackerrank medium difficulty

import scala.collection.mutable.StringBuilder
import scala.util.matching.Regex
import scala.io.StdIn.readLine
object Highest_value_palindrome {
  def main(args: Array[String]): Unit = {
    //var kk=readLine()
    println(highestValuePalindrome("72734",5,3))
  //println(kk.compareTo(s1))
  }
  def highestValuePalindrome(s: String, n: Int, k: Int): String = {
    // Write your code here
    //println(s,s.reverse)
    var palindrome_string=s.toArray
    var start=0
    var end=n-1
    var k_dup=k
    var change=0
    //for change
      while(start<=end){
        if(palindrome_string(start).toInt!=palindrome_string(end).toInt){
          change+=1
        }
        start+=1
        end-=1
      }

    start=0
    end=n-1
    var diff=k_dup-change
      while(start<=end){
        //var max1=Array(palindrome_string(start),palindrome_string(end)).max
        if(palindrome_string(start)==palindrome_string(end)){

          if(diff>1 & palindrome_string(start)!='9' & palindrome_string(end)!='9'){
            //println("both extra change")
            palindrome_string(start)='9'
            palindrome_string(end)='9'
            diff-=2
          }
        }
        else{
          if(diff>0 & palindrome_string(start)!='9' & palindrome_string(end)!='9'){
            //println("diff")
            palindrome_string(start)='9'
            palindrome_string(end)='9'
            diff-=1
            k_dup-=2
          }
          else{
            //println("must")
            if(palindrome_string(start).toInt>palindrome_string(end).toInt) {
              palindrome_string(end)=palindrome_string(start)
            } else
              palindrome_string(start)=palindrome_string(end)
            k_dup-=1
          }
        }
        start+=1
        end-=1
      }

    if(diff!=0 & n%2==1){
      palindrome_string(n/2)='9'
    }
    var resultant=""
    for(i<-palindrome_string)
      resultant+=i

    if(diff<0)
      "-1"
    else
      resultant
}
}
