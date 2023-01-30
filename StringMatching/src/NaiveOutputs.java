import javax.swing.*;
import java.awt.*;
import java.io.*;


public class NaiveOutputs extends JFrame
{

JTextArea console;
JScrollPane consolemi;


NaiveOutputs()
{
setSize(580,290);//setting frame size
setTitle("Outputs for Naive String Matching");//writing frame title

setLocation(100,100);//adopting text area
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

setLayout(new GridBagLayout());

console = new javax.swing.JTextArea();


console.setColumns(50);//setting size of console
console.setRows(15);
console.setEditable(false);

console.setText("NAIVE STRING MATCHING OUTPUTS");//writing text in first line on console 

consolemi = new javax.swing.JScrollPane(console);//setting bar horizontal and vertical in order to adopt console in Jext Area

add(consolemi);//create text area


System.setOut(new PrintStream(new JTextAreaOutputStream(console)));
System.setErr(new PrintStream(new JTextAreaOutputStream(console)));


new Thread(new Runnable()//Initializing new Thread for writeLog()
{
public void run() 
{ try 
{
writeLog();//Define writeLog() function to be console screen
} 
catch (Exception ie) 
{ }
}
}).start();
}


public class JTextAreaOutputStream extends OutputStream//To make JTextArea to console screen
{
JTextArea te;

public JTextAreaOutputStream(JTextArea area) 
{
super();
te = area;
}

public void write(int i) //Convert Characters to Strings
{
te.append(Character.toString((char)i));
}

public void write(char[] buf, int off, int len) //Reads len characters into a specified array, started from offset off.
{
String s = new String(buf, off, len);//The data to be written,the start offset in the data,the number of bytes that are written in String
te.append(s);
}
}



public void writeLog() throws IOException //Naive String Matcher Code are implements and redirect to JTextArea to be outputs
{
	  System.out.println("");
	  NaiveStringMatcher x = new NaiveStringMatcher();
	  int i=1;
	         
	    BufferedReader br = new BufferedReader(new FileReader("automata.txt"));//Read from Text for Matching

	    String line = null;
	    long startTime = System.currentTimeMillis();
	    while ((line = br.readLine()) != null)
	    {   
	    System.out.println("Line " + i + ": " + x.Search(line,NaiveString.search.get(0)) + " occurrence" ); //Occurrence and line numbers are demonstrated on console
	    i++;
	    }
	    long endTime   = System.currentTimeMillis();
	    long totalTime = endTime - startTime;//Calculation of runtime of Naive String Matching
	    System.out.println("Time for Naive-String-Matching: " + totalTime + " ms");
	    br.close();  
	    
}

public static void main(String[] args) //JFrame opens with JTextArea on screen
{
JFrame jf = new NaiveOutputs();
jf.setVisible(true); 
jf.setResizable(false);
  

  }
}


