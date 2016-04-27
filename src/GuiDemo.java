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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuiDemo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblFirstGeneration;
	private JTextArea textArea_1;

	private String SDstr;
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
		setBounds(100, 100, 1067, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JButton startGaAlg = new JButton("Start");
		startGaAlg.setEnabled(false);
		
		
		final JButton createChr = new JButton("Create");
		
		createChr.setBounds(10, 89, 96, 23);
		contentPane.add(createChr);
		startGaAlg.setBounds(10, 339, 96, 23);
		contentPane.add(startGaAlg);
		
		
		
		final JButton btnNewButton_2 = new JButton("Open file");
		btnNewButton_2.setBounds(10, 372, 96, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Restart");
		btnNewButton_3.setBounds(10, 405, 96, 23);
		contentPane.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setText("2");
		textField.setBounds(10, 58, 96, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("3");
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setBounds(10, 147, 96, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(136, 28, 177, 400);
		contentPane.add(scrollPane_1);
		
		final JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setBorder(new EmptyBorder(5, 5, 5, 5));
		textArea.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(327, 28, 150, 400);
		contentPane.add(scrollPane);
		
		textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(505, 28, 536, 400);
		contentPane.add(panel);
		
		textField_2 = new JTextField();
		textField_2.setText("8");
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setBounds(10, 228, 96, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNumberOfFirst = new JLabel("Number of Chr");
		lblNumberOfFirst.setBounds(10, 10, 96, 23);
		contentPane.add(lblNumberOfFirst);
		
		JLabel lblInFirstGeneration = new JLabel("in first generation");
		lblInFirstGeneration.setBounds(10, 33, 96, 15);
		contentPane.add(lblInFirstGeneration);
		
		JLabel lblMaxGeneration = new JLabel("Max Generation");
		lblMaxGeneration.setBounds(10, 122, 96, 15);
		contentPane.add(lblMaxGeneration);
		
		lblFirstGeneration = new JLabel("First Generation");
		lblFirstGeneration.setBounds(138, 14, 104, 15);
		contentPane.add(lblFirstGeneration);
		
		JLabel lblStatisticalData = new JLabel("Statistical Data");
		lblStatisticalData.setBounds(327, 14, 104, 15);
		contentPane.add(lblStatisticalData);
		
		JLabel lblEquation = new JLabel("Equation");
		lblEquation.setBounds(10, 178, 96, 15);
		contentPane.add(lblEquation);
		
		JLabel lblX = new JLabel("( X - ");
		lblX.setBounds(10, 203, 46, 15);
		contentPane.add(lblX);
		
		JLabel label = new JLabel(" ) ^ 2 = 0");
		label.setBounds(66, 259, 60, 15);
		contentPane.add(label);
		
		
		
		
		
		createChr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createChr.setEnabled(false);
				startGaAlg.setEnabled(true);
				int numberOfG = 0;
				try{
					int num=Integer.parseInt(textField.getText());
					gaAlg.createRandomGeneration(num);
					
					String tmp="";
					for(int i=0;i<gaAlg.currentChrArray.length;i++)
					{
						tmp+=gaAlg.currentChrArray[i].toString()+"\n";
					}
					textArea.setText(tmp);
					
				}catch(Exception e1)
				{
					textField.setText("Number Only");
				}
				
				
			}
		});
		
		startGaAlg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGaAlg.setEnabled(false);
				
				int num=Integer.valueOf(textField_2.getText());
				gaAlg.setInputNum(num);
				
				int maxG=Integer.valueOf(textField_1.getText());
				
				int countG=0;
				boolean endBool=false;
				SDstr="";
				do{
					gaAlg.adapterFunction();
					gaAlg.Selection();
					
					txtUtl.writerTxt("=====[Generation "+(countG+1)+"]=====\r\n");
					txtUtl.writerTxt("=====[selected]=====\r\n");
					for(int i=0;i<gaAlg.selectedChrArray.length;i++)
					{
						txtUtl.writerTxt(i+" : "+gaAlg.selectedChrArray[i].toString()+"\r\n");
					}
					
					
					txtUtl.writerTxt("=====[nextChrArray]=====\r\n");
					gaAlg.exchange();
					for(int i=0;i<gaAlg.nextChrArray.length;i++)
					{
						txtUtl.writerTxt(i+" : "+gaAlg.nextChrArray[i].toString()+"\r\n");
					}
					
					endBool=gaAlg.endRule();
					
					txtUtl.writerTxt("ans : "+gaAlg.ans+"\r\n");
					SDstr+="ans : "+gaAlg.ans+"\n";
					
					gaAlg.min();
					txtUtl.writerTxt("min adapt : "+gaAlg.min+"\r\n");
					SDstr+="min adapt : "+gaAlg.min+"\n";
					
					countG++;
				}while(countG<maxG & !endBool);	
				textArea_1.setText(SDstr);
			}
			
		});
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewButton_2.setEnabled(false);
				String str=txtUtl.readTxt();
				lblFirstGeneration.setText("GA.txt");
				
				textArea.setText(str);
			}
		});
		
		btnNewButton_3.addActionListener(new ActionListener() {//restart
			public void actionPerformed(ActionEvent e) {
				
				createChr.setEnabled(true);
				startGaAlg.setEnabled(false);
				btnNewButton_2.setEnabled(true);
				
				gaAlg.init();
				txtUtl.clean();
				textArea.setText("");
				textArea_1.setText("");
				lblFirstGeneration.setText("First Generation");
				
			}
		});
	}
	
}
