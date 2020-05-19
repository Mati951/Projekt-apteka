package Menu;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import database.*;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class Rejestracja {

	private JFrame frame;
	private JLabel lblWitamyWRejestracji;
	private JLabel lblPodajSwojeImie;
	private JTextField txtImie;
	private JTextField txtNazwisko;
	private JPasswordField pwdHaslo;
	private final Action action = new SwingAction();
	private JLabel lblPodajNazweUzytkownia;
	private JTextField textField;
	private JButton btnMenuGlowne;
	private final Action action_1 = new SwingAction_1();
	private JTextField txtWiek;

	
	public Rejestracja() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle(GlowneMenu.title);
		frame.setBounds(GlowneMenu.center.x - GlowneMenu.screenSize.width/4 , GlowneMenu.center.y - GlowneMenu.screenSize.height/4, 600, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblWitamyWRejestracji = new JLabel("Witamy w rejestracji do systemu naszej Apteki");
		
		lblPodajSwojeImie = new JLabel("Podaj swoje imie:");
		
		txtImie = new JTextField();
		txtImie.setColumns(10);
		
		txtNazwisko = new JTextField();
		txtNazwisko.setColumns(10);
		
		pwdHaslo = new JPasswordField();
		
		JLabel lblPodajSowjeNazwisko = new JLabel("Podaj swoje nazwisko:");
		
		JLabel lblPodajHaslo = new JLabel("Podaj Haslo:");
		
		JButton btnZarejestruj = new JButton("Zarejestruj");
		btnZarejestruj.setAction(action);
		
		lblPodajNazweUzytkownia = new JLabel("Podaj nazwe uzytkownia:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		btnMenuGlowne = new JButton("Menu glowne");
		btnMenuGlowne.setAction(action_1);
		
		txtWiek = new JTextField();
		txtWiek.setColumns(10);
		
		JLabel lblWiek = new JLabel("Wiek:");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnZarejestruj)
					.addPreferredGap(ComponentPlacement.RELATED, 402, Short.MAX_VALUE)
					.addComponent(btnMenuGlowne))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblWiek)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtWiek, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblWitamyWRejestracji)
								.addComponent(lblPodajSwojeImie)
								.addComponent(lblPodajSowjeNazwisko, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPodajHaslo)
								.addComponent(lblPodajNazweUzytkownia))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(pwdHaslo)
								.addComponent(txtNazwisko)
								.addComponent(textField)
								.addComponent(txtImie))))
					.addContainerGap(271, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblWitamyWRejestracji)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPodajSwojeImie)
						.addComponent(txtImie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPodajSowjeNazwisko)
						.addComponent(txtNazwisko, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPodajNazweUzytkownia)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPodajHaslo)
						.addComponent(pwdHaslo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblWiek)
							.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnMenuGlowne)
								.addComponent(btnZarejestruj)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtWiek, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}
	private class SwingAction extends AbstractAction {
		private Klient klient = new Klient();
		public SwingAction() {
			putValue(NAME, "Zarejestruj");
			putValue(SHORT_DESCRIPTION, "Przesyla dane do bazy i umozliwia zalogowanie");
		}
		public void actionPerformed(ActionEvent e) {
			klient.setImie(txtImie.getText());
			klient.setHaslo(pwdHaslo.getPassword());
			klient.setNazwaU(textField.getText());
			klient.setNazwisko(txtNazwisko.getText());
			klient.setTyp(Typ.KLIENT);
			klient.setWiek(Integer.parseInt(txtWiek.getText()));
			klient.setId_klient(0);
			klient.setId(0);
			try {
				klient.dodajUzytkownikaDB();
			} catch (Exception e1) {
				System.out.println("Adding klient to database Exception");
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
}
