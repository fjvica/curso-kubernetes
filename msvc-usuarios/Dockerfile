ARG MSVC_NAME=msvc-usuarios

FROM openjdk:11.0.16 as builder

ARG MSVC_NAME

WORKDIR /app/$MSVC_NAME

COPY ./pom.xml /app
COPY ./msvc-usuarios/.mvn ./.mvn
COPY ./msvc-usuarios/mvnw .
COPY ./msvc-usuarios/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline

COPY ./msvc-usuarios/src ./src

RUN ./mvnw clean package -DskipTests


FROM openjdk:11.0.16

WORKDIR /app
COPY --from=builder /app/msvc-usuarios/target/msvc-usuarios-0.0.1-SNAPSHOT.jar .
ENV PORT 8001
EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]