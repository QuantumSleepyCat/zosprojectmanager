package by.iba.xmlreport.controllers;



import by.iba.projmanmodels.model.PageInfoModel;
import by.iba.projmanmodels.model.listforreport.ListForReport;
import by.iba.projmanmodels.model.status.StatusList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/answer")
public class AnswerController {

    @PostMapping(params = "approve")
    public String approveMethod(@RequestParam("comment")String comment,
                                @RequestParam("idrep")String idRep,
                                Model model)
    {
        System.out.println(idRep);
        int id = Integer.valueOf(idRep);
        PageInfoModel pageInfoModel = ListForReport
                .getInstance()
                .getListForReport()
                .get(id);
        StatusList.getInstance().getStatusValues().get(pageInfoModel.getId()).setStatus("Approved");
        StatusList.getInstance().getStatusValues().get(pageInfoModel.getId()).setComment(comment);
        StatusList.getInstance().getStatusValues().get(pageInfoModel.getId()).setIdInList(id);
        return "redirect:/answer/result?comment="+comment+"&result=approve";
    }

    @PostMapping(params = "reject")
    public String rejectMethod(@RequestParam("comment")String comment,
                               @RequestParam("idrep")String idRep,
                               Model model)
    {
        int id = Integer.valueOf(idRep);
        PageInfoModel pageInfoModel = ListForReport
                .getInstance()
                .getListForReport()
                .get(id);
        ListForReport.getInstance().deleteElementFromList(id);
        StatusList.getInstance().getStatusValues().get(pageInfoModel.getId()).setStatus("Rejected");
        StatusList.getInstance().getStatusValues().get(pageInfoModel.getId()).setComment(comment);
        StatusList.getInstance().getStatusValues().get(pageInfoModel.getId()).setIdInList(id);
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
