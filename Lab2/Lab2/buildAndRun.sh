#!/bin/sh
mvn clean package && docker build -t com.mycompany/Lab2 .
docker rm -f Lab2 || true && docker run -d -p 9080:9080 -p 9443:9443 --name Lab2 com.mycompany/Lab2