// https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/beauty-factor-bab8f334/

// Hackerearth - Medium Level - 30 points


// Write your code here
import scala.util.control.Breaks._
object main{
    def main(args:Array[String]){
        var arr=scala.io.StdIn.readLine().split(" ")
        var beauty_factor=arr(0).toInt
        var k_len=arr(1).toInt
        var result=""
        for(i<-1 to k_len)
            result+=i
        
        var max_limit="9"*k_len
        var flag=false
        if(k_len==9){
            if(beauty_factor==9){
                println("123456789")
            }
            else{
                println(-1)
            }
        }
        else{
            breakable{
                while(result.toInt<=max_limit.toInt){
                    while(result.contains('0') | (result.length!=result.map(_.toInt-48).toSet.toArray.length)){
                        result=((result.toInt)+1).toString
                    }
                    var resultant=beauty_factor_computation(result)
                    //println(result,resultant,beauty_factor)
                    if(resultant.toInt==beauty_factor){
                        println(result)
                        flag=true
                        break
                    }
                    result=((result.toInt)+1).toString
                    //println(result)
                }
            }
            if(flag==false){
                println(-1)
            }
        }
    }
    def beauty_factor_computation(result:String):String={
        var number=result.toArray.map(_.toInt-48).sum
        if(number<=9)
            return number.toString
        else{
            beauty_factor_computation(number.toString)   
        }
    }
}
