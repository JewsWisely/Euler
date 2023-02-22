package euler;

import java.util.ArrayList;
import java.math.BigInteger;

public class Fibonacci
{/*
   private ArrayList<BigInteger> f;
   
   public Fibonacci()
   {
      f = new ArrayList<BigInteger>();
      
      f.add(BigInteger.ONE);
      f.add(BigInteger.ONE);
   }
   
   public Fibonacci(int index)
   {
      f = new ArrayList<BigInteger>();
      
      f.add(BigInteger.ONE);
      f.add(BigInteger.ONE);
      
      generate(index);
   }
   
   public ArrayList<BigInteger> getList()
   {
      return f;
   }
   
   public BigInteger get(int index)
   {
      if(index >= f.size())
         generate(index);
      return f.get(index);
   }
   
   private void generate(int index)
   {
      int size = f.size();
      
      while(size < index)
      {
         f.add(f.get(size - 1).add(f.get(size - 2)));
         size++;
      }
   }
   
   public String toString()
   {
      String str = "[length = " + f.size();
      for(BigInteger i : f)
         str += ", " + i;
      return str + "]";
   }*/
   
}