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
import java.util.List;

/**
 *
 * @author carlos
 */
public class MyHandler {

    private LambdaLogger logger;

    public MyHandler() {

    }

    public void handler(SQSEvent event, Context context) {
        logger = context.getLogger();
        logger.log("Starting with extraction of data from SQSEvent");
        List<SQSMessage> messages = event.getRecords();
        messages.stream().parallel().forEach(this::processMessage);
    }

    private void processMessage(SQSMessage message) {
        logger.log("Message ID: " + message.getMessageId());
        String body = message.getBody();
    }

}
