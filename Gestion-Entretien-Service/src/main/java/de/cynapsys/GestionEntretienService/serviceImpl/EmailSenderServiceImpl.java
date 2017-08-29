package de.cynapsys.GestionEntretienService.serviceImpl;

import de.cynapsys.GestionEntretienService.entities.Entretienexamen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


/**
 * Created by Chams Eddine on 11/07/2017.
 */

@Service
public class EmailSenderServiceImpl  {
    private final JavaMailSender javaMailSender;
    private TemplateEngine templateEngine;

    @Autowired
    public EmailSenderServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    public boolean prepareAndSend(Entretienexamen entretienexamen) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("bensalemchams@gmail.com");
            messageHelper.setTo(entretienexamen.getEntretien().getCandidat().getEmail());
            messageHelper.setSubject("CynapsysGeekLab resultat d'examen");
            String content = build(entretienexamen);
            messageHelper.setText(content, true);
        };
        try {
            javaMailSender.send(messagePreparator);
            return true;
        } catch (MailException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public String build(Entretienexamen entretienexamen) {
        Context context = new Context();
        context.setVariable("nomCandidat", entretienexamen.getEntretien().getCandidat().getNom());
        context.setVariable("prenomCandidat", entretienexamen.getEntretien().getCandidat().getPrenom());
        context.setVariable("typeExamen", entretienexamen.getExamen().getType());
        context.setVariable("resultat", entretienexamen.getResultat());
        return templateEngine.process("email", context);
    }

}
