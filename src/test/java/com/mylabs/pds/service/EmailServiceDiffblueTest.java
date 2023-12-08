package com.mylabs.pds.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmailService.class})
@ExtendWith(SpringExtension.class)
class EmailServiceDiffblueTest {
    @Autowired
    private EmailService emailService;

    @MockBean
    private JavaMailSender javaMailSender;

    /**
     * Method under test: {@link EmailService#sendEmail()}
     */
    @Test
    void testSendEmail() throws MailException {
        doNothing().when(javaMailSender).send(Mockito.<SimpleMailMessage>any());
        String actualSendEmailResult = emailService.sendEmail();
        verify(javaMailSender).send(Mockito.<SimpleMailMessage>any());
        assertEquals("Mail sent successfully", actualSendEmailResult);
    }

    /**
     * Method under test: {@link EmailService#sendEmailwithAttachment()}
     */
    @Test
    void testSendEmailwithAttachment() throws MailException {
        doNothing().when(javaMailSender).send(Mockito.<MimeMessage>any());
        when(javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        String actualSendEmailwithAttachmentResult = emailService.sendEmailwithAttachment();
        verify(javaMailSender).createMimeMessage();
        verify(javaMailSender).send(Mockito.<MimeMessage>any());
        assertEquals("Mail sent successfully", actualSendEmailwithAttachmentResult);
    }
}
