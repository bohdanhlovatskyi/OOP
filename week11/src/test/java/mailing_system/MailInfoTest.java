package mailing_system;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MailInfoTest {

    Client c = new Client("Bohdan", 18, true);
    MailInfo mi = new MailInfo(c, MailCode.GREETINGS);

    @Test
    void getMailText() throws IOException, IllegalAccessException {
        String res = mi.getMailText();
        assertTrue(res.toString().contains("Hello, there. Bohdan, have a nice day!"));
    }
}