package by.iba.projmanmodels.model.listforreport;



import by.iba.projmanmodels.model.PageInfoModel;

import java.util.HashMap;
import java.util.Map;

public class ListForReport {
    private static ListForReport ourInstance;
    private Map<Integer,PageInfoModel> listForReport;
    private int reportId;
    public static ListForReport getInstance() {
        if(ourInstance==null)
        {
            ourInstance=new ListForReport();
        }
        return ourInstance;
    }

    private ListForReport() {
        listForReport=new HashMap<>();
    }

    public void addElementInList(PageInfoModel pageInfoModel)
    {
        this.reportId=pageInfoModel.hashCode();
        listForReport.put(reportId,pageInfoModel);
    }

    public int getReportId() {
        return reportId;
    }

    public void deleteElementFromList(int id)
    {
        listForReport.remove(id);
    }

    public Map<Integer, PageInfoModel> getListForReport() {
        return listForReport;
    }
}
