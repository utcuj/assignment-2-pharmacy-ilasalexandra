package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Medication;
import view.MedicationView;
import view.MedicationViewAdmin;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JComboBox;


public class MedicationController {

	private MedicationView medicationView;
	private MedicationViewAdmin medicationViewAdmin;
	public static String[] medsNames;
	public static List<Medication> medicationList= new ArrayList<Medication>();

	public ActionListener makeSell(){

		  ActionListener actionListener = new ActionListener() {			

            public void actionPerformed(ActionEvent actionEvent) {
    			int value=Integer.parseInt(medicationView.getQuantityField().getText());
    			String name=medicationView.getMedicationNameBox().getSelectedItem().toString();
            	try {
            	         File inputFile = new File("meds.txt");
            	         SAXBuilder saxBuilder = new SAXBuilder();
            	         Document document = saxBuilder.build(inputFile);
            	         Element medRootElement = document.getRootElement();

            	         List<Element> medsList = medRootElement.getChildren("med");

            	         for (int temp = 0; temp < medsList.size(); temp++) {   
            	        	  Element medElem = medsList.get(temp);            	        	
            	      
            	            if(medElem.getChild("name").getText().compareTo(name)==0)
            	            { 
            	            	
            	       
            	            	int initialQuanity= Integer.parseInt(medElem.getChild("quantity").getText());
            	            	if(initialQuanity-value>0 && value>0){
            	            		medicationView.getLblwrongQuantity().setVisible(false);
            	            		medElem.getChild("quantity").setText(Integer.toString(initialQuanity-value));
            	            		XMLOutputter xmlOutput = new XMLOutputter();

            	            		// display nice nice
            	            		xmlOutput.setFormat(Format.getPrettyFormat());
            	            		xmlOutput.output(document, new FileWriter("C:\\Users\\Alex\\workspace\\SecondAssignment\\meds.txt"));
            	            		System.out.println("Done");
            	            	}
            	            	else{
            	            		medicationView.getLblwrongQuantity().setVisible(true);
            	            	}
            	            		
            	            	
            	            }
            	         }
        	            
            	      } catch(JDOMException e) {
            	         e.printStackTrace();
            	      } catch(IOException ioe) {
            	         ioe.printStackTrace();
            	      }
            	   
               
            }};          
            return actionListener;
	}
	public static String[] setMedsNameList(){
		
		List<String> medNames=new ArrayList<String>();
		try {
	         File inputFile = new File("meds.txt");
	         SAXBuilder saxBuilder = new SAXBuilder();
	         Document document = saxBuilder.build(inputFile);
	         Element medRootElement = document.getRootElement();

	         List<Element> medsList = medRootElement.getChildren("med");
	         
	         for (int temp = 0; temp < medsList.size(); temp++) {    
	            Element med = medsList.get(temp);
	            medNames.add(med.getChildText("name"));
	         }
	         
	         } catch(JDOMException e) {
    	         e.printStackTrace();
    	      } catch(IOException ioe) {
    	         ioe.printStackTrace();
    	      }
		
		String[] namesArray = new String[medNames.size()];
		medNames.toArray(namesArray);
		return namesArray;
	}
	public ActionListener createBackButton(){
		ActionListener actionListener = new ActionListener() {			
        public void actionPerformed(ActionEvent actionEvent) {
        		
           	   LogInController newLogInCtrl= new LogInController();
           	   newLogInCtrl.initialize();
           	   medicationView.getFrame().setVisible(false);
               
        }};  
            
        return actionListener;
	}
	public ActionListener createBackButtonAdmin(){
		ActionListener actionListener = new ActionListener() {			
        public void actionPerformed(ActionEvent actionEvent) {
        		
           	   OptionsController newLogInCtrl= new OptionsController();
           	   newLogInCtrl.initialize();
           	   medicationViewAdmin.getFrame().setVisible(false);
               
        }};  
            
        return actionListener;
	}
	public void setMedsViewAdmin( ){
		try {
  	         File inputFile = new File("meds.txt");
  	         SAXBuilder saxBuilder = new SAXBuilder();
  	         Document document = saxBuilder.build(inputFile);
  	         Element medRootElement = document.getRootElement();

  	         List<Element> medsList = medRootElement.getChildren("med");
  	         List<Medication> meds=new ArrayList<Medication>();
  	         for (int temp = 0; temp < medsList.size(); temp++) 
  	         {   
  	        	  Element medElem = medsList.get(temp);
  	   
        	      String ingr=medElem.getChild("ingredients").getText();
        	      StringTokenizer stok = new StringTokenizer(ingr, " ");
        	      String[]tokens = new String[stok.countTokens()];
     			  List<String> ingredients=new ArrayList<String>();
     			  for(int i=0; i<tokens.length; i++)
     				{
     					tokens[i] = stok.nextToken();
     					ingredients.add(tokens[i]);
     				}
        	       Medication med=new Medication();
        	       med.setName(medElem.getChild("name").getText());
        	       med.setPrice(Integer.parseInt(medElem.getChild("price").getText()));
        	       med.setQuantity(Integer.parseInt(medElem.getChild("quantity").getText()));
        	       med.setManufacturer(medElem.getChild("manufacturer").getText());
        	       med.setIngredients(ingredients);
        	       meds.add(med);
        	       medicationList.add(med);
        	  }
  	        	 
  	    
  	          List<String> textAreaData = new ArrayList<String>();
  	          for(Medication m:meds){
  	        	 if(m!=null){
       	 	    	String aux="Name: "+m.getName()+"\nIngredients: "+Arrays.toString(m.getIngredients().toArray()).toString()+"\nManufacturer: "+m.getManufacturer()+"\nQuantity: "+Integer.toString(m.getQuantity())+"\nPrice: "+Integer.toString(m.getPrice())+"RON\n-------------------\n";
  	 	    		textAreaData.add(aux);
  	        	 }
  	          }
  	          medicationViewAdmin.getTextArea().setText(textAreaData.toString());
  	         }catch(JDOMException e) {
       	         e.printStackTrace();
       	     } catch(IOException ioe) {
       	         ioe.printStackTrace();
       	     }
	}
	public void viewMeds(){
		ActionListener actionListener = new ActionListener() {			
	        public void actionPerformed(ActionEvent actionEvent) {
	        	String searchString=medicationView.getViewInfoBox().getSelectedItem().toString();
	        	String dataString=medicationView.getSearchData().getText().toString();
	        	try {
       	         File inputFile = new File("meds.txt");
       	         SAXBuilder saxBuilder = new SAXBuilder();
       	         Document document = saxBuilder.build(inputFile);
       	         Element medRootElement = document.getRootElement();

       	         List<Element> medsList = medRootElement.getChildren("med");
       	         List<Medication> meds=new ArrayList<Medication>();
       	         for (int temp = 0; temp < medsList.size(); temp++) {   
       	        	  Element medElem = medsList.get(temp);
       	        	 
       	        	  String a="ingredient";
       	        	 
       	        	  if(searchString.toLowerCase().compareTo(a)==0){
       	        		  String ingr=medElem.getChild("ingredients").getText();
       	        		  StringTokenizer stok = new StringTokenizer(ingr, " ");
       	        		  String[]tokens = new String[stok.countTokens()];
       	        		  List<String> ingredients=new ArrayList<String>();
       	        		  for(int i=0; i<tokens.length; i++)
    						{
    							tokens[i] = stok.nextToken();
    							ingredients.add(tokens[i]);
    						}
       	        		  for(String s:ingredients){
       	        			  if(s!=null && s.compareTo(dataString.toLowerCase())==0){
       	        				Medication med=new Medication();
       	       	            	med.setName(medElem.getChild("name").getText());
       	       	            	med.setPrice(Integer.parseInt(medElem.getChild("price").getText()));
       	       	            	med.setQuantity(Integer.parseInt(medElem.getChild("quantity").getText()));
       	       	            	med.setManufacturer(medElem.getChild("manufacturer").getText());
       	       	            	med.setIngredients(ingredients);
       	       	            	meds.add(med);
       	       	            	break;
       	        			  }
       	        		  }
       	        	  }
       	        	  else{
       	        		  if(medElem.getChild(searchString.toLowerCase()).getText().compareTo(dataString.toLowerCase())==0)
       	        		{ 
             	            	String ingr=medElem.getChild("ingredients").getText();
             	            	StringTokenizer stok = new StringTokenizer(ingr, " ");
          					String[]tokens = new String[stok.countTokens()];
          					List<String> ingredients=new ArrayList<String>();
          					for(int i=0; i<tokens.length; i++)
          						{
          							tokens[i] = stok.nextToken();
          							ingredients.add(tokens[i]);
          						}
             	            	Medication med=new Medication();
             	            	med.setName(medElem.getChild("name").getText());
             	            	med.setPrice(Integer.parseInt(medElem.getChild("price").getText()));
             	            	med.setQuantity(Integer.parseInt(medElem.getChild("quantity").getText()));
             	            	med.setManufacturer(medElem.getChild("manufacturer").getText());
             	            	med.setIngredients(ingredients);
             	            	meds.add(med);
             	         }
       	        	  }
       	            
       	            }
       	        List<String> textAreaData = new ArrayList<String>();
       	         for(Medication m:meds){
       	        	 if(m!=null){
           	 	    	String aux="Name: "+m.getName()+"\nIngredients: "+Arrays.toString(m.getIngredients().toArray()).toString()+"\nManufacturer: "+m.getManufacturer()+"\nQuantity: "+Integer.toString(m.getQuantity())+"\nPrice: "+Integer.toString(m.getPrice())+"RON\n-------------------\n";
       	 	    		textAreaData.add(aux);
       	 	    		
       	 	    		
       	        	 }
       	         }
       	         medicationView.getTextArea().setText(textAreaData.toString());
       	  
       	      } catch(JDOMException e) {
       	         e.printStackTrace();
       	      } catch(IOException ioe) {
       	         ioe.printStackTrace();
       	      }
       	   
                   
	               
	        }};  
	        medicationView.getViewInfoBox().addActionListener(actionListener);
	        
	}
	public ActionListener chooseAddBtn(){
		ActionListener actionListener = new ActionListener() {			
	        public void actionPerformed(ActionEvent actionEvent) {
	        		
	           	   medicationViewAdmin.getAddPanel().setVisible(true);
	           	   medicationViewAdmin.getDeletePanel().setVisible(false);
	           	   medicationViewAdmin.getUpdatePanel().setVisible(false);
	               
	        }};  
	            
	        return actionListener;
	}
	public ActionListener chooseDeleteBtn(){
		ActionListener actionListener = new ActionListener() {			
	        public void actionPerformed(ActionEvent actionEvent) {
	        		
	           	   medicationViewAdmin.getDeletePanel().setVisible(true);
	           	   medicationViewAdmin.getUpdatePanel().setVisible(false);
	           	   medicationViewAdmin.getAddPanel().setVisible(false);
	               
	        }};  
	            
	        return actionListener;
	}
	public ActionListener chooseUpdateBtn(){
		ActionListener actionListener = new ActionListener() {			
	        public void actionPerformed(ActionEvent actionEvent) {
	        		
	           	   medicationViewAdmin.getUpdatePanel().setVisible(true);
	           	   medicationViewAdmin.getAddPanel().setVisible(false);
	           	   medicationViewAdmin.getDeletePanel().setVisible(false);
	               
	        }};  
	            
	        return actionListener;
	}
	public ActionListener addNewMed(){
		ActionListener actionListener = new ActionListener() {			
	        public void actionPerformed(ActionEvent actionEvent) {
		 	  try {
		 		 File inputFile = new File("meds.txt");
		         SAXBuilder saxBuilder = new SAXBuilder();
		         Document document = saxBuilder.build(inputFile);
       	         Element medRootElement = document.getRootElement();
		         Element newMed= new Element("med");
		         List<Element> medsList = medRootElement.getChildren("med");
		         boolean existsMed=false;
       	         for (int temp = 0; temp < medsList.size(); temp++) {   
       	        	  Element medElem = medsList.get(temp);
       	        	  String nameCheck= medElem.getChild("name").getValue();
       	        	  if(nameCheck.compareTo(medicationViewAdmin.getNameField().getText())==0)
       	        	  {
       	        		  existsMed=true;
       	        		  break;
       	        	  }}
       	         if(!existsMed)
       	        	  
       	         {
       	        		
       	        	 newMed.addContent(new Element("name").setText(medicationViewAdmin.getNameField().getText()));
       			     newMed.addContent(new Element("ingredients").setText(medicationViewAdmin.getIngredientsField().getText()));
       			     newMed.addContent(new Element("manufacturer").setText(medicationViewAdmin.getManufacturerField().getText()));
       			     newMed.addContent(new Element("quantity").setText(medicationViewAdmin.getQuantityField().getText()));
       			     newMed.addContent(new Element("price").setText(medicationViewAdmin.getPriceField().getText()));
       			     medRootElement.addContent(newMed);
       		         document.setContent(medRootElement);
         	         XMLOutputter xmlOutput = new XMLOutputter();

       	         		// display nice nice
               		xmlOutput.setFormat(Format.getPrettyFormat());
   	         		xmlOutput.output(document, new FileWriter("C:\\Users\\Alex\\workspace\\SecondAssignment\\meds.txt"));    	         	
   	         		System.out.println("Done!");
       	         
       	         }
       	         else{
       	        	 System.out.println("Med already exists");
       	        	 
       	         }
       	         medsNames=MedicationController.setMedsNameList();
       			setMedsViewAdmin();
		 	  }	catch(JDOMException e) {
      	         e.printStackTrace();
      	      } catch(IOException ioe) {
      	         ioe.printStackTrace();
      	      }
	         
	        }};
	return actionListener;	
	}
	public ActionListener deleteMed(){
		ActionListener actionListener = new ActionListener() {			
	        public void actionPerformed(ActionEvent actionEvent) {
		 	  try {
		 		 File inputFile = new File("meds.txt");
		         SAXBuilder saxBuilder = new SAXBuilder();
		         Document document = saxBuilder.build(inputFile);
       	         Element medRootElement = document.getRootElement();
       	         
		         List<Element> medsList = medRootElement.getChildren("med");
		         boolean found=false;
       	         for (int temp = 0; temp < medsList.size(); temp++) {   
       	        	  Element medElem = medsList.get(temp);
       	        	  String nameCheck= medElem.getChild("name").getValue();
       	        	  if(nameCheck.compareTo(medicationViewAdmin.getDeleteByNameField().getText())==0)
       	        	  {
       	        		  medRootElement.removeContent(medElem);
       	        
       	        		  found=true;
       	        		  break;
       	        	  }}
       	         	if(found){
       	         		System.out.println("Done");
       	         	}
       	         	else{
       	         	System.out.println("Couldn't find the med");
       	         	}
       		         document.setContent(medRootElement);
         	         XMLOutputter xmlOutput = new XMLOutputter();

       	         		// display nice nice
               		xmlOutput.setFormat(Format.getPrettyFormat());
   	         		xmlOutput.output(document, new FileWriter("C:\\Users\\Alex\\workspace\\SecondAssignment\\meds.txt"));    	         	
       	        
       			setMedsViewAdmin();
       			medsNames=MedicationController.setMedsNameList();
       			
		 	  }	catch(JDOMException e) {
      	         e.printStackTrace();
      	      } catch(IOException ioe) {
      	         ioe.printStackTrace();
      	      }
	         
	        }};
	return actionListener;	
	}
	public ActionListener updateMed(){
		ActionListener actionListener = new ActionListener() {			
	        public void actionPerformed(ActionEvent actionEvent) {
		 	  try {
		 		 File inputFile = new File("meds.txt");
		         SAXBuilder saxBuilder = new SAXBuilder();
		         Document document = saxBuilder.build(inputFile);
       	         Element medRootElement = document.getRootElement();
       	         
		         List<Element> medsList = medRootElement.getChildren("med");
		         String field=medicationViewAdmin.getSelectFieldOptions().getSelectedItem().toString();
		         String medName=medicationViewAdmin.getSelectMedBox().getSelectedItem().toString();
       	         for (int temp = 0; temp < medsList.size(); temp++) {   
       	        	  Element medElem = medsList.get(temp);
       	        	  if(medElem.getChild("name").getValue().compareTo(medName)==0)
       	        	  {
       	        		medElem.getChild(field.toLowerCase()).setText(medicationViewAdmin.getUpdateDataField().getText().toString());
  	            		System.out.println("Update!");
  	            		break;
              	           
       	        		 
       	        	  }}
       	         
       		         document.setContent(medRootElement);
         	         XMLOutputter xmlOutput = new XMLOutputter();

       	         		// display nice nice
               		xmlOutput.setFormat(Format.getPrettyFormat());
   	         		xmlOutput.output(document, new FileWriter("C:\\Users\\Alex\\workspace\\SecondAssignment\\meds.txt"));    	         	
       	        
       			setMedsViewAdmin();
       			medsNames=MedicationController.setMedsNameList();
       			medicationViewAdmin.setSelectMedBox(new JComboBox<String>(medsNames));
		 	  }	catch(JDOMException e) {
      	         e.printStackTrace();
      	      } catch(IOException ioe) {
      	         ioe.printStackTrace();
      	      }
	         
	        }};
	return actionListener;	
	}
	
