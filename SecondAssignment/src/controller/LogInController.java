package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import model.Administrator;
import model.Chemist;
import java.io.*;
import java.util.List;
import view.LogInView;


public class LogInController {

	private LogInView loginView;
	
	
	public LogInController(){
		this.loginView=new LogInView();
	}
	private Administrator findAdmin(String username){
		Administrator administrator=new Administrator();
		try {
            File inputFile = new File("admins.txt");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            System.out.println("Root element :" + document.getRootElement().getName());
            Element adminElement = document.getRootElement();

            List<Element> adminList = adminElement.getChildren();
            System.out.println("----------------------------");

            for (int temp = 0; temp < adminList.size(); temp++) {    
               Element admin = adminList.get(temp);
               if(admin.getChild("username").getText().compareTo(username)==0)
             	  {
            	  
             	  	administrator.setUsername(admin.getChild("username").getText());
             	  	administrator.setPassword(admin.getChild("password").getText());
             	  	break;
             	  }
             	  
            }
            
         } catch(JDOMException e) {
            e.printStackTrace();
         } catch(IOException ioe) {
            ioe.printStackTrace();
         }
		return administrator;
      }
	private Chemist findChemist(String username){
		Chemist chemist=new Chemist();
		try {
            File inputFile = new File("users.txt");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            Element usersElement = document.getRootElement();

            List<Element> usersList = usersElement.getChildren();

            for (int temp = 0; temp < usersList.size(); temp++) {    
               Element user = usersList.get(temp);
               if(user.getChild("username").getText().compareTo(username)==0)
             	  {
            	   chemist.setName(user.getChild("name").getText());
            	   chemist.setPnc(Integer.parseInt(user.getChild("pnc").getText()));
            	   chemist.setAdress(user.getChild("adress").getText());
            	   chemist.setEmail(user.getChild("email").getText());
            	   chemist.setUsername(user.getChild("username").getText());
            	   chemist.setPassword(user.getChild("password").getText());
             	  	break;
             	  }
             	  
            }
            
         } catch(JDOMException e) {
            e.printStackTrace();
         } catch(IOException ioe) {
            ioe.printStackTrace();
         }
		return chemist;
      }
	public ActionListener createListener(){
		ActionListener actionListener = new ActionListener() {			
            public void actionPerformed(ActionEvent actionEvent) {
        		String username=loginView.getUsernameField().getText();
    			String password=loginView.getPasswordField().getText();
            	MedicationController medCon=new MedicationController();
            	if(findAdmin(username).getUsername()!=null){
            		System.out.println("found admin!");
            		if(findAdmin(username).getPassword().compareTo(password)!=0)
            			loginView.getLblwrongPassword().setVisible(true);
            		else{
                    	OptionsController options=new OptionsController();
            			options.initialize();
            			loginView.getLblwrongPassword().setVisible(false);
            		}
            		
            			
            	}
            	else{
            			if(findChemist(username).getUsername()!=null){
            				System.out.println("found normal user!");
            				if(findChemist(username).getPassword().compareTo(password)!=0)
            					loginView.getLblwrongPassword().setVisible(true);
            				else{
            					loginView.getLblwrongPassword().setVisible(false);
            					medCon.initialize();
            		
            				}	
            			}
            			else
                    		loginView.getLbluserDoesNot().setVisible(true);
            		}
            	
            	loginView.getFrame().setVisible(false);	
         
       
               
            }};            
            return actionListener;
		
	}
	public void initialize(){ 
		loginView.getBtnLogIn().addActionListener(createListener());   
		loginView.getFrame().setVisible(true);
	}
}
