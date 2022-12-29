#!/bin/sh
mvn clean package && docker build -t com.mycompany/MovieReviewSOAR .
docker rm -f MovieReviewSOAR || true && docker run -d -p 9080:9080 -p 9443:9443 --name MovieReviewSOAR com.mycompany/MovieReviewSOAR