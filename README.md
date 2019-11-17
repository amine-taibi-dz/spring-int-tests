# spring-int-tests
Simple example for spring integration (as springboot project)
with the use of 
- DB ---> JMS, In this sample, application read lines from database and insery them as messsages in Jms destination(db2jms.xml)
- JMS ---> DB , In this sample, application read message from Jms (activemq) destination, parse them, and insert them in database (jms2db.xml)
- file --> DB  In this sample, application read files from a directory, parse them, and insert them in database (file2db.xml)

This project is a simple project for learning,
Do not use it as-is!! for production purposes...
