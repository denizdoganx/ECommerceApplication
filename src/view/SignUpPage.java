package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SignUpPageController;
import model.User;
import util.FormatController;
import util.Response;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SignUpPage extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private JTextField name;
	private JTextField surname;
	private JTextField email;
	private JTextField gender;
	private JTextField phone;
	private JLabel lblErroMessage;

	/**
	 * Create the frame.
	 */
	public SignUpPage() {
		setTitle("SignUp Page");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(185, 237, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(185, 237, 221));
		panel.setBounds(50, 25, 622, 568);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(7, 2, 20, 30));
		
		JLabel lblNewLabel_1 = new JLabel("Username : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_2);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(password);
		
		JLabel lblNewLabel_3 = new JLabel("Name : ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_3);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Surname : ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_4);
		
		surname = new JTextField();
		surname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(surname);
		surname.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Email : ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_5);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Gender : ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_6);
		
		gender = new JTextField();
		gender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(gender);
		gender.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Phone : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(phone);
		phone.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				@SuppressWarnings("deprecation")
				User user = new User(
					username.getText(),
					password.getText(),
					name.getText(),
					surname.getText(),
					email.getText(),
					gender.getText(),
					phone.getText()
				);
				
				if(FormatController.checkUser(user)) {
					SignUpPageController instance = SignUpPageController.getInstance();
					String g = gender.getText();
					if(g.toLowerCase().equals("male")) {
						user.setGender("m");
					}
					else {
						user.setGender("f");
					}
					Response result = instance.signUp(user);
					if(result.isOk()) {
						lblErroMessage.setText(result.getResponseMessage());
						lblErroMessage.setForeground(Color.white);
					}
					else {
						lblErroMessage.setText(result.getResponseMessage());
						lblErroMessage.setForeground(Color.red);
					}
					lblErroMessage.setVisible(true);
				}
			}
		});
		btnNewButton.setForeground(new Color(249, 251, 231));
		btnNewButton.setBackground(new Color(87, 125, 134));
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(220, 623, 132, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(new Color(249, 251, 231));
		btnNewButton_1.setBackground(new Color(87, 125, 134));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpPage.this.dispose();
				new StartPage();
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(424, 623, 132, 37);
		contentPane.add(btnNewButton_1);
		
		lblErroMessage = new JLabel("");
		lblErroMessage.setForeground(new Color(255, 0, 0));
		lblErroMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErroMessage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblErroMessage.setBounds(125, 681, 547, 46);
		contentPane.add(lblErroMessage);
	}

}
