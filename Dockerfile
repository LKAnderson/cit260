FROM adoptopenjdk:12-jdk-hotspot
RUN apt-get update && apt-get install -y enscript unzip
CMD ["/bin/bash"]
