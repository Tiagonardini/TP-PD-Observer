package Punto4.model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailObserver implements Observer {
    @Override
    public void notificarInscripcion(String nombre, String gmail) {
        final String username = "b730102f80e705"; // Sustituir por tu usuario de Mailtrap
        final String password = "5eb3225d16e199"; // Sustituir por tu contraseña de Mailtrap

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.mailtrap.io");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@example.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(gmail));
            message.setSubject("Inscripción al Concurso");
            message.setText("Estimado " + nombre + ",\n\nGracias por inscribirte en el concurso!");

            Transport.send(message);

            System.out.println("Email enviado a: " +gmail);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
