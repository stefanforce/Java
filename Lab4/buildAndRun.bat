@echo off
call mvn clean package
call docker build -t com.mycompany/Lab3 .
call docker rm -f Lab3
call docker run -d -p 9080:9080 -p 9443:9443 --name Lab3 com.mycompany/Lab3