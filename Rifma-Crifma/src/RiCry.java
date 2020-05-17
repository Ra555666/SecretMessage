import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class RiCry extends JFrame {
	private boolean goodOrBad;
	private int numOfDecription;
	private JTextField getNameTextField;
	private JCheckBox chckbxResultDecryption;
	private JTextPane decryptionOutputTextField;
	private JButton btnRetry;
	private JButton btnConfirm;
	private String[] goodDecriptions = { "best progrommer", "best of the best of the best", "steel balls", "clever guy", "handsome",
			"rich", "ruler of the world", "god of Java", "magnificent", "sempiternal", "wonderful", "gorgeous" };
	private String[] badDecriptions = { "fucked", "fucking fool", "fucking idiot", "douchebag", "loser", "hooker",
			"motherfucker", "twit", "moron", "ass-kisser", "bugger", "asshole" };

	public void startScreen() {
		goodOrBad = chckbxResultDecryption.isSelected();
		getNameTextField.setEditable(true);
		numOfDecription = (int) (Math.random() * 12);
		getNameTextField.setText("");
		decryptionOutputTextField.setText("");
		btnRetry.setVisible(false);
		btnConfirm.setVisible(true);
		chckbxResultDecryption.setSelected(true);
	}

	public void giveDecryption() {
		goodOrBad = chckbxResultDecryption.isEnabled();
		String name = getNameTextField.getText();
		String message = "";
		if (goodOrBad && (name != null && !name.isEmpty())) {
			message = "Name " + name + " means " + goodDecriptions[numOfDecription];
		} else if (name != null && !name.isEmpty()) {
			message = "Name " + name + " means " + badDecriptions[numOfDecription];
		} else {
			message = "Enter correct name please!";
		}
		decryptionOutputTextField.setText(message);
		getNameTextField.setEditable(false);
		btnRetry.setVisible(true);
		btnConfirm.setVisible(false);
	}

	public RiCry() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.PINK);
		getContentPane().setLayout(null);

		JLabel getNameLabel = new JLabel("What is your name, boy?");
		getNameLabel.setBounds(74, 39, 144, 32);
		getNameLabel.setForeground(new Color(0, 0, 0));
		getNameLabel.setBackground(new Color(102, 102, 255));
		getContentPane().add(getNameLabel);

		getNameTextField = new JTextField();
		getNameTextField.setBounds(273, 45, 86, 20);
		getContentPane().add(getNameTextField);
		getNameTextField.setColumns(10);

		btnConfirm = new JButton("Apply");
		btnConfirm.setBounds(170, 228, 89, 23);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				giveDecryption();
				btnConfirm.setVisible(false);
			}
		});
		getContentPane().add(btnConfirm);

		JLabel titleLabel = new JLabel("What does your name mean?");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		titleLabel.setBounds(112, 4, 229, 30);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(titleLabel);

		decryptionOutputTextField = new JTextPane();
		decryptionOutputTextField.setBounds(74, 143, 285, 74);
		getContentPane().add(decryptionOutputTextField);

		chckbxResultDecryption = new JCheckBox("NIkolay Silvanovich is the best!");
		chckbxResultDecryption.setBounds(112, 99, 214, 23);
		getContentPane().add(chckbxResultDecryption);

		btnRetry = new JButton("Retry?");
		btnRetry.setBounds(170, 228, 89, 23);
		btnRetry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startScreen();
			}
		});
		getContentPane().add(btnRetry);
	}

	public static void main(String[] args) {
		RiCry theGame = new RiCry();
		theGame.startScreen();
		theGame.setSize(new Dimension(450, 300));
		theGame.setVisible(true);

	}
}
