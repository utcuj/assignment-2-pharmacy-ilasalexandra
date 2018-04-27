package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.Medication;

public class CreateCsv implements Report {

	public void generate(List<Medication> meds) { 
	    final String NEW_LINE_SEPARATOR = "\n"; 
	    final String FILE_HEADER = "Name";

	   FileWriter fileWriter = null;
	   try {
	       fileWriter = new FileWriter("report.csv"); 
	       fileWriter.append(FILE_HEADER.toString());

	       fileWriter.append(NEW_LINE_SEPARATOR);
		 
		            for ( Medication m:meds) {
		            	if (m.getQuantity()<=1) {  
		                fileWriter.append(m.getName());  
		                fileWriter.append(NEW_LINE_SEPARATOR); 
		            }
		            }
					 
		          
		 
		        } catch (Exception e) {
		 					 
		 
		            e.printStackTrace();
		 
		        } finally {
		 
		             
		 
		            try {
	 
		                fileWriter.flush();
		 
		                fileWriter.close();
		 
		            } catch (IOException e) {
		 						 
		                e.printStackTrace();
		 
		            }
		 
		             
		 
		        }

		
	}


}
