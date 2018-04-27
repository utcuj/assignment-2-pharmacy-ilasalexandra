package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.BorderLayout;

public class EmployeesView {
	private JTextField nameField;
	private JTextField pncField;
	private JTextField userField;
	private JTextField passwordField;
	private JTextField deleteByIdField;
	private JTextField updatetDataField;
	private JTextField idUpdateField;
	private JTextField adressField;
	private JTextField emailField;
	private JFrame frame;
	private JButton btnChooseAdd;
	private JPanel addPanel;
	private JButton btnAdd;
	private JLabel lblwrongData;
	private JLabel lbladded; 
	private JButton btnChooseDelete;
	private JPanel deletePanel;
	private JButton btnDelete;
	private JLabel lblwrongID;
	private JLabel lbldeleted;
	private JButton btnChooseUpdate;
	private JPanel updatePanel;
	private JButton btnUpdate;
	private JLabel lblwrongUpdateData;
	private JComboBox<String> comboBox;
	private JLabel lblDone;
	private JButton btnBack;
	private JTextArea textArea;
	/**
	 * @wbp.parser.entryPoint
	 */

	public EmployeesView(){
		frame= new JFrame("Employee details");
		frame.setBounds(700, 300, 735, 662);

		btnChooseAdd = new JButton("Add new chemist");
		btnChooseAdd.setBounds(49, 208, 195, 67);
		frame.getContentPane().add(btnChooseAdd);
		
		addPanel = new JPanel();
		addPanel.setBounds(32, 310, 223, 222);
		frame.getContentPane().add(addPanel);
		addPanel.setLayout(null);
		addPanel.setVisible(false);
		nameField = new JTextField();
		nameField.setBounds(83, 13, 116, 22);
		addPanel.add(nameField);
		nameField.setColumns(10);
		
		pncField = new JTextField();
		pncField.setBounds(83, 38, 116, 22);
		addPanel.add(pncField);
		pncField.setColumns(10);
		
		userField = new JTextField();
		userField.setBounds(83, 64, 116, 22);
		addPanel.add(userField);
		userField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(83, 88, 116, 22);
		addPanel.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblPnc = new JLabel("PNC:");
		lblPnc.setBounds(43, 41, 28, 16);
		addPanel.add(lblPnc);
		
		JLabel lblName = new JLabel(" Name:");
		lblName.setBounds(29, 16, 42, 16);
		addPanel.add(lblName);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(12, 67, 69, 16);
		addPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(12, 91, 62, 16);
		addPanel.add(lblPassword);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(108, 167, 62, 25);
		addPanel.add(btnAdd);
		
		lblwrongData = new JLabel("!wrong data");
		lblwrongData.setForeground(new Color(255, 0, 0));
		lblwrongData.setBounds(108, 193, 87, 16);
		lblwrongData.setVisible(false);
		addPanel.add(lblwrongData);
		
		lbladded = new JLabel("added!");
		lbladded.setForeground(new Color(0, 204, 51));
		lbladded.setBounds(112, 193, 87, 16);
		lbladded.setVisible(false);
		addPanel.add(lbladded);
		
		adressField = new JTextField();
		adressField.setColumns(10);
		adressField.setBounds(83, 111, 116, 22);
		addPanel.add(adressField);
		
		JLabel lblAdress = new JLabel("Adress:");
		lblAdress.setBounds(27, 114, 44, 16);
		addPanel.add(lblAdress);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(83, 135, 116, 22);
		addPanel.add(emailField);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(29, 138, 44, 16);
		addPanel.add(lblEmail);
		
		btnChooseDelete = new JButton("Delete chemist data");
		btnChooseDelete.setBounds(256, 208, 195, 67);
		frame.getContentPane().add(btnChooseDelete);
		
		deletePanel = new JPanel();
		deletePanel.setBounds(287, 310, 124, 126);
		frame.getContentPane().add(deletePanel);
		deletePanel.setLayout(null);
		deletePanel.setVisible(false);
		JLabel lblInsertName = new JLabel("Insert pnc:");
		lblInsertName.setBounds(12, 13, 82, 16);
		deletePanel.add(lblInsertName);
		
		deleteByIdField = new JTextField();
		deleteByIdField.setBounds(12, 32, 89, 22);
		deletePanel.add(deleteByIdField);
		deleteByIdField.setColumns(10);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(12, 64, 75, 25);
		deletePanel.add(btnDelete);
		
		lblwrongID = new JLabel("!wrong ID");
		lblwrongID.setForeground(new Color(255, 0, 0));
		lblwrongID.setBounds(12, 97, 82, 16);
		lblwrongID.setVisible(false);
		deletePanel.add(lblwrongID);
		
		lbldeleted = new JLabel("Deleted!");
		lbldeleted.setForeground(new Color(0, 204, 51));
		lbldeleted.setBounds(12, 97, 82, 16);
		lbldeleted.setVisible(false);
		deletePanel.add(lbldeleted);
		
		btnChooseUpdate = new JButton("Update chemist data");
		btnChooseUpdate.setBounds(463, 208, 195, 67);
		frame.getContentPane().add(btnChooseUpdate);
		
		updatePanel = new JPanel();
		updatePanel.setBounds(463, 315, 195, 143);
		frame.getContentPane().add(updatePanel);
		updatePanel.setLayout(null);
		updatePanel.setVisible(false);
		
		JLabel lblNew = new JLabel("New:");
		lblNew.setBounds(12, 13, 35, 16);
		updatePanel.add(lblNew);
		
		String[] options={"Name","Username","Password","Mail","Adress"};
		comboBox = new JComboBox<String>(options);
		comboBox.setBounds(59, 10, 98, 22);
		updatePanel.add(comboBox);
		
		updatetDataField = new JTextField();
		updatetDataField.setBounds(59, 61, 98, 22);
		updatePanel.add(updatetDataField);
		updatetDataField.setColumns(10);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(12, 64, 35, 16);
		updatePanel.add(lblData);
		
	    btnUpdate = new JButton("Update");
		btnUpdate.setBounds(69, 96, 73, 25);
		updatePanel.add(btnUpdate);
		
		lblwrongUpdateData = new JLabel("!wrong data");
		lblwrongUpdateData.setForeground(new Color(255, 0, 0));
		lblwrongUpdateData.setBounds(74, 127, 83, 16);
		lblwrongUpdateData.setVisible(false);
		updatePanel.add(lblwrongUpdateData);
		
		lblDone = new JLabel("done!");
		lblDone.setForeground(new Color(0, 204, 51));
		lblDone.setBounds(59, 127, 83, 16);
		lblDone.setVisible(false);
		updatePanel.add(lblDone);
		
		JLabel lblChemistId = new JLabel("Chemist pnc:");
		lblChemistId.setBounds(12, 42, 73, 16);
		updatePanel.add(lblChemistId);
		
		idUpdateField = new JTextField();
		idUpdateField.setColumns(10);
		idUpdateField.setBounds(85, 39, 72, 22);
		updatePanel.add(idUpdateField);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(0, 588, 79, 25);
		frame.getContentPane().add(btnBack);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Cambria", Font.PLAIN, 16));
		textArea.setBounds(49, 31, 607, 143);
		textArea.setEditable(false);
		frame.getContentPane().add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(49, 31, 607, 143);
		frame.getContentPane().add(scrollPane);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(49, 31, 607, 143);
		frame.getContentPane().add(scrollBar, BorderLayout.CENTER);
		frame.setVisible(true);
		
	}
	public JTextField getNameField() {
		return nameField;
	}
	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}
	public JTextField getPncField() {
		return pncField;
	}
	public void setPncField(JTextField pncField) {
		this.pncField = pncField;
	}
	public JTextField getUserField() {
		return userField;
	}
	public void setUserField(JTextField userField) {
		this.userField = userField;
	}
	public JTextField getPasswordField() {
		return passwordField;
	}
	public void setPasswordField(JTextField passwordField) {
		this.passwordField = passwordField;
	}
	public JTextField getDeleteByIdField() {
		return deleteByIdField;
	}
	public void setDeleteByIdField(JTextField deleteByIdField) {
		this.deleteByIdField = deleteByIdField;
	}
	public JTextField getUpdatetDataField() {
		return updatetDataField;
	}
	public void setUpdatetDataField(JTextField updatetDataField) {
		this.updatetDataField = updatetDataField;
	}
	public JTextField getIdUpdateField() {
		return idUpdateField;
	}
	public void setIdUpdateField(JTextField idUpdateField) {
		this.idUpdateField = idUpdateField;
	}
	public JTextField getAdressField() {
		return adressField;
	}
	public void setAdressField(JTextField adressField) {
		this.adressField = adressField;
	}
	public JTextField getEmailField() {
		return emailField;
	}
	public void setEmailField(JTextField emailField) {
		this.emailField = emailField;
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JButton getBtnChooseAdd() {
		return btnChooseAdd;
	}
	public void setBtnChooseAdd(JButton btnChooseAdd) {
		this.btnChooseAdd = btnChooseAdd;
	}
	public JPanel getAddPanel() {
		return addPanel;
	}
	public void setAddPanel(JPanel addPanel) {
		this.addPanel = addPanel;
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}
	public JLabel getLblwrongData() {
		return lblwrongData;
	}
	public void setLblwrongData(JLabel lblwrongData) {
		this.lblwrongData = lblwrongData;
	}
	public JLabel getLbladded() {
		return lbladded;
	}
	public void setLbladded(JLabel lbladded) {
		this.lbladded = lbladded;
	}
	public JButton getBtnChooseDelete() {
		return btnChooseDelete;
	}
	public void setBtnChooseDelete(JButton btnChooseDelete) {
		this.btnChooseDelete = btnChooseDelete;
	}
	public JPanel getDeletePanel() {
		return deletePanel;
	}
	public void setDeletePanel(JPanel deletePanel) {
		this.deletePanel = deletePanel;
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}
	public JLabel getLblwrongID() {
		return lblwrongID;
	}
	public void setLblwrongID(JLabel lblwrongID) {
		this.lblwrongID = lblwrongID;
	}
	public JLabel getLbldeleted() {
		return lbldeleted;
	}
	public void setLbldeleted(JLabel lbldeleted) {
		this.lbldeleted = lbldeleted;
	}
	public JButton getBtnChooseUpdate() {
		return btnChooseUpdate;
	}
	public void setBtnChooseUpdate(JButton btnChooseUpdate) {
		this.btnChooseUpdate = btnChooseUpdate;
	}
	public JPanel getUpdatePanel() {
		return updatePanel;
	}
	public void setUpdatePanel(JPanel updatePanel) {
		this.updatePanel = updatePanel;
	}
	public JButton getBtnUpdate() {
		return btnUpdate;
	}
	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}
	public JLabel getLblwrongUpdateData() {
		return lblwrongUpdateData;
	}
	public void setLblwrongUpdateData(JLabel lblwrongUpdateData) {
		this.lblwrongUpdateData = lblwrongUpdateData;
	}
	public JComboBox<String> getComboBox() {
		return comboBox;
	}
	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}
	public JLabel getLblDone() {
		return lblDone;
	}
	public void setLblDone(JLabel lblDone) {
		this.lblDone = lblDone;
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
}
