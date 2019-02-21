package com.helpezee.pdfbox;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class CreateEmptyPDF {


/**
 * Demonstrate creation of an empty PDF.
 */
private void createEmptyDocument()
{
   try (final PDDocument document = new PDDocument())
   {
      final PDPage emptyPage = new PDPage();
      document.addPage(emptyPage);
      document.save("EmptyPage.pdf");
   }
   catch (IOException ioEx)
   {
      System.out.println("Exception while trying to create blank document - " + ioEx);
   }
}

public static void main(String[] args) throws IOException {
	CreateEmptyPDF pdf = new CreateEmptyPDF();
	pdf.createEmptyDocument();
}
}
