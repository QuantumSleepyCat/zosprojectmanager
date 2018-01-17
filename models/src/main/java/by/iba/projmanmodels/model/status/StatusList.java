package by.iba.projmanmodels.model.status;

import java.util.HashMap;
import java.util.Map;

public class StatusList {
    private static StatusList ourInstance ;

    public static StatusList getInstance() {
        if (ourInstance == null) {
            ourInstance=new StatusList();
        }
        return ourInstance;
    }

    private StatusList() {
    }

    private Map<Integer,StatusValue> statusValues = new HashMap<>();

    public void addItemInList(StatusValue statusValue)
    {
        statusValues.put(statusValue.getIdInfo(),statusValue);
    }

    public Map<Integer, StatusValue> getStatusValues() {
        return statusValues;
    }
}
