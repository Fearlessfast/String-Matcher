import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class NaiveString extends JFrame implements ActionListener{
	public static ArrayList<String> search = new ArrayList<String>();//keeps pattern when pattern are written in text field
    String word;
public static class ImagePanel extends JPanel{
		Image ob =new ImageIcon("turingmachine.jpg").getImage();//arranging of background theme
	public void paintComponent(Graphics g){
		g.drawImage(ob,0,0,getWidth(),getHeight(),this);
	    
	     }
	}
	
    
	JLabel title3;
	JLabel title4;
    JTextField pattern;
	JButton enter3;
  
	public NaiveString(){
	  
	  super("Search for Naive String");//writing panel title
	  
	  
	  setSize(600,350);//setting panel size
	  setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);		  
      JPanel ImagePanel2 = new ImagePanel();
      
      
      ImagePanel2.setLayout(null);
      
      title3 = new JLabel("NAIVE STRING MATCHING");//arranging label type and write on screen
      title3.setForeground(Color.ORANGE);
      title3.setFont(new Font("SansSerif",Font.BOLD,30));
      
      title4 = new JLabel("Search for String:");//arranging label type and write on screen
      title4.setForeground(Color.ORANGE);
      
      
      pattern = new JTextField();
      
      enter3 = new JButton("Search");//naming button and add on screen
  
      enter3.addActionListener(this);//making button active for mouse click
      
      
      title3.setBounds(110, 30, 400, 30);//setting locations(x,y) and sizing area(x,y)
      title4.setBounds(110, 100, 200, 30);
      pattern.setBounds(220, 100, 200, 30);
      enter3.setBounds(260, 155, 110, 40);
     
      
  
		
      ImagePanel2.add(title3);//adding tools to Imagepanel
      ImagePanel2.add(title4);
      ImagePanel2.add(pattern);
      ImagePanel2.add(enter3);
     
  
      
      add(ImagePanel2);//creating panel2
  }


public void actionPerformed(ActionEvent e) {//arranging button actions
 if(e.getSource()== enter3){//button triggers NaiveStingOutputs panel
	 word = pattern.getText();//getting pattern from text field
	 search.add(0, word);
	 
	 dispose();
	NaiveOutputs na = new NaiveOutputs();
     na.setVisible(true);
	}

	
	      }
 


public static void main(String args[]) throws Exception{
	  NaiveString na= new NaiveString();
      na.setVisible(true);
      na.setResizable(false);
      
    }
}
