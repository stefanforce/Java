@echo off
call mvn clean package
call docker build -t com.mycompany/Lab2 .
call docker rm -f Lab2
call docker run -d -p 9080:9080 -p 9443:9443 --name Lab2 com.mycompany/Lab2