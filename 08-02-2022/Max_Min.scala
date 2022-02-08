// https://www.hackerrank.com/challenges/one-month-preparation-kit-angry-children/problem?h_r=internal-search

// Hackerrank Medium - 100

object Max_Min {
  def main(args: Array[String]): Unit = {
    println(maxMin(3,Array(100,200,300,350,400,401,402)))
  }
  def maxMin(unfairness_array_length: Int, arr: Array[Int]): Int = {
    // Write your code here
    var arr_sorted=arr.sorted
    var min_unfair=arr_sorted(unfairness_array_length-1)-arr_sorted(0)
    for(i<-0 to arr.length-unfairness_array_length){
      if(min_unfair>arr_sorted(i+unfairness_array_length-1)-arr_sorted(i)) {
        min_unfair=arr_sorted(i+unfairness_array_length-1)-arr_sorted(i)
        //println(arr1(i+k-1)-arr(i))
      }
    }
    min_unfair
  }
}
