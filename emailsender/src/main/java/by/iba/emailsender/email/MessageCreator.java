package by.iba.emailsender.email;

import by.iba.projmanmodels.model.HostInfo;

public class MessageCreator {
    public static String createMessage(long id)
    {
        String message = "Hello. This is message with link for promote. \n" +
                "Go to <a href=\""+ HostInfo.getHost()+"report/"+id+
                "\">link</a>\nLogin: user\nPassword:123456";
        return message;
    }
}
