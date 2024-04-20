# spring_boot_3_Kafka
- .\bin\windows\kafka-server-start.bat .\config\server.properties

- .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

- Reference: https://reachmnadeem.wordpress.com/2020/08/30/kafka-2-6-up-and-running-in-windows-10/

# Send Message
![token generate/ user login ](https://github.com/HarshaVardhanAcharyAthaluri/spring_boot_3_Kafka/blob/main/kafkamessage.JPG)

# These properties Helps us to read unconsumed message after springboot consumer restart
* spring.kafka.consumer.group-id=spring-consumer
* spring.kafka.consumer.auto-offset-reset=earliest
* spring.kafka.consumer.enable-auto-commit=true

# Angular app.module.ts
* ng new --no-standalone

# websocket
npm install --save sockjs-client stompjs