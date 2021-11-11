#!/bin/sh
mvn clean package && docker build -t com.mycompany/Lab3 .
docker rm -f Lab3 || true && docker run -d -p 9080:9080 -p 9443:9443 --name Lab3 com.mycompany/Lab3