package com.sapient.feecalculator.reader;

import java.io.File;

import com.sapient.feecalculator.Constant.FILETYPE;

public class TrasactionReader {
	/**
	 * 
	 */
	private static TrasactionReader trasactionReader;
	/**
	 * 
	 */
	private static ExcelTransctionReader excelTransctionReader;
	/**
	 * 
	 */
	private static XMLTransctionReader xmlTransctionReader;
	/**
	 * 
	 */
	private static TextTransctionReader textTransctionReader;

	/**
	 * 
	 * @return
	 */
	public static TrasactionReader getTrasactionReaderInstance() {
		if (null == trasactionReader) {
			synchronized (TrasactionReader.class){
				if (null == trasactionReader) {
					trasactionReader = new TrasactionReader();
					excelTransctionReader= new ExcelTransctionReader();
					xmlTransctionReader = new XMLTransctionReader();
					textTransctionReader = new TextTransctionReader();
				}
			}
		}
		return trasactionReader;
	}

	/**
	 * 
	 * @return
	 */
	public ExcelTransctionReader readExcelFile(){
		return excelTransctionReader;
	}

	/**
	 * 
	 * @return
	 */
	public XMLTransctionReader readXmlFile(){
		return xmlTransctionReader;
	}

	/**
	 * 
	 * @return
	 */
	public TextTransctionReader readTextFile(){
		return textTransctionReader;
	}

	/**
	 * 
	 * @param fileType
	 * @return
	 */
	public ITransactionManager readFile(FILETYPE fileType,File transactionFile) {
		switch (fileType) {
		case CSV:
			excelTransctionReader.readTransaction(transactionFile);
			return excelTransctionReader;
		case TEXT:
			textTransctionReader.readTransaction(transactionFile);
			return textTransctionReader;
		case XML:
			xmlTransctionReader.readTransaction(transactionFile);
			return xmlTransctionReader;

		default:
			return null;
		}
	}



}
