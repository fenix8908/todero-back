# Usa la imagen oficial de Maven para construir el proyecto
FROM maven:3.9.7-amazoncorretto-17-debian AS build

# Establece el directorio de trabajo dentro del contenedor para la fase de construcción
WORKDIR /app

# Copia el archivo de configuración de Maven
COPY pom.xml .

# Descarga las dependencias del proyecto (esto ayuda a cachear las dependencias)
RUN mvn dependency:go-offline

# Copia el código fuente de la aplicación
COPY src ./src

# Ejecuta el comando de construcción de Maven
RUN mvn clean package -DskipTests

# Segunda fase: Ejecución
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor para la fase de ejecución
WORKDIR /app

# Copia el JAR generado desde la fase de construcción
COPY --from=build /app/target/*.jar ./app.jar

# Expone el puerto que tu aplicación usa
EXPOSE 8080

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
