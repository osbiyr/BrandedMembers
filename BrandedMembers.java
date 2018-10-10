package q;







// this class is the class to compile

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class BrandedMembers {
	double price;
	String first ="70 nis for one month";
	String second ="50 nis/per month for 6 months";
	String third ="40 nis/per month for 12 months";



	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrandedMembers window = new BrandedMembers();
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
	public BrandedMembers() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 737, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		//Creating the RadioButtons
		JRadioButton first = new JRadioButton("70 nis for one month");
		first.setBounds(311, 130, 322, 21);

		frame.getContentPane().add(first);

		JRadioButton second = new JRadioButton("50 nis/per month for 6 months");
		second.setBounds(311, 172, 322, 21);

		frame.getContentPane().add(second);

		JRadioButton third = new JRadioButton("40 nis/per month for 12 months");
		third.setBounds(311, 214, 322, 21);

		frame.getContentPane().add(third);



		//Headline

		JLabel lblNewLabel = new JLabel("Choose the membership program that suits for you: ");
		lblNewLabel.setBounds(128, 59, 365, 26);
		frame.getContentPane().add(lblNewLabel);
		// Create the continue button

		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {

			// creating the perform of the Continue button

			public void actionPerformed(ActionEvent e) {

				// checks what button have been selected, if no one have been selected than price is 0.0

				if(first.isSelected()==true) price = 70;
				if(second.isSelected()==true) price = 50*6;
				if(third.isSelected()==true) price = 40*12;

				//initiate second window with the price that user choose

				BM2 sw = new BM2(price);
				sw.SecondWindow(price);


				System.out.println(price);
			}



		});
		btnContinue.setBounds(321, 307, 110, 21);
		frame.getContentPane().add(btnContinue);
	}


}
