#!/bin/sh
mvn clean package && docker build -t com.mycompany/Lab7 .
docker rm -f Lab7 || true && docker run -d -p 9080:9080 -p 9443:9443 --name Lab7 com.mycompany/Lab7