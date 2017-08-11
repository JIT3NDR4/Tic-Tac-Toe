import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Result {
	JFrame result;
	JLabel w1,l1,w2,l2;
	JLabel p,w,l,r,pl1,pl2;
	public static int w1c,l1c,w2c,l2c,w1co,l1co,w2co,l2co;
	public static String p1 = "X",p2 = "O";
	JButton play;
	Result(){
		result = new JFrame("Result");
		result.setSize(600,600);
        result.setLayout(null);
        result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        result.getContentPane().setBackground(Color.BLUE);
        result.setLocationRelativeTo(null);
        r = new JLabel("<html><span style='font-size:20px;color:YELLOW'>"+"Statistics"+"</span></html>");
        w = new JLabel("<html><span style='font-size:20px;color:GREEN'>"+"WON"+"</span></html>");
        l = new JLabel("<html><span style='font-size:20px;color:RED'>"+"LOST"+"</span></html>");
        p = new JLabel("<html><span style='font-size:20px;color:WHITE'>"+"PLAYER"+"</span></html>");
        pl1 = new JLabel("<html><span style='font-size:20px;color:WHITE'>"+p1+"</span></html>");
        pl2 = new JLabel("<html><span style='font-size:20px;color:WHITE'>"+p2+"</span></html>");
        if(p1.equals("Computer")){
        	w1 = new JLabel("<html><span style='font-size:20px;color:WHITE'>"+w1co+"</span></html>");
            w1.setBounds(250, 200, 100, 50);
            l1 = new JLabel("<html><span style='font-size:20px;color:WHITE'>"+l1co+"</span></html>");
            l1.setBounds(250, 300, 100, 50);
            w2 = new JLabel("<html><span style='font-size:20px;color:WHITE'>"+w2co+"</span></html>");
            w2.setBounds(400, 200, 100, 50);
            l2 = new JLabel("<html><span style='font-size:20px;color:WHITE'>"+l2co+"</span></html>");
            l2.setBounds(400, 300, 100, 50);
        }
        else{
        	w1 = new JLabel("<html><span style='font-size:20px;color:WHITE'>"+w1c+"</span></html>");
        	w1.setBounds(250, 200, 100, 50);
        	l1 = new JLabel("<html><span style='font-size:20px;color:WHITE'>"+l1c+"</span></html>");
        	l1.setBounds(250, 300, 100, 50);
        	w2 = new JLabel("<html><span style='font-size:20px;color:WHITE'>"+w2c+"</span></html>");
        	w2.setBounds(400, 200, 100, 50);
        	l2 = new JLabel("<html><span style='font-size:20px;color:WHITE'>"+l2c+"</span></html>");
        	l2.setBounds(400, 300, 100, 50);
        }
        r.setBounds(220,30,200,50);
        p.setBounds(100,100,120,50);
        w.setBounds(250,100,100,50);
        l.setBounds(400,100,100,50);
        pl1.setBounds(100,200,120,50);
        pl2.setBounds(100,300,100,50);
        play = new JButton("<html><span style='font-size:20px;color:BLACK'>"+"Play Another"+"</span></html>");
        play.setBounds(200,400,200,50);
        play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				result.dispose();
				new Menu();
			}
		});
        result.add(play);
        result.add(r);
        result.add(pl1);
        result.add(pl2);
        result.add(w);
        result.add(p);
        result.add(l);
        result.add(w1);
        result.add(l1);
        result.add(w2);
        result.add(l2);
        result.setVisible(true);
	}
	public static void main(String[] args){
		new Result();
	}
}
