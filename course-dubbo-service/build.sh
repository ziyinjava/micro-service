#!/usr/bin/env bash

mvn clean package

docker build -t course-service:latest .
