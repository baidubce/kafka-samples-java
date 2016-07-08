@echo off

echo compile...

mvn -q clean compile exec:java^
 -Dexec.mainClass="com.baidubce.kafka.samples.Application"^
 -Dexec.args="%1"