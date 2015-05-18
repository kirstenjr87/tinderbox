# Pull base image.
FROM ubuntu:trusty
MAINTAINER mondora <together@mondora.com>

# Install Java.
RUN apt-get -y install software-properties-common && \
  echo oracle-java7-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update && \
  apt-get install -y zip unzip && \
  apt-get install -y oracle-java7-installer && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk7-installer

# Install Sbt.
ADD https://dl.bintray.com/sbt/debian/sbt-0.13.8.deb .
RUN dpkg -i sbt-0.13.8.deb

# Install Scala.
ADD http://downloads.typesafe.com/scala/2.11.6/scala-2.11.6.deb .
RUN dpkg -i scala-2.11.6.deb

# Setting up environment
ENV HOME /root
ENV DEBIAN_FRONTEND noninteractive
ENV JAVA_HOME /usr/lib/jvm/java-7-oracle
WORKDIR $HOME
COPY ./ $HOME/

# Build project.
RUN chmod a+x $HOME/lib/build_tinderbox_dist
RUN lib/build_tinderbox_dist
RUN chmod a+x $HOME/lib/fetch_nlp_models
RUN lib/fetch_nlp_models

# Launch Tinderbox
EXPOSE 9000
CMD $HOME/dist/tinderbox-1.1-SNAPSHOT/bin/tinderbox