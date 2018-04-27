package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JComboBox;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import model.Chemist;
import model.Medication;
import view.EmployeesView;

public class ChemistController {

	private EmployeesView view;
	
	public ActionListener createBackButtonAdmin(){
		ActionListener actionListener = new ActionListener() {			
        public void actionPerformed(ActionEvent actionEvent) {
        		
           	   OptionsController newLogInCtrl= new OptionsController();
           	   newLogInCtrl.initialize();
           	   view.getFrame().setVisible(false);
               
        }};  
            
        return actionListener;
	}
	public ActionListener chooseAddBtn(){
		ActionListener actionListener = new ActionListener() {			
	        public void actionPerformed(ActionEvent actionEvent) {
	        		
	           	view.getAddPanel().setVisible(true);
	           	view.getDeletePanel().setVisible(false);
	           	view.getUpdatePanel().setVisible(false);
	               
	        }};  
	            
	        return actionListener;
	}
	public ActionListener chooseDeleteBtn(){
		ActionListener actionListener = new ActionListener() {			
	        public void actionPerformed(ActionEvent actionEvent) {
	        		
	        	view.getDeletePanel().setVisible(true);
	        	view.getUpdatePanel().setVisible(false);
	        	view.getAddPanel().setVisible(false);
	               
	        }};  
	            
	        return actionListener;
	}
	public ActionListener chooseUpdateBtn(){
		ActionListener actionListener = new ActionListener() {			
	        public void actionPerformed(ActionEvent actionEvent) {
	        		
	        	view.getUpdatePanel().setVisible(true);
	        	view.getAddPanel().setVisible(false);
	        	view.getDeletePanel().setVisible(false);
	               
	        }};  
	            
	        return actionListener;
	}
	public ActionListener addNewChemist(){
		ActionListener actionListener = new ActionListener() {			
	        public void actionPerformed(ActionEvent actionEvent) {
		 	  try {
		 		 File inputFile = new File("users.txt");
		         SAXBuilder saxBuilder = new SAXBuilder();
		         Document document = saxBuilder.build(inputFile);
       	         Element chemRootElem = document.getRootElement();
		         Element newChem= new Element("chemist");
		         List<Element> chemList = chemRootElem.getChildren("chemist");
		         boolean existsMed=false;
       	         for (int temp = 0; temp < chemList.size(); temp++) {   
       	        	  Element chemElem = chemList.get(temp);
       	        	  String nameCheck= chemElem.getChild("name").getValue();
       	        	  if(nameCheck.compareTo(view.getNameField().getText())==0)
       	        	  {
       	        		  existsMed=true;
       	        		  break;
       	        	  }}
       	         if(!existsMed)
       	        	  
       	         {
       	        		
       	        	newChem.addContent(new Element("name").setText(view.getNameField().getText()));
       	        	newChem.addContent(new Element("pnc").setText(view.getPncField().getText()));
       	        	newChem.addContent(new Element("adress").setText(view.getAdressField().getText()));
       	        	newChem.addContent(new Element("email").setText(view.getEmailField().getText()));
       	        	newChem.addContent(new Element("username").setText(view.getUserField().getText()));
       	        	newChem.addContent(new Element("password").setText(view.getPasswordField().getText()));

       	        	chemRootElem.addContent(newChem);
       		        document.setContent(chemRootElem);
         	        XMLOutputter xmlOutput = new XMLOutputter();

       	         		// display nice nice
               		xmlOutput.setFormat(Format.getPrettyFormat());
   	         		xmlOutput.output(document, new FileWriter("C:\\Users\\Alex\\workspace\\SecondAssignment\\users.txt"));    	         	
   	         		System.out.println("Added!");
       	         }
       	         else{
       	        	 System.out.println("Chemist already exists");
       	        	 
       	         }
       	       //  medsNames=MedicationController.setMedsNameList();
       			//setMedsViewAdmin();
		 	  }	catch(JDOMException e) {
      	         e.printStackTrace();
      	      } catch(IOException ioe) {
      	         ioe.printStackTrace();
      	      }
	         
	        }};
	return actionListener;	
	}
	public void setEmployeesView( ){
		try {
  	         File inputFile = new File("users.txt");
  	         SAXBuilder saxBuilder = new SAXBuilder();
  	         Document document = saxBuilder.build(inputFile);
  	         Element chemRootElem = document.getRootElement();

  	         List<Element> chemList = chemRootElem.getChildren("chemist");
  	         List<Chemist> chems=new ArrayList<Chemist>();
  	         for (int temp = 0; temp < chemList.size(); temp++) 
  	         {   
  	        	  Element chemElem = chemList.get(temp);
  	  
        	       Chemist chem=new Chemist();
        	       chem.setName(chemElem.getChild("name").getText());
        	       chem.setPnc(Integer.parseInt(chemElem.getChild("pnc").getText()));
        	       chem.setAdress(chemElem.getChild("adress").getText());
        	       chem.setEmail(chemElem.getChild("email").getText());
        	       chem.setUsername(chemElem.getChild("username").getText());
        	       chem.setPassword(chemElem.getChild("password").getText());

        	       chems.add(chem);
        	  }
  	        	 
  	    
  	          List<String> textAreaData = new ArrayList<String>();
  	          for(Chemist m:chems){
  	        	 if(m!=null){
       	 	    	String aux="Name: "+m.getName()+"\nPnc: "+m.getPnc()+"\nAdress: "+m.getAdress()+"\nEmail: "+m.getEmail()+"\nUsername: "+m.getUsername()+"\nPassword:"+m.getPassword()+"\n-------------------\n";
  	 	    		textAreaData.add(aux);
  	 	    		System.out.println(aux);
  	        	 }
  	          }
  	          view.getTextArea().setText(textAreaData.toString());
  	         }catch(JDOMException e) {
       	         e.printStackTrace();
       	     } catch(IOException ioe) {
       	         ioe.printStackTrace();
       	     }
	}
	
