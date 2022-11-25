FROM openjdk:8

WORKDIR /notesapp

# buid the project using mvn install
COPY target/easy-notes-1.0.0.jar .

ENTRYPOINT [ "java", "-jar", "easy-notes-1.0.0.jar" ]