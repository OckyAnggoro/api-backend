package com.app.print;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ReportExporter {
	/**
	 * Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(ReportExporter.class);

	/**
	 * The path to the file must exist.
	 * 
	 * @param jp
	 * @param path
	 * @throws JRException
	 * @throws FileNotFoundException
	 */
	public static void exportReport(JasperPrint jp, String path)
			throws JRException, FileNotFoundException {
		logger.debug("Exporing report to: " + path);
		JRPdfExporter exporter = new JRPdfExporter();

		File outputFile = new File(path);
		File parentFile = outputFile.getParentFile();
		if (parentFile != null)
			parentFile.mkdirs();
		FileOutputStream fos = new FileOutputStream(outputFile);

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);

		exporter.exportReport();

		logger.debug("Report exported: " + path);
	}

	public static void exportReportXls(JasperPrint jp, String path)
			throws JRException, FileNotFoundException {
		JRXlsxExporter exporter = new JRXlsxExporter();

		File outputFile = new File(path);
		File parentFile = outputFile.getParentFile();
		if (parentFile != null)
			parentFile.mkdirs();
		FileOutputStream fos = new FileOutputStream(outputFile);

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);
		exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,
				Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
				Boolean.FALSE);
		exporter.setParameter(JRXlsExporterParameter.IS_IGNORE_GRAPHICS,
				Boolean.FALSE);
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
				Boolean.FALSE);

		exporter.setParameter(
				JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
				Boolean.TRUE);

		exporter.exportReport();

		logger.debug("XLS Report exported: " + path);
	}

	public static void exportReportToRtf(JasperPrint jp, String path)
			throws JRException, FileNotFoundException {
		JRRtfExporter exporter = new JRRtfExporter();

		File outputFile = new File(path);
		File parentFile = outputFile.getParentFile();
		if (parentFile != null)
			parentFile.mkdirs();
		FileOutputStream fos = new FileOutputStream(outputFile);

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);
		exporter.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS, false);

		exporter.exportReport();

		logger.debug("XLS Report exported: " + path);
	}

	public static void exportReportHtml(JasperPrint jp, String path)
			throws JRException, FileNotFoundException {
		JRHtmlExporter exporter = new JRHtmlExporter();

		File outputFile = new File(path);
		File parentFile = outputFile.getParentFile();
		if (parentFile != null)
			parentFile.mkdirs();
		FileOutputStream fos = new FileOutputStream(outputFile);

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);
		exporter.exportReport();

		logger.debug("HTML Report exported: " + path);
	}

	public static void exportReportPlainXls(JasperPrint jp, String path)
			throws JRException, IOException {
		JRXlsxExporter exporter = new JRXlsxExporter();
		//JExcelApiExporter exporter = new JExcelApiExporter();

		File outputFile = new File(path);
		File tempFile = File.createTempFile("hello", ".tmp");
		
		File parentFile = outputFile.getParentFile();
		if (parentFile != null)
			parentFile.mkdirs();
		FileOutputStream fos = new FileOutputStream(outputFile);

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
				Boolean.FALSE);
		exporter.setParameter(
				JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
				Boolean.TRUE);
		exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
				Boolean.FALSE);
		exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,
				Boolean.TRUE);

		exporter.exportReport();

		logger.debug("Report exported: " + path);

	}

}