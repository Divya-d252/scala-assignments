// https://leetcode.com/problems/search-in-rotated-sorted-array/

// LeetCode - Medium Level

import scala.util.control.Breaks._
object Solution 
{
    def search(arr: Array[Int], target: Int): Int = 
    {
        var start=0
        var end=arr.length-1
        var flag=0
        var resultant=(-1)
        breakable
        {
            while(start <= end)
            {
                var mid = (start+end)/2
                if(arr(mid) == target)
                {
                    resultant=mid
                    flag=1
                    break
                }
                else if(arr(mid) >= arr(start))
                {
                    if(target >= arr(start) & target <= arr(mid))
                    {
                       end = mid-1
                    } 
                    else 
                    {
                       start = mid+1
                    } 
                } 
                else 
                {
                    if(target >= arr(mid) & target <= arr(end))
                    {
                        start = mid+1
                    } 
                    else
                    {
                        end = mid-1;
                    }
                }
            }
        }
        resultant  
    }
}
