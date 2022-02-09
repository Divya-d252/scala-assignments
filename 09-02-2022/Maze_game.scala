//24.	Rat in a maze problem using backtracking, Given a maze
// where 1 represent free space and 0 represented it is blocked.
// Print the path from 0,0 to n-1, n-1 if exists or print -1.
// Consider the maze given below.


object _24Maze_problem {
  def main(args: Array[String]): Unit = {
    var maze=Array(Array(1,0,0,0),Array(1,1,1,0),Array(0,1,0,0),Array(0,1,1,1))
    var check=Array(Array(0,0,0,0),Array(0,0,0,0),Array(0,0,0,0),Array(0,0,0,0))

    if(Solve_Maze(maze,check,0,0,maze.length)==1) {
      println("Found the exit of the Maze")
      for(i<-0 to check.length-1){
        check(i).foreach(print)
        println()
      }
    } else
      println("Exit not found")
  }
  def Solve_Maze(maze: Array[Array[Int]], check: Array[Array[Int]], i:Int, j:Int, length: Int): Int = {
    //println(i, j)
    if (i == length - 1 & j == length - 1) {
      check(i)(j) = 1
      return 1
    }
    if (traversal(maze, i, j, length)) {
      //println(i, j, check(i)(j))
      check(i)(j) = 1
      if(i+1<length) {
        if (Solve_Maze(maze, check, i + 1, j, length)==1)
          return 1
      }
      if(j+1<length) {
        if (Solve_Maze(maze, check, i, j + 1, length)==1)
          return 1
      }
      check(i)(j) = 0
      return 0
    }
      return 0
  }
  def traversal(maze: Array[Array[Int]],i:Int,j:Int,length: Int):Boolean={
    if(i==length-1 & j==length-1)
      false
    else if(i<length & j<length & maze(i)(j)==1 ){
        true
    }
    else{
      false
    }
  }
}
