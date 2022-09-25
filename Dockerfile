FROM maven:latest
RUN mkdir /jwt_th04
WORKDIR /jwt_th04
COPY . .
EXPOSE 8080
CMD [ "mvn", "spring-boot:run" ]