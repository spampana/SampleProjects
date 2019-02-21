package com.helpezee.pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

public class RemovingPageFromExistingPFDF {

	public static void main(String[] args) throws InvalidPasswordException, IOException {

		//Loading an existing PDF document
	      File file = new File("MultiPageDocument.pdf");
	      PDDocument document = PDDocument.load(file); 
	      document.setAllSecurityToBeRemoved(true);
	      
	      //Listing the number of existing pages
	      int noOfPages= document.getNumberOfPages();
	      System.out.println("Number Of Pages : "+ noOfPages);
	       
	      //Removing the page 1
	      document.removePage(0);
	      
	      System.out.println("page removed");

	      //Saving the document
	      document.save("NewPDFAfterRemovingPage2.pdf");

	      //Closing the document
	      document.close();

	}

}
