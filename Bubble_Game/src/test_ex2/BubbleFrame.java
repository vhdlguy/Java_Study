package test_ex2;

import javax.swing.*;

public class BubbleFrame extends JFrame{
	
	private JLabel backgroundMap;
	
	
	public BubbleFrame() 
	{
		initObject();
		initSetting();
		setVisible(true);
	}
	
	private void initObject() 
	{	
		backgroundMap = new JLabel("안녕");
		backgroundMap.setSize(100, 100);
		backgroundMap.setLocation(300, 300);
		add(backgroundMap);		
	}
	
	private void initSetting() 
	{
		setSize(1000,640);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BubbleFrame();
	}

}
