package by.iba.projmanmodels.model.DTO;

import by.iba.projmanmodels.model.sendinfo.SendInfo;
import org.w3c.dom.Document;

public class JCLAndXMLDoc {
    private int idStat;
    private String jclText;
    private Document xmlDocument;
    private String comment;
    private SendInfo sendInfo;

    public SendInfo getSendInfo() {
        return sendInfo;
    }

    public void setSendInfo(SendInfo sendInfo) {
        this.sendInfo = sendInfo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public JCLAndXMLDoc() {
    }

    public JCLAndXMLDoc(String jclText, Document xmlDocument, SendInfo sendInfo) {
        this.jclText = jclText;
        this.xmlDocument = xmlDocument;
        this.sendInfo=sendInfo;
    }

    public int getIdStat() {
        return idStat;
    }

    public void setIdStat(int idStat) {
        this.idStat = idStat;
    }

    public String getJclText() {
        return jclText;
    }

    public void setJclText(String jclText) {
        this.jclText = jclText;
    }

    public Document getXmlDocument() {
        return xmlDocument;
    }

    public void setXmlDocument(Document xmlDocument) {
        this.xmlDocument = xmlDocument;
    }
}
