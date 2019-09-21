FROM adoptopenjdk:12-jdk-hotspot
RUN apt-get update && apt-get install -y apt-utils && apt-get install -y enscript unzip psutils
CMD ["/bin/bash"]