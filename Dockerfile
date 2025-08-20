# Use Maven image with OpenJDK 17 as base (has required tools)
FROM maven:3.9.4-eclipse-temurin-17

# Install unzip, curl, and AWS CLI
RUN apt-get update && apt-get install -y unzip curl bash \
  && curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o awscliv2.zip \
  && unzip awscliv2.zip \
  && ./aws/install -i /usr/local/aws-cli -b /usr/local/bin \
  && rm -rf awscliv2.zip aws

# Set up Jenkins workspace path
WORKDIR /home/jenkins/agent

# Required for Jenkins Kubernetes plugin to launch the agent
ENTRYPOINT ["jenkins-agent"]
