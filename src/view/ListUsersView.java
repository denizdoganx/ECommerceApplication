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
import model.User;
import util.CenteredTableCellRenderer;

@SuppressWarnings("serial")
public class ListUsersView extends JPanel {
	
	private JTable table;
	/**
	 * Create the panel.
	 */
	private CenteredTableCellRenderer cellModel;
	
	DefaultTableModel model;
	
	public ListUsersView() {
		
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
				"Username", "Name", "Surname", "Email", "Gender", "Phone"
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
		ArrayList<User> users = controller.getUsers();
		for(User user : users) {
			String gender = null;
			if(user.getGender().equals("m")) {
				gender = "Male";
			}
			else {
				gender = "Female";
			}
			Object[] row = {user.getUsername(), user.getName(),
					user.getSurname(), user.getEmail(), gender, user.getPhone()};
			model.addRow(row);
		}
	}

}
