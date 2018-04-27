package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.MedicationController;
import model.Medication;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class MedicationView {
	private JTextField quantityField;
	private JTextField searchData;
	private JComboBox<String> viewInfoBox;
	private JButton btnSell;
	private JButton btnBack ;	
	private	JComboBox<String> medicationNameBox;
	private JFrame frame;
	private JLabel lblwrongQuantity;
	private JLabel lblwrongData;
	private JTextArea textArea;
	private JScrollPane scrollPane_1;
	private JScrollBar scrollBar;
	
	
	/**
	 * @wbp.parser.entryPoint
	 */

	public MedicationView(){
		frame=new JFrame("Medication details");
		frame.setBounds(700, 300, 676, 561);
		frame.getContentPane().setLayout(null);
		JLabel lblSellingDetails = new JLabel("Sell product");
		lblSellingDetails.setBounds(12, 13, 162, 50);
		lblSellingDetails.setFont(new Font("Cambria", Font.PLAIN, 26));
		frame.getContentPane().add(lblSellingDetails);
		
		JLabel lblMedicationName = new JLabel("Medication Name:");
		lblMedicationName.setBounds(194, 91, 139, 16);
		lblMedicationName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblMedicationName);
		
		medicationNameBox = new JComboBox<String>(MedicationController.medsNames);
		medicationNameBox.setBounds(335, 89, 116, 22);
		frame.getContentPane().add(medicationNameBox);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(258, 126, 75, 16);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblQuantity);
		
		quantityField = new JTextField();
		quantityField.setBounds(335, 124, 37, 22);
		frame.getContentPane().add(quantityField);
		quantityField.setColumns(10);
		
		lblwrongQuantity = new JLabel("!wrong quantity");
		lblwrongQuantity.setBounds(389, 127, 89, 16);
		lblwrongQuantity.setForeground(new Color(255, 0, 0));
		lblwrongQuantity.setVisible(false);
		frame.getContentPane().add(lblwrongQuantity);
		
		btnSell = new JButton("Sell");
		btnSell.setBounds(233, 156, 205, 50);
		frame.getContentPane().add(btnSell);
		
		JLabel lblViewInfo = new JLabel("View info");
		lblViewInfo.setBounds(12, 214, 162, 50);
		lblViewInfo.setFont(new Font("Cambria", Font.PLAIN, 26));
		frame.getContentPane().add(lblViewInfo);
		
		String[] viewOptions={"Name","Ingredient","Manufacturer"};
		viewInfoBox = new JComboBox<String>(viewOptions);
		viewInfoBox.setBounds(322, 263, 116, 22);
		frame.getContentPane().add(viewInfoBox);
		
		JLabel lblViewBy = new JLabel("Search by:");
		lblViewBy.setBounds(235, 265, 82, 16);
		lblViewBy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblViewBy);
		
		searchData = new JTextField();
		searchData.setBounds(322, 294, 116, 22);
		frame.getContentPane().add(searchData);
		searchData.setColumns(10);
		
		JLabel lblInsertData = new JLabel("Insert data:");
		lblInsertData.setBounds(221, 296, 89, 16);
		lblInsertData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblInsertData);
		
	    lblwrongData = new JLabel("!wrong data");
	    lblwrongData.setBounds(450, 300, 75, 16);
		lblwrongData.setForeground(Color.RED);
		lblwrongData.setVisible(false);
		frame.getContentPane().add(lblwrongData);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(0, 491, 97, 25);
		frame.getContentPane().add(btnBack);
		
	
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Cambria", Font.PLAIN, 16));
		textArea.setBounds(162, 349, 451, 68);
		
		scrollPane_1 = new JScrollPane(textArea);
		scrollPane_1.setBounds(162, 349, 451, 68);
		frame.getContentPane().add(scrollPane_1);
		

	}
	
	
	public JTextField getQuantityField() {
		return quantityField;
	}
	public void setQuantityField(JTextField quantityField) {
		this.quantityField = quantityField;
	}

	public JTextField getSearchData() {
		return searchData;
	}
	public void setSearchData(JTextField searchData) {
		this.searchData = searchData;
	}
	public JComboBox<String> getViewInfoBox() {
		return viewInfoBox;
	}
	public void setViewInfoBox(JComboBox<String> viewInfoBox) {
		this.viewInfoBox = viewInfoBox;
	}
	public JButton getBtnSell() {
		return btnSell;
	}
	public void setBtnSell(JButton btnSell) {
		this.btnSell = btnSell;
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}


	public JComboBox<String> getMedicationNameBox() {
		return medicationNameBox;
	}


	public void setMedicationNameBox(JComboBox<String> medicationNameBox) {
		this.medicationNameBox = medicationNameBox;
	}


	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	public JLabel getLblwrongQuantity() {
		return lblwrongQuantity;
	}


	public void setLblwrongQuantity(JLabel lblwrongQuantity) {
		this.lblwrongQuantity = lblwrongQuantity;
	}


	public JLabel getLblwrongData() {
		return lblwrongData;
	}


	public void setLblwrongData(JLabel lblwrongData) {
		this.lblwrongData = lblwrongData;
	}


	public JTextArea getTextArea() {
		return textArea;
	}


	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
}
