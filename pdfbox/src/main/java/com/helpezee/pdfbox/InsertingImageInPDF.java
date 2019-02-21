package com.helpezee.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class InsertingImageInPDF {

	public static void main(String[] args) throws InvalidPasswordException, IOException {
		//Loading an existing document
	      File file = new File("EmptyPage.pdf");
	      PDDocument doc = PDDocument.load(file);
	        
	      //Retrieving the page
	      PDPage page = doc.getPage(0);
	       
	      //Creating PDImageXObject object
	      PDImageXObject pdImage = PDImageXObject.createFromFile("rose-blue-flower-rose-blooms-67636.jpeg",doc);
	       
	      //creating the PDPageContentStream object
	      PDPageContentStream contents = new PDPageContentStream(doc, page);

	      //Drawing the image in the PDF document
	      contents.drawImage(pdImage, 10, 10);

	      System.out.println("Image inserted");
	      
	      //Closing the PDPageContentStream object
	      contents.close();		
			
	      //Saving the document
	      doc.save("ImagePDF.pdf");
	            
	      //Closing the document
	      doc.close();

	}

}
