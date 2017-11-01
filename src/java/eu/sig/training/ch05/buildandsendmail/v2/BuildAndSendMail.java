package eu.sig.training.ch05.buildandsendmail.v2;

@SuppressWarnings("unused")
public class BuildAndSendMail {

    // tag::buildAndSendMail[]
    public void buildAndSendMail(MailMan m, MailAddress mAddress,
        MailBody mBody) {
        // 메일을 작성한다.
        Mail mail = new Mail(mAddress, mBody);
        // 메일을 전송한다.
        m.sendMail(mail);
    }

    private class Mail {
        private MailAddress address;
        private MailBody body;

        private Mail(MailAddress mAddress, MailBody mBody) {
            this.address = mAddress;
            this.body = mBody;
        }
    }

    private class MailBody {
        String subject;
        MailMessage message;

        public MailBody(String subject, MailMessage message) {
            this.subject = subject;
            this.message = message;
        }
    }

    private class MailAddress {
        private String mId;

        private MailAddress(String firstName, String lastName,
            String division) {
            this.mId = firstName.charAt(0) + "." + lastName.substring(0, 7)
                + "@"
                + division.substring(0, 5) + ".compa.ny";
        }
    }
    // end::buildAndSendMail[]

    private MailMessage formatMessage(MailFont font, String string) {
        return null;
    }

    private class MailMan {
        public void send(String mId, String subject, MailMessage mMessage) {}
        public void sendMail(Mail mail) {}
    }

    private class MailFont {}

    private class MailMessage {}

}
