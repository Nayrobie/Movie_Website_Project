@echo off
call mvn clean package
call docker build -t com.mycompany/MovieReviewSOAR .
call docker rm -f MovieReviewSOAR
call docker run -d -p 9080:9080 -p 9443:9443 --name MovieReviewSOAR com.mycompany/MovieReviewSOAR