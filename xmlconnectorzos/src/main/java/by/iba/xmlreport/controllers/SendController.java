package by.iba.xmlreport.controllers;

import by.iba.projmanmodels.model.DTO.JCLAndXMLDoc;
import by.iba.projmanmodels.model.HostInfo;
import by.iba.projmanmodels.model.PageInfoModel;
import by.iba.projmanmodels.model.listforreport.ListForReport;
import by.iba.projmanmodels.model.statuslist.StatusBarList;
import by.iba.jmsmqworker.services.jms.JmsServiceSend;
import by.iba.xmlgenerator.initialize.InitDTO;
import by.iba.xmlreport.services.promote.SendInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/send")
public class SendController {
    @Autowired
    private SendInfo sendInfo;
    @Autowired
	private JmsServiceSend jmsServiceSend;
    @GetMapping("/{id}")
    public String sendInfo(@PathVariable int id)
    {
        PageInfoModel pageInfoModel = ListForReport
                .getInstance()
                .getListForReport()
                .get(id);
        ListForReport.getInstance().deleteElementFromList(id);
        JCLAndXMLDoc file = new InitDTO().init(pageInfoModel);
        file.setIdStat(pageInfoModel.getId());
        StatusBarList.getInstance().getStatusItems().get(file.getIdStat())
        .setStyleClass("list-group-item list-group-item-action list-group-item-warning")
        .setStatus("In process");
        jmsServiceSend.send(file);
        return "redirect:/";
    }

}
