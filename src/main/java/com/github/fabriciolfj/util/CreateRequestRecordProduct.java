package com.github.fabriciolfj.util;


import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.kinesis.model.PutRecordRequest;
import software.amazon.awssdk.services.kinesis.model.PutRecordsRequest;
import software.amazon.awssdk.services.kinesis.model.PutRecordsRequestEntry;

import java.nio.ByteBuffer;
import java.util.List;

import static com.github.fabriciolfj.util.Constants.PARTITION_KEY;
import static com.github.fabriciolfj.util.Constants.STREAM_PRODUCTS;

public class CreateRequestRecordProduct {

    public static PutRecordRequest toRequest(final String value) {
        final SdkBytes data = SdkBytes.fromByteBuffer(ByteBuffer.wrap(value.getBytes()));

        return PutRecordRequest.builder()
                .streamName(STREAM_PRODUCTS)
                .partitionKey(PARTITION_KEY)
                .data(data)
                .build();
    }

    public static PutRecordsRequestEntry toRequests(final String value) {
        final SdkBytes data = SdkBytes.fromByteBuffer(ByteBuffer.wrap(value.getBytes()));

        return PutRecordsRequestEntry.builder()
                .partitionKey(PARTITION_KEY)
                .data(data)
                .build();
    }

    public static PutRecordsRequest toManyRequest(final List<PutRecordsRequestEntry> list) {
        return PutRecordsRequest
                .builder()
                .records(list)
                .streamName(STREAM_PRODUCTS)
                .build();
    }
}
