package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import controller.MyAccountPageController;
import model.User;
import util.FormatController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class EditProfileView extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private User user;
	private JPasswordField currentPasswordField;
	private JPasswordField newPasswordField;
	private JTextField phoneNumberField;
	private JTextField emailField;
	private JTextField surnameField;
	private JTextField nameField;
	private JRadioButton femaleRdnBtn;
	private JRadioButton maleRdnBtn;
	public EditProfileView(User user) {
		this.user = user;
		setLayout(null);
		setVisible(true);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 5, 931, 832);
		add(tabbedPane);
		
		JPanel mainPanelOfFirstTab = new JPanel();
		tabbedPane.addTab("My Membership Information", null, mainPanelOfFirstTab, null);
		mainPanelOfFirstTab.setLayout(null);
		
		
		JPanel innerPanelOfFirstTab = new JPanel();
		innerPanelOfFirstTab.setBounds(116, 46, 725, 710);
		mainPanelOfFirstTab.add(innerPanelOfFirstTab);
		innerPanelOfFirstTab.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Information Profile");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setBounds(88, 52, 260, 31);
		innerPanelOfFirstTab.add(lblNewLabel_2);
		
		JTextPane txtpnHereYouCan = new JTextPane();
		txtpnHereYouCan.setBackground(new Color(240, 240, 240));
		txtpnHereYouCan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnHereYouCan.setText("Here you can edit the information you need so that we can keep your experience at Allhere at the best level.");
		txtpnHereYouCan.setBounds(88, 108, 509, 40);
		innerPanelOfFirstTab.add(txtpnHereYouCan);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(88, 218, 146, 31);
		innerPanelOfFirstTab.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Surname");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(403, 218, 107, 31);
		innerPanelOfFirstTab.add(lblNewLabel_4);
		
		nameField = new JTextField();
		nameField.setText(this.user.getName());
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameField.setBounds(88, 260, 260, 40);
		innerPanelOfFirstTab.add(nameField);
		nameField.setColumns(10);
		
		surnameField = new JTextField();
		surnameField.setText(this.user.getSurname());
		surnameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		surnameField.setBounds(403, 260, 260, 40);
		innerPanelOfFirstTab.add(surnameField);
		surnameField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(88, 350, 113, 26);
		innerPanelOfFirstTab.add(lblNewLabel_5);
		
		femaleRdnBtn = new JRadioButton("Female");
		femaleRdnBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		femaleRdnBtn.setBounds(88, 397, 174, 23);
		innerPanelOfFirstTab.add(femaleRdnBtn);
		
		maleRdnBtn = new JRadioButton("Male");
		maleRdnBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		maleRdnBtn.setBounds(296, 397, 189, 23);
		innerPanelOfFirstTab.add(maleRdnBtn);
		
		if(user.getGender().toLowerCase().equals("m")) {
			maleRdnBtn.setSelected(true);
		}
		else {
			femaleRdnBtn.setSelected(true);
		}
		
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(femaleRdnBtn);
		buttonGroup.add(maleRdnBtn);
		
		JButton btnNewButton_4 = new JButton("Update");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = EditProfileView.this.user;
				String currentName = EditProfileView.this.nameField.getText();
				String currentSurname = EditProfileView.this.surnameField.getText();
				String currentGender;
				
				if(femaleRdnBtn.isSelected()) {
					currentGender = "f";
				}
				else {
					currentGender = "m";
				}
				if(currentName.equals(user.getName()) && currentSurname.equals(user.getSurname()) && currentGender.equals(user.getGender())) {
					JOptionPane.showMessageDialog(null, "You did not make any changes.", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					if(FormatController.checkName(currentName) && FormatController.checkSurname(currentSurname)) {
						MyAccountPageController instance = MyAccountPageController.getInstance();
						
						boolean result = instance.changeMembershipInformation(user.getId(), currentName, currentSurname, currentGender);
						
						if(!result) {
							JOptionPane.showMessageDialog(null, "Failed to update.", "Warning!", JOptionPane.WARNING_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "Update process successful.", "Successful!", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_4.setBounds(88, 486, 575, 50);
		innerPanelOfFirstTab.add(btnNewButton_4);
		

		
		
		JPanel mainPanelOfSecondTab = new JPanel();
		tabbedPane.addTab("Password Change", null, mainPanelOfSecondTab, null);
		mainPanelOfSecondTab.setLayout(null);
		
		JPanel innerPanelOfSecondTab = new JPanel();
		innerPanelOfSecondTab.setBounds(203, 54, 530, 658);
		mainPanelOfSecondTab.add(innerPanelOfSecondTab);
		innerPanelOfSecondTab.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Password Change");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_9.setBounds(59, 66, 357, 49);
		innerPanelOfSecondTab.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Current Password");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(64, 178, 276, 26);
		innerPanelOfSecondTab.add(lblNewLabel_10);
		
		currentPasswordField = new JPasswordField();
		currentPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		currentPasswordField.setBounds(59, 215, 399, 42);
		innerPanelOfSecondTab.add(currentPasswordField);
		currentPasswordField.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("New Password");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(59, 304, 264, 26);
		innerPanelOfSecondTab.add(lblNewLabel_11);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		newPasswordField.setBounds(59, 341, 399, 42);
		innerPanelOfSecondTab.add(newPasswordField);
		newPasswordField.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("For your security, set a password that does not include your name, surname and date of birth.");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_12.setBounds(59, 394, 399, 26);
		innerPanelOfSecondTab.add(lblNewLabel_12);
		
		JButton btnUpdatePassword = new JButton("Update");
		btnUpdatePassword.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String currentPassword = EditProfileView.this.currentPasswordField.getText();
				String newPassword = EditProfileView.this.newPasswordField.getText();
				String realPassword = EditProfileView.this.user.getPassword();
				if(currentPassword.isEmpty() || newPassword.isEmpty()) {
					JOptionPane.showMessageDialog(null, "These fields cannot be left blank.", "Warning!", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(!currentPassword.equals(realPassword)) {
						JOptionPane.showMessageDialog(null, "Wrong Password.", "Warning!", JOptionPane.WARNING_MESSAGE);
					}
					else {
						if(currentPassword.equals(newPassword)) {
							JOptionPane.showMessageDialog(null, "Enter a different password than the current password.", "Warning!", JOptionPane.WARNING_MESSAGE);
						}
						else {
							if(newPassword.length() < 4) {
								JOptionPane.showMessageDialog(null, "New password length must be at least 4 characters.", "Warning!", JOptionPane.WARNING_MESSAGE);
							}
							else {
								MyAccountPageController instance = MyAccountPageController.getInstance();
								
								boolean result = instance.changePassword(EditProfileView.this.user.getId(), newPassword);
								
								if(!result) {
									JOptionPane.showMessageDialog(null, "Could not update password.", "Warning!", JOptionPane.WARNING_MESSAGE);
								}
								else {
									JOptionPane.showMessageDialog(null, "Password updated successfully.", "Successful.", JOptionPane.INFORMATION_MESSAGE);
								}
							}
						}
					}
				}
			}
		});
		btnUpdatePassword.setFocusable(false);
		btnUpdatePassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdatePassword.setBounds(59, 498, 399, 42);
		innerPanelOfSecondTab.add(btnUpdatePassword);
		
		JPanel mainPanelOfThirdTab = new JPanel();
		tabbedPane.addTab("Contact Information", null, mainPanelOfThirdTab, null);
		mainPanelOfThirdTab.setLayout(null);
		
		JPanel innerPanelOfThirdTab = new JPanel();
		innerPanelOfThirdTab.setBounds(185, 63, 566, 640);
		mainPanelOfThirdTab.add(innerPanelOfThirdTab);
		innerPanelOfThirdTab.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Contact Information");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_6.setBounds(83, 57, 310, 33);
		innerPanelOfThirdTab.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Mobile Phone Number");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(83, 170, 217, 24);
		innerPanelOfThirdTab.add(lblNewLabel_7);
		
		phoneNumberField = new JTextField();
		phoneNumberField.setText(this.user.getPhone());
		phoneNumberField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		phoneNumberField.setBounds(83, 205, 410, 42);
		innerPanelOfThirdTab.add(phoneNumberField);
		phoneNumberField.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("E-Mail Address");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(83, 300, 193, 33);
		innerPanelOfThirdTab.add(lblNewLabel_8);
		
		emailField = new JTextField();
		emailField.setText(this.user.getEmail());
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailField.setBounds(83, 344, 410, 42);
		innerPanelOfThirdTab.add(emailField);
		emailField.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Update");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = EditProfileView.this.user;
				String newEmail = EditProfileView.this.emailField.getText();
				String newPhoneNumber = EditProfileView.this.phoneNumberField.getText();
				
				if(user.getEmail().equals(newEmail) && user.getPhone().equals(newPhoneNumber)) {
					JOptionPane.showMessageDialog(null, "You did not make any changes.", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					if(FormatController.chechEmailFormat(newEmail) && FormatController.checkPhoneNumber(newPhoneNumber)) {
						MyAccountPageController instance = MyAccountPageController.getInstance();
						boolean result = instance.changeCommunicationInformation(user.getId(), newEmail, newPhoneNumber);
						if(!result) {
							JOptionPane.showMessageDialog(null, "Failed to update.", "Warning!", JOptionPane.WARNING_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "Update process successful.", "Successful!", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});
		btnNewButton_5.setFocusable(false);
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_5.setBounds(83, 483, 410, 42);
		innerPanelOfThirdTab.add(btnNewButton_5);

	}

}
