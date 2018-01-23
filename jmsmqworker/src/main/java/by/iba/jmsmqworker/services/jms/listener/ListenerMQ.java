package by.iba.jmsmqworker.services.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import by.iba.logsgetter.getlogs.GetLogsByFtp;
//import by.iba.logsgetter.getlogs.reading.ReadLogs;

@Component
public class ListenerMQ /*implements MessageListener*/{

/*	private String appName=null;
	@Autowired
	private GetLogsByFtp getLogs;
	
	@Autowired
	private ReadLogs readLogs;
	
	@Override
	public void onMessage(Message message) {
		
		if (message instanceof TextMessage)
        {
		try {
			String str = ((TextMessage)message).getText();
			System.out.println(str.trim());
			String fullLine=str.trim().replace("&", "");
			if(!fullLine.contains("JOB"))
			{
				appName=fullLine;
				System.out.println("ИМЯ "+appName);
			}
			else if(fullLine.contains("JOB"))
			{
			getLogs.execute(appName,fullLine);
			readLogs.read(appName,fullLine);
			System.out.println(fullLine);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
        }
	}*/

}
