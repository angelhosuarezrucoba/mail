package com.springboot.app.mail.config.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.mail.config.service.NotificationService;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class RegistrationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/enviar/{correo}/{clave}/{destino}")
    public String signUpSuccess2(@PathVariable String correo, @PathVariable String clave,
            @PathVariable String destino)
            throws MessagingException, IOException {
        notificationService.send(correo, clave, destino);
        return "gracias";
    }
}
