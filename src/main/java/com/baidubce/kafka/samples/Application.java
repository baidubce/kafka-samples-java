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

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Application {
    private static final int NUM_OF_RECORD = 10;

    public static void main(String[] args) throws IOException {
        if (args.length < 1 || "".equals(args[0])) {
            System.out.println("argument topic_name missing");
            System.out.println("");
            System.out.println("Usage: run.bat/run.sh topic_name");
            System.out.println("Please follow guide on https://bce.baidu.com/product/kafka.html to: ");
            System.out.println("  1. Create/Get client.keystore.jks, client.truststore.jks files.");
            System.out.println("  2. Create/Get client.properties file.");
            System.out.println("  3. Create/Get topic.");
            return;
        }

        if (new File("client.keystore.jks").length() == 0 || new File("client.truststore.jks").length() == 0) {
            System.out.println("Please replace *.jks with your own.");
            return;
        }

        Properties properties = new Properties();
        properties.load(Application.class.getClassLoader().getResourceAsStream("client.properties"));
        if ("your_keystore_password".equals(properties.getProperty("ssl.keystore.password"))) {
            System.out.println("Please replace resources/client.properties with your own.");
            return;
        }

        String topic = args[0];
        Producer.run(topic, NUM_OF_RECORD);
        Consumer.run(topic, NUM_OF_RECORD);
    }
}
