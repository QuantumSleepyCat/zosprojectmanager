package by.iba.projmanmodels.model;



import by.iba.projmanmodels.model.sendinfo.SendInfo;

import java.util.ArrayList;
import java.util.List;

public class PageInfoModel {
    private int id;
    private String applicationName;
    private String prodect_CR_ID;
    private String requester;
    private String transferDate;
    private String region;
    private String host;
    private int port;
    private List<Item> items= new ArrayList<>();
    private SendInfo sendInfo = new SendInfo();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public SendInfo getSendInfo() {
        return sendInfo;
    }

    public void setSendInfo(SendInfo sendInfo) {
        this.sendInfo = sendInfo;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    public void setItem(Item item)
    {
        items.add(item);
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getProdect_CR_ID() {
        return prodect_CR_ID;
    }

    public void setProdect_CR_ID(String prodect_CR_ID) {
        this.prodect_CR_ID = prodect_CR_ID;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(String transferDate) {
        this.transferDate = transferDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        int code = (int) ((applicationName.length()*prodect_CR_ID.length()*requester.length()*
                transferDate.length()*region.length())*(Math.random()*123));
        for(Item item:items)
        {
            code+=item.hashCode()*(Math.random()*323+232);
        }
        return code+sendInfo.hashCode();
    }
}
