package com.github.fabriciolfj.config;

import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.kinesis.KinesisClient;

public class KinesisClientConfig {

    private static KinesisClient kinesisClient;

    public static synchronized KinesisClient getInstance() {
        if (kinesisClient != null) {
            return kinesisClient;
        }

        kinesisClient = getKinesisClient();
        return kinesisClient;
    }

    private synchronized static KinesisClient getKinesisClient() {
        final AwsCredentialsProvider credentialsProvider =
                ProfileCredentialsProvider
                        .create("default");

        final KinesisClient kinesisClient = KinesisClient
                .builder()
                .credentialsProvider(credentialsProvider)
                .region(Region.SA_EAST_1).build();
        return kinesisClient;
    }
}
