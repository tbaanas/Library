package controller;

import interfaces.EmailSender;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;



public class EmailController implements EmailSender{
    private  EmailSender emailSender;
    private TemplateEngine templateEngine;

/*    public EmailController(EmailSender emailSender,
                           TemplateEngine templateEngine){

        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }*/
    public void send(String email,String hash) {

        Context context = new Context();
        context.setVariable("header", "Nowy artykuł na CodeCouple");
        context.setVariable("title", "#8 Spring Boot – email - szablon i wysyłanie");
        context.setVariable("description", "Tutaj jakis opis...");
        context.setVariable("link", "https://webtom.herokuapp.com/Hash/" + hash);
        String body = templateEngine.process("template", context);
        emailSender.sendEmail(email, "POTWIERDŹ MAILA", body);

    }



    public void sendEmail(String to, String title, String content) {

    }
}
