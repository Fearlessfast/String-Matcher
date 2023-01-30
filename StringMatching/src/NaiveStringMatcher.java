public class NaiveStringMatcher
{
   
   
    public int occurrence;
    
    
  public int Search(String text,String pattern)
  {
        int j;
        int n = text.length();
        int m = pattern.length();
        occurrence = 0;
                         
                       
        for (int i = 0; i <= n - m; i++)//matching for pattern and words in text as 
                                        //long as string length difference between text and pattern
        {                 
         for(j=0;j<m;j++)
         {                
          if(pattern.charAt(j)==text.charAt(i+j))//checking if the first character in the word next 
                                                 //in line in text is same as the first character in pattern
          {                         
              
           while(pattern.charAt(j)==text.charAt(i+j))//checking if the other characters in the word 
           {                                         //is same as the other characters in the pattern
              
              j++;
              if(j==m-1)
              {               
             if(pattern.charAt(m-1)==text.charAt(i+j))//if the last character in the word
                                                      // is  same as the last character in pattern occurrence increases
             {
               occurrence++;
                  }
              } 
             
              else
              {
              break;
              }
              
           }
          }
          
          else
          {
           break;
          }
                    
         }
                
        }
      
        
     return occurrence;
   }

    
}
