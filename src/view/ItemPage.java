package view;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import model.CartItem;
import model.Item;
import model.ShoppingCart;
import util.ItemPageItemElement;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class ItemPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	
	private ItemPageItemElement receivedItem;
	private JLabel image;
	private JButton btnBackward;
	private JButton btnForward;
	private JTextPane txtItemName;
	private JLabel txtItemPrice;
	private JButton btnMinus;
	private JButton btnPlus;
	private JLabel lblPiece;
	private JButton btnAddToCart;
	
	private int totalPieceNum;
	private int currentImageNo;
	private ArrayList<String> imagePaths;
	protected HomePage homePage;
	
	public ItemPage(HomePage homePage, ItemPageItemElement item) {
		this.homePage = homePage;
		this.totalPieceNum = 1;
		this.currentImageNo = 0;
		this.receivedItem = item;
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 1018);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(184, 231, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		image = new JLabel("");
		image.setOpaque(true);
		image.setBackground(new Color(255, 255, 255));
		image.setBounds(10, 11, 650, 910);
		contentPane.add(image);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(184, 231, 225));
		panel_1.setBounds(10, 920, 650, 59);
		contentPane.add(panel_1);
		
		btnBackward = new JButton();
		btnBackward.setBackground(new Color(255, 238, 179));
		btnBackward.setIcon(new ImageIcon("images/backwardButton.png"));
		btnBackward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ItemPage.this.currentImageNo == 0) {
					ItemPage.this.currentImageNo = ItemPage.this.imagePaths.size() - 1;
				}
				else {
					ItemPage.this.currentImageNo--;
				}
				ItemPage.this.image.setIcon(new ImageIcon(ItemPage.this.imagePaths.get(ItemPage.this.currentImageNo)));
				
			}
		});
		panel_1.add(btnBackward);
		
		btnForward = new JButton(new ImageIcon("images/forwardButton.png"));
		btnForward.setBackground(new Color(255, 238, 179));
		btnForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ItemPage.this.currentImageNo == ItemPage.this.imagePaths.size() - 1) {
					ItemPage.this.currentImageNo = 0;
				}
				else {
					ItemPage.this.currentImageNo++;
				}
				ItemPage.this.image.setIcon(new ImageIcon(ItemPage.this.imagePaths.get(ItemPage.this.currentImageNo)));
			}
		});
		panel_1.add(btnForward);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(184, 231, 225));
		panel_2.setBounds(670, 11, 504, 957);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtItemName = new JTextPane();
		txtItemName.setBackground(new Color(184, 231, 225));
		txtItemName.setText("Acer Nitro 5 AN515-45 AMD Ryzen 5 5600H 8GB 256GB SSD GTX1650 Freedos 15.6\" FHD 144Hz Taşınabilir Bilgisayar NH.QB9EY.004");
		txtItemName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtItemName.setEditable(false);
		txtItemName.setBounds(10, 11, 484, 66);
		panel_2.add(txtItemName);
		
		txtItemPrice = new JLabel("12,999.00 $");
		txtItemPrice.setFont(new Font("Tahoma", Font.BOLD, 32));
		txtItemPrice.setBounds(10, 138, 484, 54);
		panel_2.add(txtItemPrice);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(184, 231, 225));
		panel_3.setBounds(10, 837, 484, 66);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.setBackground(new Color(255, 238, 179));
		btnAddToCart.setIconTextGap(30);
		btnAddToCart.setIcon(new ImageIcon("images/cart.png"));
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				if(ShoppingCart.getCart().getPieceNumber() >= 5) {
					JOptionPane.showMessageDialog(null, "You can add up to 5 different types of products to your cart.", "Warning !", JOptionPane.WARNING_MESSAGE);
				}
				else {
					ItemPageItemElement itemPageItemElement = ItemPage.this.receivedItem;
					
					CartItem cartItem = new CartItem(
							itemPageItemElement.getItem().getId(),
							itemPageItemElement.getImagePaths().get(0),
							itemPageItemElement.getItem().getItemName(),
							itemPageItemElement.getItem().getUnitPrice(),
							ItemPage.this.totalPieceNum);
					ShoppingCart.getCart().addItem(cartItem);
					
					new AddedItemPage(
							ItemPage.this,
							itemPageItemElement.getItem().getId(),
							itemPageItemElement.getImagePaths().get(0),
							itemPageItemElement.getItem().getItemName());
				}

				
			}
		});
		btnAddToCart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddToCart.setBounds(139, 11, 335, 44);
		panel_3.add(btnAddToCart);
		
		btnMinus = new JButton(new ImageIcon("images/minusButton.png"));
		btnMinus.setBackground(new Color(255, 238, 179));
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ItemPage.this.totalPieceNum != 1) {
					ItemPage.this.totalPieceNum--;
					ItemPage.this.lblPiece.setText(String.valueOf(ItemPage.this.totalPieceNum));
				}
			}
		});
		btnMinus.setFont(new Font("Tahoma", Font.PLAIN, 5));
		btnMinus.setBounds(10, 11, 32, 32);
		panel_3.add(btnMinus);
		
		lblPiece = new JLabel("1");
		lblPiece.setHorizontalAlignment(SwingConstants.CENTER);
		lblPiece.setBounds(38, 11, 46, 22);
		panel_3.add(lblPiece);
		
		JLabel lblNewLabel_3 = new JLabel("Piece");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(38, 33, 46, 22);
		panel_3.add(lblNewLabel_3);
		
		btnPlus = new JButton(new ImageIcon("images/plusButton.png"));
		btnPlus.setBackground(new Color(255, 238, 179));
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemPage.this.totalPieceNum++;
				ItemPage.this.lblPiece.setText(String.valueOf(ItemPage.this.totalPieceNum));
			}
		});
		btnPlus.setFont(new Font("Tahoma", Font.PLAIN, 6));
		btnPlus.setBounds(83, 11, 32, 32);
		panel_3.add(btnPlus);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		setComponents(this.receivedItem);
	}
	
	private void setComponents(ItemPageItemElement receivedItem) {
		Item item = receivedItem.getItem();
		this.imagePaths = receivedItem.getImagePaths();
		image.setIcon(new ImageIcon(imagePaths.get(0)));
		txtItemPrice.setText(String.valueOf(item.getUnitPrice()) + "$");
		txtItemName.setText(item.getItemName());
	}
}
