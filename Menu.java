import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu{
	public static int playlevel;
	public static String x;
	public static String o;
	JComboBox<String> theme;
    Menu(){
        JFrame menu = new JFrame("Tic-Tac-Toe");
        menu.setSize(600,600);
        menu.setLayout(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.getContentPane().setBackground(Color.BLUE);
        
        JLabel l = new JLabel("<html><span style='font-size:15px;color:RED'>"+"Level "+"</span></html>");
        l.setBounds(200,50,70,40);
        JLabel t = new JLabel("<html><span style='font-size:15px;color:RED'>"+"Theme "+"</span></html>");
        t.setBounds(200,110,70,40);
        
        String lev[] = {"Easy","Hard"};
        JComboBox<String> level = new JComboBox<String>(lev);
        level.setBounds(280,50,100,30);
        String the[] = {"RG","YB"};
        theme = new JComboBox<String>(the);
        theme.setBounds(280,120,100,30);
        
        JButton p1 = new JButton("<html><span style='font-size:23px;color:GREEN'>"+"One Player"+"</span></html>");
        p1.setBounds(200,200,200,80);
        JButton p2 = new JButton("<html><span style='font-size:23px;color:YELLOW'>"+"Two Player"+"</span></html>");
        p2.setBounds(200,300,200,80);
        JButton help = new JButton("<html><span style='font-size:23px;color:RED'>"+"EXIT"+"</span></html>");
        help.setBounds(200,400,200,80);
        
        //one player
        p1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				playlevel = level.getSelectedIndex();
				themeselect();
				menu.dispose();
				new OnePlayer();
			}
		});
        //two player
        p2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				themeselect();
				menu.dispose();
				new TwoPlayer();
			}
		});
        
        //close button
        help.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				menu.dispose();
			}
		});
        
        menu.add(t);
        menu.add(theme);
        menu.add(l);
        menu.add(level);
        menu.add(p1);
        menu.add(p2);
        menu.add(help);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }
    public void themeselect(){
    	if(theme.getSelectedIndex()==0){
    		x="<html><span style='font-size:80px;color:GREEN'>"+"X"+"</span></html>";
    		o="<html><span style='font-size:80px;color:RED'>"+"O"+"</span></html>";
    	}
    	else{
    		x="<html><span style='font-size:80px;color:YELLOW'>"+"X"+"</span></html>";
    		o="<html><span style='font-size:80px;color:BLUE'>"+"O"+"</span></html>";
    	}
    }
    public static void main(String[]args){
    	SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Menu();
			}
		});
    }
}
