package view;

import javax.swing.JFrame;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;


public class OptionsView {
	private JFrame frame;
	private JButton btnEmployees;
	private JButton btnMedication;
	private JButton btnBack; 
	private JRadioButton rdbtnCsv;
	private JRadioButton rdbtnPdf;
	private JButton btnCreateReport;
	/**
	 * @wbp.parser.entryPoint
	 */

	public OptionsView(){
		frame=new JFrame("Options");
		frame.getContentPane().setLayout(null);
		frame.setBounds(700, 300, 445, 298);

		btnEmployees = new JButton("Employees");
		
		btnEmployees.setBounds(37, 55, 150, 62);
		frame.getContentPane().add(btnEmployees);
		
		btnMedication = new JButton("Medication");
		btnMedication.setBounds(239, 55, 150, 62);
		frame.getContentPane().add(btnMedication);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(0, 230, 97, 25);
		frame.getContentPane().add(btnBack);
		
		rdbtnCsv = new JRadioButton("csv");
		rdbtnCsv.setBounds(58, 176, 47, 25);
		frame.getContentPane().add(rdbtnCsv);
		
		JLabel lblCreateReport = new JLabel("Create report:");
		lblCreateReport.setBounds(58, 151, 100, 16);
		frame.getContentPane().add(lblCreateReport);
		
		rdbtnPdf = new JRadioButton("pdf");
		rdbtnPdf.setBounds(111, 176, 47, 25);
		frame.getContentPane().add(rdbtnPdf);
		
		btnCreateReport = new JButton("Create report");
		btnCreateReport.setBounds(174, 176, 119, 25);
		frame.getContentPane().add(btnCreateReport);
	}

	
	
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JButton getBtnEmployees() {
		return btnEmployees;
	}
	public void setBtnEmployees(JButton btnEmployees) {
		this.btnEmployees = btnEmployees;
	}
	public JButton getBtnMedication() {
		return btnMedication;
	}
	public void setBtnMedication(JButton btnMedication) {
		this.btnMedication = btnMedication;
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}



	public JRadioButton getRdbtnCsv() {
		return rdbtnCsv;
	}



	public void setRdbtnCsv(JRadioButton rdbtnCsv) {
		this.rdbtnCsv = rdbtnCsv;
	}



	public JRadioButton getRdbtnPdf() {
		return rdbtnPdf;
	}



	public void setRdbtnPdf(JRadioButton rdbtnPdf) {
		this.rdbtnPdf = rdbtnPdf;
	}



	public JButton getBtnCreateReport() {
		return btnCreateReport;
	}



	public void setBtnCreateReport(JButton btnCreateReport) {
		this.btnCreateReport = btnCreateReport;
	}



}
