import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TwoPlayer {
	JFrame board;
	JButton sq[];
	int playerTurn=0,count=0;
	int bclick[];
	String x=Menu.x;//"<html><span style='font-size:80px;color:GREEN'>"+"X"+"</span></html>";
	String o=Menu.o;//"<html><span style='font-size:80px;color:RED'>"+"O"+"</span></html>";
	
	
	TwoPlayer(){
        board = new JFrame("Tic-Tac-Toe");
        board.setSize(600,600);
        board.setLayout(new GridLayout(3,3));
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.getContentPane().setBackground(Color.BLUE);
       
        sq = new JButton[9];
        bclick = new int[9];
        for(int i=0;i<9;i++){
        	sq[i] = new JButton();
        	board.add(sq[i]);
        	bclick[i]=1;
        }
        sq[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){			
				if(bclick[0]==1){
					setPosition(0);
					bclick[0]=0;
				}
			}
		});
        sq[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(bclick[1]==1){
					setPosition(1);
					bclick[1]=0;
				}
			}
		});
        sq[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(bclick[2]==1){
					setPosition(2);
					bclick[2]=0;
				}
			}
		});
        sq[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(bclick[3]==1){
					setPosition(3);
					bclick[3]=0;
				}
			}
		});
        sq[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(bclick[4]==1){
					setPosition(4);
					bclick[4]=0;
				}
			}
		});
        sq[5].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(bclick[5]==1){
					setPosition(5);
					bclick[5]=0;
				}
			}
		});
        sq[6].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(bclick[6]==1){
					setPosition(6);
					bclick[6]=0;
				}
			}
		});
        sq[7].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(bclick[7]==1){
					setPosition(7);
					bclick[7]=0;
				}
			}
		});
        sq[8].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(bclick[8]==1){
					setPosition(8);
					bclick[8]=0;
				}
			}
		});
        
        
        
        board.setLocationRelativeTo(null);
        board.setVisible(true);
    }
	public void setPosition(int i){
		if(playerTurn==0){
				sq[i].setText(o);
		}
		else{
				sq[i].setText(x);
		}
		playerTurn=(playerTurn+1)%2;
		count++;
		if(check())	
			reset();
	}
	public boolean check(){
		String x="",y="",z="";
		//row wise calculation
		
		for(int i=0;i<9;i++){
			x=sq[i].getText();
			y=sq[++i].getText();
			z=sq[++i].getText();
			if(x.equals(y) && y.equals(z) && x!=""){
				if(playerTurn==1){
					Result.w2c++;
					Result.l1c++;
					JOptionPane.showMessageDialog(null, "Player O Won");
				}
				else{
					Result.w1c++;
					Result.l2c++;
					JOptionPane.showMessageDialog(null, "Player X Won");
				 }
				return true;
			}
		}
		//cols wise calculation
		for(int i=0;i<3;i++){
			x=sq[i].getText();
			y=sq[i+3].getText();
			z=sq[6+i].getText();
			if(x.equals(y) && y.equals(z) && x!=""){
				if(playerTurn==1){
					Result.w2c++;
					Result.l1c++;
					JOptionPane.showMessageDialog(null, "Player O Won");
				}
				else{
					Result.w1c++;
					Result.l2c++;
					JOptionPane.showMessageDialog(null, "Player X Won");
				 }
				return true;
			}
		}
		//first diagonal wise calculation
		x=sq[0].getText();
		y=sq[4].getText();
		z=sq[8].getText();
		if(x.equals(y) && y.equals(z) && x!=""){
			if(playerTurn==1){
				Result.w2c++;
				Result.l1c++;
				JOptionPane.showMessageDialog(null, "Player O Won");
			}
			else{
				Result.w1c++;
				Result.l2c++;
				JOptionPane.showMessageDialog(null, "Player X Won");
			 }
			return true;
		}
		//Second diagonal wise calculation
		x=sq[2].getText();
		y=sq[4].getText();
		z=sq[6].getText();
		if(x.equals(y) && y.equals(z) && x!=""){
			if(playerTurn==1){
				Result.w2c++;
				Result.l1c++;
				JOptionPane.showMessageDialog(null, "Player O Won");
			}
			else{
				Result.w1c++;
				Result.l2c++;
				JOptionPane.showMessageDialog(null, "Player X Won");
			 }
			return true;
		}
		if(count==9){
			JOptionPane.showMessageDialog(null, "DRAW");
			return true;
		}
		
		return false;
	}
	public void reset(){
		board.dispose();
		Result.p1="X";
		Result.p2="O";
		new Result();
	}
    public static void main(String[]args){
    	SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new TwoPlayer();
			}
		});
    }
}
