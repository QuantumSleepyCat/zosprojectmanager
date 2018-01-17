package by.iba.xmlreport.controllers;


import by.iba.xmlreport.controllers.logutils.GettingListLogs;
import by.iba.projmanmodels.model.statuslist.StatusBarList;
import by.iba.xmlreport.services.status.JobStatusValues;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/status")
public class StatusBarController {


    @Autowired
    private JobStatusValues jobStatusValues;

    @Autowired
    private GettingListLogs gettingListLogs;
    
    @GetMapping
    public String getStatus(Model model)
    {
        jobStatusValues.updateStatus();
        model.addAttribute("statusList", StatusBarList.getInstance().getStatusItems().values());
        return "statusbar";
    }

    @GetMapping("/{id}")
    public String getStatusJob(@PathVariable int id, Model model)
    {
        jobStatusValues.updateStatusById(id);
        List<String[]> logList = new ArrayList<>();
        String[] logParts = gettingListLogs.execute(StatusBarList.getInstance().getStatusItems().get(id).getLogs());
        for(String logPart:logParts)
        {
        	logList.add(logPart.split("\n"));
        }
        model.addAttribute("job",StatusBarList.getInstance().getStatusItems().get(id));
        model.addAttribute("logs",logList);
        return "jobstatus";
    }
}
