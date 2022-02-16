// https://leetcode.com/problems/zigzag-conversion/submissions/

// LeetCode - Medium Difficulty

object Solution { 
    def convert(s: String, numRows: Int): String = {   
        var result=""
        if(s.length==1 | numRows==1){
            result=s
        }
        else if(s.length==2 | numRows==2){
            for(i<-0 to s.length-1){
                if(i%2==0)
                    result+=s(i)
            }
            for(i<-0 to s.length-1){
                if(i%2==1)
                    result+=s(i)
            }
        }
        else{
            for(i<-0 to numRows-1){
                if(i==0 | i==numRows-1){
                    var k=i
                    while(k<=s.length-1){
                        result+=s(k)
                        k+=(numRows)+(numRows-2)
                    }
                }
                else{
                    var x=0
                    while(x<s.length){
                        if(x+i<s.length)
                            result+=s(x+i)
                        if(x+(numRows+(numRows-2))-i<s.length)
                            result+=s(x+(numRows+(numRows-2))-i)
                        x+=(numRows+(numRows-2))
                    }
                }
            }
        }
        result
    }
}
