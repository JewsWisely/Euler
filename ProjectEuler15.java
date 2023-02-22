public class ProjectEuler15
{
   public static void main(String[] args)
   {
      double[][] grid = new double[21][21];
      for(int r = 0; r < grid.length; r++)
      {
         for(int c = 0; c < grid.length; c++)
         {
            if(r == 0 || c == 0)
               grid[r][c] = 1;
            else
               grid[r][c] = grid[r - 1][c] + grid[r][c - 1];
            System.out.print(" " + grid[r][c]);
         }
         System.out.println();
      }
   }
}