package com.nr.springmvc.pdf;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

 

public abstract class SchoolPdfView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		  /*Document document = new Document(PageSize.A4.rotate(), 36, 36, 54, 36);
Map<String,String> mapStud=(Map<String,String>)model.get("LISTSTUD");
		
		Table t=new Table(mapStud.size());
		t.addCell("Firstname");
		t.addCell("Lastname");
		t.addCell("Grade");
		t.addCell("Section");
		t.addCell("AcademicYear");
		t.addCell("TotalAmount");
		t.addCell("FeePaid");
		t.addCell("DueFee");
		 for (Map.Entry<String, String> entry : mapStud.entrySet()) {
			 t.addCell(entry.getKey());
			 t.addCell(entry.getValue());
	      }
	      document.add(t);
		*/
	      
		Map<String,Object> mapStud=(Map<String,Object>)model.get("SUD");
	      
	      
	   // IE workaround: write into byte array first.
	      ByteArrayOutputStream baos = createTemporaryOutputStream();

	      // Apply preferences and build metadata.
	      Document document = new Document(PageSize.A4.rotate(), 36, 36, 54, 36);
	      PdfWriter writer = PdfWriter.getInstance(document, baos);
	      prepareWriter(mapStud, writer, request);
	      buildPdfMetadata(mapStud, document, request);

	      // Build PDF document.
	      document.open();
	      buildPdfDocument(mapStud, document, writer, request, response);
	      document.close();

	      // Flush to HTTP response.
	      response.setHeader("Content-Disposition", "attachment");    // make browser to ask for download/display
	      writeToResponse(response, baos);
	      
	      
	}

	protected void prepareWriter(Map<String, Object> model, PdfWriter writer, HttpServletRequest request) throws DocumentException {
	    writer.setViewerPreferences(getViewerPreferences());
	}

	protected int getViewerPreferences() {
	    return PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage;
	}


	protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request) {
	}


	protected abstract void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
	                                         HttpServletRequest request, HttpServletResponse response) throws Exception;
	 
	 
/*
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	 
		Map<String,String> mapStud=(Map<String,String>)model.get("LISTSTUD");
		
		Table t=new Table(mapStud.size());
		t.addCell("Firstname");
		t.addCell("Lastname");
		t.addCell("Grade");
		t.addCell("Section");
		t.addCell("AcademicYear");
		t.addCell("TotalAmount");
		t.addCell("FeePaid");
		t.addCell("DueFee");
		 for (Map.Entry<String, String> entry : mapStud.entrySet()) {
			 t.addCell(entry.getKey());
			 t.addCell(entry.getValue());
	      }
	      document.add(t);
		
	}*/
	
}
