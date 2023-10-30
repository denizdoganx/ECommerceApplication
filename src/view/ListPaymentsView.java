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

import controller.AdminPageController;
import model.Payment;
import util.CenteredTableCellRenderer;

@SuppressWarnings("serial")
public class ListPaymentsView extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private CenteredTableCellRenderer cellModel;
	
	private JTable table;

	DefaultTableModel model;
	
	public ListPaymentsView() {

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
				"Order ID", "Payment Date", "Payment Type", "Is Ok", "Approve Code", "Payment Total"
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
		ArrayList<Payment> payments = controller.getPayments();
		for(Payment payment : payments) {
			String paymentType = null;
			
			if(payment.getPaymentType() == 0) {
				paymentType = "Card";
			}
			else {
				paymentType = "Cash";
			}
			Object[] row = {payment.getOrderId(), payment.getDate(), paymentType,
					payment.isOk(), payment.getApproveCode(), payment.getPaymentTotal()};
			model.addRow(row);
		}
	}

}
