package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.ImageResizer;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AddedItemPage extends JFrame {

	private JPanel contentPane;

	private ItemPage itemPage;

	/**
	 * Create the frame.
	 */
	public AddedItemPage(ItemPage itemPage, int itemId, String imagePath, String information) {
		this.itemPage = itemPage;
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 834, 204);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String smallerImagePath = "images/smaller" + itemId + ".jpg";
		ImageResizer.resizeImage(imagePath, smallerImagePath, 205, 143);
		JLabel image = new JLabel(new ImageIcon(smallerImagePath));
		image.setBounds(10, 11, 205, 143);
		contentPane.add(image);
		
		JLabel lblNewLabel_1 = new JLabel("The product is in your cart.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(225, 29, 268, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblInformation = new JLabel(information);
		lblInformation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInformation.setBounds(225, 88, 329, 35);
		contentPane.add(lblInformation);
		
		JButton btnGoToCart = new JButton("Go To Cart");
		btnGoToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddedItemPage.this.dispose();
				AddedItemPage.this.itemPage.dispose();
				new ShoppingCartPage(AddedItemPage.this.itemPage.homePage);
			}
		});
		btnGoToCart.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGoToCart.setBounds(654, 29, 154, 35);
		contentPane.add(btnGoToCart);
		
		JButton btnKeepShooping = new JButton("Keep Shooping");
		btnKeepShooping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddedItemPage.this.dispose();
				AddedItemPage.this.itemPage.dispose();
			}
		});
		btnKeepShooping.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnKeepShooping.setBounds(654, 88, 154, 35);
		contentPane.add(btnKeepShooping);
	}

}
