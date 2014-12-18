package com.sapient.feecalculator.reader;

import java.io.File;

import com.sapient.feecalculator.Constant.FILETYPE;


public class XMLTransctionReader extends AbstractTransactionReader implements ITransactionManager {

	
	@Override
	public void readTransaction(File transactionFile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ITransactionManager readFile(FILETYPE fileType) {
		if(fileType == FILETYPE.CSV){
			return TrasactionReader.getTrasactionReaderInstance().readXmlFile();
		}
		return null;
	}

}
