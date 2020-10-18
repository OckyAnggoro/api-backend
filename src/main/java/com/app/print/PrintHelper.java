package com.app.print;

import java.awt.Color;
import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.app.AppConstant;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.AutoText;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilder;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import ar.com.fdvs.dj.domain.builders.StyleBuilder;
import ar.com.fdvs.dj.domain.constants.Border;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.constants.Page;
import ar.com.fdvs.dj.domain.constants.Transparency;
import ar.com.fdvs.dj.domain.constants.VerticalAlign;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class PrintHelper {

	@SuppressWarnings("deprecation")
	public static ResponseEntity<?> print(int intPrintType,
			Collection<?> list, String[][] arrColumns, String strTitle, String nameDownloadFile,
			HttpServletRequest request) throws Exception {

		{
			String strReportType = "xlsx";
//			if (intPrintType == AppConstant.EXPORT_PRINT_TYPE_EXLS) {
//				strReportType = "xlsx";
//			} else if (intPrintType == AppConstant.EXPORT_PRINT_TYPE_DOC) {
//				strReportType = "doc";
//			} else {
//				strReportType = "pdf";
//			}

			FastReportBuilder drb = new FastReportBuilder();

			Date today = new Date();
			/*
			 * SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			 * AppContext.getParameterStringByName(AppConstant.ParameterEnum.
			 * DATETIME_FORMAT_LONG)); String formattedDate = DATE_FORMAT.format(today);
			 */

			/* Set global style */
			drb.setPageSizeAndOrientation(Page.Page_Letter_Landscape());
			drb.setTitle(strTitle);

			Style dateStyle = new StyleBuilder(true).setTextColor(Color.black)
					.build();

			drb.setUseFullPageWidth(true);
			drb.setColumnSpace(0);

			drb.addAutoText(AutoText.AUTOTEXT_PAGE_X_OF_Y,
					AutoText.POSITION_FOOTER, AutoText.ALIGNMENT_RIGHT);

			drb.setProperty("net.sf.jasperreports.default.tab.stop.width", "2");

			Style headerStyle = new Style();
			headerStyle.setBorder(Border.THIN());
			headerStyle.setBorderColor(Color.black);
			headerStyle.setTransparency(Transparency.OPAQUE);
			headerStyle.setBackgroundColor(new Color(229, 0, 0));
			headerStyle.setTextColor(Color.WHITE);
			headerStyle.setStretchWithOverflow(true);
			headerStyle.setPadding(3);
			headerStyle.setVerticalAlign(VerticalAlign.MIDDLE);
			headerStyle.setHorizontalAlign(HorizontalAlign.CENTER);

			/* // Set specific row style */
			Style columDetailBorderCenter = new Style();
			columDetailBorderCenter.setBorder(Border.THIN());
			columDetailBorderCenter.setBorderColor(Color.black);
			columDetailBorderCenter.setHorizontalAlign(HorizontalAlign.CENTER);
			columDetailBorderCenter.setTransparency(Transparency.OPAQUE);
			columDetailBorderCenter.setBackgroundColor(Color.WHITE);
			columDetailBorderCenter.setStretchWithOverflow(true);
			columDetailBorderCenter.setPadding(3);
			columDetailBorderCenter.setVerticalAlign(VerticalAlign.TOP);

			Style columDetailBorderRight = new Style();
			columDetailBorderRight.setBorder(Border.THIN());
			columDetailBorderRight.setBorderColor(Color.black);
			columDetailBorderRight.setHorizontalAlign(HorizontalAlign.RIGHT);
			columDetailBorderRight.setTransparency(Transparency.OPAQUE);
			columDetailBorderRight.setBackgroundColor(Color.WHITE);
			columDetailBorderRight.setStretchWithOverflow(true);
			columDetailBorderRight.setPadding(3);
			columDetailBorderRight.setVerticalAlign(VerticalAlign.TOP);

			Style columDetailBorderLeft = new Style();
			columDetailBorderLeft.setBorder(Border.THIN());
			columDetailBorderLeft.setBorderColor(Color.black);
			columDetailBorderLeft.setHorizontalAlign(HorizontalAlign.LEFT);
			columDetailBorderLeft.setTransparency(Transparency.OPAQUE);
			columDetailBorderLeft.setBackgroundColor(Color.WHITE);
			columDetailBorderLeft.setStretchWithOverflow(true);
			columDetailBorderLeft.setPadding(3);
			columDetailBorderLeft.setVerticalAlign(VerticalAlign.TOP);

			for (Integer i = 0; i < arrColumns.length; i++) {

				/*SET CLASS NAME*/
				String className = String.class.getName();
				
				if (arrColumns[i][3].equalsIgnoreCase(AppConstant.EXPORT_FORMAT_INTEGER)) {
					className = Integer.class.getName();
				}
				else if (arrColumns[i][3].equalsIgnoreCase(AppConstant.EXPORT_FORMAT_LONG)) {
					className = Long.class.getName();
				}
				else if (arrColumns[i][3].equalsIgnoreCase(AppConstant.EXPORT_FORMAT_FLOAT)) {
					className = Float.class.getName();
				}
				else if (arrColumns[i][3].equalsIgnoreCase(AppConstant.EXPORT_FORMAT_DOUBLE)) {
					className = Double.class.getName();
				}
				else if (arrColumns[i][3].equalsIgnoreCase(AppConstant.EXPORT_FORMAT_DATE)
						|| arrColumns[i][3].equalsIgnoreCase(AppConstant.EXPORT_FORMAT_DATETIME)
						|| arrColumns[i][3].equalsIgnoreCase(AppConstant.EXPORT_FORMAT_PERIOD)) {
					className = Date.class.getName();
				}
				else if (arrColumns[i][3].equalsIgnoreCase(AppConstant.EXPORT_FORMAT_CURRENCY)) {
					className = BigDecimal.class.getName();
				}
				
				System.out.println("Column Class Name = " + arrColumns[i][3]);
				
				AbstractColumn column = ColumnBuilder.getInstance()
						.setColumnProperty(arrColumns[i][0], className)
						.setTitle(arrColumns[i][1]).setWidth(30).build();
				
				if (arrColumns[i][2].equalsIgnoreCase(AppConstant.ALIGN_LEFT)) {
					column.setStyle(columDetailBorderLeft);
				}
				else if (arrColumns[i][2].equalsIgnoreCase(AppConstant.ALIGN_CENTER)) {
					column.setStyle(columDetailBorderCenter);
				}
				else if (arrColumns[i][2].equalsIgnoreCase(AppConstant.ALIGN_RIGHT)) {
					column.setStyle(columDetailBorderRight);
				}
				column.setHeaderStyle(headerStyle);

				/*SET PATTERN*/				
				 if (arrColumns[i][3].equalsIgnoreCase(AppConstant.EXPORT_FORMAT_CURRENCY)) {
					 column.setPattern(AppConstant.FORMAT_CURRENCY);
				} else if (arrColumns[i][3].equalsIgnoreCase(AppConstant.EXPORT_FORMAT_DATE)) {
					column.setPattern(AppConstant.FORMAT_SHORT_DATE_2); 
				} else if (arrColumns[i][3].equalsIgnoreCase(AppConstant.EXPORT_FORMAT_DATETIME)) {
					column.setPattern(AppConstant.FORMAT_LONG_DATE_2);
				} else if (arrColumns[i][3].equalsIgnoreCase(AppConstant.EXPORT_FORMAT_PERIOD)) {
					column.setPattern(AppConstant.FORMAT_PERIOD);
				}
				drb.addColumn(column);
			}

			drb.setIgnorePagination(strReportType.equalsIgnoreCase("xlsx"));
			final DynamicReport dr = drb.build();

			JRDataSource ds = new JRBeanCollectionDataSource(list);
			HashMap<String, Object> params = new HashMap<String, Object>();
			JasperReport jr = DynamicJasperHelper.generateJasperReport(dr, new ClassicLayoutManager(), params);
			JasperPrint jp = JasperFillManager.fillReport(jr, params, ds);

			final String fileName = "report_"+ "_"+ (new SimpleDateFormat("yyyyMMddhhmmSS").format(new Date())) + "." + strReportType;
			
			File tempFile = File.createTempFile(fileName, ".tmp");
			String outputFile = tempFile.getAbsolutePath();

			if (strReportType.equalsIgnoreCase("xlsx")) {
				ReportExporter.exportReportPlainXls(jp, outputFile);
			} else if (strReportType.equalsIgnoreCase("pdf")) {
				ReportExporter.exportReport(jp, outputFile);
			} else if (strReportType.equalsIgnoreCase("doc")) {
				ReportExporter.exportReportToRtf(jp, outputFile);
			}
			
			File file = new File(outputFile);
			byte[] content = null;
			
			if(file.exists()){
				content = Files.readAllBytes(file.toPath());
			}
			
			
			if (strReportType.equalsIgnoreCase("xlsx")) {
				return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=" + nameDownloadFile + "; fileType="+AppConstant.EXPORT_PRINT_TYPE_EXLS)
						.header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.CONTENT_DISPOSITION)
						.body(content);
			}
//			} else if (strReportType.equalsIgnoreCase("doc")) {
//				return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.wordprocessingml.document"))
//						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=" + nameDownloadFile + "; fileType="+AppConstant.EXPORT_PRINT_TYPE_DOC)
//						.header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.CONTENT_DISPOSITION)
//						.body(content);
//			} else {
//				return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/x-pdf"))
//						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=" + nameDownloadFile + ".PDF; fileType="+AppConstant.EXPORT_PRINT_TYPE_PDF)
//						.header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.CONTENT_DISPOSITION)
//						.body(content);
//			}	
		}
		return null;
	}
	
}
