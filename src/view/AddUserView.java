package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import controller.SignUpPageController;
import model.User;
import util.FormatController;
import util.Response;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AddUserView extends JPanel {
	private JTextField username;
	private JPasswordField password;
	private JTextField name;
	private JTextField surname;
	private JTextField email;
	private JTextField gender;
	private JTextField phone;
	private JLabel lblErroMessage;

	/**
	 * Create the panel.
	 */
	public AddUserView() {
		setBackground(new Color(249, 251, 231));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(249, 251, 231));
		panel.setBounds(49, 32, 711, 530);
		add(panel);
		panel.setLayout(new GridLayout(7, 2, 6, 10));
		
		JLabel lblNewLabel_1 = new JLabel("Username : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_2);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(password);
		
		JLabel lblNewLabel_3 = new JLabel("Name : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_3);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Surname : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_4);
		
		surname = new JTextField();
		surname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(surname);
		surname.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Email : ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_5);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Gender : ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_6);
		
		gender = new JTextField();
		gender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(gender);
		gender.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Phone : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel);
		
		phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(phone);
		phone.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread threadOfAddUserOperation = new Thread() {
					public void run() {
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
							String g = gender.getText();
							if(g.toLowerCase().equals("male")) {
								user.setGender("m");
							}
							else {
								user.setGender("f");
							}
							SignUpPageController instance = SignUpPageController.getInstance();
							Response result = instance.signUp(user);
							if(result.isOk()) {
								lblErroMessage.setText("User successfully added. ");
								lblErroMessage.setForeground(Color.green);
							}
							else {
								lblErroMessage.setText(result.getResponseMessage());
								lblErroMessage.setForeground(Color.red);
							}
							lblErroMessage.setVisible(true);
						}
					}
				};
				threadOfAddUserOperation.start();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(639, 641, 121, 42);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBounds(407, 641, 121, 42);
		add(btnNewButton_1);
		
		lblErroMessage = new JLabel("");
		lblErroMessage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblErroMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblErroMessage.setBounds(407, 711, 353, 52);
		add(lblErroMessage);

	}

}
