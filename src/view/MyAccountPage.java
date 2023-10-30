package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ShoppingCart;
import model.User;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MyAccountPage extends JFrame {

	private JPanel contentPane;
	private JPanel fragmentPanel;
	private HomePage referenceOfHomePage = null;
	private User user;
	/**
	 * Create the frame.
	 */
	public MyAccountPage(HomePage referenceOfHomePage) {
		this.referenceOfHomePage = referenceOfHomePage;
		this.user = referenceOfHomePage.user;
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 1000);
		setLocationRelativeTo(null);		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 34, 280, 939);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(12, 1, 6, 10));
		
		String nameSurname = user.getName() + " " + user.getSurname();
		JLabel lblNewLabel = new JLabel(nameSurname);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JButton btnEditProfile = new JButton("Edit Profile");
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyAccountPage.this.fragmentPanel.removeAll();
				MyAccountPage.this.fragmentPanel.revalidate();
				MyAccountPage.this.fragmentPanel.add(new EditProfileView(MyAccountPage.this.user));
				MyAccountPage.this.fragmentPanel.repaint();
			}
		});
		btnEditProfile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnEditProfile);
		
		JButton btnMyOrders = new JButton("My Orders");
		btnMyOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MyAccountPage.this.fragmentPanel.removeAll();
				MyAccountPage.this.fragmentPanel.revalidate();
				MyAccountPage.this.fragmentPanel.add(new MyOrdersView(MyAccountPage.this.user.getId()));
				MyAccountPage.this.fragmentPanel.repaint();
			}
		});
		btnMyOrders.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnMyOrders);
		
		JButton btnMyAssessments = new JButton("My Assessments");
		btnMyAssessments.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnMyAssessments);
		
		JButton btnMyCards = new JButton("My Cards");
		btnMyCards.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMyCards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyAccountPage.this.fragmentPanel.removeAll();
				MyAccountPage.this.fragmentPanel.revalidate();
				MyAccountPage.this.fragmentPanel.add(new MyCardsView(MyAccountPage.this.user.getId()));
				MyAccountPage.this.fragmentPanel.repaint();
			}
		});
		panel.add(btnMyCards);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyAccountPage.this.referenceOfHomePage.dispose();
				MyAccountPage.this.dispose();
				ShoppingCart.getCart().emptyTheCart();
				new StartPage(); 
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnLogOut);
		
		JLabel lblNewLabel_1 = new JLabel("My Account Information");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_1.setBounds(300, 11, 793, 80);
		contentPane.add(lblNewLabel_1);
		
		fragmentPanel = new JPanel();
		fragmentPanel.setBounds(300, 102, 954, 848);
		contentPane.add(fragmentPanel);
		
		fragmentPanel.setLayout(null);
		fragmentPanel.setLayout(new GridLayout(1, 1, 5, 5));
		
		JButton backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyAccountPage.this.dispose();
				MyAccountPage.this.referenceOfHomePage.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		backButton.setBounds(1103, 11, 151, 80);
		contentPane.add(backButton);
		/*
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 5, 934, 832);
		mainPanel.add(tabbedPane);
		
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
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(88, 260, 260, 40);
		innerPanelOfFirstTab.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setBounds(403, 260, 260, 40);
		innerPanelOfFirstTab.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(88, 350, 113, 26);
		innerPanelOfFirstTab.add(lblNewLabel_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Female");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(88, 397, 174, 23);
		innerPanelOfFirstTab.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Male");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setBounds(296, 397, 189, 23);
		innerPanelOfFirstTab.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton_4 = new JButton("Update");
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
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setBounds(59, 215, 399, 42);
		innerPanelOfSecondTab.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("New Password");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(59, 304, 264, 26);
		innerPanelOfSecondTab.add(lblNewLabel_11);
		
		textField_5 = new JTextField();
		textField_5.setBounds(59, 341, 399, 42);
		innerPanelOfSecondTab.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("For your security, set a password that does not include your name, surname and date of birth.");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_12.setBounds(59, 394, 399, 26);
		innerPanelOfSecondTab.add(lblNewLabel_12);
		
		JButton btnNewButton_6 = new JButton("Update");
		btnNewButton_6.setFocusable(false);
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_6.setBounds(59, 498, 399, 42);
		innerPanelOfSecondTab.add(btnNewButton_6);
		
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
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setBounds(83, 205, 410, 42);
		innerPanelOfThirdTab.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("E-Mail Address");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(83, 300, 193, 33);
		innerPanelOfThirdTab.add(lblNewLabel_8);
		
		textField_3 = new JTextField();
		textField_3.setBounds(83, 344, 410, 42);
		innerPanelOfThirdTab.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Update");
		btnNewButton_5.setFocusable(false);
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_5.setBounds(83, 483, 410, 42);
		innerPanelOfThirdTab.add(btnNewButton_5);*/
	}
}
