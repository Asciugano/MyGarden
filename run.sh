#!/bin/zsh

mvn clean compile
mvn dependency:build-classpath -Dmdep.outputFile=.classpath
java -XstartOnFirstThread -cp target/classes:$(cat .classpath) com.asciugano.Main
