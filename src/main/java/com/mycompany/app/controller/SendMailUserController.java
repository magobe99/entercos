package com.mycompany.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.app.modelo.MailServiceUsuario;

@Controller
public class SendMailUserController {
	@Autowired
    private MailServiceUsuario mailService;

    @GetMapping("correo")
    public String envioCorreoUser() {
        return "correo";
    }

    @PostMapping("/sendEmailUsuario")
    public String sendEmailUsuario(@RequestParam("to") String to,@RequestParam("subject") String subject, @RequestParam("body") String body) {
       
        String message = body;
        mailService.sendEmailUsuario("wilmogo2020@gmail.com", to , subject, message);

        return "correo";
    }
}
