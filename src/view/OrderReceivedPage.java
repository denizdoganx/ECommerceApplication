package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import util.OrderReceivedPageItemElement;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class OrderReceivedPage extends JFrame {

	private JPanel contentPane;
	private JLabel lblOrderNumber;
	private JLabel cardNum;
	
	private HomePage referenceOfHomePage;
	/**
	 * Create the frame.
	 */
	public OrderReceivedPage(OrderReceivedPageItemElement item, HomePage referenceOfHomePage) {
		this.referenceOfHomePage = referenceOfHomePage;
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 5, 1169, 248);
		panel.setBackground(new Color(240, 240, 240));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your order has been received.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(130, 11, 1024, 72);
		panel.add(lblNewLabel);
		
		JTextPane txtpnYouCanFind = new JTextPane();
		txtpnYouCanFind.setBackground(new Color(240, 240, 240));
		txtpnYouCanFind.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnYouCanFind.setText("You can access the details of your order, invoice information or cargo tracking number in the my account section.");
		txtpnYouCanFind.setBounds(130, 87, 536, 44);
		panel.add(txtpnYouCanFind);
		
		JButton btnNewButton = new JButton("Go to the My Account Page");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderReceivedPage.this.dispose();
				OrderReceivedPage.this.referenceOfHomePage.myAccountButton.doClick();
				
			}
		});
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		btnNewButton.setBackground(new Color(255, 128, 0));
		btnNewButton.setForeground(new Color(240, 240, 240));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(130, 159, 200, 33);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 264, 1164, 286);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(155);
		panel_2.setBounds(10, 61, 1144, 43);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Order Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Delivery Address");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Invoice Information");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Amount Paid");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_4);
		
		lblOrderNumber = new JLabel(item.getOrderNumber());
		lblOrderNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOrderNumber.setBounds(139, 115, 164, 35);
		panel_1.add(lblOrderNumber);
		
		JLabel deliveryAddressTitle = new JLabel(item.getAddress().getAddressTitle());
		deliveryAddressTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		deliveryAddressTitle.setBounds(394, 115, 164, 28);
		panel_1.add(deliveryAddressTitle);
		
		JLabel invoiceInformationTitle = new JLabel(item.getAddress().getAddressTitle());
		invoiceInformationTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		invoiceInformationTitle.setBounds(656, 115, 164, 35);
		panel_1.add(invoiceInformationTitle);
		
		JLabel deliveryAddressText = new JLabel(item.getAddress().getAddressText());
		deliveryAddressText.setBounds(394, 154, 164, 14);
		panel_1.add(deliveryAddressText);
		
		JLabel invoiceInformationText = new JLabel(item.getAddress().getAddressText());
		invoiceInformationText.setBounds(656, 154, 164, 14);
		panel_1.add(invoiceInformationText);
		
		JLabel deliveryAddressTowCit = new JLabel(item.getAddress().getTown() + " / " + item.getAddress().getCity());
		deliveryAddressTowCit.setBounds(394, 179, 164, 14);
		panel_1.add(deliveryAddressTowCit);
		
		JLabel invoiceInformationTowCit = new JLabel(item.getAddress().getTown() + " / " + item.getAddress().getCity());
		invoiceInformationTowCit.setBounds(656, 179, 164, 14);
		panel_1.add(invoiceInformationTowCit);
		
		JLabel totalPrice = new JLabel(item.getTotalPrice() + " $");
		totalPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		totalPrice.setBounds(937, 115, 164, 35);
		panel_1.add(totalPrice);
		
		cardNum = new JLabel(item.getCardNumber());
		cardNum.setBounds(937, 161, 217, 14);
		panel_1.add(cardNum);
	}
	
	
}
