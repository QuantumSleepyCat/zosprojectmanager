package by.iba.emailsender.email;

import by.iba.projmanmodels.model.HostInfo;

public class MessageCreator {
    public static String createMessage(int id)
    {
        String message = "Hello. This is message with link for promote. \n" +
                "Go to "+ HostInfo.getHost()+"report/"+id+
                "\nLogin: user\nPassword:123456";
        return message;
    }
}
