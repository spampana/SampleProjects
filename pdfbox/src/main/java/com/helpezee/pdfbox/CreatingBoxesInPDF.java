package com.helpezee.pdfbox;

import java.awt.Color;
import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

public class CreatingBoxesInPDF {

	 public static void main(String args[]) throws Exception {

	      //Loading an existing document
	      File file = new File("EmptyPage.pdf");
	      PDDocument document = PDDocument.load(file);
	        
	      //Retrieving a page of the PDF Document
	      PDPage page = document.getPage(0);

	      //Instantiating the PDPageContentStream class
	      PDPageContentStream contentStream = new PDPageContentStream(document, page);
	       
	      //Setting the non stroking color
	      contentStream.setNonStrokingColor(Color.DARK_GRAY);

	      //Drawing a rectangle 
	      contentStream.addRect(200, 650, 100, 100);

	      //Drawing a rectangle
	      contentStream.fill();

	      System.out.println("rectangle added");

	      //Closing the ContentStream object
	      contentStream.close();

	      //Saving the document
	      File file1 = new File("Colorbox.pdf");
	      document.save(file1);

	      //Closing the document
	      document.close();
}
}