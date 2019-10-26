/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dcarlidev.processdatafromfield4;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;
import com.dcarlidev.processdatafromfield4.model.MT103;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author carlos
 */
public class MyHandler {
    
    private LambdaLogger logger;
    private final EntityManager entityManager = Persistence.createEntityManagerFactory("ProcessDataFromField4_PU").createEntityManager();
    private int invocation = 0;
    
    public MyHandler() {
        
    }
    
    public void handler(SQSEvent event, Context context) {
        logger = context.getLogger();
        logger.log("Starting with extraction of data from SQSEvent " + invocation);
        invocation++;
        List<SQSMessage> messages = event.getRecords();
        logger.log("Size of records: " + messages.size());
        messages.stream().forEach(this::processMessage);
    }
    
    private void processMessage(SQSMessage message) {
//        logger.log("Message ID: " + message.getMessageId());
        String body = message.getBody();
//        logger.log("Body: " + body);
        String[] lines = body.replaceAll("\t", "").trim().split("\n:");
        MT103 mt103 = new MT103();
        for (String line : lines) {
            String beginLine = line.startsWith(":") ? line.substring(1, 3) : line.substring(0, 2);
            int begin = Integer.parseInt(beginLine);
            switch (begin) {
                case 20:
                    getField20(line, mt103);
                case 21:
                    getField21(line, mt103);
                case 25:
                    getField25(line, mt103);
                case 28:
                    getField28(line, mt103);
                case 60:
                    getField60(line, mt103);
                case 61:
                    getField61(line, mt103);
                case 62:
                    getField62(line, mt103);
                case 64:
                    getField64(line, mt103);
                case 86:
                    getField86(line, mt103);
            }
        }
        logger.log("Comenzando a insertar " + mt103.getField20());
        EntityTransaction tx = entityManager.getTransaction();
        if (!tx.isActive()) {
            tx.begin();
        }
        entityManager.persist(mt103);
        tx.commit();
        logger.log("Termino de insertar " + mt103.getField20());
    }
    
    private void getField20(String line, MT103 mt103) {
        String field20 = line.substring(4);
        mt103.setField20(field20);
    }
    
    private void getField21(String line, MT103 mt103) {
        String field21 = line.substring(3);
        mt103.setField21(field21);
    }
    
    private void getField25(String line, MT103 mt103) {
        String field25 = line.substring(3);
        mt103.setField25(field25);
    }
    
    private void getField28(String line, MT103 mt103) {
        String field28 = line.substring(4);
        mt103.setField28(field28);
    }
    
    private void getField60(String line, MT103 mt103) {
        String field60 = line.substring(4);
        mt103.setField60(field60);
    }
    
    private void getField61(String line, MT103 mt103) {
        mt103.setField61(line);
    }
    
    private void getField62(String line, MT103 mt103) {
        String field62 = line.substring(3);
        mt103.setField62(field62);
    }
    
    private void getField64(String line, MT103 mt103) {
        String field64 = line.substring(3);
        mt103.setField64(field64);
    }
    
    private void getField86(String line, MT103 mt103) {
        String field86 = line.substring(3);
        mt103.setField86(field86);
    }
    
    public static void main(String... args) {
        MyHandler myh = new MyHandler();
        SQSMessage message = new SQSMessage();
        message.setBody("\n		:20:191014123456\n"
                + "		:21:191014999999\n"
                + "		:25:PL30116022020000001111111111\n"
                + "		:28C:1433\n"
                + "		:60F:C141019USD1000,01\n"
                + "		:61:0506200620CN100,00\n"
                + "		BancoBasa\n"
                + "		:62F:C050620PLN1005,01\n"
                + "		:64:C050620PLN1005,01\n"
                + "		:86:Wyci?g nr: 143 z dnia: 2019-10-14");
        myh.processMessage(message);
    }
    
}
