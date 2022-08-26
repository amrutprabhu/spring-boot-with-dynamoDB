package com.amrut.prabhu;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories
public class DynamoDBConfiguration {

    @Bean
    public AmazonDynamoDB amazonDynamoDB(AWSCredentials AWSCredentials,
                                         @Value("${aws.dynamoDBUrl}") String dynamoDBURl) {

        AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamoDBURl, "eu-central-1"))
                .withCredentials(new AWSStaticCredentialsProvider(AWSCredentials));
        AmazonDynamoDB build = builder.build();
        return build;
    }

    @Bean
    public AWSCredentials awsCredentials(@Value("${aws.accessKey}") String accesskey,
                                         @Value("${aws.secretKey}") String secretkey) {
        return new BasicAWSCredentials(accesskey, secretkey);
    }
}
