FROM adoptopenjdk:11-jre-hotspot
LABEL maintainer=" "
LABEL version="0.0.1"
LABEL description="prodotto rest api"
RUN apt update && apt install tzdata -y
ENV TZ="Europe/Rome"
RUN mkdir -p /opt/prodotto/backend
COPY target/ProdottoRestSpring-0.0.1-SNAPSHOT.jar /opt/prodotto/backend
WORKDIR /opt/prodotto/backend
ENTRYPOINT ["java", "-jar","ProdottoRestSpring-0.0.1-SNAPSHOT.jar"]