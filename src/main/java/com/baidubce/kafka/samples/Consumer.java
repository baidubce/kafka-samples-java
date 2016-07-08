/*
 * Copyright (c) 2014 Baidu.com, Inc. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.baidubce.kafka.samples;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;

import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

class Consumer {
    private static final int TIME_OUT_MS = 5000;

    static void run(String topic, int numOfRecords) throws IOException {
        Properties properties = new Properties();
        properties.load(Consumer.class.getClassLoader().getResourceAsStream("client.properties"));
        properties.setProperty(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, "kafka.bj.baidubce.com:9092");
        properties.setProperty(CommonClientConfigs.CLIENT_ID_CONFIG, "kafka-samples-java-consumer-1");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "kafka-samples-java-group");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class.getName());

        KafkaConsumer<byte[], byte[]> consumer = new KafkaConsumer<byte[], byte[]>(properties);
        consumer.subscribe(Collections.singletonList(topic));

        while (numOfRecords > 0) {
            ConsumerRecords<byte[], byte[]> records = consumer.poll(TIME_OUT_MS);
            for (ConsumerRecord<byte[], byte[]> record : records) {
                String position = record.partition() + "-" + record.offset();
                String key = new String(record.key(), "UTF-8");
                String value = new String(record.value(), "UTF-8");
                System.out.println(position + ": " + key + " " + value);
            }
            numOfRecords -= records.count();
        }

        consumer.close();
    }
}
