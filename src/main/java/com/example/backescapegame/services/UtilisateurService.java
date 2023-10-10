package com.example.backescapegame.services;


import com.example.backescapegame.entities.Utilisateur;
import com.example.backescapegame.repositories.UtilisateurRepository;
import com.example.backescapegame.tasks.EmailDetails;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sender;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public String envoyerMail(Integer id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).get();
        String corps = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Votre Score</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color: #f2f2f2;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        .container {\n" +
                "            max-width: 600px;\n" +
                "            margin: 0 auto;\n" +
                "            padding: 20px;\n" +
                "            background-color: #ffffff;\n" +
                "            border: 1px solid #ccc;\n" +
                "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
                "        }\n" +
                "        h1 {\n" +
                "            color: #333;\n" +
                "        }\n" +
                "        p {\n" +
                "            color: #666;\n" +
                "            font-size: 18px;\n" +
                "        }\n" +
                "        .signature {\n" +
                "            margin-top: 20px;\n" +
                "            font-style: italic;\n" +
                "            color: #999;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <h1>Votre Score</h1>\n" +
                "        <p>Bonjour " + utilisateur.getNom() + ",</p>\n" +
                "        <p>Votre score est : <strong>" + utilisateur.getScore() + "</strong></p>\n" +
                "        <p>Merci de nous avoir choisis !</p>\n" +
                "        <p class=\"signature\">Cordialement,<br>Votre Nom</p>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>\n";
        EmailDetails details = new EmailDetails(utilisateur.getEmail(), corps, "Résumé d'\"Escape ton Hacèlement\"", null);

        try {


            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);


            helper.setFrom(sender);
            helper.setTo(details.getDestinataire());

            helper.setSubject(details.getSujet());
            message.setContent(details.getCorps(), "text/html; charset=utf-8");
            // Sending the mail
            javaMailSender.send(message);
            return "le mail a bien été envoyé";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return e.toString();
        }
    }
}
