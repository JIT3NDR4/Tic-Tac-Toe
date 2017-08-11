import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class OnePlayer {
	JFrame board;
	JButton sq[];
	int playerTurn=0,count=0;
	int bclick[];
	String x=Menu.x;//"<html><span style='font-size:80px;color:GREEN'>"+"X"+"</span></html>";
	String o=Menu.o;//"<html><span style='font-size:80px;color:RED'>"+"O"+"</span></html>";
	
	OnePlayer(){
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
        if(Menu.playlevel==1){
        	compTurn();
        	count=1;
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
		sq[i].setText(o);
		bclick[i]=0;
		playerTurn=(playerTurn+1)%2;
		count++;
		if(check())	{
			reset();
			return ;
		}
		playerTurn=(playerTurn+1)%2;
		if(Menu.playlevel==1)
			compTurnhard();
		else
			compTurn();
		count++;
		if(check())	
			reset();
	}
	public void compTurn(){
			int i = randomMove();
			int y=0;
			while(bclick[i]!=1 && y<100){
				i=randomMove();
				y++;
			}
			sq[i].setText(x);
			bclick[i]=0;
	}
	int randomMove() {
        Random random=new Random();
        int x=random.nextInt();
        x=x%9;
        if(x<0)
            x=-x;
        return x;
    }
	public void compTurnhard(){
		if(count<4){
			int i = randomMove();
			int y=0;
			while(bclick[i]!=1 && y<100){
				i=randomMove();
				y++;
			}
			sq[i].setText(x);
			bclick[i]=0;
		}
		else{
			if(sq[0].getText().equals(sq[1].getText()) && bclick[2]==1){
				sq[2].setText(x);
				bclick[2]=0;
			}
			else if(sq[0].getText().equals(sq[2].getText()) && bclick[1]==1){
				sq[1].setText(x);
				bclick[1]=0;
			}
			else if(sq[0].getText().equals(sq[3].getText()) && bclick[6]==1){
				sq[6].setText(x);
				bclick[6]=0;
			}
			else if(sq[0].getText().equals(sq[6].getText()) && bclick[3]==1){
				sq[3].setText(x);
				bclick[3]=0;
			}
			else if(sq[0].getText().equals(sq[4].getText()) && bclick[8]==1){
				sq[8].setText(x);
				bclick[8]=0;
			}
			else if(sq[0].getText().equals(sq[8].getText()) && bclick[4]==1){
				sq[4].setText(x);
				bclick[4]=0;
			}
			else if(sq[1].getText().equals(sq[4].getText()) && bclick[7]==1){
				sq[7].setText(x);
				bclick[7]=0;
			}
			else if(sq[1].getText().equals(sq[7].getText()) && bclick[4]==1){
				sq[4].setText(x);
				bclick[4]=0;
			}
			else if(sq[2].getText().equals(sq[5].getText()) && bclick[8]==1){
				sq[8].setText(x);
				bclick[8]=0;
			}
			else if(sq[2].getText().equals(sq[8].getText()) && bclick[5]==1){
				sq[5].setText(x);
				bclick[5]=0;
			}
			else if(sq[3].getText().equals(sq[4].getText()) && bclick[5]==1){
				sq[5].setText(x);
				bclick[5]=0;
			}
			else if(sq[3].getText().equals(sq[5].getText()) && bclick[4]==1){
				sq[4].setText(x);
				bclick[4]=0;
			}
			else if(sq[6].getText().equals(sq[7].getText()) && bclick[8]==1){
				sq[8].setText(x);
				bclick[8]=0;
			}
			else if(sq[6].getText().equals(sq[8].getText()) && bclick[7]==1){
				sq[7].setText(x);
				bclick[7]=0;
			}
			else{
				int i = randomMove();
				int y=0;
				while(bclick[i]!=1 && y<100){
					i=randomMove();
					y++;
				}
				sq[i].setText(x);
				bclick[i]=0;
			}
		}
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
					Result.w2co++;
					Result.l1co++;
					JOptionPane.showMessageDialog(null, "You Won");
				}
				else{
					Result.w1co++;
					Result.l2co++;
					JOptionPane.showMessageDialog(null, "Computer Won");
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
					Result.w2co++;
					Result.l1co++;
					JOptionPane.showMessageDialog(null, "You Won");
				}
				else{
					Result.w1co++;
					Result.l2co++;
					JOptionPane.showMessageDialog(null, "Computer Won");
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
				Result.w2co++;
				Result.l1co++;
				JOptionPane.showMessageDialog(null, "You Won");
			}
			else{
				Result.w1co++;
				Result.l2co++;
				JOptionPane.showMessageDialog(null, "Computer Won");
			}
			return true;
		}
		//Second diagonal wise calculation
		x=sq[2].getText();
		y=sq[4].getText();
		z=sq[6].getText();
		if(x.equals(y) && y.equals(z) && x!=""){
			if(playerTurn==1){
				Result.w2co++;
				Result.l1co++;
				JOptionPane.showMessageDialog(null, "You Won");
			}
			else{
				Result.w1co++;
				Result.l2co++;
				JOptionPane.showMessageDialog(null, "Computer Won");
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
		Result.p1="Computer";
		Result.p2="You";
		new Result();
	}
	public static void main(String[]args){
    	SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new OnePlayer();
			}
		});
    }
}
