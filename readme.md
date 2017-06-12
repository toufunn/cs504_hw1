#Assumption:
#Mysql database: private
#Tomcat:9001

#BUILD CODE
cd running-information-analysis-service
mvn clean install
cd target;java -jar running-location-service-1.0.0.BUILD-SNAPSHOT.jar

#INSERTION:
curl -H "Content-Type: application/json" localhost:9001/users -d @health-information-analysis.json

#GET ALL page and size are needed
curl -X GET "http://localhost:9001/users?page=0&size=3"

#DELETE A SPECIF userId
#curl -X DELETE "http://localhost:9001/user/{userId}"
#e.g
curl -X DELETE "http://localhost:9001/user/33"


#GET A SPECIF userId
#curl -X GET "http://localhost:9001/user/{userId}"
#e.g
curl -X GET "http://localhost:9001/user/33?page=0&size=1"

#GET healtWarning by its level page and size are needed
curl -X GET "http://localhost:9001/users/heart?page=0&size=2"

#DELET ALL RECORDS
curl -X POST "http://localhost:9001/purge"

#TODO
#Write Specification to only return a subset of json

