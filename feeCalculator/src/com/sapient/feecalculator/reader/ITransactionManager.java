package com.sapient.feecalculator.reader;

import com.sapient.feecalculator.Constant.FILETYPE;

/**
 * 
 * @author saurabhsharma01
 *
 */
public interface ITransactionManager {

	public void displayTransactionReport();

	public ITransactionManager readFile(FILETYPE fileType);
}
