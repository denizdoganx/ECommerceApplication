package view;

import javax.swing.JPanel;

import model.Address;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AddressSelectionView extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private DeliveryAndPaymentPage deliveryAndPaymentPage;
	private Address address;
	
	public AddressSelectionView(Address address, DeliveryAndPaymentPage deliveryAndPaymentPage) {
		this.address = address;
		this.deliveryAndPaymentPage = deliveryAndPaymentPage;
		
		setVisible(true);
		setLayout(new GridLayout(1, 1, 0, 0));
		
		JButton btnNewButton = new JButton(address.getAddressTitle() + " / " + address.getCity() + " / " + address.getTown());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddressSelectionView.this.deliveryAndPaymentPage.fragmentPanel1.removeAll();
				AddressSelectionView.this.deliveryAndPaymentPage.fragmentPanel1.revalidate();
				AddressSelectionView.this.deliveryAndPaymentPage.fragmentPanel1.repaint();
				AddressSelectionView.this.deliveryAndPaymentPage.fillTheRegisteredAddressLabel(
						AddressSelectionView.this.deliveryAndPaymentPage.registeredAddresses.indexOf(AddressSelectionView.this.address));
			}
		});
		add(btnNewButton);

	}

}
