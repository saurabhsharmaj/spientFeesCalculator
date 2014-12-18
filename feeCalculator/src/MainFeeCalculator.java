import java.io.File;

import com.sapient.feecalculator.Constant.FILETYPE;
import com.sapient.feecalculator.reader.ITransactionManager;
import com.sapient.feecalculator.reader.TrasactionReader;


public class MainFeeCalculator {
	public static void main(String[] args) {
		//Read Excel/CSV/TEXT/XML
		File transactionfile = new File(new File("").getAbsolutePath(),"resource/sampleData.txt");
		ITransactionManager tranction= TrasactionReader.getTrasactionReaderInstance().readFile(FILETYPE.TEXT,transactionfile);		
		tranction.displayTransactionReport();	
		
		
	}
}
