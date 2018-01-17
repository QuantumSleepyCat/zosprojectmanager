package by.iba.jmsmqworker.services.jms;

import by.iba.projmanmodels.model.DTO.JCLAndXMLDoc;

public interface JmsServiceSend {
	void send(JCLAndXMLDoc jclAndXMLDoc);
}
