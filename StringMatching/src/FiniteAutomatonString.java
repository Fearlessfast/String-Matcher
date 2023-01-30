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


public class FiniteAutomatonString extends JFrame implements ActionListener{
	public static ArrayList<String> search2 = new ArrayList<String>();//keeps pattern when pattern are written in text field
    String word2;
	public static class ImagePanel extends JPanel{
		Image ob =new ImageIcon("turingmachine.jpg").getImage();//arranging of background theme
	public void paintComponent(Graphics g){
		g.drawImage(ob,0,0,getWidth(),getHeight(),this);
	     }
	}
	
    
	JLabel title5;
	JLabel title6;
    JTextField pattern2;
	JButton enter4;
  
	public FiniteAutomatonString(){
	  
	  super("Search for Finite Automaton String Matching");//writing panel title
	  
	  setSize(600,350);//setting panel size
	  setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);		  
      JPanel ImagePanel2 = new ImagePanel();
      
      
      ImagePanel2.setLayout(null);
      
      title5 = new JLabel("FINITE AUTOMATON STRING MATCHING");//arranging label type and write on screen
      title5.setForeground(Color.ORANGE);
      title5.setFont(new Font("SansSerif",Font.BOLD,20));
      
      title6 = new JLabel("Search for String:");//arranging label type and write on screen
      title6.setForeground(Color.ORANGE);
      
      
      pattern2 = new JTextField();
      
      enter4 = new JButton("Search");//naming button and add on screen
  
      enter4.addActionListener(this);//making button active for mouse click
      
      
      title5.setBounds(110, 30, 400, 30);//setting locations(x,y) and sizing area(x,y)
      title6.setBounds(110, 100, 200, 30);
      pattern2.setBounds(220, 100, 200, 30);
      enter4.setBounds(260, 155, 110, 40);
     
      
  
		
      ImagePanel2.add(title5);//adding tools to Imagepanel2
      ImagePanel2.add(title6);
      ImagePanel2.add(pattern2);
      ImagePanel2.add(enter4);
     
  
      
      add(ImagePanel2);//creating Imagepanel2
  }


public void actionPerformed(ActionEvent e) {//arranging button actions
 if(e.getSource()== enter4){//button triggers NaiveStingOutputs panel
	
	word2 = pattern2.getText();//getting pattern from text field
	search2.add(0, word2);
	dispose();
	FiniteAutomatonOutputs fi = new FiniteAutomatonOutputs();
    fi.setVisible(true);
	
 }

	
	      }
 


public static void main(String args[]) throws Exception{
	  FiniteAutomatonString fi= new FiniteAutomatonString();
      fi.setVisible(true);
      fi.setResizable(false);
      
    }
}

