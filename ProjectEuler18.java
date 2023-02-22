import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class ProjectEuler18
{
   static Scanner scanner;
   static int numLines = 15;
   static int[][] tree = new int[numLines][];
   
   public static void main(String[] args) throws FileNotFoundException
   {   
      long t0 = System.nanoTime();
      File file = new File("text/18.txt");
      scanner = new Scanner(file);
      
      for(int i = 0; i < numLines; i++)
         tree[i] = new int[i + 1];
         
      int r = 0, c = 0;
      
      while(scanner.hasNextInt())
      {
         tree[r][c++] = scanner.nextInt();
         if(c >= tree[r].length)
         {
            r++;
            c = 0;
         }
      }//file to 2D array
      
      System.out.println(maxSum(0, 0, 0));
      long t1 = System.nanoTime();
      System.out.println("time to solve: " + (t1 - t0) / 1000000 + " milliseconds");
   }
   
   public static int maxSum(int sum, int row, int col)
   {
      if(row == numLines - 1){
         if(col >= numLines - 1)
            return sum + tree[row][col];
         return sum + Math.max(tree[row][col], tree[row][col + 1]);
      }
      
      return Math.max(maxSum(sum + tree[row][col], row + 1, col), maxSum(sum + tree[row][col], row + 1, col + 1));
   }
}