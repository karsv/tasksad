
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {
	private DocumentBuilderFactory dbf = null;
	private DocumentBuilder db = null;
	private Document doc = null;
	private NodeList listLogin = null;
	private NodeList listPassword = null;
	private Node nodeLogin = null;
	private Node nodePassword = null;
	private Element elementLogin = null;
	private Element elementPassword = null;
	
	XMLParser(){
		dbf = DocumentBuilderFactory.newInstance(); 
		dbf.setValidating(false);
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			doc = db.parse(new File("/home/afterlie/Workspace/Java/ITEA/src/tasks/users.xml"));
			listLogin = doc.getElementsByTagName("login");
			listPassword = doc.getElementsByTagName("password");
		} catch (SAXException | IOException e) {
			
		}
	}
	
        /**
         *  approve login from xml file
         * @param login
         * @param password
         * @return 
         */
	public boolean aproveLogin(String login, char[] password){
		boolean flag = false;
		String pass = "";
		for(int i = 0; i < listLogin.getLength(); i++){
			for(int j = 0; j < password.length; j++){
				pass = pass + password[j];
			}
			nodeLogin = listLogin.item(i);
			nodePassword = listPassword.item(i);
			elementLogin = (Element) nodeLogin;
			elementPassword = (Element) nodePassword;
			if(elementLogin.getTextContent().equals(login) && elementPassword.getTextContent().equals(pass)){
				flag = true;
				break;
			} else {
				pass = "";
			}
		}
		return flag;
	}

	
}
