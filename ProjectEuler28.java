public class ProjectEuler28
{
   public static void main(String[] args)
   {
      /*
      long t0 = System.nanoTime();
      int[][] matrix = new int[1001][1001];
      int r = 0, c = matrix[0].length - 1, num = matrix.length * matrix[0].length;
      for(int i = 0; i < (matrix.length > matrix[0].length ? matrix.length / 2 : matrix[0].length / 2); i++){
         while(c >= 0 && matrix[r][c] == 0)
            matrix[r][c--] = num--;
         r++;
         c++;
         
         while(r < matrix.length && matrix[r][c] == 0)
            matrix[r++][c] = num--;
         r--;
         c++;
         
         while(c < matrix[0].length && matrix[r][c] == 0)
            matrix[r][c++] = num--;
         r--;
         c--;
         
         while(r >= 0 && matrix[r][c] == 0)
            matrix[r--][c] = num--;
         r++;
         c--;
      }
      matrix[r][c] = num;
      int sum = -1; //counting 1 twice
      for(int i = 0; i < matrix.length; i++)
      {
         sum += matrix[i][i];
         sum += matrix[i][matrix.length - i - 1];
      }        
      long t1 = System.nanoTime();
      System.out.println(sum + "\nsolve time: " + (t1 - t0) / 1000000000.0 + " seconds");
      */
      
      long t0 = System.nanoTime();
      int sum = 1, num = 1, size = 1001;
      for(int i = 2; i < size; i += 2)
      {
         for(int x = 0; x < 4; x++)
         {
            sum += num + i;
            num += i;
         }
      }
      long t1 = System.nanoTime();
      System.out.println(sum + "\nsolve time: " + (t1 - t0) / 1000000000.0 + " seconds");
      
      //669171001
   }
}