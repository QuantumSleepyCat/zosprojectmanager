package by.iba.xmlreport.controllers;




import by.iba.emailsender.email.EmailSender;
import by.iba.emailsender.email.MessageCreator;

import by.iba.jmsmqworker.services.jms.JmsServiceSend;

import by.iba.jpadb.db.entities.Role;
import by.iba.jpadb.db.entities.User;
import by.iba.jpadb.db.entities.promoting.PageInfoModel;
import by.iba.jpadb.db.entities.promoting.StatusItem;
import by.iba.jpadb.db.services.facade.DBServices;
import by.iba.jpadb.db.services.promoteinfo.PromoteInfoService;
import by.iba.jpadb.db.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SetInfoController {

	@Autowired
	private JmsServiceSend jmsServiceSend;

	@Autowired
    private DBServices dbServices;

    @GetMapping(value = "/")
    public String setInfoPage(Model model)
    {

       //model.addAttribute("message","test message");
    	//jmsServiceSend.send();
        //System.err.println(promoteInfoService.findById(1).getAppname());
        model.addAttribute("pageInfo",new PageInfoModel());
       return "index";
        //return "test";
    }


    @PostMapping(value = "/sendtoftp")
    public ModelAndView sendToFtpZos(ModelAndView model,
                                     @ModelAttribute PageInfoModel pageInfo,
                                     HttpServletRequest httpServletRequest,
                                     Authentication authentication) throws InterruptedException {
       // pageInfo.setPort(httpServletRequest.getLocalPort());
        //StatusBarList.getInstance().iterCounter();
        //pageInfo.setId(StatusBarList.getInstance().getCounter());
       // ListForReport.getInstance().addElementInList(pageInfo);
        //StatusList.getInstance().addItemInList(new StatusValue(pageInfo.getId(),"Awaiting"));
        //EmailSender emailSender = new EmailSender("tol9411@yandex.ru",
        //        "5bn88kw3");
        //emailSender.send("Promote project",
        //        MessageCreator.createMessage(ListForReport.getInstance().getReportId()),
        ///        pageInfo.getSendInfo().getCl_email());
        //StatusBarList.getInstance().setItem(new StatusItem(pageInfo.getId(),pageInfo.getApplicationName(),
        //        "Awaiting","list-group-item list-group-item-action list-group-item-info",
        //        pageInfo.getSendInfo().getUsername(),"No comment"),pageInfo.getId());
        User user =dbServices.getUserService().findByLogin(authentication.getName());
        pageInfo.setRequester(user);
        dbServices.getPromoteInfoService().addOrUpdate(pageInfo);
        dbServices.getStatusItemService().addOrUpdate(new StatusItem("Awaiting",
                "list-group-item list-group-item-action list-group-item-info","No comment",
                pageInfo));
        EmailSender emailSender = new EmailSender("tol9411@yandex.ru",
                "5bn88kw3");
        emailSender.send("Promote project",
               MessageCreator.createMessage(pageInfo.getId()),
               pageInfo.getSendInfo().getCl_email());
        model.setViewName("redirect:/");
        return model;
    }

}
