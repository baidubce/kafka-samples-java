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
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.ByteArraySerializer;

import java.io.IOException;
import java.util.Properties;

class Producer {
    static void run(String topic, int numOfRecords) throws IOException {
        Properties properties = new Properties();
        properties.load(Consumer.class.getClassLoader().getResourceAsStream("client.properties"));
        properties.setProperty(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, "kafka.bj.baidubce.com:9092");
        properties.setProperty(CommonClientConfigs.CLIENT_ID_CONFIG, "kafka-samples-java-producer-1");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class.getName());

        KafkaProducer<byte[], byte[]> producer = new KafkaProducer<byte[], byte[]>(properties);

        for (int i = 0; i < numOfRecords; i++) {
            byte[] key = Integer.toString(i).getBytes("UTF-8");
            byte[] value = "hello, kafka".getBytes("UTF-8");
            ProducerRecord<byte[], byte[]> record = new ProducerRecord<byte[], byte[]>(topic, key, value);
            producer.send(record);
        }

        producer.close();
    }
}
