package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.AdminPageController;
import model.Invoice;
import util.CenteredTableCellRenderer;

import javax.swing.JTable;

@SuppressWarnings("serial")
public class ListInvoicesView extends JPanel {
	
	private CenteredTableCellRenderer cellModel;
	
	private JTable table;

	DefaultTableModel model;
	
	/**
	 * Create the panel.
	 */
	public ListInvoicesView() {
		
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
				"Order ID", "Address ID", "Payment Date", "Cargo Fiche Number", "Total Price"
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
		
		AdminPageController controller = AdminPageController.getInstance();
		ArrayList<Invoice> invoices = controller.getInvoices();
		for(Invoice invoice : invoices) {
			Object[] row = {invoice.getOrderId(), invoice.getAddressId(), invoice.getDate(),
					invoice.getCargoFicheNum(), invoice.getTotalPrice()};
			model.addRow(row);
		}
	}

}
