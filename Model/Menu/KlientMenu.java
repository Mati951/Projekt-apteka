package Menu;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import database.ConnectToDB;
import database.Klient;
import database.Produkty;
import database.Typ;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Action;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Scrollbar;
import java.awt.event.ActionListener;

public class KlientMenu {

	private JFrame frame;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private JTextArea txtTuWyswietliSi;
	private final Action action_4 = new SwingAction_4();
	private JTextArea txtPodajNazweLeku;
	private JTextArea txtrTuWyswietlaSie;
	private final Action action_5 = new SwingAction_5();


	public KlientMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle(GlowneMenu.title);
		frame.setBounds(GlowneMenu.center.x - GlowneMenu.screenSize.width/4 , GlowneMenu.center.y - GlowneMenu.screenSize.height/4, 800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblCoChceszZrobic = new JLabel("Co chcesz zrobic?");
		
		JButton btnKupLeki = new JButton("Wswietl dostepne produkty");
		btnKupLeki.setAction(action_1);
		
		JButton btnZamowLeki = new JButton("Zamow leki");
		btnZamowLeki.setAction(action_2);
		
		JButton btnSprawdzDostepnosc = new JButton("Sprawdz dostepnosc");
		btnSprawdzDostepnosc.setAction(action_3);
		
		JButton btnNewButton = new JButton("GlowneMenu");
		btnNewButton.setAction(action);
		
		txtTuWyswietliSi = new JTextArea();
		txtTuWyswietliSi.setText("Tu wyswietli sie dostepnosc twojego leku\nPodaj jego nazwe.");
		txtTuWyswietliSi.setColumns(10);
		
		JButton btnWyczyscPole = new JButton("Wyczysc Pola");
		btnWyczyscPole.setAction(action_4);
		
		txtPodajNazweLeku = new JTextArea();
		txtPodajNazweLeku.setText("Podaj nazwe leku i po spacji ilosc");
		txtPodajNazweLeku.setColumns(10);
		
		txtrTuWyswietlaSie = new JTextArea();
		JScrollPane scroll = new JScrollPane (txtrTuWyswietlaSie, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		txtrTuWyswietlaSie.setText("Tu wyswietla sie wszystkie dostepne produkty");
		
		JButton btnNewButton_1 = new JButton("Wyswietl moje zamowienia");
		btnNewButton_1.setAction(action_5);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSprawdzDostepnosc, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
						.addComponent(lblCoChceszZrobic)
						.addComponent(btnZamowLeki, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
						.addComponent(btnKupLeki, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtPodajNazweLeku, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
						.addComponent(txtTuWyswietliSi, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnWyczyscPole, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(162)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
							.addContainerGap())
						.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCoChceszZrobic)
							.addGap(11)
							.addComponent(btnKupLeki))
						.addComponent(txtTuWyswietliSi, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnZamowLeki)
						.addComponent(txtPodajNazweLeku, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(btnSprawdzDostepnosc)
							.addGap(32)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
					.addGap(90)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnWyczyscPole)
						.addComponent(btnNewButton))
					.addContainerGap())
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
		Produkty produkt = new Produkty();
		public SwingAction_1() {
			putValue(NAME, "Sprawdz Dostepnosc");
			putValue(SHORT_DESCRIPTION, "Mozesz sprawdzic dostepnosc swojego leku");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				String nazwa = txtTuWyswietliSi.getText();
				ConnectToDB.polacz();
				Statement st = ConnectToDB.con.createStatement();
				ResultSet rs = st.executeQuery("Select \"id_produkty\", nazwa, ilosc from produkty");
				while (rs.next()) {
					produkt.setId(rs.getInt(1));
					produkt.setNazwa(rs.getString(2));
					produkt.setIlosc(rs.getInt(3));
					if(nazwa.equals(produkt.getNazwa())) {
						txtTuWyswietliSi.setText("Lek "+ produkt.getNazwa() + " jest dostepny w ilosci: " + produkt.getIlosc());
					}
				}
				
				ConnectToDB.rozlacz();
			} catch (Exception e1) {
				System.out.println("Exeption w sprawdzaniu dosepnosci z bazy danych");
				e1.printStackTrace();
			}
		}
	}
	private class SwingAction_2 extends AbstractAction {
		Klient klient = new Klient(GlowneMenu.window2);
		public SwingAction_2() {
		
			putValue(NAME, "Zamow Leki");
			putValue(SHORT_DESCRIPTION, "Tym przyciskiem mozesz zamowic leki");
		}
		public void actionPerformed(ActionEvent e) {
			String[] lines = txtPodajNazweLeku.getText().split(" ");
			txtPodajNazweLeku.setText(klient.zamowLeki(lines));
		}
	}
	private class SwingAction_3 extends AbstractAction {
		Produkty produkt = new Produkty();
		String textPola;
		public SwingAction_3() {
			putValue(NAME, "Wyswietl dostepne produkty");
			putValue(SHORT_DESCRIPTION, "Pokaz wszystkie dostepne produkty");
		}
		public void actionPerformed(ActionEvent e) {
			try {
			textPola = "";
			ConnectToDB.polacz();
			Statement st = ConnectToDB.con.createStatement();
			ResultSet rs = st.executeQuery("Select \"id_produkty\", nazwa, ilosc from produkty");
			while (rs.next()) {
				produkt.setId(rs.getInt(1));
				produkt.setNazwa(rs.getString(2));
				produkt.setIlosc(rs.getInt(3));
				if(produkt.getIlosc() > 0) {
					textPola += "Lek "+ produkt.getNazwa() + " jest dostepny w ilosci: " + produkt.getIlosc() + "\n";
				}
			}
			txtrTuWyswietlaSie.setText(textPola);
			
			ConnectToDB.rozlacz();
			}catch (Exception e1){
				System.out.println("Exception w wyswietlaniu produktow.");
				e1.printStackTrace();
			}
	}
		
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Wyczysc Pola");
			putValue(SHORT_DESCRIPTION, "Tym przyciskiem wyczyscisz pola textowe");
		}
		public void actionPerformed(ActionEvent e) {
			txtTuWyswietliSi.setText(null);
			txtPodajNazweLeku.setText(null);
			txtrTuWyswietlaSie.setText(null);
		}
	}
	private class SwingAction_5 extends AbstractAction {
		Klient klient = new Klient(GlowneMenu.window2);
		public SwingAction_5() {
			putValue(NAME, "Wysietl moje zamowienia");
			putValue(SHORT_DESCRIPTION, "Wyswietli wszystkie wykonane przez ciebie zamowienia");
		}
		public void actionPerformed(ActionEvent e) {
			txtrTuWyswietlaSie.setText(null);
			txtrTuWyswietlaSie.setText(klient.wyswietlZamowienia());
		}
	}
}
