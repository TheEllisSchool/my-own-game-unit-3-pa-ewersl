package game2048;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;




public class game2048 extends JFrame {
    

	//private static final int GRIDSIZE = 4; 
	
	
	//Cells [] [] Cells = new Cells [GRIDSIZE] [GRIDSIZE]; 
	
    private int rows = 4;
    private int cols = 4;
    private Cells [][] grid = new Cells[rows][cols];
    private JPanel panel2048 = new JPanel();
    private int endRow = rows - 1;
    private int endCol = cols - 1;


public game2048 (){
        initGUI();
        
        setTitle("2048");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
       // setSize(450, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
      
private void initGUI(){
            //title 
            JPanel titlePanel = new JPanel(); 
            Color bcPurp = new Color (242, 230, 244);
            titlePanel.setBackground(bcPurp);
            add(titlePanel, BorderLayout.PAGE_START);
            Font titleFont = new Font("Drugs", Font.BOLD, 32);
            JLabel titleLabel = new JLabel("2048");
            titleLabel.setBackground(Color.blue);
            titleLabel.setOpaque(true);
            titleLabel.setForeground(Color.WHITE);
            titleLabel.setFont(titleFont);
            titleLabel.setHorizontalAlignment(JLabel.CENTER);
            titlePanel.add(titleLabel);
            
            //center panel
            panel2048 = new JPanel();
            panel2048.setBackground(Color.WHITE);
            panel2048.setLayout(new GridLayout(rows, cols));
            add(panel2048, BorderLayout.CENTER);
            
            for (int r=0; r < rows; r++) {
				for (int c= 0; c < cols; c++) {
					grid [r][c] = new Cells ( r, c);
					panel2048.add(grid [r] [c]);
				}
            }
					
         
           //need to add that thing
            newgame2048(); 
            
            addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent e){
                    //char c = e.getKeyChar();
                    //System.out.println(c);
                    int keyCode = e.getKeyCode();
                    moveTile(keyCode);
                }       
            });        
        
            
         
            
            //button panel
            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Color.WHITE);
            add(buttonPanel, BorderLayout.PAGE_END);
            JButton new2048Button = new JButton("New Game!");
            new2048Button.setFocusable(false);
           
            
			
			new2048Button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					newgame2048();
				} 
			}); 
			buttonPanel.add(new2048Button, BorderLayout.CENTER);
}
			public boolean check (int r, int c) {
				if (r >= 0 && r< rows) {
					if (c >= 0 && c< cols) {
						return true; 
					}
				} else {
					return false;
				}
				return false;
			}

private void moveTile(int direction){
	int newNumber; 
	
    switch (direction){
        case KeyEvent.VK_DOWN:
            for (int r=0; r < rows; r++) {
            		for (int c=0; c < cols; c++) {
            			if  (check (r, c) == true && check (r+1, c) == true) {
            				if (grid [r] [c].getNumber () == grid [r+1] [c].getNumber ()) { 
                    			newNumber= grid[r][c].getNumber ()+grid[r+1][c].getNumber ();
                    			grid [r+1] [c].setNumber(newNumber);
                    			grid [r] [c].setNumber(0);
                    			}
            			}

            		}
            }
         case KeyEvent.VK_UP:
        	 for (int r=0; r < rows; r++) {
         		for (int c=0; c < cols; c++) {
         			if (check (r,c) == true && check (r-1, c) == true) { 
         				if (grid [r] [c].getNumber () == grid [r-1] [c].getNumber ()) {
         					newNumber= grid[r][c].getNumber ()+grid[r-1][c].getNumber ();
         					grid [r-1] [c].setNumber(newNumber);
         					grid [r] [c].setNumber(0);
         				}
         			}
         		}
        	 }
            			
         case KeyEvent.VK_RIGHT:
        	 for (int r=0; r < rows; r++) {
          		for (int c=0; c < cols; c++) {
          			if (check (r, c) == true && check (r, c+ 1) == true) {
          				if (grid [r] [c].getNumber () == grid [r] [c+1].getNumber ()) {
          					newNumber= grid[r][c].getNumber () +grid[r][c+1].getNumber ();
          					grid [r] [c+1].setNumber(newNumber);
          					grid [r] [c].setNumber(0);
          					}
          			}
          		}
        	 }
         case KeyEvent.VK_LEFT:
        	 for (int r=0; r < rows; r++) {
           		for (int c=0; c < cols; c++) {
           			if (check (r, c) == true && check (r, c-1) == true) {
            			if (grid [r] [c].getNumber () == grid [r] [c-1].getNumber ()) {
            				newNumber= grid[r][c].getNumber () +grid[r][c-1].getNumber ();
            				grid [r] [c-1].setNumber(newNumber);
            				grid [r] [c].setNumber(0);
                    		}
           			}
           		}
        
        	 }
    }
    brandnewNumber ();
}
		
           
	private void newgame2048 (){
		
		for (int r= 0; r< rows; r++) {
			for (int c=0; c< cols; c++) {
				grid [r][c].setNumber (0); 
			}
		}
		
		grid[3][3].setNumber(2);
		grid[2][3].setNumber(2); 
	}

	public void brandnewNumber () {
		int randomRow;
		int randomCol; 
		do {
			Random r = new Random(); 
			randomRow = r.nextInt(rows-0); 
			randomCol = r.nextInt(cols-0);
		}
		while (grid [randomRow] [randomCol].getNumber () != 0); 
		grid [randomRow] [randomCol].setNumber (2);
		
	}
    
	public static void main(String[] args) {
		try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch ( Exception e) {}
        
        EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
            		new game2048();
            }   
        });	
	}
}



