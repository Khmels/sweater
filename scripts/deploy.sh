#!/usr/bin/env bash

mvn clean package

echo 'The goal you specified requires a project to execute but there is no POM in this directory '

echo  'Copy files...'

scp -i ~/.ssh/id_rsa \
    target/serving-web-content-0.0.1-SNAPSHOT.jar \
    serhio@192.168.0.105:/home/serhio/.dev/

echo  'Restart server...'

ssh -i ~/.ssh/id_rsa serhio@192.168.0.105 << EOF
pgrep java | xargs kill -9
nohup java -jar serving-web-content-0.0.1-SNAPSHOT.jar > log.txt &
EOF

echo 'Bye'