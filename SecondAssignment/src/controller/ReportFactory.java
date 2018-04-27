package controller;

public class ReportFactory {
	 public Report getReport(String repType){
	      if(repType == null){
	         return null;
	      }		
	      if(repType.equalsIgnoreCase("CSV")){
	         return new CreateCsv();
	         
	      } else if(repType.equalsIgnoreCase("PDF")){
	         return new CreatePdf();
	         
	      }
	      return null;
	   }
}
