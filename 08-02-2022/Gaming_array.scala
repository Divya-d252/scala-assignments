// https://www.hackerrank.com/challenges/an-interesting-game-1/problem?h_r=internal-search

// Hackerrank Medium - 35 
object Gaming_array {
  def main(args: Array[String]): Unit = {
    println(gamingArray(Array(2,3,5,4,1)))
  }
  def gamingArray(arr: Array[Int]): String = {
    // Write your code here
    var arr_max_elements=arr
    var max1=arr(0)
    for(i<-0 to arr.length-1){
      if(max1<arr(i)){
        max1=arr(i)
        //println(max1)
      }
      arr_max_elements(i)=max1
    }
    var length=arr_max_elements.distinct.length

    if(length%2==1)
      "BOB"
    else
      "ANDY"
  }
}
