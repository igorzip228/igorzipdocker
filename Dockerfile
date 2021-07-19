FROM openjdk:17-ea-14-jdk-alpine3.13

# RUN apt-get install curl jq
RUN apk add curl jq

#Workspace
WORKDIR /usr/share/docker_study

# ADD .jar under target from host
# into this image
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

# in case of any other dependency like .csv / .json / .xls
# please ADD that as well

# ADD suite files
ADD duck_duck_test.xml duck_duck_test.xml
ADD wiki_test.xml wiki_test.xml

#ADD health check script
ADD healthcheck.sh healthcheck.sh
# BROWSER
# HUB_HOST
# MODULE

ENTRYPOINT sh healthcheck.sh
# ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE