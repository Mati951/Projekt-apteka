package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import database.ConnectToDB;
import database.Klient;
import database.Typ;
import database.Uzytkownik;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.Action;

public class Logowanie {

	static JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	public final Uzytkownik user = new Uzytkownik();

	public Logowanie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle(GlowneMenu.title);
		frame.setBounds(GlowneMenu.center.x - GlowneMenu.screenSize.width / 4,
				GlowneMenu.center.y - GlowneMenu.screenSize.height / 4, 600, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblProszSiZalogowa = new JLabel("Prosz\u0119 si\u0119 zalogowa\u0107");

		JLabel lblPodajNazweUzytkownika = new JLabel("Podaj nazwe uzytkownika:");

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblPodajHaslo = new JLabel("Podaj haslo:");

		passwordField = new JPasswordField();

		JButton btnZaloguj = new JButton("Zaloguj");
		btnZaloguj.setAction(action);

		JButton btnZapomnialemHaso = new JButton("Zapomnialem has\u0142o");
		btnZapomnialemHaso.setAction(action_2);

		JButton btnNiePosiadamKonta = new JButton("Nie posiadam konta");
		btnNiePosiadamKonta.setAction(action_1);

		JButton btnGlowneMenu = new JButton("Glowne menu");
		btnGlowneMenu.setAction(action_3);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(162)
							.addComponent(lblProszSiZalogowa))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPodajNazweUzytkownika)
								.addComponent(lblPodajHaslo))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))))
					.addGap(171))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnZaloguj)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnZapomnialemHaso)
					.addGap(103)
					.addComponent(btnGlowneMenu)
					.addPreferredGap(ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
					.addComponent(btnNiePosiadamKonta))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblProszSiZalogowa)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPodajNazweUzytkownika)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPodajHaslo)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnZaloguj)
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnZapomnialemHaso)
						.addComponent(btnGlowneMenu)
						.addComponent(btnNiePosiadamKonta)))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}

	private class SwingAction extends AbstractAction {
		private String login;
		private char[] haslo;
		private Typ typ;
		private char[] input;

		

		public SwingAction() {
			putValue(NAME, "Zaloguj");
			putValue(SHORT_DESCRIPTION, "Loguje do aplikacji");
		}

		public void actionPerformed(ActionEvent e) {
			try {
				ConnectToDB.polacz();

				Statement st = ConnectToDB.con.createStatement();
				ResultSet rs = st.executeQuery("Select nazwau, haslo, typ, imie, nazwisko from uzytkownik");
				while (rs.next()) {
					user.setNazwaU(rs.getString(1));
					user.setHaslo(rs.getString(2).toCharArray());
					user.setTyp(Typ.valueOf(rs.getString(3)));
					user.setImie(rs.getString(4));
					user.setNazwisko(rs.getString(5));
					login = user.getNazwaU();
					typ = user.getTyp();
					input = passwordField.getPassword();
					String haslo = new String(input);
					System.out.println(login + " " + haslo + " " + typ);
					if (login.equals(textField.getText()) && isPasswordCorrect(input)) {
						switch (typ) {
						case KIEROWNIK:
							frame.dispose();
							KierownikMenu kierWindow = new KierownikMenu();
							break;
						case FARMACEUTA:
							frame.dispose();
							FarmaceutaMenu farWindow = new FarmaceutaMenu();
							break;
						case KLIENT:
							frame.dispose();
							KlientMenu kliWindow = new KlientMenu();
						default:
							frame.dispose();
						}
						break;
					}
				}
				ConnectToDB.rozlacz();
			} catch (Exception e1) {
				System.out.println("checking user from database Exception");
				e1.printStackTrace();
			}
			if (isPasswordCorrect(input)) {
				Error error = new Error();
			}
		}

		private boolean isPasswordCorrect(char[] input) {
			boolean isCorrect = true;
			char[] correctPassword = user.getHaslo();
			;

			if (input.length != correctPassword.length) {
				isCorrect = false;
			} else {
				isCorrect = Arrays.equals(input, correctPassword);
			}

			// Zero out the password.
			Arrays.fill(correctPassword, '0');

			return isCorrect;
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Nie posiadam konta");
			putValue(SHORT_DESCRIPTION, "Przenosi do rejestracji");
		}

		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			Rejestracja window = new Rejestracja();
		}
	}

	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Zapomnialem hasla");
			putValue(SHORT_DESCRIPTION, "Przechodzi do okna z odnawianiem hasla");
		}

		public void actionPerformed(ActionEvent e) {
			OdnowHaslo window = new OdnowHaslo();
		}
	}

	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Menu Glowne");
			putValue(SHORT_DESCRIPTION, "Powrot do glownego menu");
		}

		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			GlowneMenu window = new GlowneMenu();
		}
	}
}
