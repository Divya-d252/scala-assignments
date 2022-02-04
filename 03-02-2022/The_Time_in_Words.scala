//Hacker Rank - Level Medium -30 - 3rd feb
object The_Time_in_Words {
  def main(args: Array[String]): Unit = {
    println(timeInWords(5,59))
  }
  def timeInWords(hour: Int, minute: Int): String = {
    var numbertoWord:Map[String,String]=Map("1"->"one","2"->"two","3"->"three","4"->"four",
      "5"->"five","6"->"six","7"->"seven","8"->"eight","9"->"nine","10"->"ten","11"->"eleven",
      "12"->"twelve","13"->"thirteen","14"->"fourteen","16"->"sixteen","17"->"seventeen",
      "18"->"eighteen","19"->"nineteen","20"->"twenty","30"->"thirty","40"->"fourty",
      "50"->"fifty"
    )
    var s1=""
    if(minute==30){
      s1="half past "+numbertoWord(hour.toString)
    }
    else if(minute<30){
      if(minute==0){
        s1=numbertoWord(hour.toString)+" o' clock"
      }
      else if(minute==15){
        s1="quarter past "+numbertoWord(hour.toString)
      }
      else
      {
        if(numbertoWord.contains(minute.toString)){
          if(minute==1)
          {
            s1=numbertoWord(minute.toString)+" minute past "+numbertoWord(hour.toString)
          }
          else{
            s1=numbertoWord(minute.toString)+" minutes past "+numbertoWord(hour.toString)
          }
        }
        else{
          var x=(minute/10)*10
          var y=(minute%10)
          s1=numbertoWord(x.toString)+" "+numbertoWord(y.toString)+" minutes past "+numbertoWord(hour.toString)
        }
      }
    }
    else {
      var adv_hour=hour+1
      var rem_minutes = 60 - minute
      if(minute==45){
        s1="quarter to "+adv_hour
      }
      else if(rem_minutes==1){
        s1=numbertoWord(rem_minutes.toString)+" minute to "+numbertoWord(adv_hour.toString)
      }

      else if (numbertoWord.contains(rem_minutes.toString)) {
        s1 = numbertoWord(rem_minutes.toString)+ " minutes to " + numbertoWord(adv_hour.toString)
      }
      else {

        var x = (rem_minutes / 10) * 10
        var y = (rem_minutes % 10)
        s1 = numbertoWord(x.toString) + " " + numbertoWord(y.toString) + " minutes to " + numbertoWord(adv_hour.toString)
      }
    }
    s1
    // Write your code here

  }


}
