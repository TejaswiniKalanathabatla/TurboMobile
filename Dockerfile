FROM tejaswini25/dockerimage:PROD.5



# Copy any additional files or configurations to the container
COPY TurboMobile/target/TurboMobile.war /usr/local/tomcat/webapps/ROOT.war


# Expose any necessary ports
EXPOSE 8080

# Define the command to start the Tomcat server
CMD ["catalina.sh", "run"] 
