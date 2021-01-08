FROM tomcat:8.5.58

COPY ./target/*.war $CATALINA_HOME/webapps

EXPOSE 8080