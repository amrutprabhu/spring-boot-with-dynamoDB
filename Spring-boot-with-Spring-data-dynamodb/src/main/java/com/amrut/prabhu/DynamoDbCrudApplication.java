package com.amrut.prabhu;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.amrut.prabhu.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DynamoDbCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamoDbCrudApplication.class, args);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void onapplicationready() {
//        CreateTableRequest createTableRequest = dynamoDBMapper.generateCreateTableRequest(Person.class)
//                .withProvisionedThroughput(new ProvisionedThroughput(1l, 1l));
//        TableUtils.createTableIfNotExists(amazonDynamoDB, createTableRequest);
//    }

}
