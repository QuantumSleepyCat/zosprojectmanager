package by.iba.xmlreport.controllers;



import by.iba.projmanmodels.model.listforreport.ListForReport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController {


    @GetMapping("/{id}")
    public String getReport(@PathVariable int id, Model model)
    {
        try{
          model.addAttribute("items", ListForReport
                  .getInstance()
                  .getListForReport()
                  .get(id).getItems());
          model.addAttribute("id",id);
        }
        catch (Exception e)
        {
            return "error";
        }
        return "report";
    }
}
