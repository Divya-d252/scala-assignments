//https://www.hackerrank.com/challenges/common-child/problem?h_r=internal-search

// Hackerrank Medium Difficulty - 60 points
import Array.ofDim
object commonChild {
  def main(args: Array[String]): Unit = {
    println(commonChild("SHINCHAN","NOHARAAA"))
  }
  def commonChild(string1: String, string2: String): Int = {
    // Write your code here
    var resultant =Array.ofDim[Int](string1.length+1,string1.length+1)
    //resultant.foreach(x=>println(x(0)))
    for(i<-1 to string1.length){
      for(j<-1 to string1.length){
        if(string1(i-1)==string2(j-1))
          resultant(i)(j)=resultant(i-1)(j-1)+1
        else {
          resultant(i)(j)=Array(resultant(i-1)(j),resultant(i)(j-1)).max
          //println(l(i)(j))
        }
      }
    }
    resultant(string1.length)(string1.length)

  }

}
