package game2048;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Cells extends JLabel {
	  private static int SIZE = 70; //length and width of each cell 
	    public static final int TOP = 0;
	    public static final int RIGHT = 1;
	    public static final int BOTTOM = 2;
	    public static final int LEFT = 3;
	    private int row = -1;
	    private int col = -1;

		public int number;
	    private boolean [] wall = {true, true, true, true};
	    
	    private boolean current = false;
	    private boolean end = false;
	    
	    public boolean isWall(int index){
	        return wall[index];
	    }
	    
	    @Override
	    public Dimension getPreferredSize(){
	        return new Dimension (SIZE, SIZE);
	    }
	    
	    @Override
	    public void paintComponent(Graphics g){
	    		//fill background
		    	Color backgroundColor = changeColor();
		    	g.setColor(backgroundColor);
		    	g.fillRect(0, 0, SIZE, SIZE);
		    	
		    	//draw number
		    	g.setColor(Color.BLACK);
		    if (number > 0) {
		    	g.drawString("" + number, SIZE/2, SIZE/2);
		    }
		    	if (number == 0) {
		    		g.drawString("", SIZE/2, SIZE/2);
		    	}
		    	//draw the walls
	        if (isWall(TOP)) {
	        		g.drawLine(0, 0, SIZE,0); //top line 
	        }
	        
	        if (isWall(LEFT)) {
	        		g.drawLine(0, 0, 0, SIZE); // left line
	        }
	        
	    }
	    
	    
	    
	
	public Cells (int r, int c) {
		this.row= r; 
		this.col= c; 
		number = 0; 
		setPreferredSize (new Dimension (SIZE, SIZE)); 
		//changeText();
		changeColor();
		//setBorder(new EmptyBorder (0, 0, 0, 0));
	}
	
	
	public int getRow () {
		return row;
	}
	
	public int getCol () {
		return col;
	}
	
	public int getNumber () {
		return number; 
	}
	public void reset () {
		number= 0;
	}
	
	public void setNumber (int newNumber) {
		number = newNumber;
		repaint ();
	}
	
	/*
	public void changeText () {
		setForeground(Color.BLACK);
		if (number == 0) {
			setText ("");
		} else {
			setText ("" +number);
			//System.out.println("changing text...");
		}
	}
	*/
	
	

	public Color changeColor () {
		Color two = new Color (244, 248, 255);
		Color four = new Color (227, 240, 255);
		Color eight = new Color (200, 235, 255);
		Color sixteen = new Color (173, 229, 255);
		Color thirtyTwo = new Color (200, 222, 255); 
		Color sixtyFour = new Color (146, 216, 255); 
		Color onetwoeight = new Color (129, 209, 255);
		Color twofivesix = new Color (112, 201, 255);
		Color fivetwelve = new Color (85, 194, 255);
		Color onezerotwentyfour = new Color (33, 113, 255);
		Color twentyfourtyeight = new Color (0, 92, 255); 
		Color fourzeronesix = new Color (0, 67, 188);
		if (number == 0) {
			return Color.GRAY;
		}
		if (number == 2) {
			return two;
			//setBackground (two); 
			//System.out.println("changing color");
		}
		if (number == 4) {
			return four;
		}
		if (number == 8) {
			return eight;
		}
		if (number == 16) {
			return sixteen;
		}
		if (number == 32) {
			return thirtyTwo; 
		}
		if (number == 64) {
			return sixtyFour;
		}
		if (number == 128) {
			return onetwoeight;
		}
		if (number == 256) {
			return twofivesix;
		}
		if (number == 512) {
			return fivetwelve;  
		}
		if (number == 1024) {
			return onezerotwentyfour;
		}
		if (number == 2048) {
			return twentyfourtyeight;
		}
		if (number == 4016) {
			return fourzeronesix;
		}
		
		return null;
		
	}
}
