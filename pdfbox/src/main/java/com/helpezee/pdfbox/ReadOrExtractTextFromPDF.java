package com.helpezee.pdfbox;

import java.io.IOException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadOrExtractTextFromPDF {

	public static void main(String[] args) {

		ReadOrExtractTextFromPDF pdf = new ReadOrExtractTextFromPDF();
		pdf.parseOnlinePdfText();
	}

	/**
	 * Parse text from an online PDF.
	 */
	private void parseOnlinePdfText() {
		final String address = "http://www.africau.edu/images/default/sample.pdf";
		try {
			final URL scalaByExampleUrl = new URL(address);
			final PDDocument documentToBeParsed = PDDocument.load(scalaByExampleUrl.openStream());
			final PDFTextStripper stripper = new PDFTextStripper();
			final String pdfText = stripper.getText(documentToBeParsed);
			System.out.println("Parsed text size is " + pdfText.length() + " characters:");
			System.out.println(pdfText);
		} catch (IOException ioEx) {
			System.out.println("Exception while trying to parse text from PDF at " + address);
		}
	}

}
