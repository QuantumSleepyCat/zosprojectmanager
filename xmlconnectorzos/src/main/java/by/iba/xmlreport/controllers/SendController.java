package by.iba.xmlreport.controllers;

import by.iba.jmsmqworker.services.jms.JmsServiceSend;

import by.iba.jpadb.db.entities.promoting.PageInfoModel;
import by.iba.jpadb.db.services.facade.DBServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xmlcreate.XMLFile;

@Controller
@RequestMapping("/send")
public class SendController {
    @Autowired
	private JmsServiceSend jmsServiceSend;
    @Autowired
    private DBServices dbServices;
    @GetMapping("/{id}")
    public String sendInfo(@PathVariable long id)
    {
        PageInfoModel pageInfoModel = dbServices.getPromoteInfoService().findById(id);
        dbServices.getStatusItemService().findByPageInfo(pageInfoModel)
                .setStyleClass("list-group-item list-group-item-action list-group-item-warning")
                .setStatus("In process");
        jmsServiceSend.send(new XMLFile().createXmlFile(pageInfoModel));
        return "redirect:/";
    }

}
