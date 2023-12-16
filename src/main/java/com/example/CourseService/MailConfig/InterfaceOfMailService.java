package com.example.CourseService.MailConfig;

public interface InterfaceOfMailService {
    String sendMail(MailDetail mailDetail);

    String sendMailWithAttachment(MailDetail mailDetail);
}
