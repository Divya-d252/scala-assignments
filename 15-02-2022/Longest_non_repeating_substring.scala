// https://leetcode.com/problems/longest-substring-without-repeating-characters/

// Leetcode - Medium Level

// Write your code here

object Solution {
    def lengthOfLongestSubstring(s: String): Int = {
        var array=Array[String]()
        var start=0
        var max_resultant=0
        for(iterator<-0 to s.length-1){
            var character=s(iterator)
            while(array.contains(character.toString)){
                array=array.slice(1,array.length)
                start+=1
            }
            array=array++Array(s(iterator).toString)
            if(max_resultant<(iterator-start+1)){
                max_resultant=iterator-start+1
            }
        }
        max_resultant
    }
}
