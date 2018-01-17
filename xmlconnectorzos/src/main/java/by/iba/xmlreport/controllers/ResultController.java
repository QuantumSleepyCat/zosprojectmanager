package by.iba.xmlreport.controllers;


import by.iba.xmlreport.ftpsend.FtpSender;
import by.iba.projmanmodels.model.DTO.JCLAndXMLDoc;
import by.iba.projmanmodels.model.jclcreate.CreatingJCLFile;
import by.iba.projmanmodels.model.result.RejectResult;
import by.iba.projmanmodels.model.statuslist.StatusBarList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class ResultController {

    @PostMapping("/result/approve")
    public void getResultApprove(@RequestBody JCLAndXMLDoc jclAndXMLDoc)
    {
        StatusBarList.getInstance().getStatusItems().get(
                jclAndXMLDoc.getIdStat()
        ).setStyleClass("list-group-item list-group-item-success")
        .setStatus("Approved")
        .setComment(jclAndXMLDoc.getComment());
        FtpSender ftpSender=new FtpSender();
        ftpSender.sendFileToZos(jclAndXMLDoc.getXmlDocument(),
                new CreatingJCLFile().createJclFile(jclAndXMLDoc.getJclText()),jclAndXMLDoc.getSendInfo());
    }

    @PostMapping("/result/reject")
    public void getResultReject(@RequestBody RejectResult rejectResult)
    {
        StatusBarList.getInstance().getStatusItems().get(rejectResult.getId())
                .setStyleClass("list-group-item list-group-item-danger")
                .setStatus("Rejected")
                .setComment(rejectResult.getComment());
    }

}
