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
import util.CenteredTableCellRenderer;
import util.MyOrdersViewOrderElement;

@SuppressWarnings("serial")
public class MyOrdersView extends JPanel {

	/**
	 * Create the panel.
	 */
	private CenteredTableCellRenderer cellModel;
	
	private JTable table;

	DefaultTableModel model;
	
	private int userId;
	
	public MyOrdersView(int userId) {

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
				"Order Date", "Total Price", "Order Status", "Order Number", "Address"
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
		ArrayList<MyOrdersViewOrderElement> orders = controller.getOrders(this.userId);
		for(MyOrdersViewOrderElement order : orders) {
			String orderStatus = null;
			if(order.getOrderStatus() == 0) {
				orderStatus = "Getting Ready";
			}
			else if(order.getOrderStatus() == 1) {
				orderStatus = "In Cargo";
			}
			else {
				orderStatus = "Was Delivered";
			}
			Object[] row = {order.getDate(), order.getTotalPrice(), orderStatus,
					order.getOrderNumber(), order.getAddressString()};
			model.addRow(row);
		}
	}

}
