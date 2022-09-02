package com.github.fabriciolfj.util;

import software.amazon.awssdk.services.kinesis.model.GetRecordsRequest;
import software.amazon.awssdk.services.kinesis.model.GetShardIteratorRequest;
import software.amazon.awssdk.services.kinesis.model.ShardIteratorType;

public class CreateFindRequestProduct {

    public static GetRecordsRequest getRecordsRequest(final String idShard) {
        return GetRecordsRequest
                .builder()
                .shardIterator(idShard)
                .limit(5)
                .build();
    }

    public static GetShardIteratorRequest getShardIteratorRequest() {
        return GetShardIteratorRequest.builder()
                .streamName(Constants.STREAM_PRODUCTS)
                .shardId("shardId-000000000003")
                .shardIteratorType(ShardIteratorType.TRIM_HORIZON.name())
                .build();
    }
}
