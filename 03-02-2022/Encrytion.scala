//Hacker Rank - Level Medium -30 - 3rd feb
object Encrytion {
  def main(args: Array[String]): Unit = {
    println(encryption("haveaniceday"))
  }
  def encryption(s: String): String = {
    // Write your code here
    var s1=s.replaceAll(" ","")
    //println(s1)
    var strLength=s1.length
    var root=math.pow(strLength,0.5)

    var row=math.floor(root).toInt
    var column=math.ceil(root).toInt
    if(row*column<s1.length){
      row+=1
    }
    //println(row,column)

    var result=""
    for(i<-0 to column-1){
      var index=i
      for(j<-0 to row-1){
        if(index < s1.length & result.length<strLength+column-1){
          result+=s1(index)
          index+=column
        }
      }
      result+=" "
    }
    result
  }
}
