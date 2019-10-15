# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM adoptopenjdk/openjdk8:latest
RUN mkdir /usr/src/bootdocker
COPY empleados-0.0.1-SNAPSHOT.jar /usr/src/bootdocker
WORKDIR /usr/src/bootdocker
EXPOSE 8080
CMD ["java","-jar","-Dspring.data.mongodb.host=mongodbcontainer","/usr/src/empleados-0.0.1-SNAPSHOT.jar"]

