package by.iba.xmlreport.services.promote;

import by.iba.xmlreport.ftpsend.FtpSender;
import by.iba.projmanmodels.model.DTO.JCLAndXMLDoc;
import by.iba.projmanmodels.model.jclcreate.CreatingJCLFile;
import org.springframework.stereotype.Service;

@Service
public class SendInfoImpl implements SendInfo{
    @Override
    public void send(JCLAndXMLDoc jclAndXMLDoc) {
        FtpSender ftpSender=new FtpSender();
        ftpSender.sendFileToZos(jclAndXMLDoc.getXmlDocument(),
                new CreatingJCLFile().createJclFile(jclAndXMLDoc.getJclText()),jclAndXMLDoc.getSendInfo());
    }
}
