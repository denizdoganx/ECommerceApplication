package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Address;
import model.Card;
import model.CartItem;
import model.Invoice;
import model.InvoiceDetail;
import model.Order;
import model.OrderDetail;
import model.Payment;
import model.ShoppingCart;
import util.FormatController;
import util.OrderReceivedPageItemElement;
import util.RandomClass;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

import controller.DeliveryAndPaymentPageController;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DeliveryAndPaymentPage extends JFrame {

	private JPanel contentPane;
	
	
	private JTextField country;
	private JTextField city;
	private JTextField town;
	private JTextField district;
	private JTextField addressText;
	private JTextField postalCode;
	private JTextField addressTitle;
	private JTextField cardNumber;
	private JTextField nameSurname;
	private JTextField expirationDate;
	private JTextField securityNumber;
	
	protected JPanel fragmentPanel1;
	protected JPanel fragmentPanel2;
	protected ArrayList<Card> registeredCards;
	protected ArrayList<Address> registeredAddresses;
	
	private int selectedCardIndex;
	private int selectedAddressIndex;
	
	private ShoppingCart cart;
	private JLabel lblSelectedAddress;
	private JLabel lblSelectedCardName;
	private JLabel lblSelectedCardNum;

	private JButton chooseAnotherAddress;
	private JButton chooseAnotherCard;
	
	protected HomePage referenceOfHomePage;
	
	/**
	 * Create the frame.
	 */
	public DeliveryAndPaymentPage(ArrayList<Card> registeredCards, ArrayList<Address> registeredAddresses, HomePage referenceOfHomePage) {
		this.referenceOfHomePage = referenceOfHomePage;
		this.selectedAddressIndex = - 1;
		this.selectedCardIndex = - 1;
		this.registeredCards = registeredCards;
		this.registeredAddresses = registeredAddresses;
		this.cart = ShoppingCart.getCart();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 836, 364);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("My Registered Addresses", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("My Registered Addresses");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 73, 240, 30);
		panel.add(lblNewLabel);
		
		lblSelectedAddress = new JLabel("");
		lblSelectedAddress.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		lblSelectedAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectedAddress.setBounds(10, 143, 240, 40);
		panel.add(lblSelectedAddress);
		
		chooseAnotherAddress = new JButton("Choose Another Address");
		chooseAnotherAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeliveryAndPaymentPage.this.fragmentPanel1.removeAll();
				DeliveryAndPaymentPage.this.fragmentPanel1.revalidate();
				for(Address tempAddress : DeliveryAndPaymentPage.this.registeredAddresses) {
					DeliveryAndPaymentPage.this.fragmentPanel1.add(new AddressSelectionView(tempAddress, DeliveryAndPaymentPage.this));
				}
				DeliveryAndPaymentPage.this.fragmentPanel1.repaint();
			}
		});
		chooseAnotherAddress.setBounds(10, 223, 184, 30);
		panel.add(chooseAnotherAddress);
		
		fragmentPanel1 = new JPanel();
		fragmentPanel1.setBounds(314, 11, 507, 314);
		panel.add(fragmentPanel1);
		fragmentPanel1.setLayout(new GridLayout(6, 1, 0, 10));
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add a New Address", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Country : ");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(173, 11, 110, 25);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("City : ");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(173, 47, 110, 25);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Town : ");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setBounds(173, 87, 110, 25);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("District : ");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(173, 120, 110, 25);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Address Text : ");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(173, 156, 110, 25);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Postal Code : ");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(173, 192, 110, 25);
		panel_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Address Title : ");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_13.setBounds(173, 228, 110, 25);
		panel_1.add(lblNewLabel_13);
		
		country = new JTextField();
		country.setFont(new Font("Tahoma", Font.PLAIN, 15));
		country.setBounds(293, 11, 400, 25);
		panel_1.add(country);
		country.setColumns(10);
		
		city = new JTextField();
		city.setFont(new Font("Tahoma", Font.PLAIN, 15));
		city.setColumns(10);
		city.setBounds(293, 51, 400, 25);
		panel_1.add(city);
		
		town = new JTextField();
		town.setFont(new Font("Tahoma", Font.PLAIN, 15));
		town.setColumns(10);
		town.setBounds(293, 91, 400, 25);
		panel_1.add(town);
		
		district = new JTextField();
		district.setFont(new Font("Tahoma", Font.PLAIN, 15));
		district.setColumns(10);
		district.setBounds(293, 124, 400, 25);
		panel_1.add(district);
		
		addressText = new JTextField();
		addressText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addressText.setColumns(10);
		addressText.setBounds(293, 160, 400, 25);
		panel_1.add(addressText);
		
		postalCode = new JTextField();
		postalCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		postalCode.setColumns(10);
		postalCode.setBounds(293, 196, 400, 25);
		panel_1.add(postalCode);
		
		addressTitle = new JTextField();
		addressTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addressTitle.setColumns(10);
		addressTitle.setBounds(293, 232, 400, 25);
		panel_1.add(addressTitle);
		
		JButton btnAddNewAddress = new JButton("Add");
		btnAddNewAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userId = DeliveryAndPaymentPage.this.cart.getUserId();
				String country = DeliveryAndPaymentPage.this.country.getText();
				String city = DeliveryAndPaymentPage.this.city.getText();
				String town = DeliveryAndPaymentPage.this.town.getText();
				String district = DeliveryAndPaymentPage.this.district.getText();
				String addressText = DeliveryAndPaymentPage.this.addressText.getText();
				String postalCode = DeliveryAndPaymentPage.this.postalCode.getText();
				String addressTitle = DeliveryAndPaymentPage.this.addressTitle.getText();
				
				if(country.isEmpty() ||
						city.isEmpty() ||
						town.isEmpty() ||
						district.isEmpty() ||
						addressText.isEmpty() ||
						postalCode.isEmpty() ||
						addressTitle.isEmpty()
						) 
				{
					JOptionPane.showMessageDialog(null, "These fields cannot be left blank.", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				else {
					Address newAddress = new Address(userId, country, city, town, district, addressText, postalCode, addressTitle);
					DeliveryAndPaymentPageController controller = DeliveryAndPaymentPageController.getInstance();
					boolean result = controller.addNewAddress(newAddress);
					if(!result) {
						JOptionPane.showMessageDialog(null, "Address could not be added.", "Warning!", JOptionPane.WARNING_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Address added successfully.", "Info", JOptionPane.INFORMATION_MESSAGE);
						DeliveryAndPaymentPage.this.registeredAddresses.add(newAddress);
						DeliveryAndPaymentPage.this.chooseAnotherAddress.doClick();
					}
				}
			}
		});
		btnAddNewAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddNewAddress.setBounds(604, 287, 89, 23);
		panel_1.add(btnAddNewAddress);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 386, 836, 364);
		contentPane.add(tabbedPane_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_1.addTab("My Registered Cards", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("My Registered Cards");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 73, 240, 30);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_5.setBounds(10, 143, 240, 60);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		lblSelectedCardName = new JLabel("DENİZ DOĞAN");
		lblSelectedCardName.setBounds(10, 11, 220, 14);
		panel_5.add(lblSelectedCardName);
		
		lblSelectedCardNum = new JLabel("8500 4561 1235 9632");
		lblSelectedCardNum.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSelectedCardNum.setBounds(10, 36, 220, 14);
		panel_5.add(lblSelectedCardNum);
		
		chooseAnotherCard = new JButton("Choose Another Card");
		chooseAnotherCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DeliveryAndPaymentPage.this.fragmentPanel2.removeAll();
				DeliveryAndPaymentPage.this.fragmentPanel2.revalidate();
				for(Card tempCard : DeliveryAndPaymentPage.this.registeredCards) {
					CardSelectionView cardSelectionView = new CardSelectionView(tempCard, DeliveryAndPaymentPage.this);
					DeliveryAndPaymentPage.this.fragmentPanel2.add(cardSelectionView);
				}
				DeliveryAndPaymentPage.this.fragmentPanel2.repaint();
			}
		});
		chooseAnotherCard.setBounds(10, 240, 184, 30);
		panel_2.add(chooseAnotherCard);
		
		fragmentPanel2 = new JPanel();
		fragmentPanel2.setBounds(314, 11, 507, 314);
		panel_2.add(fragmentPanel2);
		fragmentPanel2.setLayout(new GridLayout(6, 1, 0, 10));
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("Add a New Card", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_7_1 = new JLabel("Card Number : ");
		lblNewLabel_7_1.setBounds(83, 59, 228, 28);
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("Name and Surname On Card : ");
		lblNewLabel_7_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_1_1.setBounds(83, 98, 228, 28);
		panel_3.add(lblNewLabel_7_1_1);
		
		JLabel lblNewLabel_7_1_1_1 = new JLabel("Expiration Date : ");
		lblNewLabel_7_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_1_1_1.setBounds(83, 137, 228, 28);
		panel_3.add(lblNewLabel_7_1_1_1);
		
		JLabel lblNewLabel_7_1_1_1_1 = new JLabel("Security Number : ");
		lblNewLabel_7_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7_1_1_1_1.setBounds(83, 176, 228, 28);
		panel_3.add(lblNewLabel_7_1_1_1_1);
		
		cardNumber = new JTextField();
		cardNumber.setBounds(321, 59, 228, 28);
		panel_3.add(cardNumber);
		cardNumber.setColumns(10);
		
		nameSurname = new JTextField();
		nameSurname.setColumns(10);
		nameSurname.setBounds(321, 104, 228, 28);
		panel_3.add(nameSurname);
		
		expirationDate = new JTextField();
		expirationDate.setColumns(10);
		expirationDate.setBounds(321, 143, 228, 28);
		panel_3.add(expirationDate);
		
		securityNumber = new JTextField();
		securityNumber.setColumns(10);
		securityNumber.setBounds(321, 182, 228, 28);
		panel_3.add(securityNumber);
		
		JButton btnNewButton_4 = new JButton("Add");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userId = DeliveryAndPaymentPage.this.cart.getUserId();
				String cardNumber = DeliveryAndPaymentPage.this.cardNumber.getText();
				String nameSurname = DeliveryAndPaymentPage.this.nameSurname.getText();
				String expirationDate = DeliveryAndPaymentPage.this.expirationDate.getText();
				String securityNumber = DeliveryAndPaymentPage.this.securityNumber.getText();
				
				if(cardNumber.isEmpty() || nameSurname.isEmpty() || expirationDate.isEmpty() || securityNumber.isEmpty()) {
					JOptionPane.showMessageDialog(null, "These fields cannot be left blank.", "Warning!", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(FormatController.checkNameAndSurnameOnTheCard(nameSurname)
							&& FormatController.checkFormatOfCardNumber(cardNumber)
							&& FormatController.checkFormatOfExpirationDate(expirationDate)
							&& FormatController.checkSecurityNumber(securityNumber)) {
						Card newCard = new Card(userId, cardNumber, nameSurname, expirationDate, securityNumber);
						DeliveryAndPaymentPageController controller = DeliveryAndPaymentPageController.getInstance();
						boolean result = controller.addNewCard(newCard);
						if(!result) {
							JOptionPane.showMessageDialog(null, "New Card could not be added.", "Warning!", JOptionPane.WARNING_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "New Card added successfully.", "Info", JOptionPane.INFORMATION_MESSAGE);
							DeliveryAndPaymentPage.this.registeredCards.add(newCard);
							DeliveryAndPaymentPage.this.chooseAnotherCard.doClick();
						}
					}

				}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4.setBounds(460, 258, 89, 23);
		panel_3.add(btnNewButton_4);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(856, 11, 318, 364);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Total amount to be paid");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 11, 298, 42);
		panel_7.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(cart.getTotalPrice() + " $");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_6.setBounds(10, 64, 298, 42);
		panel_7.add(lblNewLabel_6);
		
		JButton btnNewButton_2 = new JButton("Confirm Order");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(DeliveryAndPaymentPage.this.selectedAddressIndex != -1 && DeliveryAndPaymentPage.this.selectedCardIndex != -1) {
					ShoppingCart cart = DeliveryAndPaymentPage.this.cart;
					
					int userId = cart.getUserId();
					int addressId = DeliveryAndPaymentPage.this.registeredAddresses.get(DeliveryAndPaymentPage.this.selectedAddressIndex).getId();
					Date date = new Date();
					float totalPrice = cart.getTotalPrice();
					int status = 0;
					RandomClass rndC = RandomClass.getInstance();
					String orderNumber = 
							String.valueOf(rndC.getRandomNumber(10)) +
							String.valueOf(rndC.getRandomNumber(10)) + 
							String.valueOf(rndC.getRandomNumber(10)) +
							"  " +
							String.valueOf(rndC.getRandomNumber(10)) +
							String.valueOf(rndC.getRandomNumber(10)) + 
							String.valueOf(rndC.getRandomNumber(10)) +
							"  " +
							String.valueOf(rndC.getRandomNumber(10)) +
							String.valueOf(rndC.getRandomNumber(10)) + 
							String.valueOf(rndC.getRandomNumber(10));
	
					DeliveryAndPaymentPageController controller = DeliveryAndPaymentPageController.getInstance();
					Order order = new Order(userId, addressId, date, totalPrice, status, orderNumber);
					
					
					
					int orderId = controller.addOrder(order);
					
					if(orderId == - 1) {
						System.out.println("HATA BURADA");
						JOptionPane.showMessageDialog(null, "Failed to create order !", "Error !", JOptionPane.ERROR_MESSAGE);
					}
					else {
						String approveCode = String.valueOf(rndC.getRandomNumber(100000, 999999));
						System.out.println("Confirmation Code : " +approveCode);
						boolean isOk = false;
						for(int i = 2;i >= 0; i--) {
							String input = JOptionPane.showInputDialog(null, "Enter the confirmation code sent to your phone for payment.");
							if(input == null || input == "" || !input.equals(approveCode)) {
								JOptionPane.showMessageDialog(null, "Failed ! You have the last " + i + " attempts left.", "Error !", JOptionPane.ERROR_MESSAGE);
								isOk = false;
							}
							else {
								isOk = true;
								break;
							}
						}
						
						if(!isOk) {
							JOptionPane.showMessageDialog(null, "Payment not received !", "Error !", JOptionPane.ERROR_MESSAGE);
						}
						
						Payment payment = new Payment(orderId, date, 0, isOk, approveCode, totalPrice);
						
						boolean paymentIsAddedToDB = controller.addPayment(payment);
						
						if(!paymentIsAddedToDB) {
							JOptionPane.showMessageDialog(null, "Payment not received !", "Error !", JOptionPane.ERROR_MESSAGE);
						}
						else if (orderId != -1 && controlOfStockNumbers()){
							int cargoFicheNum = rndC.getRandomNumber(100000000, 999999999);
							Invoice invoice = new Invoice(orderId, addressId, date, cargoFicheNum, totalPrice);
							int invoiceId = controller.addInvoice(invoice);
							OrderDetail tempOrderDetail = null;
							int tempLastInsertedOrderDetailId;
							boolean toggle = false;;
							for(CartItem cartItem : cart.getItems()) {
								tempOrderDetail = new OrderDetail(
										orderId,
										cartItem.getId(),
										cartItem.getPrice(),
										cartItem.getAmount(),
										(float)cartItem.getAmount() * cartItem.getPrice());
								tempLastInsertedOrderDetailId = controller.addOrderDetail(tempOrderDetail);
								
								if(tempLastInsertedOrderDetailId != -1) {
									if(invoiceId == - 1) {
										System.out.println("Invoice Oluşturulamamış!!");
									}
									else {
										InvoiceDetail invoiceDetail = new InvoiceDetail(
												invoiceId,
												tempLastInsertedOrderDetailId, 
												cartItem.getId(), 
												cartItem.getPrice(), 
												cartItem.getAmount(),
												(float)cartItem.getAmount() * cartItem.getPrice());
										boolean invoiceDetailIsAddedToDb = controller.addInvoiceDetail(invoiceDetail);
										
										if(!invoiceDetailIsAddedToDb) {
											System.out.println("Failed !!! Invoice was not created !!!");
										}
										else {
											toggle = true;
											System.out.println("Invoice detail was successfully created.");
											
											if(controller.reduceStockNumber(cartItem.getId(), cartItem.getAmount())) {
												System.out.println("Reduce stock number operation is successfully.");
											}
											
										}
									}
								}
								else {
									System.out.println("Item Id : " + cartItem.getId() + " Failed to create order detail!");
								}
							}
							
							if(toggle) {
								DeliveryAndPaymentPage.this.dispose();
								new OrderReceivedPage(
										new OrderReceivedPageItemElement(orderNumber,
												DeliveryAndPaymentPage.this
												.registeredAddresses.get(DeliveryAndPaymentPage.this.selectedAddressIndex),
												totalPrice,
												DeliveryAndPaymentPage.this
												.registeredCards.get(DeliveryAndPaymentPage.this.selectedCardIndex).getCardNumber()),
										DeliveryAndPaymentPage.this.referenceOfHomePage);
								ShoppingCart.getCart().emptyTheCart();
							}
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Card and Address Field cannot be empty !", "Error !", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(10, 170, 298, 42);
		panel_7.add(btnNewButton_2);
		
		fillTheRegisteredAddressLabel(0);
		fillTheRegisteredCardLabel(0);
	}
	
	protected void fillTheRegisteredAddressLabel(int addressIndex) {
		
		if(this.registeredAddresses !=  null && this.registeredAddresses.size() > 0) {
			Address a = this.registeredAddresses.get(addressIndex);
			lblSelectedAddress.setText(a.getAddressTitle() + " / " + a.getCity() + " / " + a.getTown());
			this.selectedAddressIndex = addressIndex;
		}
		else {
			lblSelectedAddress.setText("No registered address.");
			this.selectedAddressIndex = - 1;
		}
		
	}
	
	protected boolean controlOfStockNumbers() {
		DeliveryAndPaymentPageController instance = DeliveryAndPaymentPageController.getInstance();
		for(CartItem item : cart.getItems()) {
			int stockNumber = instance.getStockNumberOfGivenItem(item.getId());
			if(stockNumber < item.getAmount()) {
				JOptionPane.showMessageDialog(null, "You can purchase a maximum of " + stockNumber + " of " + item.getInformation() + ".", "Error!", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
	protected void fillTheRegisteredCardLabel(int cardIndex) {
		if(this.registeredCards != null && this.registeredCards.size() > 0) {
			Card card = this.registeredCards.get(cardIndex);
			lblSelectedCardName.setText(card.getNameAndSurnameOnTheCard());
			lblSelectedCardNum.setText(card.getCardNumber());
			this.selectedCardIndex = cardIndex;
		}
		else {
			lblSelectedCardName.setText("No registered card.");
			lblSelectedCardNum.setText("XXXX XXXX XXXX XXXX");
			this.selectedCardIndex = - 1;
		}
	}
}
