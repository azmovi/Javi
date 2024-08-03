#!/bin/bash

PROJECT_NAME="Conversion"

DEPENDECIES="devtools,thymeleaf,web"

TYPE="maven-project"

VERSION="22"

ARTIFACT="ConversionMVC"

GROUP="br.ufscar.web"

PACKING_NAME="br.ufscar.web"

mkdir $ARTIFACT
cd $ARTIFACT

spring init \
    -n=$PROJECT_NAME \
    -d=$DEPENDECIES \
    -t=$TYPE \
    -a=$ARTIFACT \
    -j=$VERSION \
    -g=$GROUP \
    --package-name=$PACKING_NAME

unzip "$ARTIFACT.zip"
rm "$ARTIFACT.zip"
