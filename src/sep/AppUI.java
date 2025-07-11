package sep;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AppUI extends JFrame{
	private static final long serialVersionUID = 1L;
	// Attributes for the UI components
	private JLabel titleLabel = new JLabel("Script Encryption", JLabel.CENTER), copyrightLabel = new JLabel("© 2025 by river0077", JLabel.CENTER);
	private JLabel passwordLabel = new JLabel("Password:", JLabel.CENTER), keyLabel = new JLabel("Key:          ", JLabel.CENTER);
	private JTextField passwordField, keyField, resultField;
	private JButton encryptButton, decryptButton;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem exit = new JMenuItem("Exit"), help = new JMenuItem("Help"), about = new JMenuItem("About");
	
	public AppUI() {
		// UI constructor
		setTitle("Script Encryption");
		setSize(400, 225);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setJMenuBar(menuBar = new JMenuBar());
		menuBar.add(fileMenu = new JMenu("File"));
		fileMenu.add(help);
		fileMenu.add(about);
		fileMenu.add(exit);
		// Action listeners for menu items
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		help.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(new UIPanel(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	private class UIPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		
		public UIPanel() {
			// UI panel constructor
			setLayout(new BorderLayout());
			passwordField = new JTextField(30);
			keyField = new JTextField(30);
			JPanel inputPanel = new JPanel();
			inputPanel.setLayout(new BorderLayout());
			JPanel passPanel = new JPanel();
			passPanel.add(passwordLabel);
			passPanel.add(passwordField);
			JPanel keyPanel = new JPanel();
			keyPanel.add(keyLabel);
			keyPanel.add(keyField);
			inputPanel.add(passPanel, BorderLayout.NORTH);
			inputPanel.add(keyPanel, BorderLayout.CENTER);
			JPanel panelOther = new JPanel();
			panelOther.setLayout(new BorderLayout());
			encryptButton = new JButton("Encrypt");
			// Action listener for the encrypt button
			encryptButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String password = passwordField.getText();
					String key = keyField.getText();
					if (password.isEmpty() || key.isEmpty()) {
						resultField.setText("Please enter both password and key.");
						return;
					}
					if (password.contains(" ") || key.contains(" ")) {
						resultField.setText("Password and key cannot contain spaces.");
						return;
					}
					if (password.length() < 4 || password.length() > 15) {
						resultField.setText("Password must be between 4 and 15 characters long.");
						return;
					}
					if (key.length() != 4) {
						resultField.setText("Key must be exactly 4 characters long.");
						return;
					}
					String encrypted = Script_Encryption.encrypt(password, key);
					resultField.setText(encrypted);
					revalidate();
					repaint();
				}
			});
			decryptButton = new JButton("Decrypt");
			// Action listener for the decrypt button
			decryptButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String password = passwordField.getText();
					String key = keyField.getText();
					if (password.isEmpty() || key.isEmpty()) {
						resultField.setText("Please enter both password and key.");
						return;
					}
					if (password.contains(" ") || key.contains(" ")) {
						resultField.setText("Password and key cannot contain spaces.");
						return;
					}
					if (password.length() < 4 || password.length() > 30) {
						resultField.setText("Password must be between 4 and 30 characters long.");
						return;
					}
					if (key.length() != 4) {
						resultField.setText("Key must be exactly 4 characters long.");
						return;
					}
					String decrypted = Script_Encryption.decrypt(password, key);
					resultField.setText(decrypted);
					System.out.println("Decrypted: " + decrypted);
					revalidate();
					repaint();
				}
			});
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new FlowLayout());
			buttonPanel.add(encryptButton);
			buttonPanel.add(decryptButton);
			panelOther.add(buttonPanel, BorderLayout.NORTH);
			resultField = new JTextField(20);
			panelOther.add(resultField, BorderLayout.CENTER);
			panelOther.add(copyrightLabel, BorderLayout.SOUTH);
			add(titleLabel, BorderLayout.NORTH);
			add(inputPanel, BorderLayout.CENTER);
			add(panelOther, BorderLayout.SOUTH);
		}
	}
}
