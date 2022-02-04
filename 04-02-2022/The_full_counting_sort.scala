import scala.collection.mutable.ListBuffer
object The_full_counting_sort {
  def main(args: Array[String]): Unit = {
    countSort(Array(Array(0.toString,"a"),Array(1.toString,"b"),Array(0.toString,"c"),Array(1.toString,"d")))
  }
  def countSort(arr: Array[Array[String]]) {
    // Write your code here
    var string=""
    var key=0
    var result:Array[String]=Array[String]()
    for(i<-0 to 100)
      result=result++Array("")
    for(i<-0 to (arr.length)-1){
       key=arr(i)(0).toInt
       //ar(k)=""
       if(i<arr.length/2)
         string="- "
       else
         string=arr(i)(1)+" "
      result(key)=result(key)++string
   }
    result.foreach(print)
  }

}
