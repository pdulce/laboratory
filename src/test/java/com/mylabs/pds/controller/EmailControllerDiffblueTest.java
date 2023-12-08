package com.mylabs.pds.controller;

import static org.mockito.Mockito.when;

import com.mylabs.pds.service.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EmailController.class})
@ExtendWith(SpringExtension.class)
class EmailControllerDiffblueTest {
    @Autowired
    private EmailController emailController;

    @MockBean
    private EmailService emailService;

    /**
     * Method under test:  {@link EmailController#sendEmail()}
     */
    @Test
    void testSendEmail() throws Exception {
        when(emailService.sendEmail()).thenReturn("jane.doe@example.org");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/sendEmail");
        MockMvcBuilders.standaloneSetup(emailController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("jane.doe@example.org"));
    }

    /**
     * Method under test:  {@link EmailController#sendEmailwithAttachment()}
     */
    @Test
    void testSendEmailwithAttachment() throws Exception {
        when(emailService.sendEmailwithAttachment()).thenReturn("jane.doe@example.org");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/sendEmailwithAttachment");
        MockMvcBuilders.standaloneSetup(emailController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("jane.doe@example.org"));
    }
}
