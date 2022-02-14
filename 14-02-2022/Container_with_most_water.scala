// https://leetcode.com/problems/container-with-most-water/submissions/

// LeetCode - Medium Level

import scala.util.control.Breaks._
object Solution {
    def maxArea(height: Array[Int]): Int = {
        var max_area=0
        var i=0
        var j=height.length-1
        breakable{
            while(i<j){
                var area=(j-i)*(Array(height(i),height(j)).min)
                //print(i,j,area)
                if(area>max_area){
                    max_area=area
                }
                if(height(i)==height(j)){
                    i+=1
                    j-=1
                }
                else if(height(i)<height(j)){
                    i+=1
                }
                else{
                    j-=1
                }
                if(i==j)
                    break
                
            }
        }
        max_area   
    }
}
