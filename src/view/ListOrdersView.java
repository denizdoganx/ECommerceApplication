package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.AdminPageController;
import model.Order;
import util.CenteredTableCellRenderer;

import java.awt.Font;

@SuppressWarnings("serial")
public class ListOrdersView extends JPanel {
	
	private JTable table;
	/**
	 * Create the panel.
	 */
	private CenteredTableCellRenderer cellModel;
	
	DefaultTableModel model;
	public ListOrdersView() {
		
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
				"User ID", "Order Date", "Total Price", "Order Status", "Order Number"
			}
		));
		model = (DefaultTableModel)table.getModel();
		scrollPane.setViewportView(table);
		initTable();
	}
	
	private void initTable() {
		
		for(int i = 0;i < table.getColumnModel().getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(cellModel);
		}
		
		AdminPageController controller = AdminPageController.getInstance();
		ArrayList<Order> orders = controller.getOrders();
		for(Order order : orders) {
			String orderStatus = null;
			if(order.getStatus() == 0) {
				orderStatus = "Getting Ready";
			}
			else if(order.getStatus() == 1) {
				orderStatus = "In Cargo";
			}
			else {
				orderStatus = "Was Delivered";
			}
			Object[] row = {order.getUserId(), order.getDate(),
					order.getTotalPrice(), orderStatus, order.getOrderNumber()};
			model.addRow(row);
		}
	}
}
