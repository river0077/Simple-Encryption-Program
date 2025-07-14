package sep;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class AppUI extends JFrame {
	private static final long serialVersionUID = 1L;
	// Attributes for the UI components
	private JLabel titleLabel = new JLabel("Simple Encryption Program", JLabel.CENTER),
			copyrightLabel = new JLabel("© 2025 by river0077", JLabel.CENTER);
	private JLabel passwordLabel = new JLabel("Password:", JLabel.CENTER),
			keyLabel = new JLabel("Key:          ", JLabel.CENTER);
	private JTextField passwordField, keyField, resultField;
	private JButton encryptButton, decryptButton;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem exit = new JMenuItem("Exit"), help = new JMenuItem("Help"), about = new JMenuItem("About");

	public AppUI() {
		// UI constructor
		setTitle("Simple Encryption Program");
		setSize(425, 235);
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
				HelpFrame helpFrame = new HelpFrame();
				helpFrame.setVisible(true);
			}
		});
		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame aboutFrame = new JFrame("About");
				aboutFrame.setSize(300, 150);
				aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				JLabel aboutLabel = new JLabel("<html><center>Simple Encryption Program<br>Version 1.0<br>© 2025 by river0077</center></html>", JLabel.CENTER);
				aboutFrame.add(aboutLabel);
				aboutFrame.setLocationRelativeTo(null);
				aboutFrame.setVisible(true);
			}
		});
		add(new UIPanel(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
	}

	private class UIPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		public UIPanel() {
			// UI panel constructor
			setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(5, 5, 5, 5);

			// Title Label
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 2;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.anchor = GridBagConstraints.CENTER;
			add(titleLabel, gbc);

			// Password Label and Field
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.gridwidth = 1;
			gbc.fill = GridBagConstraints.NONE;
			gbc.anchor = GridBagConstraints.EAST;
			add(passwordLabel, gbc);

			passwordField = new JTextField(20);
			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.weightx = 1.0;
			add(passwordField, gbc);

			// Key Label and Field
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.fill = GridBagConstraints.NONE;
			gbc.weightx = 0;
			gbc.anchor = GridBagConstraints.EAST;
			add(keyLabel, gbc);

			keyField = new JTextField(20);
			gbc.gridx = 1;
			gbc.gridy = 2;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.weightx = 1.0;
			add(keyField, gbc);

			// Buttons Panel
			JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			encryptButton = new JButton("Encrypt");
			decryptButton = new JButton("Decrypt");
			buttonPanel.add(encryptButton);
			buttonPanel.add(decryptButton);

			gbc.gridx = 0;
			gbc.gridy = 3;
			gbc.gridwidth = 2;
			gbc.fill = GridBagConstraints.NONE;
			gbc.weightx = 0;
			gbc.anchor = GridBagConstraints.CENTER;
			add(buttonPanel, gbc);

			// Result Field
			resultField = new JTextField(25);
			resultField.setEditable(false);
			resultField.setHorizontalAlignment(JTextField.CENTER);
			resultField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Result", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
			gbc.gridx = 0;
			gbc.gridy = 4;
			gbc.gridwidth = 2;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.weightx = 1.0;
			add(resultField, gbc);

			// Copyright Label
			gbc.gridx = 0;
			gbc.gridy = 5;
			gbc.gridwidth = 2;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.weighty = 1.0;
			gbc.anchor = GridBagConstraints.SOUTH;
			add(copyrightLabel, gbc);

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
					if (password.length() < 4 || password.length() > 50) {
						resultField.setText("Password must be between 4 and 50 characters long.");
						return;
					}
					if (key.length() != 4) {
						resultField.setText("Key must be exactly 4 characters long.");
						return;
					}
					String encrypted = Script_Encryption.encrypt(password, key);
					resultField.setText(encrypted);
					resultField.setHorizontalAlignment(JTextField.CENTER);
					revalidate();
					repaint();
				}
			});
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
					if (password.length() < 4 || password.length() > 50) {
						resultField.setText("Password must be between 4 and 50 characters long.");
						return;
					}
					if (key.length() != 4) {
						resultField.setText("Key must be exactly 4 characters long.");
						return;
					}
					String decrypted = Script_Encryption.decrypt(password, key);
					resultField.setText(decrypted);
					resultField.setHorizontalAlignment(JTextField.CENTER);
					System.out.println("Decrypted: " + decrypted);
					revalidate();
					repaint();
				}
			});
		}
	}

	// HelpFrame class to display the help content in a new window
	private class HelpFrame extends JFrame {
		private static final long serialVersionUID = 1L;

		public HelpFrame() {
			setTitle("Help");
			setSize(800, 600);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setContentPane(new HelpPanel());
			setLocationRelativeTo(null);
		}
	}

	// HelpPanel class to display the help content
	private class HelpPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private Image backgroundImage;

		public HelpPanel() {
			setLayout(new BorderLayout());
			try {
				backgroundImage = ImageIO.read(new File("src/resources/help.png"));
			} catch (IOException e) {
				e.printStackTrace();

				System.err.println("Could not load help.png. Make sure the file exists at src/resources/help.png");
				backgroundImage = null;
			}
		}
		// Override paintComponent to draw the background image
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (backgroundImage != null) {
				g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
			}
		}
	}
}