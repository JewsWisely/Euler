import static euler.Euler.*;
import euler.FileReader;
import java.util.*;

public class ProjectEuler54
{     
   static final int A = 14;
   static final int K = 13;
   static final int Q = 12;
   static final int J = 11;
   static final int T = 10;
   
   public static void main(String [] args)
   {  
      long t0 = System.nanoTime();
      
      FileReader reader = new FileReader("text/54.txt");
      Scanner scanner = reader.getScanner();
      String[] line;
      int wins = 0;
      
      while(scanner.hasNextLine())
      {
         line = scanner.nextLine().split(" ");
         if(p1Wins(line))
            wins++;
      }
         
      reader.close();
      
      long t1 = System.nanoTime();
      System.out.println(wins + ", solve time: " + (t1 - t0)/1000000.0 + " milliseconds");
   }
   
   public static boolean p1Wins(String[] line)
   {
      
      int[] n1 = new int[5], n2 = new int[5];
      char[] suit1 = new char[5], suit2 = new char[5];
      
      for(int i = 0; i < line.length; i++)
      {
         if(i < 5)
         {
            n1[i] = getNumber(line[i].charAt(0));
            suit1[i] = line[i].charAt(1);
         }
         else
         {
            n2[i - 5] = getNumber(line[i].charAt(0));
            suit2[i - 5] = line[i].charAt(1);
         }
      }
      
      Arrays.sort(n1);
      Arrays.sort(n2);
      
      if(royal(n1, suit1))
         return true;
      if(royal(n2, suit2))
         return false;
      
      switch((int)Math.signum(straightFlush(n1, suit1) - straightFlush(n2, suit2)))
      {
         case -1:
            return false;
         case 1: /*
            System.out.println("SF");
            for(int i = 0; i < n1.length; i++)
               System.out.print(n1[i] + " ");
            System.out.println();*/
            return true;
         case 0:
            int num = straightFlush(n1, suit1);
            if(num != -1)
               return max(n1, num) > max(n2, num);
         default:
            break;
      }       
      
      switch((int)Math.signum(four(n1) - four(n2)))
      {
         case -1:
            return false;
         case 1: /*
            System.out.println("4");
            for(int i = 0; i < n1.length; i++)
               System.out.print(n1[i] + " ");
            System.out.println();*/
            return true;
         case 0:
            int num = four(n1);
            if(num != -1)
               return max(n1, num) > max(n2, num);
         default:
            break;
      }
      
      switch((int)Math.signum(fullHouse(n1) - fullHouse(n2)))
      {
         case -1:
            return false;
         case 1: /*
            System.out.println("FH");
            for(int i = 0; i < n1.length; i++)
               System.out.print(n1[i] + " ");
            System.out.println();*/
            return true;
         case 0:
            int num = fullHouse(n1);
            if(num != -1)
               return max(n1, num) > max(n2, num);
         default:
            break;
      }
    
      if(flush(suit1))
      {/*
         System.out.println("F");
         for(int i = 0; i < suit1.length; i++)
            System.out.print(suit1[i] + " ");
         System.out.println();*/
         if(flush(suit2))
            return max(n1, -1) > max(n2, -1);
         else
            return true;
      }
      if(flush(suit2))
      {
         if(flush(suit1))
            return max(n1, -1) > max(n2, -1);
         else
            return false;
      }
      
      switch((int)Math.signum(straight(n1) - straight(n2)))
      {
         case -1:
            return false;
         case 1: /*
            System.out.println("S");
            for(int i = 0; i < n1.length; i++)
               System.out.print(n1[i] + " ");
            System.out.println();*/
            return true;
         case 0:
            int num = straight(n1);
            if(num != -1)
               return max(n1, num) > max(n2, num);
         default:
            break;
      }
      
      switch((int)Math.signum(three(n1) - three(n2)))
      {
         case -1:
            return false;
         case 1: /*
            System.out.println("3");
            for(int i = 0; i < n1.length; i++)
               System.out.print(n1[i] + " ");
            System.out.println();*/
            return true;
         case 0:
            int num = three(n1);
            if(num != -1)
               return max(n1, num) > max(n2, num);
         default:
            break;
      }
      
      switch((int)Math.signum(twoPair(n1) - twoPair(n2)))
      {
         case -1:
            return false;
         case 1: /*
            System.out.println("2P");
            for(int i = 0; i < n1.length; i++)
               System.out.print(n1[i] + " ");
            System.out.println();*/
            return true;
         case 0:
            int num = twoPair(n1);
            if(num != -1)
               return max(n1, num) > max(n2, num);
         default:
            break;
      }
      
      switch((int)Math.signum(onePair(n1) - onePair(n2)))
      {
         case -1:
            return false;
         case 1: /*
            System.out.println("1P");
            for(int i = 0; i < n1.length; i++)
               System.out.print(n1[i] + " ");
            System.out.println();*/
            return true;
         case 0:
            int num = onePair(n1);
            if(num != -1)
               return max(n1, num) > max(n2, num);
         default:
            break;
      }
      
      return max(n1, -1) > max(n2, -1);
   }
   
