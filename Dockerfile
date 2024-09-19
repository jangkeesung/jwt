# 1단계: 빌드 환경
FROM gradle:7.5-jdk17 AS build

# 작업 디렉토리 설정
WORKDIR /app

# Gradle 파일 복사 및 Gradle 캐시 생성
COPY build.gradle settings.gradle ./
COPY src ./src
RUN gradle build --no-daemon -x test

# 2단계: 실행 환경
FROM openjdk:17-alpine

# JAR 파일 복사
COPY --from=build /app/build/libs/*.jar spring-boot-app.jar

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/spring-boot-app.jar"]