	public void initialize(){
		medsNames=MedicationController.setMedsNameList();

		medicationView=new MedicationView();
		
		medicationView.getBtnSell().addActionListener(makeSell());
		medicationView.getBtnBack().addActionListener(createBackButton());
		viewMeds();
		medicationView.getFrame().setVisible(true);
	}
	public void initializeAdminView(){
		medsNames=MedicationController.setMedsNameList();
		medicationViewAdmin= new MedicationViewAdmin();	
		medicationViewAdmin.getFrame().addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		    	medicationViewAdmin.getAddPanel().setVisible(false);
		    	medicationViewAdmin.getDeletePanel().setVisible(false);
		    	medicationViewAdmin.getUpdatePanel().setVisible(false);
		    }
		});
		medicationViewAdmin.getBtnChooseAdd().addActionListener(chooseAddBtn());
		medicationViewAdmin.getBtnChooseDelete().addActionListener(chooseDeleteBtn());
		medicationViewAdmin.getBtnChooseUpdate().addActionListener(chooseUpdateBtn());
		medicationViewAdmin.getBtnBack().addActionListener(createBackButtonAdmin());
		medicationViewAdmin.getBtnAdd().addActionListener(addNewMed());
		medicationViewAdmin.getBtnDelete().addActionListener(deleteMed());
		medicationViewAdmin.getBtnUpdate().addActionListener(updateMed());
		setMedsViewAdmin();
		medicationViewAdmin.getFrame().setVisible(true);
		
	}
}
