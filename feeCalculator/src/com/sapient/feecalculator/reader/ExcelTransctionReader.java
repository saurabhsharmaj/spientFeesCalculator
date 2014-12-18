package com.sapient.feecalculator.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.sapient.feecalculator.Constant.FILETYPE;
import com.sapient.feecalculator.Transaction;


public class ExcelTransctionReader extends AbstractTransactionReader implements ITransactionManager {


	@Override
	public void readTransaction(File transactionFile) {

		
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(transactionFile));
			while ((line = br.readLine()) != null) {
				String[] transactionAttributes = line.split(cvsSplitBy);
				Transaction transaction = getTransaction(transactionAttributes); 
				saveTransaction(transaction);

			}		 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}	


	@Override
	public ITransactionManager readFile(FILETYPE fileType) {
		if(fileType == FILETYPE.CSV){
			return TrasactionReader.getTrasactionReaderInstance().readExcelFile();
		}
		return null;
	}


}
