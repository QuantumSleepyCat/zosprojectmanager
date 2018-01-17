package by.iba.xmlgenerator.initialize;


import by.iba.projmanmodels.model.DTO.JCLAndXMLDoc;
import by.iba.projmanmodels.model.PageInfoModel;
import by.iba.xmlgenerator.xmlcreate.XMLFile;

public class InitDTO {
    public JCLAndXMLDoc init(PageInfoModel pageInfoModel)
    {
        String jcl = "No jcl";
        return new JCLAndXMLDoc(jcl,new XMLFile().createXmlFile(pageInfoModel),pageInfoModel.getSendInfo());
    }
}
