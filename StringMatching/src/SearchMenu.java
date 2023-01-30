//Main class to start program.


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;


	
	
	public class SearchMenu extends JFrame implements ActionListener{
		
	public static class ImagePanel extends JPanel{
			Image ob =new ImageIcon("turingmachine.jpg").getImage();//arranging of background theme
		public void paintComponent(Graphics g){
			g.drawImage(ob,0,0,getWidth(),getHeight(),this);
		     }
		}
	
		JLabel title1;
		JLabel title2;
		JButton enter1;
		JButton enter2;
	 
		public SearchMenu(){
		  
		  super("Search for String Matching");//writing panel title
		  
		  setSize(600,350);//setting panel size
		  setVisible(true);
	      setDefaultCloseOperation(EXIT_ON_CLOSE);		  
	      JPanel ImagePanel = new ImagePanel();
	      ImagePanel.setLayout(null);
	      
	      title1 = new JLabel("STRING MATCHERS");//arranging label type and write on screen
	      title1.setForeground(Color.ORANGE);
	      title1.setFont(new Font("SansSerif",Font.BOLD,30));
	      
	      title2 = new JLabel("Choose Your Search Type");//arranging label type and write on screen
	      title2.setForeground(Color.ORANGE);
	      
	      
	  
	      enter1 = new JButton("Naive String Matcher");//naming button and add on screen
	      enter2 = new JButton("Finite Automaton Matcher");
	      
	      enter1.addActionListener(this);//making button active for mouse click
	      enter2.addActionListener(this);
	      
	      title1.setBounds(140, 30, 400, 30);//setting locations(x,y) and sizing area(x,y) 
	      title2.setBounds(210, 90, 200, 30);
	      enter1.setBounds(170, 150, 220, 40);
	      enter2.setBounds(170, 200, 220, 40);
	      
	  
			
	      ImagePanel.add(title1);//adding tools to Imagepanel
	      ImagePanel.add(title2);
	      ImagePanel.add(enter1);
	      ImagePanel.add(enter2);
	  
	      
	      add(ImagePanel);//creating ImagePanel
	  }

	
		public void actionPerformed(ActionEvent e) {//arranging button actions
			if(e.getSource()== enter1){//button triggers NaiveString panel
			dispose();
			NaiveString na = new NaiveString();
		    na.setVisible(true);
			}
			else if(e.getSource()== enter2){//button triggers FiniteAutomatonString panel
			dispose();
			FiniteAutomatonString fi = new FiniteAutomatonString();
			fi.setVisible(true);
			}
		     
		}
			
		public static void main(String args[]) throws Exception{
			  SearchMenu ser = new SearchMenu();
		      ser.setVisible(true);
		      ser.setResizable(false);
	      
		    }
		
	  }




