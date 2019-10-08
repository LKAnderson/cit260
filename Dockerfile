FROM adoptopenjdk:12-jdk-hotspot
RUN apt-get update && apt-get install -y apt-utils && apt-get install -y unzip nodejs npm && npm install -g markdown-pdf
CMD ["/bin/bash"]