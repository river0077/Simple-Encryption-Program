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
	private JLabel titleLabel = new JLabel("Script Encryption", JLabel.CENTER);
	private JLabel passwordLabel = new JLabel("Password:", JLabel.CENTER), keyLabel = new JLabel("Key:          ", JLabel.CENTER);
	private JTextField passwordField, keyField, resultField;
	private JButton encryptButton, decryptButton;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem exit = new JMenuItem("Exit"), help = new JMenuItem("Help"), about = new JMenuItem("About");
	
	public AppUI() {
		setTitle("Script Encryption");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setJMenuBar(menuBar = new JMenuBar());
		menuBar.add(fileMenu = new JMenu("File"));
		fileMenu.add(help);
		fileMenu.add(about);
		fileMenu.add(exit);
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
			setLayout(new BorderLayout());
			passwordField = new JTextField(20);
			keyField = new JTextField(20);
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
			encryptButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			decryptButton = new JButton("Decrypt");
			decryptButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new FlowLayout());
			buttonPanel.add(encryptButton);
			buttonPanel.add(decryptButton);
			panelOther.add(buttonPanel, BorderLayout.NORTH);
			resultField = new JTextField();
			panelOther.add(resultField, BorderLayout.CENTER);
			add(titleLabel, BorderLayout.NORTH);
			add(inputPanel, BorderLayout.CENTER);
			add(panelOther, BorderLayout.SOUTH);
		}
	}
}
