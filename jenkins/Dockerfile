FROM jenkins/jenkins:lts

USER root
RUN apt-get update && apt-get install -y curl tar && rm -rf /var/lib/apt/lists/*

WORKDIR /opt
RUN curl -L -o graalvm.tar.gz "https://download.oracle.com/graalvm/21/latest/graalvm-jdk-21_linux-x64_bin.tar.gz" \
    && tar -xzf graalvm.tar.gz \
    && rm graalvm.tar.gz \
    && mv graalvm-jdk-* graalvm-jdk-21

ENV JAVA_HOME=/opt/graalvm-jdk-21
ENV PATH="$JAVA_HOME/bin:$PATH"

USER jenkins