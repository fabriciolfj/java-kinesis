package com.github.fabriciolfj;

import com.github.fabriciolfj.config.KinesisClientConfig;
import com.github.fabriciolfj.converter.ProductJson;
import com.github.fabriciolfj.util.CreateRequestRecordProduct;

import java.util.logging.Logger;

public class EventSender {

    private static Logger log = Logger.getLogger(EventSender.class.getName());

    public static void main(String[] args) {
        sendEvent();
    }

    private static void sendEvent() {
        final var client = KinesisClientConfig.getInstance();
        final var value = ProductJson.toJson(1);

        var record = CreateRequestRecordProduct.toRequest(value);
        var result = client.putRecord(record);

        log.info("Send result " + result);
        client.close();
    }
}
