package csvTransaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.progressoft.induction.transactionsparser.Transaction;
import com.progressoft.induction.transactionsparser.TransactionParser;

public class CsvTransactionParser implements TransactionParser
{  
public static void main(String[] args)  
{  

//create a reader
try (BufferedReader br = Files.newBufferedReader(Paths.get("H:\\stage\\transactions-parser-master\\src\\main\\resources\\Unit_Test_1.csv"))) {

 // CSV file delimiter
 String DELIMITER = ",";
 List<Transaction> L1 = new ArrayList<Transaction>();
 
 // read the file line by line
 String line;
 while ((line = br.readLine()) != null) {

     // convert line into columns
     String[] columns = line.split(DELIMITER);
     Transaction TransactionObj = new Transaction();
     
     TransactionObj.setDescription(columns[0]);  
     TransactionObj.setDirection(columns[1]); 
     String str=columns[2].replaceAll(",","");
     BigDecimal bd=new BigDecimal(str);
	 TransactionObj.setAmount(bd);  
     TransactionObj.setCurrency(columns[3]); 
    
     L1.add(TransactionObj);
     
     // print all columns
     
 }
  System.out.println(L1);

} catch (IOException ex) {
 ex.printStackTrace();
}
}

@Override
public List<Transaction> parse(File transactionsFile) {
	// TODO Auto-generated method stub
	return null;
}
}