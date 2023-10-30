package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridLayout;


@SuppressWarnings("serial")
public class AdminPage extends JFrame {

	private JPanel contentPane;
	private JPanel fragmentPanel;


	/**
	 * Create the frame.
	 */
	public AdminPage() {
		setTitle("Admin Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 1000);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(249, 251, 231));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(249, 251, 231));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 292, 961);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(249, 251, 231));
		panel_1.setBorder(new EmptyBorder(6, 6, 6, 6));
		panel_1.setBounds(0, 172, 292, 535);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(7, 1, 5, 10));
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage.this.fragmentPanel.removeAll();
				AdminPage.this.fragmentPanel.revalidate();
				AdminPage.this.fragmentPanel.add(new AddItemView());
				AdminPage.this.fragmentPanel.repaint();
			}
		});
		btnAddItem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddItem.setFocusable(false);
		btnAddItem.setAlignmentX(0.5f);
		panel_1.add(btnAddItem);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage.this.fragmentPanel.removeAll();
				AdminPage.this.fragmentPanel.revalidate();
				AdminPage.this.fragmentPanel.add(new AddUserView());
				AdminPage.this.fragmentPanel.repaint();
			}
		});
		btnAddUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddUser.setFocusable(false);
		btnAddUser.setAlignmentX(0.5f);
		panel_1.add(btnAddUser);
		
		JButton btnListOrders = new JButton("List Orders");
		btnListOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage.this.fragmentPanel.removeAll();
				AdminPage.this.fragmentPanel.revalidate();
				AdminPage.this.fragmentPanel.add(new ListOrdersView());
				AdminPage.this.fragmentPanel.repaint();
			}
		});
		btnListOrders.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListOrders.setFocusable(false);
		panel_1.add(btnListOrders);
		
		JButton btnListInvoices = new JButton("List Invoices");
		btnListInvoices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage.this.fragmentPanel.removeAll();
				AdminPage.this.fragmentPanel.revalidate();
				AdminPage.this.fragmentPanel.add(new ListInvoicesView());
				AdminPage.this.fragmentPanel.repaint();
			}
		});
		btnListInvoices.setFocusable(false);
		btnListInvoices.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnListInvoices);
		
		JButton btnListPayments = new JButton("List Payments");
		btnListPayments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage.this.fragmentPanel.removeAll();
				AdminPage.this.fragmentPanel.revalidate();
				AdminPage.this.fragmentPanel.add(new ListPaymentsView());
				AdminPage.this.fragmentPanel.repaint();
			}
		});
		btnListPayments.setFocusable(false);
		btnListPayments.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnListPayments);
		
		JButton btnNewButton_1 = new JButton("List Users");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage.this.fragmentPanel.removeAll();
				AdminPage.this.fragmentPanel.revalidate();
				AdminPage.this.fragmentPanel.add(new ListUsersView());
				AdminPage.this.fragmentPanel.repaint();
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnNewButton_1);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFocusable(false);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage.this.dispose();
				
				new StartPage();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnLogOut);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("images/adminAccount.png"));
		lblNewLabel_1.setBounds(10, 11, 282, 150);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Admin Panel");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(232, 170, 66));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 64));
		lblNewLabel.setBounds(302, 0, 1072, 121);
		contentPane.add(lblNewLabel);
		
		fragmentPanel = new JPanel();
		fragmentPanel.setBackground(new Color(249, 251, 231));
		fragmentPanel.setBounds(312, 132, 1062, 818);
		contentPane.add(fragmentPanel);
		fragmentPanel.setLayout(new GridLayout(1, 1, 5, 5));
		setLocationRelativeTo(null);
	}
}
