# spring-int-tests
Simple example for spring integration (as springboot project)
with the use of 
- DB ---> JMS, In this sample, application read lines from database and insery them as messsages in Jms destination((<a href="https://github.com/amine-taibi-dz/spring-int-tests/blob/master/src/main/resources/integration/db2jms.xml">db2jms.xml</a>)
- JMS ---> DB , In this sample, application read message from Jms (activemq) destination, parse them, and insert them in database ((<a href="https://github.com/amine-taibi-dz/spring-int-tests/blob/master/src/main/resources/integration/jms2db.xml">jms2db.xml</a>)
- file --> DB  In this sample, application read files from a directory, parse them, and insert them in database (<a href="https://github.com/amine-taibi-dz/spring-int-tests/blob/master/src/main/resources/integration/file2db.xml">file2db.xml</a>)

This project is a simple project for learning,
Do not use it as-is!! for production purposes...
