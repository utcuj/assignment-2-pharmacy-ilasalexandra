package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.OptionsView;

public class OptionsController {

	private OptionsView opView;
	public ActionListener createBackButton(){
		ActionListener actionListener = new ActionListener() {			
	        public void actionPerformed(ActionEvent actionEvent) {
	        		
	           	   LogInController newLogInCtrl= new LogInController();
	           	   newLogInCtrl.initialize();
	           	opView.getFrame().setVisible(false);
	               
	        }};  
	            
	        return actionListener;
	}
	public ActionListener createMedsButton(){
		ActionListener actionListener = new ActionListener() {			
	        public void actionPerformed(ActionEvent actionEvent) {
	        		
	           	   MedicationController medCtrl= new MedicationController();
	           	   medCtrl.initializeAdminView();
	           	   opView.getFrame().setVisible(false);
	               
	        }};  
	            
	        return actionListener;
	}
	public ActionListener createEmployeesButton(){
		ActionListener actionListener = new ActionListener() {			
	        public void actionPerformed(ActionEvent actionEvent) {
	        		
	           	   ChemistController chemCtrl= new ChemistController();
	           	   chemCtrl.initialize();
	           	   opView.getFrame().setVisible(false);
	               
	        }};  
	            
	        return actionListener;
	}
	
	
	public ActionListener createReportBtn(){
		ActionListener actionListener = new ActionListener() {			
	        public void actionPerformed(ActionEvent actionEvent) {
	       
	        	ReportFactory rep = new ReportFactory();
	        	if(opView.getRdbtnCsv().isSelected()){
	        		CreateCsv gen= (CreateCsv) rep.getReport("CSV");
					gen.generate(MedicationController.medicationList);
	        		}
	        		else
	        			if(opView.getRdbtnPdf().isSelected()){
	        				CreatePdf gen= (CreatePdf) rep.getReport("PDF");
	    					gen.generate(MedicationController.medicationList);
	        			}
	               
	        }};  
	            
	        return actionListener;
	}


	public void initialize(){
		opView=new OptionsView();
		opView.getBtnBack().addActionListener(createBackButton());
		opView.getBtnEmployees().addActionListener(createEmployeesButton());
		opView.getBtnMedication().addActionListener(createMedsButton());
		opView.getFrame().setVisible(true);
		opView.getBtnCreateReport().addActionListener(createReportBtn());
		
	}
	
}
