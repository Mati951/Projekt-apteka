package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

import database.Farmaceuta;
import database.Kasa;
import database.Kierownik;
import database.Typ;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class KierownikMenu {

	private JFrame frame;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private final Action action_6 = new SwingAction_6();
	private JTextArea txtrImie;
	private JPasswordField passwordField;
	private JTextField textField;
	private Kierownik kierownik = new Kierownik();

	public KierownikMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle(GlowneMenu.title);
		frame.setBounds(100, 100, 800, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnZatrudnij = new JButton("Zatrudnij");
		btnZatrudnij.setAction(action_1);
		btnZatrudnij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnZwolnij = new JButton("Zwolnij");
		btnZwolnij.setAction(action_2);
		
		JButton btnStowrzNoweZamowienie = new JButton("Stowrz nowe zamowienie");
		btnStowrzNoweZamowienie.setAction(action_3);
		
		JButton btnUaktualnijdane = new JButton("UaktualnijDane");
		btnUaktualnijdane.setAction(action_4);
		
		JButton btnOproznijKase = new JButton("Oproznij Kase");
		btnOproznijKase.setAction(action_5);
		
		JButton button = new JButton("GlowneMenu");
		button.setAction(action);
		
		txtrImie = new JTextArea();
		txtrImie.setToolTipText("Najedz na odpowiedni przycisk po wiecej informacji.");
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Haslo:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNazwaUzytkownika = new JLabel("Nazwa uzytkownika");
		
		JLabel lblHaslo = new JLabel("Haslo:");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnOproznijKase, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnUaktualnijdane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnStowrzNoweZamowienie, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnZwolnij, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnZatrudnij, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(txtrImie, GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNazwaUzytkownika)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(lblHaslo)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnZatrudnij)
							.addGap(3)
							.addComponent(btnZwolnij)
							.addGap(5)
							.addComponent(btnStowrzNoweZamowienie)
							.addGap(5)
							.addComponent(btnUaktualnijdane)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnOproznijKase))
						.addComponent(txtrImie, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHaslo)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNazwaUzytkownika))
					.addGap(37)
					.addComponent(button)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		frame.setVisible(true);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Menu Glowne");
			putValue(SHORT_DESCRIPTION, "Powrot do glownego menu");
		}

		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			GlowneMenu window = new GlowneMenu();
		}
	}
	private class SwingAction_1 extends AbstractAction {
		private Farmaceuta farm = new Farmaceuta();
		public SwingAction_1() {
			putValue(NAME, "Zatrudnij");
			putValue(SHORT_DESCRIPTION, "Podaj wszystkie dane w odpowiedniej kolejnosci, Kolejnosc: Imie, Nazwisko, Wiek, Wynagrodzenie, Konto");
		}
		public void actionPerformed(ActionEvent e) {
			String[] lines = txtrImie.getText().split("\n");
			farm.setImie(lines[0]);
			farm.setNazwisko(lines[1]);
			farm.setNazwaU(textField.getText());
			farm.setHaslo(passwordField.getPassword());
			farm.setWiek(Integer.parseInt(lines[3]));
			try {
				farm.setWynagrodzenie(Integer.parseInt(lines[4]));
		   }catch (NumberFormatException e1){
		       System.out.println("Not a number"); 
		   } 
			farm.setKontoBankowe(lines[5]);
			farm.setTyp(Typ.FARMACEUTA);
			farm.setId_farmaceuta(0);
			farm.setId(0);
			try {
				farm.dodajUzytkownikaDB();
			} catch (Exception e1) {
				System.out.println("Exception w dodawaniu farmaceuty do bazy danych");
				e1.printStackTrace();
			}
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Zwolnij");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Zamow produkty");
			putValue(SHORT_DESCRIPTION, "Tutaj zamowisz produkty do magazynu");
		}
		public void actionPerformed(ActionEvent e) {
			String[] lines = txtrImie.getText().split(" ");
			try {
				
				txtrImie.setText(kierownik.zlozZamowienie(lines));
			} catch (Exception e1) {
				System.out.println("Exception w skladaniu zamowienia przez kierownika");
				e1.printStackTrace();
			}
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Uaktualnij dane");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "Oproznij kase");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				kierownik.podsumowanie();
			} catch (Exception e1) {
				System.out.println("Blad w podsumowaniu");
				e1.printStackTrace();
			}
		}
	}
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "Podsumowanie");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
