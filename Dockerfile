FROM 155400439473.dkr.ecr.us-east-1.amazonaws.com/poc-docker:BaseImage3



# Copy any additional files or configurations to the container
COPY target/TurboMobile.war /usr/local/tomcat/webapps/ROOT.war


# Expose any necessary ports
EXPOSE 8080

# Define the command to start the Tomcat server
CMD ["catalina.sh", "run"] 
