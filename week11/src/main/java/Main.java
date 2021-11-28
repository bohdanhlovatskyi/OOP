import mailing_system.Client;
import mailing_system.MailCode;
import mailing_system.MailInfo;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Client c = new Client("Bohdan", 18, true);
        MailInfo mi = new MailInfo(c, MailCode.GREETINGS);
        try {
            System.out.println(mi.getMailText());
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
