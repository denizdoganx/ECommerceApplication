package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;

import controller.AdminPageController;
import model.Item;
import util.FormatController;
import util.ImageObject;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AddItemView extends JPanel {
	private JTextField itemCode;
	private JTextField itemName;
	private JTextField unitPrice;
	private JTextField brand;
	private JTextField category4;
	private JTextField category1;
	private JTextField category2;
	private JTextField category3;
	private JLabel lblNewLabel_8;
	private JTextField stockNumber;
	private JLabel labelImage1;
	private JLabel labelImage2;
	private JLabel labelImage3;
	private JLabel labelImage4;
	private JPanel panelImage1;
	private JPanel panelImage2;
	private JPanel panelImage3;
	private JPanel panelImage4;
	private ImageObject selectedImage1 = null;
	private ImageObject selectedImage2 = null;
	private ImageObject selectedImage3 = null;
	private ImageObject selectedImage4 = null;
	private JButton btnImage1;
	private JButton btnImage2;
	private JButton btnImage3;
	private JButton btnImage4;
	/**
	 * Create the panel.
	 */
	public AddItemView() {
		setBackground(new Color(249, 251, 231));
		setLayout(null);
		setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(249, 251, 231));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(388, 11, 380, 748);
		add(panel);
		panel.setLayout(new GridLayout(13, 1, 6, 10));
		
		itemCode = new JTextField();
		panel.add(itemCode);
		itemCode.setColumns(10);
		
		itemName = new JTextField();
		panel.add(itemName);
		itemName.setColumns(10);
		
		unitPrice = new JTextField();
		panel.add(unitPrice);
		unitPrice.setColumns(10);
		
		brand = new JTextField();
		panel.add(brand);
		brand.setColumns(10);
		
		category1 = new JTextField();
		panel.add(category1);
		category1.setColumns(10);
		
		category2 = new JTextField();
		panel.add(category2);
		category2.setColumns(10);
		
		category3 = new JTextField();
		panel.add(category3);
		category3.setColumns(10);
		
		category4 = new JTextField();
		panel.add(category4);
		category4.setColumns(10);
		
		stockNumber = new JTextField();
		panel.add(stockNumber);
		stockNumber.setColumns(10);
		
		panelImage1 = new JPanel();
		panelImage1.setVisible(false);
		panelImage1.setBackground(new Color(249, 251, 231));
		panel.add(panelImage1);
		panelImage1.setLayout(null);
		
		labelImage1 = new JLabel("");
		labelImage1.setBounds(0, 0, 261, 47);
		panelImage1.add(labelImage1);
		
		btnImage1 = new JButton("Remove");
		btnImage1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelImage1.setVisible(false);
				labelImage1.setText("");
				AddItemView.this.selectedImage1 = null;
			}
		});
		btnImage1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnImage1.setBounds(271, 0, 99, 47);
		panelImage1.add(btnImage1);
		
		panelImage2 = new JPanel();
		panelImage2.setVisible(false);
		panelImage2.setBackground(new Color(249, 251, 231));
		panel.add(panelImage2);
		panelImage2.setLayout(null);
		
		labelImage2 = new JLabel("");
		labelImage2.setBounds(0, 0, 260, 47);
		panelImage2.add(labelImage2);
		
		btnImage2 = new JButton("Remove");
		btnImage2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelImage2.setVisible(false);
				labelImage2.setText("");
				AddItemView.this.selectedImage2 = null;
			}
		});
		btnImage2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnImage2.setBounds(271, 0, 99, 47);
		panelImage2.add(btnImage2);
		
		panelImage3 = new JPanel();
		panelImage3.setVisible(false);
		panelImage3.setBackground(new Color(249, 251, 231));
		panel.add(panelImage3);
		panelImage3.setLayout(null);
		
		labelImage3 = new JLabel("");
		labelImage3.setBounds(0, 0, 260, 47);
		panelImage3.add(labelImage3);
		
		btnImage3 = new JButton("Remove");
		btnImage3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelImage3.setVisible(false);
				labelImage3.setText("");
				AddItemView.this.selectedImage3 = null;
			}
		});
		btnImage3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnImage3.setBounds(271, 0, 99, 47);
		panelImage3.add(btnImage3);
		
		panelImage4 = new JPanel();
		panelImage4.setVisible(false);
		panelImage4.setBackground(new Color(249, 251, 231));
		panel.add(panelImage4);
		panelImage4.setLayout(null);
		
		labelImage4 = new JLabel("");
		labelImage4.setBounds(0, 0, 260, 47);
		panelImage4.add(labelImage4);
		
		btnImage4 = new JButton("Remove");
		btnImage4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelImage4.setVisible(false);
				labelImage4.setText("");
				AddItemView.this.selectedImage4 = null;
			}
		});
		btnImage4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnImage4.setBounds(271, 0, 99, 47);
		panelImage4.add(btnImage4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(249, 251, 231));
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBounds(66, 11, 291, 577);
		add(panel_1);
		panel_1.setLayout(new GridLayout(10, 1, 6, 10));
		
		JLabel lblNewLabel_1 = new JLabel("Item Code : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Item Name : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Unit Price : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Brand : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Category 1 : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Category 2 : ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Category 3 : ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Category 4 : ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("Number Of Stock : ");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNewLabel_9);
		
		JButton btnNewButton_2 = new JButton("Select Image");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				
				int response = fileChooser.showOpenDialog(null);
				
				if(response == JFileChooser.APPROVE_OPTION) {
					if(labelImage1.getText().isEmpty()) {
						panelImage1.setVisible(true);
						labelImage1.setText(fileChooser.getSelectedFile().getName());
						AddItemView.this.selectedImage1 = new ImageObject(fileChooser.getSelectedFile());
					}
					else if(labelImage2.getText().isEmpty()) {
						panelImage2.setVisible(true);
						labelImage2.setText(fileChooser.getSelectedFile().getName());
						AddItemView.this.selectedImage2 = new ImageObject(fileChooser.getSelectedFile());
					}
					else if(labelImage3.getText().isEmpty()) {
						panelImage3.setVisible(true);
						labelImage3.setText(fileChooser.getSelectedFile().getName());
						AddItemView.this.selectedImage3 = new ImageObject(fileChooser.getSelectedFile());
					}
					else if(labelImage4.getText().isEmpty()) {
						panelImage4.setVisible(true);
						labelImage4.setText(fileChooser.getSelectedFile().getName());
						AddItemView.this.selectedImage4 = new ImageObject(fileChooser.getSelectedFile());
					}
					else {
						JOptionPane.showMessageDialog(null, "You can add up to 4 images.", "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnAddButton = new JButton("Add");
		btnAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread threadOfAddItemOperation = new Thread() {
					public void run() {
						if(!labelImage1.getText().isEmpty() || !labelImage2.getText().isEmpty()
								|| !labelImage3.getText().isEmpty() || !labelImage4.getText().isEmpty()) {
							try {
								//String unitPriceTextForm = unitPrice.getText();
								//String numberOfStock = stockNumber.getText();

								Item item = new Item(
										itemCode.getText(),
										itemName.getText(),
										Float.parseFloat(unitPrice.getText()),
										brand.getText(),
										category1.getText(),
										category2.getText(),
										category3.getText(),
										category4.getText(),
										Integer.valueOf(stockNumber.getText())
										);
								if(FormatController.checkItem(item)) {
									AdminPageController instance = AdminPageController.getInstance();
									int lastInsertedId = instance.addItem(item);

									if(lastInsertedId != -1) {
										ArrayList<ImageObject> selectedImages = new ArrayList<>();
										if(AddItemView.this.selectedImage1 != null) {
											AddItemView.this.selectedImage1.setItemID(lastInsertedId);
											selectedImages.add(AddItemView.this.selectedImage1);
										}
										if(AddItemView.this.selectedImage2 != null) {
											AddItemView.this.selectedImage2.setItemID(lastInsertedId);
											selectedImages.add(AddItemView.this.selectedImage2);
										}
										if(AddItemView.this.selectedImage3 != null) {
											AddItemView.this.selectedImage3.setItemID(lastInsertedId);
											selectedImages.add(AddItemView.this.selectedImage3);
										}
										if(AddItemView.this.selectedImage4 != null) {
											AddItemView.this.selectedImage4.setItemID(lastInsertedId);
											selectedImages.add(AddItemView.this.selectedImage4);
										}
										boolean result = instance.addImages(selectedImages);
										if(result) {
											AddItemView.this.resetButton();
											lblNewLabel_8.setText("The Item has been succesfully added.");
											lblNewLabel_8.setForeground(Color.green);
										}
										else {
											System.out.println("Item is added but images could not be added to db.");
										}
									}
									else {
										lblNewLabel_8.setText("The product could not be added !");
										lblNewLabel_8.setForeground(Color.red);
									}
									lblNewLabel_8.setVisible(true);
								}
							}
							catch(Exception e) {
								JOptionPane.showMessageDialog(null, "Do not enter text in the number fields. ", "Error!", JOptionPane.ERROR_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "You must add at least one image.", "Warning!", JOptionPane.ERROR_MESSAGE);
						}
					}
				};
				threadOfAddItemOperation.start();
			}
		});
		btnAddButton.setFocusable(false);
		btnAddButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddButton.setBounds(629, 770, 139, 43);
		add(btnAddButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddItemView.this.resetButton();
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(389, 770, 139, 43);
		add(btnNewButton_1);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(10, 734, 370, 56);
		add(lblNewLabel_8);

	}

	private void resetButton() {
		itemCode.setText("");
		itemName.setText("");
		unitPrice.setText("");
		brand.setText("");
		category1.setText("");
		category2.setText("");
		category3.setText("");
		category4.setText("");
		stockNumber.setText("");
		btnImage1.doClick();
		btnImage2.doClick();
		btnImage3.doClick();
		btnImage4.doClick();
	}
}
