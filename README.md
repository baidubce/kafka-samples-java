# 百度Kafka服务Java源代码样例

百度Kafka是托管的Kafka消息服务。完全兼容开源Kafka。本样例展示如何使用Kafka原生客户端访问百度Kafka服务。
改样例包含可执行的源代码，如果需要，您可以直接基于样例中的代码进行再次开发。

## 如何运行

### 运行环境

- [Oracle JDK 7 or JDK 8](http://www.oracle.com/technetwork/java/)
- 最新的稳定版[Apache Maven](http://maven.apache.org/)

### 准备topic和SSL证书

准备工作的细节请参考[BCE官网帮助文档](https://cloud.baidu.com/doc/Kafka/QuickGuide.html)

1. 在BCE管理控制台中创建好topic。
2. 在BCE管理控制台中下载您的jks证书文件和kafka客户端配置文件。
3. 用上一步的文件替换样例代码中的`client.keystore.jks`, `client.truststore.jks`以及`src/main/resources/client.properties`

### 运行样例代码

windows环境请执行：

    run.bat your_topic_name

linux环境请执行：

    sh run.sh your_topic_name

## 参考链接

- [百度Kafka产品介绍](https://bce.baidu.com/product/kafka.html)
- [Kafka](http://kafka.apache.org/)




# Baidu Kafka Java Samples

Baidu Kafka is a fully managed kafka compatible message service.
This sample illustrates how to access Baidu Kafka using open source kafka client.

## How to run

### Kafka-samples-java requires

- Latest stable [Oracle JDK 7 or JDK 8](http://www.oracle.com/technetwork/java/)
- Latest stable [Apache Maven](http://maven.apache.org/)

### Prepare your topic and SSL certificates

Please follow [guide](https://cloud.baidu.com/doc/Kafka/QuickGuide.html) on cloud.baidu.com for detail.

1. Create your own topic in BCE console.
2. Download your own certificate files and kafka client properties files in BCE console.
3. Replace `client.keystore.jks`, `client.truststore.jks` and `src/main/resources/client.properties` with your own.

### Run the sample

On windows execute

    run.bat your_topic_name

On linux execute

    sh run.sh your_topic_name

## Links

- [Baidu Kafka](https://bce.baidu.com/product/kafka.html)
- [Kafka](http://kafka.apache.org/)