	public ActionListener deleteChem(){
		ActionListener actionListener = new ActionListener() {			
	        public void actionPerformed(ActionEvent actionEvent) {
		 	  try {
		 		 File inputFile = new File("users.txt");
		         SAXBuilder saxBuilder = new SAXBuilder();
		         Document document = saxBuilder.build(inputFile);
       	         Element chemRootElem = document.getRootElement();
       	         
		         List<Element> chemList = chemRootElem.getChildren("chemist");
		         boolean found=false;
       	         for (int temp = 0; temp < chemList.size(); temp++) {   
       	        	  Element chemElem = chemList.get(temp);
       	        	  String nameCheck= chemElem.getChild("pnc").getValue();
       	        	  if(nameCheck.compareTo(view.getDeleteByIdField().getText())==0)
       	        	  {
       	        		  chemRootElem.removeContent(chemElem);
       	        		  found=true;
       	        		  break;
       	        	  }}
       	         	if(found){
       	         		System.out.println("Done");
       	         	}
       	         	else{
       	         	System.out.println("Couldn't find the user");
       	         	}
       		         document.setContent(chemRootElem);
         	         XMLOutputter xmlOutput = new XMLOutputter();

       	         		// display nice nice
               		xmlOutput.setFormat(Format.getPrettyFormat());
   	         		xmlOutput.output(document, new FileWriter("C:\\Users\\Alex\\workspace\\SecondAssignment\\users.txt"));    	         	
       	        
       			setEmployeesView();
		 	  }	catch(JDOMException e) {
      	         e.printStackTrace();
      	      } catch(IOException ioe) {
      	         ioe.printStackTrace();
      	      }
	         
	        }};
	return actionListener;	
	}
	
	public ActionListener updateChemist(){
		ActionListener actionListener = new ActionListener() {			
	        public void actionPerformed(ActionEvent actionEvent) {
		 	  try {
		 		 File inputFile = new File("users.txt");
		         SAXBuilder saxBuilder = new SAXBuilder();
		         Document document = saxBuilder.build(inputFile);
       	         Element chemRootElem = document.getRootElement();
       	         
		         List<Element> chemList = chemRootElem.getChildren("chemist");
		         String field=view.getComboBox().getSelectedItem().toString();

		         for (int temp = 0; temp < chemList.size(); temp++) {   
       	        	  Element chemElem = chemList.get(temp);
       	        	  if(chemElem.getChild("pnc").getValue().compareTo(view.getIdUpdateField().getText())==0)
       	        	  {
       	        		chemElem.getChild(field.toLowerCase()).setText(view.getUpdatetDataField().getText().toString());
  	            		System.out.println("Update!");
  	            		break;
              	           
       	        		 
       	        	  }}
       	         
       		         document.setContent(chemRootElem);
         	         XMLOutputter xmlOutput = new XMLOutputter();

       	         		// display nice nice
               		xmlOutput.setFormat(Format.getPrettyFormat());
   	         		xmlOutput.output(document, new FileWriter("C:\\Users\\Alex\\workspace\\SecondAssignment\\users.txt"));    	         	
       	        
       			setEmployeesView();
		 	  }	catch(JDOMException e) {
      	         e.printStackTrace();
      	      } catch(IOException ioe) {
      	         ioe.printStackTrace();
      	      }
	         
	        }};
	return actionListener;	
	}
	
	public void initialize(){
		view = new EmployeesView();
		setEmployeesView();
		view.getFrame().addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		    	view.getAddPanel().setVisible(false);
		    	view.getDeletePanel().setVisible(false);
		    	view.getUpdatePanel().setVisible(false);
		    }
		});
		view.getBtnBack().addActionListener(createBackButtonAdmin());
		view.getBtnChooseAdd().addActionListener(chooseAddBtn());
		view.getBtnChooseDelete().addActionListener(chooseDeleteBtn());
		view.getBtnChooseUpdate().addActionListener(chooseUpdateBtn());
		view.getBtnAdd().addActionListener(addNewChemist());
		view.getBtnDelete().addActionListener(deleteChem());
		//view.getBtnUpdate().addActionListener(updateChemist());
	}
	
}
