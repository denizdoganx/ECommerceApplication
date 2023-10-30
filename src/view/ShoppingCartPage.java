package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ShoppingCartPageController;
import model.CartItem;
import model.ShoppingCart;
import util.ImageResizer;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class ShoppingCartPage extends JFrame {

	private JPanel contentPane;
	
	private ShoppingCart cart;
	private JPanel itemPanel1;
	private JPanel itemPanel2;
	private JPanel itemPanel3;
	private JPanel itemPanel4;
	private JPanel itemPanel5;
	private JPanel controlPanel;
	private JLabel emptyCartMessage;
	private JLabel image1;
	private JLabel image2;
	private JLabel image3;
	private JLabel image4;
	private JLabel image5;
	private JLabel info1;
	private JLabel info2;
	private JLabel info3;
	private JLabel info4;
	private JLabel info5;
	private JLabel price1;
	private JLabel price2;
	private JLabel price3;
	private JLabel price4;
	private JLabel price5;
	private JLabel numOfSelectedProducts;
	private JLabel totalPrice;
	private JLabel amount1;
	private JLabel amount2;
	private JLabel amount3;
	private JLabel amount4;
	private JLabel amount5;

	protected HomePage referenceOfHomePage;
	
	/**
	 * Create the frame.
	 */
	public ShoppingCartPage(HomePage referenceOfHomePage) {
		this.referenceOfHomePage = referenceOfHomePage;
		this.cart = ShoppingCart.getCart();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 928);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(212, 250, 252));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		itemPanel1 = new JPanel();
		itemPanel1.setBackground(new Color(212, 250, 252));
		itemPanel1.setVisible(false);
		itemPanel1.setBounds(10, 10, 910, 165);
		contentPane.add(itemPanel1);
		itemPanel1.setLayout(null);
		
		image1 = new JLabel("");
		image1.setBounds(10, 11, 205, 143);
		itemPanel1.add(image1);
		
		info1 = new JLabel("Prodcut Information Message");
		info1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		info1.setBounds(246, 11, 654, 32);
		itemPanel1.add(info1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(212, 250, 252));
		panel_1.setBounds(246, 122, 134, 32);
		itemPanel1.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton(new ImageIcon("images/minusButton.png"));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartPage.this.reduceTheNumberOfGivenProduct(0);
			}
		});
		btnNewButton.setBounds(0, 0, 32, 32);
		panel_1.add(btnNewButton);
		
		amount1 = new JLabel("");
		amount1.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount1.setHorizontalAlignment(SwingConstants.CENTER);
		amount1.setBounds(35, 0, 58, 32);
		panel_1.add(amount1);
		
		JButton btnNewButton_1 = new JButton(new ImageIcon("images/plusButton.png"));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartPage.this.increaseTheNumberOfGivenProduct(0);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1.setBounds(92, 0, 32, 32);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton(new ImageIcon("images/trashBox.png"));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartPage.this.removeGivenProductFromCart(0);
			}
		});
		btnNewButton_2.setBounds(382, 122, 32, 32);
		itemPanel1.add(btnNewButton_2);
		
		price1 = new JLabel("38.997$");
		price1.setFont(new Font("Tahoma", Font.BOLD, 18));
		price1.setHorizontalAlignment(SwingConstants.RIGHT);
		price1.setBounds(729, 122, 171, 32);
		itemPanel1.add(price1);
		
		itemPanel2 = new JPanel();
		itemPanel2.setBackground(new Color(212, 250, 252));
		itemPanel2.setVisible(false);
		itemPanel2.setLayout(null);
		itemPanel2.setBounds(10, 186, 910, 165);
		contentPane.add(itemPanel2);
		
		image2 = new JLabel("");
		image2.setBounds(10, 11, 205, 143);
		itemPanel2.add(image2);
		
		info2 = new JLabel("Prodcut Information Message");
		info2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		info2.setBounds(246, 11, 654, 32);
		itemPanel2.add(info2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(212, 250, 252));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(246, 122, 133, 32);
		itemPanel2.add(panel_1_1);
		
		JButton btnNewButton_3 = new JButton(new ImageIcon("images/minusButton.png"));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartPage.this.reduceTheNumberOfGivenProduct(1);
			}
		});
		btnNewButton_3.setBounds(0, 0, 32, 32);
		panel_1_1.add(btnNewButton_3);
		
		amount2 = new JLabel("");
		amount2.setHorizontalAlignment(SwingConstants.CENTER);
		amount2.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount2.setBounds(35, 0, 58, 32);
		panel_1_1.add(amount2);
		
		JButton btnNewButton_1_1 = new JButton(new ImageIcon("images/plusButton.png"));
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartPage.this.increaseTheNumberOfGivenProduct(1);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1_1.setBounds(92, 0, 32, 32);
		panel_1_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton(new ImageIcon("images/trashBox.png"));
		btnNewButton_2_1.setBackground(new Color(255, 255, 255));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartPage.this.removeGivenProductFromCart(1);
			}
		});
		btnNewButton_2_1.setBounds(382, 122, 32, 32);
		itemPanel2.add(btnNewButton_2_1);
		
		price2 = new JLabel("38.997$");
		price2.setHorizontalAlignment(SwingConstants.RIGHT);
		price2.setFont(new Font("Tahoma", Font.BOLD, 18));
		price2.setBounds(729, 122, 171, 32);
		itemPanel2.add(price2);
		
		itemPanel3 = new JPanel();
		itemPanel3.setBackground(new Color(212, 250, 252));
		itemPanel3.setVisible(false);
		itemPanel3.setLayout(null);
		itemPanel3.setBounds(10, 362, 910, 165);
		contentPane.add(itemPanel3);
		
		image3 = new JLabel("");
		image3.setBounds(10, 11, 205, 143);
		itemPanel3.add(image3);
		
		info3 = new JLabel("Prodcut Information Message");
		info3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		info3.setBounds(246, 11, 654, 32);
		itemPanel3.add(info3);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(212, 250, 252));
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(246, 122, 137, 32);
		itemPanel3.add(panel_1_2);
		
		JButton btnNewButton_4 = new JButton(new ImageIcon("images/minusButton.png"));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartPage.this.reduceTheNumberOfGivenProduct(2);
			}
		});
		btnNewButton_4.setBounds(0, 0, 32, 32);
		panel_1_2.add(btnNewButton_4);
		
		amount3 = new JLabel("");
		amount3.setHorizontalAlignment(SwingConstants.CENTER);
		amount3.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount3.setBounds(35, 0, 58, 32);
		panel_1_2.add(amount3);
		
		JButton btnNewButton_1_2 = new JButton(new ImageIcon("images/plusButton.png"));
		btnNewButton_1_2.setBackground(new Color(255, 255, 255));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartPage.this.increaseTheNumberOfGivenProduct(2);
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1_2.setBounds(92, 0, 32, 32);
		panel_1_2.add(btnNewButton_1_2);
		
		JButton btnNewButton_2_2 = new JButton(new ImageIcon("images/trashBox.png"));
		btnNewButton_2_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartPage.this.removeGivenProductFromCart(2);
			}
		});
		btnNewButton_2_2.setBounds(382, 122, 32, 32);
		itemPanel3.add(btnNewButton_2_2);
		
		price3 = new JLabel("38.997$");
		price3.setHorizontalAlignment(SwingConstants.RIGHT);
		price3.setFont(new Font("Tahoma", Font.BOLD, 18));
		price3.setBounds(729, 122, 171, 32);
		itemPanel3.add(price3);
		
		itemPanel4 = new JPanel();
		itemPanel4.setBackground(new Color(212, 250, 252));
		itemPanel4.setVisible(false);
		itemPanel4.setLayout(null);
		itemPanel4.setBounds(10, 538, 910, 165);
		contentPane.add(itemPanel4);
		
		image4 = new JLabel("");
		image4.setBounds(10, 11, 205, 143);
		itemPanel4.add(image4);
		
		info4 = new JLabel("Prodcut Information Message");
		info4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		info4.setBounds(246, 11, 654, 32);
		itemPanel4.add(info4);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(new Color(212, 250, 252));
		panel_1_3.setLayout(null);
		panel_1_3.setBounds(246, 122, 137, 32);
		itemPanel4.add(panel_1_3);
		
		JButton btnNewButton_5 = new JButton(new ImageIcon("images/minusButton.png"));
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartPage.this.reduceTheNumberOfGivenProduct(3);
			}
		});
		btnNewButton_5.setBounds(0, 0, 32, 32);
		panel_1_3.add(btnNewButton_5);
		
		amount4 = new JLabel("");
		amount4.setHorizontalAlignment(SwingConstants.CENTER);
		amount4.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount4.setBounds(35, 0, 58, 32);
		panel_1_3.add(amount4);
		
		JButton btnNewButton_1_3 = new JButton(new ImageIcon("images/plusButton.png"));
		btnNewButton_1_3.setBackground(new Color(255, 255, 255));
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartPage.this.increaseTheNumberOfGivenProduct(3);
			}
		});
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1_3.setBounds(92, 0, 32, 32);
		panel_1_3.add(btnNewButton_1_3);
		
		JButton btnNewButton_2_3 = new JButton(new ImageIcon("images/trashBox.png"));
		btnNewButton_2_3.setBackground(new Color(255, 255, 255));
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartPage.this.removeGivenProductFromCart(3);
			}
		});
		btnNewButton_2_3.setBounds(382, 122, 32, 32);
		itemPanel4.add(btnNewButton_2_3);
		
		price4 = new JLabel("38.997$");
		price4.setHorizontalAlignment(SwingConstants.RIGHT);
		price4.setFont(new Font("Tahoma", Font.BOLD, 18));
		price4.setBounds(729, 122, 171, 32);
		itemPanel4.add(price4);
		
		itemPanel5 = new JPanel();
		itemPanel5.setBackground(new Color(212, 250, 252));
		itemPanel5.setVisible(false);
		itemPanel5.setLayout(null);
		itemPanel5.setBounds(10, 714, 910, 165);
		contentPane.add(itemPanel5);
		
		image5 = new JLabel("");
		image5.setBounds(10, 11, 205, 143);
		itemPanel5.add(image5);
		
		info5 = new JLabel("Prodcut Information Message");
		info5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		info5.setBounds(246, 11, 654, 32);
		itemPanel5.add(info5);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setBackground(new Color(212, 250, 252));
		panel_1_4.setLayout(null);
		panel_1_4.setBounds(246, 122, 138, 32);
		itemPanel5.add(panel_1_4);
		
		JButton btnNewButton_6 = new JButton(new ImageIcon("images/minusButton.png"));
		btnNewButton_6.setBackground(new Color(255, 255, 255));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartPage.this.reduceTheNumberOfGivenProduct(4);
			}
		});
		btnNewButton_6.setBounds(0, 0, 32, 32);
		panel_1_4.add(btnNewButton_6);
		
		amount5 = new JLabel("");
		amount5.setHorizontalAlignment(SwingConstants.CENTER);
		amount5.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount5.setBounds(35, 0, 58, 32);
		panel_1_4.add(amount5);
		
		JButton btnNewButton_1_4 = new JButton(new ImageIcon("images/plusButton.png"));
		btnNewButton_1_4.setBackground(new Color(255, 255, 255));
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartPage.this.increaseTheNumberOfGivenProduct(4);
			}
		});
		btnNewButton_1_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1_4.setBounds(92, 0, 32, 32);
		panel_1_4.add(btnNewButton_1_4);
		
		JButton btnNewButton_2_4 = new JButton(new ImageIcon("images/trashBox.png"));
		btnNewButton_2_4.setBackground(new Color(255, 255, 255));
		btnNewButton_2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartPage.this.removeGivenProductFromCart(4);
			}
		});
		btnNewButton_2_4.setBounds(382, 122, 32, 32);
		itemPanel5.add(btnNewButton_2_4);
		
		price5 = new JLabel("38.997$");
		price5.setHorizontalAlignment(SwingConstants.RIGHT);
		price5.setFont(new Font("Tahoma", Font.BOLD, 18));
		price5.setBounds(729, 122, 171, 32);
		itemPanel5.add(price5);
		
		controlPanel = new JPanel();
		controlPanel.setBackground(new Color(212, 250, 252));
		controlPanel.setVisible(false);
		controlPanel.setBounds(950, 10, 224, 869);
		contentPane.add(controlPanel);
		controlPanel.setLayout(null);
		
		numOfSelectedProducts = new JLabel("");
		numOfSelectedProducts.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numOfSelectedProducts.setHorizontalAlignment(SwingConstants.CENTER);
		numOfSelectedProducts.setBounds(10, 11, 204, 37);
		controlPanel.add(numOfSelectedProducts);
		
		totalPrice = new JLabel("");
		totalPrice.setFont(new Font("Tahoma", Font.BOLD, 28));
		totalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		totalPrice.setBounds(10, 109, 204, 50);
		controlPanel.add(totalPrice);
		
		JButton btnNewButton_7 = new JButton("Complete the Shopping");
		btnNewButton_7.setForeground(new Color(240, 240, 240));
		btnNewButton_7.setBackground(new Color(108, 155, 207));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartPage.this.dispose();
				int userId = ShoppingCartPage.this.cart.getUserId();
				ShoppingCartPageController controller = ShoppingCartPageController.getInstance();
				new DeliveryAndPaymentPage(
						controller.getCards(userId),
						controller.getAddresses(userId),
						ShoppingCartPage.this.referenceOfHomePage
						);
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_7.setBounds(10, 221, 204, 43);
		controlPanel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton(new ImageIcon("images/trashBoxShoppPage.png"));
		btnNewButton_8.setBackground(new Color(108, 155, 207));
		
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartPage.this.cart.emptyTheCart();
				initializeTheCell();
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_8.setBounds(10, 708, 205, 150);
		controlPanel.add(btnNewButton_8);
		
		emptyCartMessage = new JLabel("Your cart is currently empty.");
		emptyCartMessage.setVisible(false);
		emptyCartMessage.setFont(new Font("Tahoma", Font.BOLD, 48));
		emptyCartMessage.setBounds(10, 11, 1164, 164);
		contentPane.add(emptyCartMessage);
		
		initializeTheCell();
		setValuesOfItemsOfControlPanel();
	}
	
	private void initializeTheCell() {
		setVisibilityOfPanels(this.cart.getPieceNumber());
		int panelNum = 1;
		for(CartItem cartItem : this.cart.getItems()) {
			setValuesOfItemsOfItemPanel(panelNum, cartItem);
			panelNum++;
		}
	}
	
	private void setValuesOfItemsOfControlPanel() {
		if(this.cart.getPieceNumber() != 0) {
			numOfSelectedProducts.setText("Selected Products (" + this.cart.getPieceNumber() + ")");
			totalPrice.setText(this.cart.getTotalPrice() + "$");
		}
	}
	
	private void setValuesOfItemsOfItemPanel(int itemPanelNo, CartItem cartItem) {
		String smallerImagePath = "images/smaller" + cartItem.getId() + ".jpg";
		
		ImageResizer.resizeImage(cartItem.getImagePath(), smallerImagePath, 205, 143);
		
		JLabel[] labels = getLabelsOfGivenPanel(itemPanelNo);
		labels[0].setIcon(new ImageIcon(smallerImagePath));
		labels[1].setText(cartItem.getInformation());
		labels[2].setText(String.valueOf((float)cartItem.getAmount()* cartItem.getPrice()) + "$");
		labels[3].setText(String.valueOf(cartItem.getAmount()));
	}
	
	
	private void reduceTheNumberOfGivenProduct(int index) {
		CartItem tempItem = this.cart.getItem(index);
		int oldAmount = tempItem.getAmount();
		if(oldAmount != 1) {
			tempItem.setAmount(oldAmount - 1);
			setValuesOfItemsOfControlPanel();
			initializeTheCell();
		}
	}
	
	private void increaseTheNumberOfGivenProduct(int index) {
		CartItem tempItem = this.cart.getItem(index);
		int oldAmount = tempItem.getAmount();
		tempItem.setAmount(oldAmount + 1);
		setValuesOfItemsOfControlPanel();
		initializeTheCell();
	}
	
	private void removeGivenProductFromCart(int index) {
		this.cart.deleteItemWithIndex(index);
		initializeTheCell();
		setValuesOfItemsOfControlPanel();
	}
	
	private JLabel[] getLabelsOfGivenPanel(int itemPanelNo) {
		JLabel[] labels = new JLabel[4];
		
		switch(itemPanelNo) {
		
		case 1:
			labels[0] = image1;
			labels[1] = info1;
			labels[2] = price1;
			labels[3] = amount1;
			break;
		case 2:
			labels[0] = image2;
			labels[1] = info2;
			labels[2] = price2;
			labels[3] = amount2;
			break;
		case 3:
			labels[0] = image3;
			labels[1] = info3;
			labels[2] = price3;
			labels[3] = amount3;
			break;
		case 4:
			labels[0] = image4;
			labels[1] = info4;
			labels[2] = price4;
			labels[3] = amount4;
			break;
		case 5:
			labels[0] = image5;
			labels[1] = info5;
			labels[2] = price5;
			labels[3] = amount5;
			break;
		}
		return labels;
	}
	
	private void setVisibilityOfPanels(int numberOfItem) {
		switch (numberOfItem) {
		case 0:
			emptyCartMessage.setVisible(true);
			itemPanel1.setVisible(false);
			itemPanel2.setVisible(false);
			itemPanel3.setVisible(false);
			itemPanel4.setVisible(false);
			itemPanel5.setVisible(false);
			controlPanel.setVisible(false);
			break;
			
		case 1: 
			emptyCartMessage.setVisible(false);
			itemPanel1.setVisible(true);
			itemPanel2.setVisible(false);
			itemPanel3.setVisible(false);
			itemPanel4.setVisible(false);
			itemPanel5.setVisible(false);
			controlPanel.setVisible(true);
			break;
			
		case 2:
			emptyCartMessage.setVisible(false);
			itemPanel1.setVisible(true);
			itemPanel2.setVisible(true);
			itemPanel3.setVisible(false);
			itemPanel4.setVisible(false);
			itemPanel5.setVisible(false);
			controlPanel.setVisible(true);
			break;
			
		case 3:
			emptyCartMessage.setVisible(false);
			itemPanel1.setVisible(true);
			itemPanel2.setVisible(true);
			itemPanel3.setVisible(true);
			itemPanel4.setVisible(false);
			itemPanel5.setVisible(false);
			controlPanel.setVisible(true);
			break;
			
		case 4:
			emptyCartMessage.setVisible(false);
			itemPanel1.setVisible(true);
			itemPanel2.setVisible(true);
			itemPanel3.setVisible(true);
			itemPanel4.setVisible(true);
			itemPanel5.setVisible(false);
			controlPanel.setVisible(true);
			break;
			
		case 5:
			emptyCartMessage.setVisible(false);
			itemPanel1.setVisible(true);
			itemPanel2.setVisible(true);
			itemPanel3.setVisible(true);
			itemPanel4.setVisible(true);
			itemPanel5.setVisible(true);
			controlPanel.setVisible(true);
			break;
		}

	}
}
