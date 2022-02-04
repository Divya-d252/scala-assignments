object Greedy_Florist {
  def main(args: Array[String]): Unit = {
    println(getMinimumCost(3,Array(1,3,5,7,9)))
  }
  def getMinimumCost(k: Int, c: Array[Int]): Int = {
    var arr=c.sorted.reverse
    var result=0
    var turn=0
    for(i<-0 to arr.length-1){
      turn=(i/k)
      result+=(turn+1)*arr(i)
      //print(turn,result)
    }
    result
  }
}
