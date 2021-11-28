package mailing_system;

import java.io.IOException;
import java.lang.reflect.Field;

public class MailInfo {
    private Client client;
    private MailCode mc;

    public MailInfo(Client client, MailCode mc) {
        this.client = client;
        this.mc = mc;
    }

    public String getMailText() throws IOException, IllegalAccessException {
        String text = mc.generateText();

        for(Field f: client.getClass().getDeclaredFields()) {
            Template t = f.getAnnotation(Template.class);
            if (t == null) continue;

            try {
                text = text.replace(t.value(), f.get(client).toString());
            } catch (IllegalAccessException _) {
                continue;
            }
        }

        return text;
    }
}
