/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitario;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.Deportista;

/**
 *
 * @author LARH96
 */
public class Email {

    private final Properties props = new Properties();
    private Session session;

    private String remitente;
    private String contrasenna;

    private void init() {
        this.remitente = "generictestlarh96@gmail.com";
        this.contrasenna = "C0mpl1c4d4";

        props.put("mail.smtp.host", "smtp.gmail.com"); //mail.gmail.com
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", 25); //587?
        props.put("mail.smtp.auth", "true");
        session = Session.getDefaultInstance(props);

        //ó con:
        //props.put("mail.smtp.mail.sender", remitente);
        //props.put("mail.smtp.user", "usuario");
    }

    public void sendEmail(String destinatario, Deportista pDeportista) {
        String asunto = "Autoregistro Deportista";
        String mensaje = pDeportista.getNombre() + " "
                + pDeportista.getApellido1()
                + " se ha realizado su registro y tan pronto como sea asignado"
                + " un instructor le estará llegando un correo con la comunicación";

        init();
        try {
            MimeMessage message = new MimeMessage(session);

            //remitente y destinatario
            message.setFrom(new InternetAddress(remitente)); //ó message.setFrom(new InternetAddress((String) props.get("mail.smtp.mail.sender")));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(destinatario));

            //correo
            message.setSubject(asunto);
            message.setText(mensaje);

            Transport t = session.getTransport("smtp");
            t.connect(remitente, contrasenna);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        } catch (MessagingException e) {
            e.getMessage();
        }
    }
}
