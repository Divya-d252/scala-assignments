// https://leetcode.com/problems/rotate-image/

// Leetcode - Medium Level

object Solution 
{
    def rotate(matrix: Array[Array[Int]]): Unit = 
    {
        for(i<-0 to matrix.length-1)
        {
            for(j<-i+1 to matrix.length-1)
            {
                
                var temp=matrix(i)(j)
                matrix(i)(j)=matrix(j)(i)
                matrix(j)(i)=temp
                //print(matrix(i)(j))
            }
        }
        for(i<-0 to matrix.length-1)
        {
            for(j<-0 to (matrix.length/2)-1)
            {
                var temp=matrix(i)(j)
                matrix(i)(j)=matrix(i)(matrix.length-j-1)
                matrix(i)(matrix.length-j-1)=temp
            }
        }
    }
}
