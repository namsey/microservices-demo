# Debian variant
FROM jenkins/inbound-agent:jdk17

USER root
RUN apt-get update \
 && apt-get install -y --no-install-recommends unzip curl bash ca-certificates \
 && curl -fsSL "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o awscliv2.zip \
 && unzip -q awscliv2.zip \
 && ./aws/install -i /usr/local/aws-cli -b /usr/local/bin \
 && rm -rf /var/lib/apt/lists/* awscliv2.zip aws

USER jenkins
WORKDIR /home/jenkins/agent
# ENTRYPOINT stays as provided by inbound-agent (don’t override)
