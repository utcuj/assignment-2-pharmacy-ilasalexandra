package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import model.Medication;

public class CreatePdf implements Report  {

	@Override
	public void generate(List<Medication> a) {
	
		try {
			PdfWriter writer = new PdfWriter("output.pdf");
	        PdfDocument pdf = new PdfDocument(writer);
	        @SuppressWarnings("resource")
			Document document = new Document(pdf);
	
			for (Medication m:a)
			{
				System.out.println(m.getName());
				if (m.getQuantity()<=1)
				{
					document.add(new Paragraph("The medicine named: "+m.getName()+" it's out of stock!\n"));
				}
			}
			
		} catch (FileNotFoundException  e) {
			e.printStackTrace();
		}
	
		
	}

}
