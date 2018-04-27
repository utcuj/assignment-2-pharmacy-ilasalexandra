package view;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MedicationController;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class MedicationViewAdmin {
	private JTextField nameField;
	private JTextField ingredientsField;
	private JTextField manufacturerField;
	private JTextField priceField;
	private JTextField quantityField;
	private JTextField deleteByNameField;
	private JTextField updateDataField;
	private JFrame frame;
	private JButton btnChooseAdd;
	private JButton btnChooseDelete;
	private JButton btnChooseUpdate;
	private JPanel addPanel;
	private JButton btnAdd;
	private JLabel lblwrongInsertData;
	private JLabel lblAddDone;
	private JButton btnBack;
	private JPanel deletePanel;
	private JButton btnDelete;
	private JLabel lblWrongDeleteData ;
	private JLabel lblDeleteDone;
	private JPanel updatePanel;
	private JComboBox<String> selectFieldOptions;
	private JComboBox<String> selectMedBox;
	private JButton btnUpdate;
	private JLabel lblwrongUpdateData;
	private JLabel lblUpdateDone;
	private JTextArea textArea;
	
	/**
	 * @wbp.parser.entryPoint
	 */

	public MedicationViewAdmin(){
		frame= new JFrame("Medication details-advanced");
		frame.getContentPane().setLayout(null);
		frame.setBounds(700, 300, 735, 662);
		
		btnChooseAdd = new JButton("Add medication");
		btnChooseAdd.setBounds(22, 236, 199, 73);
		frame.getContentPane().add(btnChooseAdd);
		
		btnChooseDelete = new JButton("Delete medication");
		btnChooseDelete.setBounds(256, 236, 199, 73);
		frame.getContentPane().add(btnChooseDelete);
		
		btnChooseUpdate = new JButton("Update medication data");
		btnChooseUpdate.setBounds(486, 236, 199, 73);
		frame.getContentPane().add(btnChooseUpdate);
		
		addPanel = new JPanel();
		addPanel.setBounds(12, 337, 234, 199);
		frame.getContentPane().add(addPanel);
		addPanel.setVisible(false);
		addPanel.setLayout(null);
		
		nameField = new JTextField();
		nameField.setBounds(87, 13, 116, 22);
		addPanel.add(nameField);
		nameField.setColumns(10);
		
		ingredientsField = new JTextField();
		ingredientsField.setBounds(87, 37, 116, 22);
		addPanel.add(ingredientsField);
		ingredientsField.setColumns(10);
		
		manufacturerField = new JTextField();
		manufacturerField.setBounds(87, 61, 116, 22);
		addPanel.add(manufacturerField);
		manufacturerField.setColumns(10);
		
		priceField = new JTextField();
		priceField.setBounds(87, 85, 59, 22);
		addPanel.add(priceField);
		priceField.setColumns(10);
		
		quantityField = new JTextField();
		quantityField.setBounds(87, 107, 59, 22);
		addPanel.add(quantityField);
		quantityField.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(42, 16, 38, 16);
		addPanel.add(lblName);
		
		JLabel lblIngredients = new JLabel("Ingredients:");
		lblIngredients.setBounds(15, 40, 73, 16);
		addPanel.add(lblIngredients);
		
		JLabel lblManufacturer = new JLabel("Manufacturer:");
		lblManufacturer.setBounds(2, 64, 86, 16);
		addPanel.add(lblManufacturer);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(50, 88, 38, 16);
		addPanel.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(32, 110, 56, 16);
		addPanel.add(lblQuantity);
		
		 btnAdd = new JButton("Add");
		btnAdd.setBounds(117, 142, 59, 25);
		addPanel.add(btnAdd);
		
		lblwrongInsertData = new JLabel("!wrong data");
		lblwrongInsertData.setForeground(new Color(255, 0, 0));
		lblwrongInsertData.setBounds(117, 170, 86, 16);
		lblwrongInsertData.setVisible(false);
		addPanel.add(lblwrongInsertData);
		
		lblAddDone = new JLabel("done!");
		lblAddDone.setForeground(new Color(0, 204, 51));
		lblAddDone.setBounds(127, 170, 86, 16);
		lblAddDone.setVisible(false);
		addPanel.add(lblAddDone);
		
		btnBack = new JButton(" Back");
		btnBack.setBounds(0, 577, 97, 25);
		frame.getContentPane().add(btnBack);
		
		deletePanel = new JPanel();
		deletePanel.setBounds(298, 337, 126, 126);
		frame.getContentPane().add(deletePanel);
		deletePanel.setVisible(false);
		deletePanel.setLayout(null);
		
		JLabel lblInsertName = new JLabel("Insert name:");
		lblInsertName.setBounds(12, 13, 81, 16);
		deletePanel.add(lblInsertName);
		
		deleteByNameField = new JTextField();
		deleteByNameField.setBounds(12, 42, 88, 22);
		deletePanel.add(deleteByNameField);
		deleteByNameField.setColumns(10);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(22, 78, 69, 25);
		deletePanel.add(btnDelete);
		
		lblWrongDeleteData = new JLabel("!wrong data");
		lblWrongDeleteData.setForeground(Color.RED);
		lblWrongDeleteData.setBounds(32, 110, 86, 16);
		lblWrongDeleteData.setVisible(false);
		deletePanel.add(lblWrongDeleteData);
		
		lblDeleteDone = new JLabel("done!");
		lblDeleteDone.setForeground(new Color(0, 204, 51));
		lblDeleteDone.setBounds(32, 110, 86, 16);
		lblDeleteDone.setVisible(false);
		deletePanel.add(lblDeleteDone);
		
		updatePanel = new JPanel();
		updatePanel.setBounds(486, 347, 199, 164);
		frame.getContentPane().add(updatePanel);
		updatePanel.setVisible(false);
		updatePanel.setLayout(null);
		
		JLabel lblNew = new JLabel("New:");
		lblNew.setBounds(12, 59, 35, 16);
		updatePanel.add(lblNew);
		
		String[] options={"Name","Quantity","Price"};
		selectFieldOptions = new JComboBox<String>(options);
		selectFieldOptions.setBounds(101, 56, 86, 22);
	    updatePanel.add(selectFieldOptions);
		
		updateDataField = new JTextField();
		updateDataField.setBounds(111, 85, 76, 22);
		updatePanel.add(updateDataField);
		updateDataField.setColumns(10);
		
		JLabel lblInsertNewData = new JLabel("Insert new data:");
		lblInsertNewData.setBounds(9, 88, 101, 16);
		updatePanel.add(lblInsertNewData);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(64, 110, 86, 25);
		updatePanel.add(btnUpdate);
		
		lblwrongUpdateData = new JLabel("!wrong data");
		lblwrongUpdateData.setForeground(Color.RED);
		lblwrongUpdateData.setBounds(64, 135, 86, 16);
		lblwrongUpdateData.setVisible(false);
		updatePanel.add(lblwrongUpdateData);
		
		lblUpdateDone = new JLabel("done!");
		lblUpdateDone.setForeground(new Color(0, 204, 51));
		lblUpdateDone.setBounds(64, 135, 86, 16);
		lblUpdateDone.setVisible(false);
		updatePanel.add(lblUpdateDone);
		
		JLabel lblSelectMed = new JLabel("Select med:");
		lblSelectMed.setBounds(12, 13, 87, 16);
		updatePanel.add(lblSelectMed);
		
		selectMedBox = new JComboBox<String>(MedicationController.medsNames);
		selectMedBox.setBounds(101, 13, 86, 22);
		updatePanel.add(selectMedBox);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Cambria", Font.PLAIN, 16));
		textArea.setBounds(200, 26, 360, 155);
		textArea.setEditable(false);
		frame.getContentPane().add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(200, 26, 360, 155);
		frame.getContentPane().add(scrollPane);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(200, 26, 291, 155);
		frame.getContentPane().add(scrollBar);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	
	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public JTextField getIngredientsField() {
		return ingredientsField;
	}

	public void setIngredientsField(JTextField ingredientsField) {
		this.ingredientsField = ingredientsField;
	}

	public JTextField getManufacturerField() {
		return manufacturerField;
	}

	public void setManufacturerField(JTextField manufacturerField) {
		this.manufacturerField = manufacturerField;
	}

	public JTextField getPriceField() {
		return priceField;
	}

	public void setPriceField(JTextField priceField) {
		this.priceField = priceField;
	}

	public JTextField getQuantityField() {
		return quantityField;
	}

	public void setQuantityField(JTextField quantityField) {
		this.quantityField = quantityField;
	}

	public JTextField getDeleteByNameField() {
		return deleteByNameField;
	}

	public void setDeleteByNameField(JTextField deleteByNameField) {
		this.deleteByNameField = deleteByNameField;
	}

	public JTextField getUpdateDataField() {
		return updateDataField;
	}

	public void setUpdateDataField(JTextField updateDataField) {
		this.updateDataField = updateDataField;
	}

	public JButton getBtnChooseAdd() {
		return btnChooseAdd;
	}

	public void setBtnChooseAdd(JButton btnChooseAdd) {
		this.btnChooseAdd = btnChooseAdd;
	}

	public JButton getBtnChooseDelete() {
		return btnChooseDelete;
	}

	public void setBtnChooseDelete(JButton btnChooseDelete) {
		this.btnChooseDelete = btnChooseDelete;
	}

	public JButton getBtnChooseUpdate() {
		return btnChooseUpdate;
	}

	public void setBtnChooseUpdate(JButton btnChooseUpdate) {
		this.btnChooseUpdate = btnChooseUpdate;
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

	public JLabel getLblwrongInsertData() {
		return lblwrongInsertData;
	}

	public void setLblwrongInsertData(JLabel lblwrongInsertData) {
		this.lblwrongInsertData = lblwrongInsertData;
	}

	public JLabel getLblAddDone() {
		return lblAddDone;
	}

	public void setLblAddDone(JLabel lblAddDone) {
		this.lblAddDone = lblAddDone;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
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

	public JLabel getLblWrongDeleteData() {
		return lblWrongDeleteData;
	}

	public void setLblWrongDeleteData(JLabel lblWrongDeleteData) {
		this.lblWrongDeleteData = lblWrongDeleteData;
	}

	public JLabel getLblDeleteDone() {
		return lblDeleteDone;
	}

	public void setLblDeleteDone(JLabel lblDeleteDone) {
		this.lblDeleteDone = lblDeleteDone;
	}

	public JPanel getUpdatePanel() {
		return updatePanel;
	}

	public void setUpdatePanel(JPanel updatePanel) {
		this.updatePanel = updatePanel;
	}

	public JComboBox<String> getComboBox() {
		return selectFieldOptions;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.selectFieldOptions = comboBox;
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

	public JLabel getLblUpdateDone() {
		return lblUpdateDone;
	}

	public void setLblUpdateDone(JLabel lblUpdateDone) {
		this.lblUpdateDone = lblUpdateDone;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JComboBox<String> getSelectFieldOptions() {
		return selectFieldOptions;
	}

	public void setSelectFieldOptions(JComboBox<String> selectFieldOptions) {
		this.selectFieldOptions = selectFieldOptions;
	}

	public JComboBox<String> getSelectMedBox() {
		return selectMedBox;
	}

	public void setSelectMedBox(JComboBox<String> selectMedBox) {
		this.selectMedBox = selectMedBox;
	}
}
