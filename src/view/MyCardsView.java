package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.MyAccountPageController;
import model.Card;
import util.CenteredTableCellRenderer;

@SuppressWarnings("serial")
public class MyCardsView extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private CenteredTableCellRenderer cellModel;
	
	private JTable table;

	DefaultTableModel model;
	
	private int userId;
	
	public MyCardsView(int userId) {

		this.userId = userId;
		cellModel = new CenteredTableCellRenderer();
		

		
		setBorder(new EmptyBorder(40, 40, 40, 40));
		setBackground(new Color(249, 251, 231));
		setLayout(new GridLayout(1, 1, 40, 40));
		
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(40);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Card Number", "Name and Surname on the Card", "Expiration Date", "Security Number"
			}
		));
		
		model = (DefaultTableModel) table.getModel();
		
		scrollPane.setViewportView(table);
		
		initTable();
	}
	
	private void initTable() {
		
		for(int i = 0;i < table.getColumnModel().getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(cellModel);
		}
		
		MyAccountPageController controller = MyAccountPageController.getInstance();
		ArrayList<Card> cards = controller.getCards(this.userId);
		for(Card card : cards) {
			Object[] row = {card.getCardNumber(), card.getNameAndSurnameOnTheCard(), card.getExpirationDate(),
					card.getSecurityNumber()};
			model.addRow(row);
		}
	}

}
