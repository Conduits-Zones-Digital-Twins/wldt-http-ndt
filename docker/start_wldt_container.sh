#!/bin/bash

docker run --name=wldt-zone-dt \
    -p 9090:9090 \
    -v $(pwd)/logback.xml:/usr/local/src/mvnapp/src/main/resources/logback.xml \
    -v $(pwd)/logback.xml:/usr/local/src/mvnapp/target/classes/logback.xml \
    -d registry.gitlab.com/piconem-university/projects/dt-conduits-zones-iiot/wldt-http-zdt:0.1