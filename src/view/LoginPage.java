package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.HomePageController;
import controller.LoginPageController;
import util.HomePageItemElement;
import util.Response;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel lblErrorMessage;
	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setVisible(true);
		this.setPreferredSize(new Dimension(600,400));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(244, 87, 164, 31);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(244, 163, 164, 31);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Username : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(162, 90, 72, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(162, 170, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				//Thread threadOfLoginOperation = new Thread() {
					//public void run() {
						LoginPageController loginController = LoginPageController.getInstance();
						String username = usernameField.getText();
						String password = passwordField.getText();
						if(!username.isEmpty() && !password.isEmpty()) {
							
							Response response = loginController.login(username, password);
							if(response.isOk()) {
								if(response.getAuthority() == 0) {
									LoginPage.this.dispose();
									new AdminPage();
								}
								else {
									HomePageController homePageController = HomePageController.getInstance();
									LoginPage.this.dispose();
									ArrayList<HomePageItemElement> items = homePageController.getHomePageItems();
									new HomePage(response.getUser(), items);
								}
							}
							else {
								lblErrorMessage.setText(response.getResponseMessage());
							}
						}
						else {
							if(username.isEmpty()) {
								usernameField.setBorder(BorderFactory.createLineBorder(Color.red));
							}
							else {
								usernameField.setBorder(BorderFactory.createLineBorder(Color.black));
							}
							if(password.isEmpty()) {
								passwordField.setBorder(BorderFactory.createLineBorder(Color.red));	
							}
							else {
								passwordField.setBorder(BorderFactory.createLineBorder(Color.black));
							}
							lblErrorMessage.setText("");
						}
					//}
				//};

				//threadOfLoginOperation.start();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(193, 229, 89, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage.this.dispose();
				new StartPage();
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(303, 229, 89, 41);
		contentPane.add(btnNewButton_1);
		
		lblErrorMessage = new JLabel("");
		lblErrorMessage.setForeground(new Color(255, 0, 0));
		lblErrorMessage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorMessage.setBounds(103, 299, 398, 41);
		contentPane.add(lblErrorMessage);
		this.setLocationRelativeTo(null);
	}
}
