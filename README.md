## Source

[Telusko: Rest API | Web Service Tutorial](https://www.youtube.com/watch?v=BZi44GOD8kY&list=WL&index=25)

## application.properties

Add following details in application.properties (src/main/resources)

```
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/restdb
spring.datasource.username=root
spring.datasource.password=root@123   # password for root
server.error.include-message=always
```

Modify the above details depending upon the your configuration.

Here,<br>
DBMS is **mysql**. <br>
Database is **restdb**.