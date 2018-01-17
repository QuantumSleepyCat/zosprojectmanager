package by.iba.jmsmqworker.services.jms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.ibm.mq.jms.MQQueue;
import com.ibm.msg.client.wmq.WMQConstants;

import by.iba.projmanmodels.model.DTO.JCLAndXMLDoc;

@Service
public class JmsServiceSendImpl implements JmsServiceSend{
	private static String str = null;
	@Autowired
	JmsOperations jmsOperations;
	
	public void send(JCLAndXMLDoc jclAndXMLDoc){
		
		
		String filename = "xml.data.txt";
		File file = new File(filename);
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    String out ="";
        Transformer transformer;
		try {
			
			transformer = TransformerFactory.newInstance()
			        .newTransformer();			 
		        DOMSource source = new DOMSource(jclAndXMLDoc.getXmlDocument());
		        StreamResult result = new StreamResult(file);
		        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		        transformer.transform(source, result);
		        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		        while(bufferedReader.ready())
		        {
		        	out+=bufferedReader.readLine();
		        }
		        
		} catch (TransformerConfigurationException | TransformerFactoryConfigurationError e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       str=out;
	
		  MessageCreator messageCreator = new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				  TextMessage textMessage =session.createTextMessage();
				textMessage.setIntProperty(WMQConstants.JMS_IBM_CHARACTER_SET, 1047);
				textMessage.setIntProperty(WMQConstants.JMS_IBM_ENCODING, 785);
				textMessage.setText(new String(str));
				return textMessage;
			}
		};
		MQQueue mqQueue=null;
		try {
			mqQueue = new MQQueue("TRIG.TEST.USER06A");
			mqQueue.setTargetClient(WMQConstants.WMQ_CLIENT_NONJMS_MQ);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  jmsOperations.send(mqQueue,messageCreator);
	}
}
