ssh -o StrictHostKeyChecking=no root@172.100.101.84 -tt << remotessh
set -x
docker rm -f service-boot-web
docker run -d -p 8080:8080 --name service-boot-web --mount type=bind,source=/tmp/service-boot-web-0.0.1-SNAPSHOT.jar,target=/opt/jenkinsapp/service-boot-web-0.0.1-SNAPSHOT.jar leerenbo/git-java10-maven-ssh java -jar /opt/jenkinsapp/service-boot-web-0.0.1-SNAPSHOT.jar
exit
