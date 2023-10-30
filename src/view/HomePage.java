package view;

import model.ShoppingCart;
import model.User;
import util.HomePageItemElement;
import util.HomePageItemHolder;
import util.ItemPageItemElement;

import javax.swing.JLabel;

import javax.swing.border.LineBorder;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.util.ArrayList;

import controller.HomePageController;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class HomePage extends JFrame {

	private JPanel contentPane;
	
	private JTextField searchField;
	
	private JPanel itemPanel1;
	private JLabel labelPrice1;
	private JLabel labelInfo1;
	private JLabel labelImage1;
	
	private JPanel itemPanel2;
	private JLabel labelInfo2;
	private JLabel labelImage2;
	private JLabel labelPrice2;
	
	private JPanel itemPanel3;
	private JLabel labelInfo3;
	private JLabel labelImage3;
	private JLabel labelPrice3;
	
	private JPanel itemPanel4;
	private JLabel labelInfo4;
	private JLabel labelImage4;
	private JLabel labelPrice4;
	
	private JPanel itemPanel5;
	private JLabel labelInfo5;
	private JLabel labelImage5;
	private JLabel labelPrice5;
	
	private JPanel itemPanel6;
	private JLabel labelInfo6;
	private JLabel labelImage6;
	private JLabel labelPrice6;
	
	private JPanel itemPanel7;
	private JLabel labelInfo7;
	private JLabel labelImage7;
	private JLabel labelPrice7;
	
	private JPanel itemPanel8;
	private JLabel labelInfo8;
	private JLabel labelImage8;
	private JLabel labelPrice8;
	
	private JPanel itemPanel9;
	private JLabel labelInfo9;
	private JLabel labelImage9;
	private JLabel labelPrice9;
	
	private JPanel itemPanel10;
	private JLabel labelInfo10;
	private JLabel labelImage10;
	private JLabel labelPrice10;
	
	private JPanel itemPanel11;
	private JLabel labelInfo11;
	private JLabel labelImage11;
	private JLabel labelPrice11;
	
	private JPanel itemPanel12;
	private JLabel labelInfo12;
	private JLabel labelImage12;
	private JLabel labelPrice12;
	
	
	private int whichPage;
	
	private ArrayList<HomePageItemElement> items;
	
	protected User user;
	
	private ShoppingCart cart;
	protected JButton myAccountButton;
	private JPanel holderOfPageNumber;
	private JLabel lblNewLabel_2;

	
	/**
	 * Create the frame.
	 */
	public HomePage(User user, ArrayList<HomePageItemElement> elements) {
		HomePageItemHolder.getInstance().setItems(elements);
		this.items = elements;
		this.whichPage = 0;
		this.user = user;
		this.cart = ShoppingCart.getCart();
		this.cart.setUserID(this.user.getId());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1680, 1024);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(184, 231, 225));
		contentPane.setBorder(new LineBorder(new Color(240, 240, 240), 3));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(184, 231, 225));
		panel.setBounds(61, 11, 1664, 124);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("allhere");
		lblNewLabel.setForeground(new Color(10, 77, 104));
		lblNewLabel.setBounds(10, 11, 230, 102);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 72));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search Product : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(new Color(10, 77, 104));
		lblNewLabel_1.setBackground(new Color(10, 77, 104));
		lblNewLabel_1.setBounds(412, 49, 182, 22);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 18));
		panel.add(lblNewLabel_1);
		
		searchField = new JTextField();
		searchField.setBackground(new Color(255, 255, 255));
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchText = HomePage.this.searchField.getText().toLowerCase();
				ArrayList<HomePageItemElement> filtredItems = new ArrayList<>();
				for(HomePageItemElement tempItem : HomePageItemHolder.getInstance().getItems() ) {
					if(tempItem.getInformationText().toLowerCase().contains(searchText)) {
						filtredItems.add(tempItem);
					}
				}
				HomePage.this.items = filtredItems;
				HomePage.this.whichPage = 0;
				HomePage.this.initializeOfPageNumberButtons();
				HomePage.this.fillInTheGrids();
			}
		});

		searchField.setBounds(594, 40, 430, 48);
		panel.add(searchField);
		searchField.setColumns(10);
		
		myAccountButton = new JButton();
		myAccountButton.setBackground(new Color(10, 77, 104));
		myAccountButton.setIcon(new ImageIcon("images/myAccount.png"));
		myAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HomePage.this.setVisible(false);
				new MyAccountPage(HomePage.this);
				
			}
		});
		myAccountButton.setFocusable(false);
		myAccountButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		myAccountButton.setBounds(1246, 25, 120, 73);
		panel.add(myAccountButton);
		
		JButton myCartButton = new JButton();
		myCartButton.setBackground(new Color(10, 77, 104));
		myCartButton.setIcon(new ImageIcon("images/myCart.png"));
		myCartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShoppingCartPage(HomePage.this);
			}
		});
		myCartButton.setFocusable(false);
		myCartButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		myCartButton.setBounds(1410, 25, 120, 73);
		panel.add(myCartButton);
		
		lblNewLabel_2 = new JLabel(new ImageIcon("images/search.png"));
		lblNewLabel_2.setBounds(1020, 40, 48, 48);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(184, 231, 225));
		panel_1.setBounds(141, 201, 1394, 773);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(184, 231, 225));
		panel_2.setBounds(10, 11, 1374, 676);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 6, 10, 6));
		
		itemPanel1 = new JPanel();
		itemPanel1.setBackground(new Color(212, 250, 252));
		itemPanel1.setBorder(null);
		itemPanel1.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseEntered(MouseEvent e) {
				HomePage.this.setCursor(Cursor.HAND_CURSOR);
			}
			@SuppressWarnings("deprecation")
			@Override
			public void mouseExited(MouseEvent e) {
				HomePage.this.setCursor(Cursor.DEFAULT_CURSOR);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage.this.sendItemToItemPage(1);
			}
		});
		panel_2.add(itemPanel1);
		itemPanel1.setLayout(null);
		
		labelPrice1 = new JLabel("");
		labelPrice1.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelPrice1.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrice1.setBounds(10, 302, 200, 22);
		itemPanel1.add(labelPrice1);
		
		labelInfo1 = new JLabel("");
		labelInfo1.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfo1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelInfo1.setBounds(10, 11, 200, 34);
		itemPanel1.add(labelInfo1);
		
		labelImage1 = new JLabel("");
		labelImage1.setBounds(10, 56, 200, 235);
		itemPanel1.add(labelImage1);
		
		itemPanel2 = new JPanel();
		itemPanel2.setBorder(null);
		itemPanel2.setBackground(new Color(212, 250, 252));
		itemPanel2.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseEntered(MouseEvent e) {
				HomePage.this.setCursor(Cursor.HAND_CURSOR);
			}
			@SuppressWarnings("deprecation")
			@Override
			public void mouseExited(MouseEvent e) {
				HomePage.this.setCursor(Cursor.DEFAULT_CURSOR);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage.this.sendItemToItemPage(2);
			}
		});
		panel_2.add(itemPanel2);
		itemPanel2.setLayout(null);
		
		labelInfo2 = new JLabel("");
		labelInfo2.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelInfo2.setBounds(10, 11, 200, 34);
		itemPanel2.add(labelInfo2);
		
		labelImage2 = new JLabel("");
		labelImage2.setBounds(10, 51, 200, 235);
		itemPanel2.add(labelImage2);
		
		labelPrice2 = new JLabel("");
		labelPrice2.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrice2.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelPrice2.setBounds(10, 302, 200, 22);
		itemPanel2.add(labelPrice2);
		
		itemPanel3 = new JPanel();
		itemPanel3.setBorder(null);
		itemPanel3.setBackground(new Color(212, 250, 252));
		itemPanel3.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseEntered(MouseEvent e) {
				HomePage.this.setCursor(Cursor.HAND_CURSOR);
			}
			@SuppressWarnings("deprecation")
			@Override
			public void mouseExited(MouseEvent e) {
				HomePage.this.setCursor(Cursor.DEFAULT_CURSOR);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage.this.sendItemToItemPage(3);
			}
		});
		panel_2.add(itemPanel3);
		itemPanel3.setLayout(null);
		
		labelInfo3 = new JLabel("");
		labelInfo3.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfo3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelInfo3.setBounds(10, 11, 200, 34);
		itemPanel3.add(labelInfo3);
		
		labelImage3 = new JLabel("");
		labelImage3.setBounds(10, 56, 200, 235);
		itemPanel3.add(labelImage3);
		
		labelPrice3 = new JLabel("");
		labelPrice3.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrice3.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelPrice3.setBounds(10, 302, 200, 22);
		itemPanel3.add(labelPrice3);
		
		itemPanel4 = new JPanel();
		itemPanel4.setBorder(null);
		itemPanel4.setBackground(new Color(212, 250, 252));
		itemPanel4.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseEntered(MouseEvent e) {
				HomePage.this.setCursor(Cursor.HAND_CURSOR);
			}
			@SuppressWarnings("deprecation")
			@Override
			public void mouseExited(MouseEvent e) {
				HomePage.this.setCursor(Cursor.DEFAULT_CURSOR);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage.this.sendItemToItemPage(4);
			}
		});
		panel_2.add(itemPanel4);
		itemPanel4.setLayout(null);
		
		labelInfo4 = new JLabel("");
		labelInfo4.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfo4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelInfo4.setBounds(10, 11, 200, 34);
		itemPanel4.add(labelInfo4);
		
		labelImage4 = new JLabel("");
		labelImage4.setBounds(10, 56, 200, 235);
		itemPanel4.add(labelImage4);
		
		labelPrice4 = new JLabel("");
		labelPrice4.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrice4.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelPrice4.setBounds(10, 302, 200, 22);
		itemPanel4.add(labelPrice4);
		
		itemPanel5 = new JPanel();
		itemPanel5.setBorder(null);
		itemPanel5.setBackground(new Color(212, 250, 252));
		itemPanel5.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseEntered(MouseEvent e) {
				HomePage.this.setCursor(Cursor.HAND_CURSOR);
			}
			@SuppressWarnings("deprecation")
			@Override
			public void mouseExited(MouseEvent e) {
				HomePage.this.setCursor(Cursor.DEFAULT_CURSOR);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage.this.sendItemToItemPage(5);
			}
		});
		panel_2.add(itemPanel5);
		itemPanel5.setLayout(null);
		
		labelInfo5 = new JLabel("");
		labelInfo5.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfo5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelInfo5.setBounds(10, 11, 200, 34);
		itemPanel5.add(labelInfo5);
		
		labelImage5 = new JLabel("");
		labelImage5.setBounds(10, 56, 200, 235);
		itemPanel5.add(labelImage5);
		
		labelPrice5 = new JLabel("");
		labelPrice5.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrice5.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelPrice5.setBounds(10, 302, 200, 22);
		itemPanel5.add(labelPrice5);
		
		itemPanel6 = new JPanel();
		itemPanel6.setBorder(null);
		itemPanel6.setBackground(new Color(212, 250, 252));
		itemPanel6.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseEntered(MouseEvent e) {
				HomePage.this.setCursor(Cursor.HAND_CURSOR);
			}
			@SuppressWarnings("deprecation")
			@Override
			public void mouseExited(MouseEvent e) {
				HomePage.this.setCursor(Cursor.DEFAULT_CURSOR);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage.this.sendItemToItemPage(6);
			}
		});
		panel_2.add(itemPanel6);
		itemPanel6.setLayout(null);
		
		labelInfo6 = new JLabel("");
		labelInfo6.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfo6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelInfo6.setBounds(10, 11, 200, 34);
		itemPanel6.add(labelInfo6);
		
		labelImage6 = new JLabel("");
		labelImage6.setBounds(10, 56, 200, 235);
		itemPanel6.add(labelImage6);
		
		labelPrice6 = new JLabel("");
		labelPrice6.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrice6.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelPrice6.setBounds(10, 302, 200, 22);
		itemPanel6.add(labelPrice6);
		
		itemPanel7 = new JPanel();
		itemPanel7.setBorder(null);
		itemPanel7.setBackground(new Color(212, 250, 252));
		itemPanel7.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseEntered(MouseEvent e) {
				HomePage.this.setCursor(Cursor.HAND_CURSOR);
			}
			@SuppressWarnings("deprecation")
			@Override
			public void mouseExited(MouseEvent e) {
				HomePage.this.setCursor(Cursor.DEFAULT_CURSOR);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage.this.sendItemToItemPage(7);
			}
		});
		panel_2.add(itemPanel7);
		itemPanel7.setLayout(null);
		
		labelInfo7 = new JLabel("");
		labelInfo7.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfo7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelInfo7.setBounds(10, 11, 200, 34);
		itemPanel7.add(labelInfo7);
		
		labelImage7 = new JLabel("");
		labelImage7.setBounds(10, 56, 200, 235);
		itemPanel7.add(labelImage7);
		
		labelPrice7 = new JLabel("");
		labelPrice7.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrice7.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelPrice7.setBounds(10, 302, 200, 22);
		itemPanel7.add(labelPrice7);
		
		itemPanel8 = new JPanel();
		itemPanel8.setBorder(null);
		itemPanel8.setBackground(new Color(212, 250, 252));
		itemPanel8.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseEntered(MouseEvent e) {
				HomePage.this.setCursor(Cursor.HAND_CURSOR);
			}
			@SuppressWarnings("deprecation")
			@Override
			public void mouseExited(MouseEvent e) {
				HomePage.this.setCursor(Cursor.DEFAULT_CURSOR);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage.this.sendItemToItemPage(8);
			}
		});
		panel_2.add(itemPanel8);
		itemPanel8.setLayout(null);
		
		labelInfo8 = new JLabel("");
		labelInfo8.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfo8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelInfo8.setBounds(10, 11, 200, 34);
		itemPanel8.add(labelInfo8);
		
		labelImage8 = new JLabel("");
		labelImage8.setBounds(10, 56, 200, 235);
		itemPanel8.add(labelImage8);
		
		labelPrice8 = new JLabel("");
		labelPrice8.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrice8.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelPrice8.setBounds(10, 302, 200, 22);
		itemPanel8.add(labelPrice8);
		
		itemPanel9 = new JPanel();
		itemPanel9.setBorder(null);
		itemPanel9.setBackground(new Color(212, 250, 252));
		itemPanel9.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseEntered(MouseEvent e) {
				HomePage.this.setCursor(Cursor.HAND_CURSOR);
			}
			@SuppressWarnings("deprecation")
			@Override
			public void mouseExited(MouseEvent e) {
				HomePage.this.setCursor(Cursor.DEFAULT_CURSOR);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage.this.sendItemToItemPage(9);
			}
		});
		panel_2.add(itemPanel9);
		itemPanel9.setLayout(null);
		
		labelInfo9 = new JLabel("");
		labelInfo9.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfo9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelInfo9.setBounds(10, 11, 200, 34);
		itemPanel9.add(labelInfo9);
		
		labelImage9 = new JLabel("");
		labelImage9.setBounds(10, 56, 200, 235);
		itemPanel9.add(labelImage9);
		
		labelPrice9 = new JLabel("");
		labelPrice9.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrice9.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelPrice9.setBounds(10, 302, 200, 22);
		itemPanel9.add(labelPrice9);
		
		itemPanel10 = new JPanel();
		itemPanel10.setBorder(null);
		itemPanel10.setBackground(new Color(212, 250, 252));
		itemPanel10.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseEntered(MouseEvent e) {
				HomePage.this.setCursor(Cursor.HAND_CURSOR);
			}
			@SuppressWarnings("deprecation")
			@Override
			public void mouseExited(MouseEvent e) {
				HomePage.this.setCursor(Cursor.DEFAULT_CURSOR);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage.this.sendItemToItemPage(10);
			}
		});
		panel_2.add(itemPanel10);
		itemPanel10.setLayout(null);
		
		labelInfo10 = new JLabel("");
		labelInfo10.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfo10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelInfo10.setBounds(10, 11, 200, 34);
		itemPanel10.add(labelInfo10);
		
		labelImage10 = new JLabel("");
		labelImage10.setBounds(10, 56, 200, 235);
		itemPanel10.add(labelImage10);
		
		labelPrice10 = new JLabel("");
		labelPrice10.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrice10.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelPrice10.setBounds(10, 302, 200, 22);
		itemPanel10.add(labelPrice10);
		
		itemPanel11 = new JPanel();
		itemPanel11.setBorder(null);
		itemPanel11.setBackground(new Color(212, 250, 252));
		itemPanel11.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseEntered(MouseEvent e) {
				HomePage.this.setCursor(Cursor.HAND_CURSOR);
			}
			@SuppressWarnings("deprecation")
			@Override
			public void mouseExited(MouseEvent e) {
				HomePage.this.setCursor(Cursor.DEFAULT_CURSOR);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage.this.sendItemToItemPage(11);
			}
		});
		panel_2.add(itemPanel11);
		itemPanel11.setLayout(null);
		
		labelInfo11 = new JLabel("");
		labelInfo11.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfo11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelInfo11.setBounds(10, 11, 200, 34);
		itemPanel11.add(labelInfo11);
		
		labelImage11 = new JLabel("");
		labelImage11.setBounds(10, 56, 200, 235);
		itemPanel11.add(labelImage11);
		
		labelPrice11 = new JLabel("");
		labelPrice11.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrice11.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelPrice11.setBounds(10, 302, 200, 22);
		itemPanel11.add(labelPrice11);
		
		itemPanel12 = new JPanel();
		itemPanel12.setBorder(null);
		itemPanel12.setBackground(new Color(212, 250, 252));
		itemPanel12.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseEntered(MouseEvent e) {
				HomePage.this.setCursor(Cursor.HAND_CURSOR);
			}
			@SuppressWarnings("deprecation")
			@Override
			public void mouseExited(MouseEvent e) {
				HomePage.this.setCursor(Cursor.DEFAULT_CURSOR);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				HomePage.this.sendItemToItemPage(12);
			}
		});
		panel_2.add(itemPanel12);
		itemPanel12.setLayout(null);
		
		labelInfo12 = new JLabel("");
		labelInfo12.setHorizontalAlignment(SwingConstants.CENTER);
		labelInfo12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelInfo12.setBounds(10, 11, 200, 34);
		itemPanel12.add(labelInfo12);
		
		labelImage12 = new JLabel("");
		labelImage12.setBounds(10, 56, 200, 235);
		itemPanel12.add(labelImage12);
		
		labelPrice12 = new JLabel("");
		labelPrice12.setHorizontalAlignment(SwingConstants.CENTER);
		labelPrice12.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelPrice12.setBounds(10, 302, 200, 22);
		itemPanel12.add(labelPrice12);
		
		holderOfPageNumber = new JPanel();
		holderOfPageNumber.setBackground(new Color(255, 238, 179));
		holderOfPageNumber.setBounds(10, 708, 1374, 54);
		panel_1.add(holderOfPageNumber);
		
		initializeOfPageNumberButtons();
		
		fillInTheGrids();
	}
	
	private void fillInTheGrids() {
		resetAllItems();
		int index = 0;
		for(int i = whichPage*12;i < items.size(); i++) {
			index++;
			JLabel[] labels = getItemsOfPanel(index);
			setItemPanel(labels[0], labels[1], labels[2], items.get(i));
			
			if(whichPage == 0 && i == 11) {
				break;
			}
			else if(whichPage == 1 && i == 23) {
				break;
			}
			else if(whichPage == 2 && i == 35) {
				break;
			}
		}
	}

	
	private void setItemPanel(JLabel info, JLabel image, JLabel price, HomePageItemElement item) {
		info.setText(item.getInformationText());
		image.setIcon(new ImageIcon(item.getFilePathOfIcon()));
		price.setText(item.getPriceText());
	}
	
	
	private void sendItemToItemPage(int cellNumber) {
		//HomePage.this.dispose();
		//HomePage.this.setVisible(false);
		
		if(whichPage * 12 + cellNumber - 1 < items.size()) {
			HomePageItemElement clickedItem = HomePage.this.items.get(whichPage * 12  + cellNumber - 1);
			
			ItemPageItemElement itemToBeSent = HomePageController.getInstance().getItemPageElement(clickedItem.getProductId());
			
			new ItemPage(HomePage.this ,itemToBeSent);
		}
	}
	
	private void resetAllItems() {
		for(int i = 1;i <= 12; i++) {
			JLabel[] labels = getItemsOfPanel(i);
			labels[0].setText("");
			labels[1].setIcon(null);
			labels[2].setText("");
		}
	}
	
	private void initializeOfPageNumberButtons() {
		this.holderOfPageNumber.removeAll();
		this.holderOfPageNumber.revalidate();
		if(items.size() > 0) {
			JButton number1Button = new JButton(new ImageIcon("images/number1button.png"));
			number1Button.setBackground(new Color(255, 238, 179));
			number1Button.setBorder(null);
			number1Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			number1Button.setFocusable(false);
			number1Button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					HomePage.this.whichPage = 0;
					HomePage.this.fillInTheGrids();
				}
				
			});
			
			this.holderOfPageNumber.add(number1Button);
		}
		if(items.size() > 12) {
			JButton number2Button = new JButton(new ImageIcon("images/number2button.png"));
			number2Button.setBackground(new Color(255, 238, 179));
			number2Button.setBorder(null);
			number2Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			number2Button.setFocusable(false);
			number2Button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					HomePage.this.whichPage = 1;
					HomePage.this.fillInTheGrids();
				}
				
			});
			this.holderOfPageNumber.add(number2Button);
		}
		if(items.size() > 24) {
			JButton number3Button = new JButton(new ImageIcon("images/number3button.png"));
			number3Button.setBackground(new Color(255, 238, 179));
			number3Button.setBorder(null);
			number3Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			number3Button.setFocusable(false);
			number3Button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					HomePage.this.whichPage = 2;
					HomePage.this.fillInTheGrids();
				}
				
			});
			this.holderOfPageNumber.add(number3Button);
		}
		this.holderOfPageNumber.repaint();
	}
	

	
	private JLabel[] getItemsOfPanel(int itemNo) {
		JLabel[] labels = new JLabel[3];
		
		switch(itemNo) {
		case 1:
			labels[0] = labelInfo1;
			labels[1] = labelImage1;
			labels[2] = labelPrice1;
			break;
		case 2:
			labels[0] = labelInfo2;
			labels[1] = labelImage2;
			labels[2] = labelPrice2;
			break;
		case 3:
			labels[0] = labelInfo3;
			labels[1] = labelImage3;
			labels[2] = labelPrice3;
			break;
		case 4:
			labels[0] = labelInfo4;
			labels[1] = labelImage4;
			labels[2] = labelPrice4;
			break;
		case 5:
			labels[0] = labelInfo5;
			labels[1] = labelImage5;
			labels[2] = labelPrice5;
			break;
		case 6:
			labels[0] = labelInfo6;
			labels[1] = labelImage6;
			labels[2] = labelPrice6;
			break;
		case 7:
			labels[0] = labelInfo7;
			labels[1] = labelImage7;
			labels[2] = labelPrice7;
			break;
		case 8:
			labels[0] = labelInfo8;
			labels[1] = labelImage8;
			labels[2] = labelPrice8;
			break;
		case 9:
			labels[0] = labelInfo9;
			labels[1] = labelImage9;
			labels[2] = labelPrice9;
			break;
		case 10:
			labels[0] = labelInfo10;
			labels[1] = labelImage10;
			labels[2] = labelPrice10;
			break;
		case 11:
			labels[0] = labelInfo11;
			labels[1] = labelImage11;
			labels[2] = labelPrice11;
			break;
		case 12:
			labels[0] = labelInfo12;
			labels[1] = labelImage12;
			labels[2] = labelPrice12;
			break;
		}
		return labels;
	}
}
