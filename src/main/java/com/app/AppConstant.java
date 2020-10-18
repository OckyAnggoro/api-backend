package com.app;

public class AppConstant {

	public static final int FLAG_NOT_DELETED = 0;
	public static final int FLAG_IS_DELETED = 1;
	
	public static final int ITEM_SOURCE_LOGISTIC_DROPING = 1;
	public static final int ITEM_SOURCE_LOGISTIC_PENGADAAN = 2;
	
	public static final String STATUS_TRANSACTION_INSERT = "INSERT";
	public static final String STATUS_TRANSACTION_UPDATE = "UPDATE";
	
	public static final String TRANSACTION_RECEIVE = "Masuk";
	public static final String TRANSACTION_OUTGOING = "Keluar";

	public static final String EXPORT_FORMAT_STRING = "STRING";
	public static final String EXPORT_FORMAT_INTEGER = "INTEGER";
	public static final String EXPORT_FORMAT_LONG = "LONG";
	public static final String EXPORT_FORMAT_FLOAT = "FLOAT";
	public static final String EXPORT_FORMAT_DOUBLE = "DOUBLE";
	public static final String EXPORT_FORMAT_DATE = "DATE";
	public static final String EXPORT_FORMAT_DATETIME = "DATETIME";
	public static final String EXPORT_FORMAT_CURRENCY = "CURRENCY";
	public static final String EXPORT_FORMAT_PERIOD = "PERIOD";
	
	public static final String ALIGN_RIGHT = "RIGHT";
	public static final String ALIGN_LEFT = "LEFT";
	public static final String ALIGN_CENTER = "CENTER";
	public static final String ALIGN_JUSTIFY = "JUSTIFY";
	
	public static final int EXPORT_PRINT_TYPE_EXLS = 0;
	public static final int EXPORT_PRINT_TYPE_DOC = 1;
	public static final int EXPORT_PRINT_TYPE_PDF = 2;
	
	public static final String FORMAT_SHORT_DATE = "dd/MM/y";
    public static final String FORMAT_SHORT_DATE_AND_TIME = "dd/MM/y hh:mm:ss";
    public static final String FORMAT_LONG_DATE = "dd MMMM y";
    public static final String FORMAT_LONG_DATE_AND_TIME = "dd MMMM y hh:mm:ss";
    public static final String FORMAT_CURRENCY =  "#,###,##0.00";
    public static final String FORMAT_SHORT_DATE_2 = "dd-MM-yyyy";
    public static final String FORMAT_LONG_DATE_2 = "dd-MM-yyyy hh:mm:dd";
    public static final String FORMAT_PERIOD = "MMM yyyy";
}
