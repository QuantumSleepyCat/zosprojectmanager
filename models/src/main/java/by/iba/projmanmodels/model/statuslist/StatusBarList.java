package by.iba.projmanmodels.model.statuslist;

import by.iba.projmanmodels.model.statuslist.item.StatusItem;


import java.util.HashMap;
import java.util.Map;

public class StatusBarList {
    private static StatusBarList ourInstance;
    private int counter=0;
    private Map<Integer,StatusItem> statusItems=new HashMap<>();
    public static StatusBarList getInstance() {
        if(ourInstance==null)
        {
            ourInstance=new StatusBarList();
        }
        return ourInstance;
    }

    public void iterCounter()
    {
        counter++;
    }

    public void unCount()
    {
        counter--;
    }

    public int getCounter() {
        return counter;
    }

    public void setItem(StatusItem statusItem, int id)
    {
        statusItems.put(id, statusItem);
    }

    public Map<Integer, StatusItem> getStatusItems() {
        return statusItems;
    }

    private StatusBarList() {
    }
}
