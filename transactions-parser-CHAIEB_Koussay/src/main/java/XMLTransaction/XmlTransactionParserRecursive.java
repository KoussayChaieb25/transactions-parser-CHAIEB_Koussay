package XMLTransaction;


import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;  
import org.w3c.dom.NodeList;
import com.progressoft.induction.transactionsparser.Transaction;  

public class XmlTransactionParserRecursive
{  
public static void main(String[] args) throws ParserConfigurationException, Exception  
{  
try   
{  
	File file = new File("H:\\stage\\transactions-parser-master\\src\\main\\resources\\Unit_test_1.xml");  
	DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
	Document document = documentBuilder.parse(file);  
	document.getDocumentElement().normalize();
	System.out.println("Root element: "+ document.getDocumentElement().getNodeName());  
	NodeList nList = document.getElementsByTagName("Transaction");
	
	
	List<Transaction> L1 = new ArrayList<Transaction>();
	
	
	for (int count = 0; count < nList.getLength(); count++)   
	{  
		Node elemNode = nList.item(count);  
		if (elemNode.getNodeType() == Node.ELEMENT_NODE)   
		{  
			
			Element eElement = (Element) elemNode;
			Transaction TransactionObj = new Transaction();
			
			
			TransactionObj.setDescription(eElement
	                  .getElementsByTagName("Description")
	                  .item(0)
	                  .getTextContent()); 
		    
		    TransactionObj.setDirection(eElement
	                  .getElementsByTagName("Direction")
	                  .item(0)
	                  .getTextContent());
		    
		     String node = eElement
	                  .getElementsByTagName("Amount")
	                  .item(0)
	                  .getChildNodes().item(1).getTextContent();
	                  
		     BigDecimal bd=new BigDecimal(node);
			 TransactionObj.setAmount(bd);  
			
			 
		     String node2 = eElement
	                  .getElementsByTagName("Amount")
	                  .item(0)
	                  .getChildNodes().item(3).getTextContent()
	                  ;
		     TransactionObj.setCurrency(node2);  
		    
		     L1.add(TransactionObj);  
		     
			
		}
		
	}
	System.out.println(L1);
	}catch (Exception e) {
        e.printStackTrace();
	}
}  
}

	