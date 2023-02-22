package euler;
import java.io.*;
import java.util.*;

public class FileReader
{
   private File file;
   private Scanner scanner;
   
   public FileReader(String fileName)
   {
      try
      {
         file = new File(fileName);
         scanner = new Scanner(file);
      }
      catch(Exception e)
      {
         System.out.println(e);
      }
   }
   
   public File getFile()
   {
      return file;
   }
   
   public Scanner getScanner()
   {
      return scanner;
   }
   
   public void close()
   {
      scanner.close();
      scanner = null;
      file = null;
   }
}