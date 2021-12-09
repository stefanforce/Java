@echo off
call mvn clean package
call docker build -t com.mycompany/Lab7 .
call docker rm -f Lab7
call docker run -d -p 9080:9080 -p 9443:9443 --name Lab7 com.mycompany/Lab7