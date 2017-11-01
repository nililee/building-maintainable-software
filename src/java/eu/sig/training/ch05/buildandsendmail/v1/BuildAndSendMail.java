package eu.sig.training.ch05.buildandsendmail.v1;

public class BuildAndSendMail {
    // tag::buildAndSendMail[]
    public void buildAndSendMail(MailMan m, String firstName, String lastName,
        String division, String subject, MailFont font, String message1,
        String message2, String message3) {
        // 이메일 주소 형식으로 맞춘다.
        String mId = firstName.charAt(0) + "." + lastName.substring(0, 7) + "@"
            + division.substring(0, 5) + ".compa.ny";
        // 주어진 타입과 원천 메시지로 메시지 형식을 맞춘다.
        MailMessage mMessage = formatMessage(font,
            message1 + message2 + message3);
        // 메시지를 전송한다.
        m.send(mId, subject, mMessage);
    }
    // end::buildAndSendMail[]

    @SuppressWarnings("unused")
    private MailMessage formatMessage(MailFont font, String string) {
        return null;
    }

    private class MailMan {

        @SuppressWarnings("unused")
        public void send(String mId, String subject, MailMessage mMessage) {}

    }

    private class MailFont {

    }

    private class MailMessage {

    }

}
