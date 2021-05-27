package com.kirabium.gegemail.service;


import com.kirabium.gegemail.model.Mail;

import java.util.ArrayList;
import java.util.List;


/**
 * Mail API client
 */
public interface MailApiService {

    /**
     * Get all my Mails
     * @return {@link List}
     */
    ArrayList<Mail> getMails();

    /**
     * Deletes a mail
     * @param mail
     */
    void deleteMail(Mail mail);

    /**
     * Create a mail
     * @param mail
     */
    void createMail(Mail mail);
}
