package com.github.fabriciolfj;

import com.github.fabriciolfj.converter.ProductJson;
import com.github.fabriciolfj.util.CreateFindRequestProduct;
import software.amazon.awssdk.services.kinesis.model.GetRecordsRequest;
import software.amazon.awssdk.services.kinesis.model.GetRecordsResponse;
import software.amazon.awssdk.services.kinesis.model.Record;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.github.fabriciolfj.config.KinesisClientConfig.getInstance;

public class ReceivedEvents {

    private static Logger log = Logger.getLogger(ReceivedEvents.class.getName());

    public static void main(String[] args) {
        receive();
    }

    private static void receive() {
        var client = getInstance();
        var iteratorRequest = CreateFindRequestProduct.getShardIteratorRequest();
        final var response = client.getShardIterator(iteratorRequest);

        String idShard = response.shardIterator();

        while (idShard != null) {
            final GetRecordsRequest request = CreateFindRequestProduct.getRecordsRequest(idShard);
            final GetRecordsResponse recordsResponse = client.getRecords(request);

            final List<Record> records = recordsResponse.records();
            records.stream()
                    .map(p -> new String(p.data().asByteArray()))
                    .map(s -> ProductJson.toProduct(s))
                    .forEach(p -> log.info("Product " + p.toString()));


            idShard = recordsResponse.nextShardIterator();
        }

        client.close();
    }
}