   public static int onePair(int[] n)
   {
      for(int i = 0; i < n.length - 1; i++)
         if(n[i] == n[i + 1])
            return n[i];
      return -1;
   }
   
   public static boolean royal(int[] n, char[] c)
   {
      return flush(c) && straight(n) == A;
   }
   
   public static int straightFlush(int[] n, char[] c)
   {
      return flush(c) ? straight(n) : -1;
   }
   
   public static int twoPair(int[] n)
   {
      int ree = 0;
      
      for(int i = 0; i < n.length - 1; i++)
         if(n[i] == n[i + 1]  && ++ree == 2)
            return n[i];
      return -1;
      /*
      int[][] ree = new int[3][2];
      
      for(int i = 0; i < n.length; i++)
         for(int k = 0; k < ree.length + 1; k++)
            if(k == ree.length)
               return -1;
            else if(n[i] == ree[k][0])
            {
               ree[k][1]++;
               break;
            }
            else if(ree[k][0] == 0)
            {
               ree[k][0] = n[i];
               ree[k][1]++;
               break;
            }
      
      int count = 0;
      for(int i = 0; i < ree.length; i++)
         if(ree[i][1] == 2)
            count++;
      
      if(count != 2)
         return -1;
         
      count = 0; 
      for(int i = 0; i < ree.length; i++)
         if(ree[i][1] == 2 && ree[i][0] > count)
            count = ree[i][0];
            
      return count;*/
   }
   
   public static int three(int[] n)
   {
      return (n[2] == n[1] && n[1] == n[0]) || (n[2] == n[3] && n[3] == n[4]) || (n[2] == n[1] && n[2] == n[3]) ? n[2] : -1;
      
      /*
      int[][] ree = new int[3][2];
      
      for(int i = 0; i < n.length; i++)
         for(int k = 0; k < ree.length + 1; k++)
            if(k == ree.length)
               return -1;
            else if(n[i] == ree[k][0])
            {
               ree[k][1]++;
               break;
            }
            else if(ree[k][0] == 0)
            {
               ree[k][0] = n[i];
               ree[k][1]++;
               break;
            }
      
      for(int k = 0; k < ree.length; k++)
         if(ree[k][1] == 3)
            return ree[k][0];
      return -1;*/
   }
   
   public static int fullHouse(int[] n)
   {
      return n[0] == n[1] && n[3] == n[4] ? n[2] == n[1] ? n[0] : n[2] == n[3] ? n[4] : -1 : -1;
      /*
      int[][] ree = new int[2][2];
      for(int i = 0; i < n.length; i++)
      {
         for(int k = 0; k < ree.length + 1; k++)
         {
            if(k == ree.length)
               return -1;
            else if(ree[k][0] == 0)
            {
               ree[k][1] = n[i];
               ree[k][1] = 0;
               break;
            }
            else if(ree[k][0] == n[i])
            {
               ree[k][1]++;
               break;
            }
         }
      }
      if((ree[0][1] == 2 || ree[1][1] == 2) && (ree[0][1] == 3 || ree[1][1] == 3))
         return ree[0][1] > ree[1][1] ? ree[0][1] : ree[1][1];
      return -1;*/
   }
   
   public static int four(int[] n)
   {
      int count = 0;
      for(int i = 0; i < n.length - 1; i++)
         if(n[i] != n[i + 1] && ++count == 2)
            return -1;
      return n[0] == n[1] ? n[0] : n[4];
   }
   
   public static boolean flush(char[] suits)
   {
      for(int i = 0; i < suits.length - 1; i++)
         if(suits[i] != suits[i + 1])
            return false;
      return true;
   }
   
   public static int straight(int[] n)
   {
      for(int i = 0; i < n.length - 1; i++)
         if(n[i + 1] - n[i] != 1)
            return -1;
      return n[4];
   }
   
   public static int max(int[] n, int ignore)
   {
      for(int i = 4; i >= 0; i--)
         if(n[i] != ignore)
            return n[i];
      return -1;
   }
   
   public static int getNumber(char c)
   {
      switch(c)
      {
         case 'A':
            return A;
         case 'K':
            return K;
         case 'Q':
            return Q;
         case 'J':
            return J;
         case 'T':
            return T;
         default:
            return integer(c);
      }
   }
}