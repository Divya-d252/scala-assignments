//Hackerrank - Medium Level - 20 - 3rd feb
import scala.collection.mutable.{ListBuffer,ArrayBuffer}
import scala.io.StdIn.readLine

object Climbing_the_leaderboard {
  def main(args: Array[String]): Unit = {

    println("Please enter ranked array elements")
    var ranked_line=readLine()
    var ranked=ranked_line.split(" ").toArray.map(_.toInt)
    println("Please enter played array elements")
    var played_line=readLine()
    var played=played_line.split(" ").toArray.map(_.toInt)
    climbingLeaderboard(ranked,played).foreach(println)
    //climbingLeaderboard(Array(100,90,90,80,75,60),Array(50,65,77,90,102)).foreach(println)
  }
  def climbingLeaderboard(ranked: Array[Int], player: Array[Int]): Array[Int] = {
    // Write your code here
    var result:ArrayBuffer[Int]=ArrayBuffer()
    var ranked_players:ListBuffer[Int]=ListBuffer()
    for(i <- 0 to ranked.length-1) {
      if(!ranked_players.contains(ranked(i)))
        ranked_players+=(ranked(i))
    }

    for(i<-0 to player.length-1){
      ranked_players+=(player(i))
      var ranked_players_ranked=ranked_players.distinct.sorted.reverse
      result+=(ranked_players_ranked.indexOf(player(i))+1)
    }
    result.toArray
  }
}
