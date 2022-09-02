package com.github.fabriciolfj;

import com.github.fabriciolfj.config.KinesisClientConfig;
import com.github.fabriciolfj.converter.ProductJson;
import com.github.fabriciolfj.util.CreateRequestRecordProduct;
import software.amazon.awssdk.services.kinesis.model.PutRecordsRequestEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EventsSender {

    private static Logger log = Logger.getLogger(EventsSender.class.getName());

    public static void main(String[] args) {
        sendEvent();
    }

    private static void sendEvent() {
        final var client = KinesisClientConfig.getInstance();
        final List<PutRecordsRequestEntry> recordsRequests = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            final var value = ProductJson.toJson(i);

            recordsRequests.add(CreateRequestRecordProduct.toRequests(value));
        }

        var request = CreateRequestRecordProduct.toManyRequest(recordsRequests);
        var result = client.putRecords(request);

        log.info("Send result " + result);
        client.close();
    }
}
