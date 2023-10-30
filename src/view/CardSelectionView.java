package view;

import javax.swing.JPanel;

import model.Card;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CardSelectionView extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private DeliveryAndPaymentPage deliveryAndPaymentPage;
	private Card card;
	public CardSelectionView(Card card, DeliveryAndPaymentPage deliveryAndPaymentPage) {
		this.deliveryAndPaymentPage = deliveryAndPaymentPage;
		this.card = card;
		setVisible(true);
		setLayout(new GridLayout(1, 1, 0, 0));
		
		JButton btnNewButton = new JButton(card.getNameAndSurnameOnTheCard() + "      " + card.getCardNumber());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardSelectionView.this.deliveryAndPaymentPage.fragmentPanel2.removeAll();
				CardSelectionView.this.deliveryAndPaymentPage.fragmentPanel2.revalidate();
				CardSelectionView.this.deliveryAndPaymentPage.fragmentPanel2.repaint();
				CardSelectionView.this.deliveryAndPaymentPage.fillTheRegisteredCardLabel(
						CardSelectionView.this.deliveryAndPaymentPage.registeredCards.indexOf(CardSelectionView.this.card));
			}
		});
		add(btnNewButton);

	}
}
