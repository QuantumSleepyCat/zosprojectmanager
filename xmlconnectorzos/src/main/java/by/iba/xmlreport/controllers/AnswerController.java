package by.iba.xmlreport.controllers;


import by.iba.jpadb.db.entities.promoting.StatusItem;
import by.iba.jpadb.db.services.facade.DBServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private DBServices dbServices;

    @PostMapping(params = "approve")
    public String approveMethod(@RequestParam("comment")String comment,
                                @RequestParam("idrep")String idRep,
                                Model model)
    {
        System.out.println(idRep);
        int id = Integer.valueOf(idRep);
        StatusItem statusItem=dbServices.getStatusItemService()
                .findByPageInfo(dbServices.getPromoteInfoService().findById(id));
        statusItem.setStatus("Approved")
                .setComment(comment);
        dbServices.getStatusItemService().addOrUpdate(statusItem);
        return "redirect:/answer/result?comment="+comment+"&result=approve";
    }

    @PostMapping(params = "reject")
    public String rejectMethod(@RequestParam("comment")String comment,
                               @RequestParam("idrep")String idRep,
                               Model model)
    {
        int id = Integer.valueOf(idRep);
        StatusItem statusItem=dbServices.getStatusItemService()
                .findByPageInfo(dbServices.getPromoteInfoService().findById(id));
        statusItem.setStatus("Rejected")
                .setComment(comment);
        dbServices.getStatusItemService().addOrUpdate(statusItem);
        return "redirect:/answer/result?comment="+comment+"&result=reject";
    }

    @GetMapping("/result")
    public String getResult(@RequestParam("comment")String comment,
                            @RequestParam("result")String result,
                            Model model)
    {
        model.addAttribute("result",result);
        model.addAttribute("comment",comment);
        return "result";
    }

}
