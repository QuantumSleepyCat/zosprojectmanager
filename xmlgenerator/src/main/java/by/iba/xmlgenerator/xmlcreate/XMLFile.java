package by.iba.xmlgenerator.xmlcreate;


import by.iba.projmanmodels.model.DataSet;
import by.iba.projmanmodels.model.PageInfoModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class XMLFile {
    public Document createXmlFile(PageInfoModel pageInfo)
    {

        Document document = null;
        try {
            document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().newDocument();
        // Корневой элемент
            Element transfer = document.createElement("transfer");
            document.appendChild(transfer);

            Element transferName = document.createElement("transfer-name");
            transferName.setTextContent("Transfer request from T(Preprod) to T.LIVE");
            transfer.appendChild(transferName);

            Element appName = document.createElement("application-name");
            appName.setTextContent(pageInfo.getApplicationName());
            transfer.appendChild(appName);

            Element projectId = document.createElement("project-id");
            projectId.setTextContent(pageInfo.getProdect_CR_ID());
            transfer.appendChild(projectId);

            Element requester = document.createElement("requester");
            requester.setTextContent(pageInfo.getRequester());
            transfer.appendChild(requester);

            Element regionName = document.createElement("region-name");
            regionName.setTextContent(pageInfo.getRegion());
            transfer.appendChild(regionName);

            Element transferDate = document.createElement("transfer-date");
            transferDate.setTextContent(pageInfo.getTransferDate());
            transfer.appendChild(transferDate);

           for(int i=0;i<pageInfo.getItems().size();i++)
           {
               Element item = document.createElement("item");
               transfer.appendChild(item);
               Element itemName = document.createElement("item-name");
               itemName.setTextContent(pageInfo.getItems().get(i).getName());
               item.appendChild(itemName);
               Element itemMemberCount = document.createElement("item-member-count");
               int count=0;
               for (DataSet dataSet:pageInfo.getItems().get(0).getDataSets()) {
                   count+=dataSet.getMembers().size();
               }
               itemMemberCount.setTextContent(String.valueOf(count));
               item.appendChild(itemMemberCount);
               for(int j=0; j<pageInfo.getItems().get(i).getDataSets().size();j++) {
                   Element dataset = document.createElement("dataset");
                   item.appendChild(dataset);
                   Element itemValue = document.createElement("item-value");
                   itemValue.setTextContent(pageInfo.getItems().get(i).getDataSets()
                   .get(j).getItemValue());
                   dataset.appendChild(itemValue);
                   Element itemRemark = document.createElement("item-remark");
                   itemRemark.setTextContent(pageInfo.getItems().get(i).getDataSets()
                           .get(j).getItemRemark());
                   dataset.appendChild(itemRemark);
                   for(String member:pageInfo.getItems().get(i)
                           .getDataSets().get(j).getMembers())
                   {
                       Element memberData = document.createElement("member");
                       memberData.setTextContent(member);
                       dataset.appendChild(memberData);
                   }
               }
           }

            return document;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
