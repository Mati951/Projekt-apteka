package Menu;

import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import database.Farmaceuta;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class FarmaceutaMenu {

	private JFrame frame;
	private Farmaceuta far = new Farmaceuta();
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private JTextArea textArea;
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private JLabel lblPomoc;
	/**
	 * Create the application.
	 */
	public FarmaceutaMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle(GlowneMenu.title);
		frame.setBounds(100, 100, 800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnSprzedaj = new JButton("Sprzedaj");
		btnSprzedaj.setAction(action);
		
		JButton button = new JButton("GlowneMenu");
		button.setAction(action_1);
		
		JButton btnNewButton = new JButton("Wyswietl oczekujace zamowienia");
		btnNewButton.setAction(action_2);
		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JButton btnOtworzzamknijKase = new JButton("Otworz / Zamknij kase");
		btnOtworzzamknijKase.setAction(action_3);
		
		lblPomoc = new JLabel("Pomoc:");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(677, Short.MAX_VALUE)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnOtworzzamknijKase, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSprzedaj, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPomoc)
								.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(8)
							.addComponent(btnSprzedaj)
							.addGap(9)
							.addComponent(btnOtworzzamknijKase))
						.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPomoc)
					.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
					.addComponent(button)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		
		frame.setVisible(true);
	}
	private class SwingAction extends AbstractAction {
		
		public SwingAction() {
			putValue(NAME, "Obsluga zamowien");
			putValue(SHORT_DESCRIPTION, "Podaj id zamowienia do obslugi");
		}
		public void actionPerformed(ActionEvent e) {
			Integer zId = Integer.parseInt(textArea.getText());
			try {
				textArea.setText(far.obsluzZamowienie(zId));
			} catch (Exception e1) {
				System.out.println("Exception w w oblsudze zamowien");
				e1.printStackTrace();
			}
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Menu Glowne");
			putValue(SHORT_DESCRIPTION, "Powrot do glownego menu");
		}

		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			GlowneMenu window = new GlowneMenu();
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Wyswietl oczekujace zamowienia");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				textArea.setText(far.oczekujaceZamowienia());
			} catch (Exception e1) {
				System.out.println("Exception w wypisywaniu zamowien");
				e1.printStackTrace();
			}
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Otoworz / Zamknij kase");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				textArea.setText(far.kasaOZ());
			} catch (Exception e1) {
				System.out.println("Exception w otwarciu / zamknieciu kasy");
				e1.printStackTrace();
			}
		}
	}
}
