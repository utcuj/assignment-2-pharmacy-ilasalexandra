package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class LogInView {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton btnLogIn;
	private JLabel lblwrongPassword;
	private JLabel lbluserDoesNot;
	private JFrame frame;
	/**
	 * @wbp.parser.entryPoint
	 */

	public LogInView(){
		frame= new JFrame("Log in");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setBounds(700, 300, 464, 364);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(109, 131, 45, 16);
		frame.getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel(" Password:");
		lblPassword.setBounds(80, 166, 70, 16);
		frame.getContentPane().add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.setBounds(156, 128, 116, 22);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(156, 163, 116, 22);
		passwordField.setEchoChar('*');
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setForeground(new Color(0, 0, 153));
		lblWelcome.setFont(new Font("Cambria", Font.PLAIN, 38));
		lblWelcome.setBounds(124, 37, 174, 38);
		frame.getContentPane().add(lblWelcome);
		
		lblwrongPassword = new JLabel("!wrong password");
		lblwrongPassword.setForeground(new Color(255, 0, 0));
		lblwrongPassword.setBounds(284, 166, 116, 16);
		lblwrongPassword.setVisible(false);
		frame.getContentPane().add(lblwrongPassword);
		
	    lbluserDoesNot = new JLabel("!user does not exist");
		lbluserDoesNot.setForeground(Color.RED);
		lbluserDoesNot.setBounds(284, 131, 136, 16);
		lbluserDoesNot.setVisible(false);
		frame.getContentPane().add(lbluserDoesNot);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(177, 198, 70, 25);
		frame.getContentPane().add(btnLogIn);
		
	}
	public JTextField getUsernameField() {
		return usernameField;
	}
	public void setUsernameField(JTextField usernameField) {
		this.usernameField = usernameField;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	public JButton getBtnLogIn() {
		return btnLogIn;
	}
	public void setBtnLogIn(JButton btnLogIn) {
		this.btnLogIn = btnLogIn;
	}
	public JLabel getLblwrongPassword() {
		return lblwrongPassword;
	}
	public void setLblwrongPassword(JLabel lblwrongPassword) {
		this.lblwrongPassword = lblwrongPassword;
	}
	public JLabel getLbluserDoesNot() {
		return lbluserDoesNot;
	}
	public void setLbluserDoesNot(JLabel lbluserDoesNot) {
		this.lbluserDoesNot = lbluserDoesNot;
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
