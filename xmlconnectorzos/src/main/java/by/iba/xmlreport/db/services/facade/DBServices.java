package by.iba.xmlreport.db.services.facade;


import by.iba.xmlreport.db.services.dataset.DataSetService;
import by.iba.xmlreport.db.services.member.MemberService;
import by.iba.xmlreport.db.services.promoteinfo.PromoteInfoService;
import by.iba.xmlreport.db.services.promoteitem.PromoteItemService;
import by.iba.xmlreport.db.services.statusitem.StatusItemService;
import by.iba.xmlreport.db.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBServices {

    @Autowired
    private UserService userService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private PromoteItemService promoteItemService;
    @Autowired
    private PromoteInfoService promoteInfoService;
    @Autowired
    private DataSetService dataSetService;
    @Autowired
    private StatusItemService statusItemService;

    public UserService getUserService() {
        return userService;
    }

    public MemberService getMemberService() {
        return memberService;
    }

    public PromoteItemService getPromoteItemService() {
        return promoteItemService;
    }

    public PromoteInfoService getPromoteInfoService() {
        return promoteInfoService;
    }

    public DataSetService getDataSetService() {
        return dataSetService;
    }

    public StatusItemService getStatusItemService() {
        return statusItemService;
    }
}
