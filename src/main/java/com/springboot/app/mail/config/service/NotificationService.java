package com.springboot.app.mail.config.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private MailSenderService mailSenderService;

    public void send(String correo, String clave, String destino) throws MessagingException, IOException {

        JavaMailSender mailsender = mailSenderService.getJavaMailSender(correo, clave);
        MimeMessage msg = mailsender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setFrom(correo);
        helper.setTo(destino);
        helper.setSubject("esta es una prueba");
        helper.setText("<h1>Hola " + destino + " </h1>", true);
        mailsender.send(msg);
    }

}
