package Menu;

import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GlowneMenu {

	private JFrame frame;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	public static Toolkit theKit;
	public static Dimension screenSize;
	public static Point center;
	public static String title = "Aplikacja Apteki";
	public static Logowanie window2;
	/**
	 * Create the application.
	 */
	public GlowneMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setTitle(title);
		theKit = frame.getToolkit();
	    screenSize = theKit.getScreenSize();
	    center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		frame.setBounds(center.x - screenSize.width/4 , center.y - screenSize.height/4, 600, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JButton btnTak = new JButton("Tak");
		btnTak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				window2 = new Logowanie();
			}
		});
		btnTak.setAction(action);
		
		JButton btnNie = new JButton("Nie");
		btnNie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Rejestracja window = new Rejestracja();
			}
		});
		btnNie.setAction(action_1);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(169)
					.addComponent(btnTak)
					.addGap(150)
					.addComponent(btnNie)
					.addContainerGap(169, Short.MAX_VALUE))
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
				.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNie)
						.addComponent(btnTak))
					.addContainerGap(98, Short.MAX_VALUE))
		);
		
		JLabel lblCzyZostalesZarejestrowany = new JLabel("Czy jestes juz zarejestrowany?");
		panel_1.add(lblCzyZostalesZarejestrowany);
		
		JLabel lblWitajWAplikacji = new JLabel("Witaj w aplikacji naszej Apteki");
		panel.add(lblWitajWAplikacji);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Tak");
			putValue(SHORT_DESCRIPTION, "Przechodzi do Logowania");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Nie");
			putValue(SHORT_DESCRIPTION, "Przechodzi do Rejestracji");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
