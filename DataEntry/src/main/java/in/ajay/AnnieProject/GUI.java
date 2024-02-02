package in.ajay.AnnieProject;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener {
	int count = 0;
	private JLabel label,ja,ks;
	JButton button;
	JPanel panel;
	JFrame frame;
	
	public GUI() {
		frame=new JFrame();
		 button = new JButton("Submit");
		button.addActionListener(this);
		
		
		 panel = new JPanel();
		 label = new JLabel("Number of Clicks is : 0");
		 ja = new JLabel("more");
		
		panel.setBorder(BorderFactory.createEmptyBorder(500,500,100,500));
		panel.setLayout(new GridLayout(0,1));
		panel.add(button);
		panel.add(label);
		panel.add(ja);
		
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Our GUI");
		frame.pack();
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new GUI();
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		count++;
		label.setText("Number of Clicks is : "+count);
	}
	

}
