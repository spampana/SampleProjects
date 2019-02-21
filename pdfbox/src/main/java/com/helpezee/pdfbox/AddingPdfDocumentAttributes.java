package com.helpezee.pdfbox;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class AddingPdfDocumentAttributes {

	public static void main(String[] args) throws IOException {
		
		  //Creating PDF document object
	      PDDocument document = new PDDocument();

	      //Creating a blank page
	      PDPage blankPage = new PDPage();
	       
	      //Adding the blank page to the document
	      document.addPage( blankPage );

	      //Creating the PDDocumentInformation object 
	      PDDocumentInformation pdd = document.getDocumentInformation();

	      //Setting the author of the document
	      pdd.setAuthor("Tutorialspoint");
	       
	      // Setting the title of the document
	      pdd.setTitle("Sample document"); 
	       
	      //Setting the creator of the document 
	      pdd.setCreator("PDF Examples"); 
	       
	      //Setting the subject of the document 
	      pdd.setSubject("Example document"); 
	       
	      //Setting the created date of the document 
	      Calendar date = new GregorianCalendar();
	      date.set(2015, 11, 5); 
	      pdd.setCreationDate(date);
	      //Setting the modified date of the document 
	      date.set(2016, 6, 5); 
	      pdd.setModificationDate(date); 
	       
	      //Setting keywords for the document 
	      pdd.setKeywords("sample, first example, my pdf"); 
	      
	      
	      PDPageContentStream contentStream = new PDPageContentStream(document, blankPage);
	      
	      //Begin the Content stream 
	      contentStream.beginText(); 
	       
	      //Setting the font to the Content stream  
	      contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

	      //Setting the position for the line 
	      contentStream.newLineAtOffset(25, 500);

	      String text = "This is the sample document and we are adding content to it.";

	      //Adding text in the form of string 
	      contentStream.showText(text);      

	      //Ending the content stream
	      contentStream.endText();

	      System.out.println("Content added");

	      //Closing the content stream
	      contentStream.close();
	 
	      //Saving the document 
	      document.save("doc_attributes.pdf");

	      System.out.println("Properties added successfully ");
	       
	      //Closing the document
	      document.close();
	}

}
