// https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/best-index-1-45a2f8ff/

// Hackerearth - Medium Level

// Write your code here

import scala.collection.mutable.ArrayBuffer

object main{

	def main(args:Array[String]){

		var n=scala.io.StdIn.readInt()
        var arr=scala.io.StdIn.readLine().split(" ").map(_.toInt)
        
        var max_result:Long=(-999999999).toLong
        var arr_cummulative=ArrayBuffer[Int]()
        arr_cummulative+=0
        var sum=0
        for(i<-0 to n-1){
            sum+=arr(i)
            arr_cummulative+=sum
        }

        for(i<-1 to n){
            sum=0
            var x=(((-1)+math.pow(1+(4*(n-i+1)*2),0.5))/2).floor.toInt
            var range=(x*(x+1))/2
            
            sum=arr_cummulative(i+range-1)-arr_cummulative(i-1)
            
            if(sum>max_result)
                max_result=sum
            
        }
        println(max_result)
	}
}
