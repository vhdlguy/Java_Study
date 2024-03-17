package test_ex2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class test extends JFrame{
	JMenuItem eventTestItem;
	JMenu about = new JMenu("이프로그램은");

	private JButton button,button2;
	boolean swap=true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
	}
	
	private class aboutListner implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==about) {
				System.out.println("This Progam is ...");
			}
		}
	}
	
	private class MyListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==button) {
				if(swap) {
					button.setText("버튼이 눌러졌습니다");
					swap=false;
				}
				else
				{
					button.setText("버튼을 뗐습니다");
					swap=true;
				}
				
			} else if(e.getSource()==eventTestItem) {
				System.out.println("Execute Event Test Menu");
			}
		}
	}
	
	private class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			button2.setForeground(Color.red);
			
			button2.setText(Integer.toString(e.getClickCount()));
		
			
			//button2.setBorderPainted(false);
			
			//System.out.println("test test test");
		}
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
		createMenu();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setSize(400, 400);
		//setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("버튼 이벤트 예제");
		
		JPanel panel = new JPanel();
		button = new JButton("버튼을 누르세요");
		button2 = new JButton("버튼2");
		
		button.addActionListener(new MyListener());
		
		button2.addMouseListener(new MyMouseAdapter());
		
		panel.add(button);
		panel.add(button2);
		this.add(panel);
		//this.setVisible(true);
	}
	
	public void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");
		JMenu editMenu = new JMenu("수정");
		
		
		fileMenu.add(new JMenuItem("New"));
		fileMenu.add(new JMenuItem("Open"));
		fileMenu.add(new JMenuItem("Close"));
		
		fileMenu.addSeparator(); //분리선 
		eventTestItem = new JMenuItem("Event Test", KeyEvent.VK_E);
		fileMenu.add(eventTestItem);
		eventTestItem.addActionListener(new MyListener());
		fileMenu.addSeparator(); //분리선
		JMenu submenu = new JMenu("서브메뉴");
		fileMenu.add(submenu);
		submenu.add(new JMenuItem("Sub Menu 1"));
		submenu.add(new JMenuItem("Sub Menu 2"));
		
		mb.add(fileMenu);
		mb.add(editMenu);
		mb.add(about);
		about.addActionListener(new aboutListner());
		/**
		 * 메뉴바 붙이
		 */
		this.setJMenuBar(mb);
	}
}
