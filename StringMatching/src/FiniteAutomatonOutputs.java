import javax.swing.*;

import java.awt.*;
import java.io.*;


public class FiniteAutomatonOutputs extends JFrame
{

JTextArea console2;
JScrollPane consolemi2;


FiniteAutomatonOutputs()
{
setSize(580,290);//setting frame size
setTitle("Outputs for Finite Automaton String Matching");//writing frame title
setLocation(100,100);//adopting text area
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

setLayout(new GridBagLayout());

console2 = new javax.swing.JTextArea();


console2.setColumns(50);//setting size of console
console2.setRows(15);
console2.setEditable(false);

console2.setText("FINITE AUTOMATON STRING MATCHING OUTPUTS");//writing text in first line on console 

consolemi2 = new javax.swing.JScrollPane(console2);//setting bar horizontal and vertical in order to adopt console in Jext Area

add(consolemi2);//create text area


System.setOut(new PrintStream(new JTextAreaOutputStream(console2)));
System.setErr(new PrintStream(new JTextAreaOutputStream(console2)));


new Thread(new Runnable()//Initializing new Thread for writeLog2()
{
public void run() 
{ try 
{
writeLog2();//Define writeLog2() function to be console screen 
} 
catch (Exception ie) 
{ }
}
}).start();
}


public class JTextAreaOutputStream extends OutputStream//To make JTextArea to console screen 
{
JTextArea te2;

public JTextAreaOutputStream(JTextArea area) 
{
super();
te2 = area;
}

public void write(int i) //Convert Characters to Strings
{
te2.append(Character.toString((char)i));
}

public void write(char[] buf, int off, int len)//Reads len characters into a specified array, started from offset off. 
  {
String s = new String(buf, off, len);//The data to be written,the start offset in the data,the number of bytes that are written in String
te2.append(s);
  }
}



public void writeLog2() throws IOException //Finite Automata String Matcher Code are implements and redirect to JTextArea to be outputs
{
	System.out.println("");
    
	FiniteAutomatonMatcher y = new FiniteAutomatonMatcher();

	  int i=1;
	         
	    BufferedReader br = new BufferedReader(new FileReader("automata.txt"));//Read from Text for Matching

	    String line = null;
	    long startTime2 = System.currentTimeMillis();
	    while ((line = br.readLine()) != null)
	    {   
	    System.out.println("Line " + i + ": " + y.FASearch(line,FiniteAutomatonString.search2.get(0)) + " occurrence" ); //Occurrence and line numbers are demonstrated on console
	    i++;
	    }
	    long endTime2   = System.currentTimeMillis();
	    long totalTime2 = endTime2 - startTime2;//Calculation of runtime of Finite Automaton String Matching
	    System.out.println("Time for Finite Automaton String Matching: " + totalTime2 + " ms");
	    br.close();  

}

public static void main(String[] args) //JFrame opens with JTextArea on screen
{
JFrame jf2 = new FiniteAutomatonOutputs();
jf2.setVisible(true); 
jf2.setResizable(false);
   
  }
}


