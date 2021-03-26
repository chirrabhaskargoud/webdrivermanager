FROM markhobson/maven-chrome:jdk-8

ENV PROJECT_DIR=/app
RUN mkdir -p /app 
RUN mkdir -p /app/logs/
COPY . $PROJECT_DIR
RUN apk add tzdata
RUN cp /usr/share/zoneinfo/Asia/Kolkata /etc/localtime
RUN npm config set package-lock false
RUN cd /app && npm install
RUN chmod +x /app/init
WORKDIR "/app/"
CMD ["ng serve"]
EXPOSE 4200