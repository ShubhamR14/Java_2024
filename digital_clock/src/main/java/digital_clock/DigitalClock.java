package digital_clock;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.formdev.flatlaf.IntelliJTheme;

import javax.swing.JLabel;

public class DigitalClock {

	private JFrame frame;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClock window = new DigitalClock();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DigitalClock() {
		IntelliJTheme.setup(DigitalClock.class.getResourceAsStream("/HighContrast.theme.json"));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 546, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font f=null;
		try {
			f = Font.createFont(Font.TRUETYPE_FONT,DigitalClock.class.getResourceAsStream("/digital-7.ttf") );
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//1
//		frame.setUndecorated(true);//It will remove the title bar
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0,0, 546, 300);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField("06");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(f.deriveFont(Font.BOLD,100f));
		textField.setBorder(null);
		textField.setEditable(false);
		textField.setBounds(26,84,119,112);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField("06");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(f.deriveFont(Font.BOLD,100f));
		textField_1.setBorder(null);
		textField_1.setEditable(false);
		textField_1.setBounds(201, 84,119, 112);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField("06");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(f.deriveFont(Font.BOLD,100f));
		textField_2.setBorder(null);
		textField_2.setEditable(false);
		textField_2.setBounds(385,84,119,112);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(":");
		lblNewLabel.setFont(f.deriveFont(Font.BOLD,100f));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(152, 84, 45, 112);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(":");
		lblNewLabel_1.setFont(f.deriveFont(Font.BOLD,100f));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(330, 85, 45, 112);
		panel.add(lblNewLabel_1);
		
//		3.only call the constructor using digital_Instance
		new ClockThread(this);
	}
}
