package q;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class BM2{



	static double BMprice;
	double totalprice;
	private JFrame frame;
	private JTextField textField;
	private JTextField emailTextField;

	/**
	 * Launch the application.
	 */
	public static void SecondWindow(double Price) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BM2 window = new BM2(Price);
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
	public BM2(double Price) {
		initialize(Price);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(double Price) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		//Create cuponTextField

		final JTextField couponTextField = new JTextField(20);
		couponTextField.setBounds(163, 70, 96, 19);
		frame.getContentPane().add(couponTextField);
		couponTextField.setColumns(10);

		//Create label coupon

		JLabel lblCupon = new JLabel("coupon:");
		lblCupon.setBounds(92, 73, 61, 13);
		frame.getContentPane().add(lblCupon);
		//Create label email

		JLabel lblEmail = new JLabel("email:");
		lblEmail.setBounds(108, 132, 61, 13);
		frame.getContentPane().add(lblEmail);




		// Create textField emailTextField

		emailTextField = new JTextField();
		emailTextField.setBounds(163, 129, 96, 19);
		frame.getContentPane().add(emailTextField);
		emailTextField.setColumns(10);

		//Create button send

		JButton btnSend = new JButton("Send");
		btnSend.setBounds(174, 202, 85, 21);
		frame.getContentPane().add(btnSend);



		//Creating the perform for the send button

		btnSend.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent g) {

				double total = Price;
				totalprice = Price;


				//takes the text from mailTextField and checks if its equals to 'GotIn', if so it reduce 5% from the price

				String gotin=couponTextField.getText(); 
				if(gotin.equals("GotIn") == true ) totalprice = Price - Price*5/100;

				System.out.println(couponTextField.getText());


				// get the string from the mailTextField

				String mail = emailTextField.getText();



				// checks is the text in the mail textbox is like %@% 

				if(mail.contains("@")&& mail.startsWith("@")!=true&&mail.endsWith("@")!=true) {


					Mailing m = new Mailing();
					System.out.println(totalprice);
					m.mail(totalprice,mail);
				}
			}

		});
	}
}
