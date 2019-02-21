package com.helpezee.pdfbox;

import java.io.IOException;
import java.text.MessageFormat;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class SamplePdfWithPageNos {

	public static void main(String[] args) {

		 SamplePdfWithPageNos pdf= new SamplePdfWithPageNos();
		 pdf.createHelloDocument();

	}
	
	/**
	 * Create simple, single-page PDF "Hello" document.
	 */
	private void createHelloDocument()
	{
	   final PDPage singlePage = new PDPage();
	   final PDFont courierBoldFont = PDType1Font.COURIER_BOLD;
	   final int fontSize = 12;
	   try (final PDDocument document = new PDDocument())
	   {
	      document.addPage(singlePage);
	      final PDPageContentStream contentStream = new PDPageContentStream(document, singlePage);
	      addPageNumbers(document, "Page of {0} /"+ document.getNumberOfPages(), 60, 18);
	      contentStream.beginText();
	      contentStream.setFont(courierBoldFont, fontSize);
	      contentStream.newLineAtOffset(150, 750);
	      contentStream.showText("Hello PDFBox");
	      contentStream.endText();
	      contentStream.close();  // Stream must be closed before saving document.
	      document.save("HelloPDFBox.pdf");
	   }
	   catch (IOException ioEx)
	   {
	      System.out.println("Exception while trying to create simple document - " + ioEx);
	   }
	}
	
	public static void addPageNumbers(PDDocument document, String numberingFormat, int offset_X, int offset_Y) throws IOException {
        int page_counter = 1;
        for(PDPage page : document.getPages()){
            PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, false);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_ITALIC, 10);
            PDRectangle pageSize = page.getMediaBox();
            float x = pageSize.getLowerLeftX();
            float y = pageSize.getLowerLeftY();
            contentStream.newLineAtOffset(x+ pageSize.getWidth()-offset_X, y+offset_Y);
            String text = MessageFormat.format(numberingFormat,page_counter);
            contentStream.showText(text);
            contentStream.endText();
            contentStream.close();
            ++page_counter;
        }
    }

}


