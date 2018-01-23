package by.iba.xmlreport.controllers;



import by.iba.projmanmodels.model.listforreport.ListForReport;
import by.iba.xmlreport.db.services.facade.DBServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private DBServices dbServices;

    @GetMapping("/{id}")
    public String getReport(@PathVariable long id, Model model)
    {
        try{
          model.addAttribute("items", dbServices.getPromoteInfoService()
                  .findById(id).getItems());
          model.addAttribute("id",id);
        }
        catch (Exception e)
        {
            return "error";
        }
        return "report";
    }
}
