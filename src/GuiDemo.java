import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

public class GuiDemo extends JFrame {

	private JPanel contentPane;
	private int num=8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiDemo frame = new GuiDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JButton startGaAlg = new JButton("Start");
		
		
		JButton createChr = new JButton("Create");
		createChr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gaAlg.createRandomGeneration(num);
			}
		});
		createChr.setBounds(10, 10, 87, 23);
		contentPane.add(createChr);
		startGaAlg.setBounds(10, 43, 87, 23);
		contentPane.add(startGaAlg);
		
		
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(10, 76, 87, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(10, 105, 87, 23);
		contentPane.add(btnNewButton_3);
		
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(107, 9, 104, 243);
		contentPane.add(textArea);
		
		startGaAlg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tmp="";
				for(int i=0;i<gaAlg.currentChrArray.length;i++)
				{
					tmp+=gaAlg.currentChrArray[i].toString()+"\n";
				}
				textArea.setText(tmp);
			}
		});
	}
}
