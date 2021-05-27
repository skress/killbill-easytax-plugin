#!/usr/bin/env bash

# Copyright 2017 SolarNetwork Foundation
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

DB=postgres
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
# same version as https://github.com/killbill/killbill-avatax-plugin/tree/a129f256db6235db27168bf44bdd2e82bafef058/src/main/resources
# later versions change the format how datetime fields are converted ... don't know if that would still be correct
# so simply using the sames approach as the avatax plugin
JOOQ_VERSION=3.13.4
M2_REPOS=~/.m2/repository
MYSQL_JDBC_VERSION=5.1.35
PG_JDBC_VERSION=42.2.18
REACTIVE_STREAMS_VERSION=1.0.3
MVN=mvn

function usage() {
	echo 'gen.sh [-d <dbname>] [-m <path to maven>]'
}

while getopts ":d:m:" opt; do
	case $opt in
		d)
			DB=${OPTARG}
			;;

		m)
			MVN=${OPTARG}
			;;

		\?)
			usage
			exit 1
			;;
	esac
done

shift $(($OPTIND - 1))

JDBC_ARTIFACT=
JDBC_JAR=

if [ "$DB" == "mysql" ]; then
	JDBC_ARTIFACT="mysql:mysql-connector-java:$MYSQL_JDBC_VERSION"
	JDBC_JAR="$M2_REPOS/mysql/mysql-connector-java/$MYSQL_JDBC_VERSION/mysql-connector-java-$MYSQL_JDBC_VERSION.jar"
elif [ "$DB" == "postgres" ]; then
	JDBC_ARTIFACT="org.postgresql:postgresql:$PG_JDBC_VERSION"
	JDBC_JAR="$M2_REPOS/org/postgresql/postgresql/$PG_JDBC_VERSION/postgresql-$PG_JDBC_VERSION.jar"
else
	echo "Unsupported database type."
	exit 1
fi

JOOQ_JAR="$M2_REPOS/org/jooq/jooq/$JOOQ_VERSION/jooq-$JOOQ_VERSION.jar"
JOOQ_META_JAR="$M2_REPOS/org/jooq/jooq-meta/$JOOQ_VERSION/jooq-meta-$JOOQ_VERSION.jar"
JOOQ_CODEGEN_JAR="$M2_REPOS/org/jooq/jooq-codegen/$JOOQ_VERSION/jooq-codegen-$JOOQ_VERSION.jar"
REACTIVE_STREAMS_JAR="$M2_REPOS/org/reactivestreams/reactive-streams/$REACTIVE_STREAMS_VERSION/reactive-streams-$REACTIVE_STREAMS_VERSION.jar"

if [ ! -e "$JDBC_JAR" ]; then
	$MVN org.apache.maven.plugins:maven-dependency-plugin:2.1:get -Dartifact=$JDBC_ARTIFACT -DrepoUrl=http://sonatype.org
fi

if [ ! -e "$JOOQ_JAR" ]; then
	$MVN org.apache.maven.plugins:maven-dependency-plugin:2.1:get -Dartifact=org.jooq:jooq:$JOOQ_VERSION -DrepoUrl=http://sonatype.org
fi

if [ ! -e "$JOOQ_META_JAR" ]; then
	$MVN org.apache.maven.plugins:maven-dependency-plugin:2.1:get -Dartifact=org.jooq:jooq-meta:$JOOQ_VERSION -DrepoUrl=http://sonatype.org
fi

if [ ! -e "$JOOQ_CODEGEN_JAR" ]; then
	$MVN org.apache.maven.plugins:maven-dependency-plugin:2.1:get -Dartifact=org.jooq:jooq-codegen:$JOOQ_VERSION -DrepoUrl=http://sonatype.org
fi

if [ ! -e "$REACTIVE_STREAMS_JAR" ]; then
	$MVN org.apache.maven.plugins:maven-dependency-plugin:2.1:get -Dartifact=org.reactivestreams:reactive-streams:$REACTIVE_STREAMS_VERSION	-DrepoUrl=http://sonatype.org
fi


CLASSPATH="$JOOQ_JAR:$JOOQ_META_JAR:$JOOQ_CODEGEN_JAR:$JDBC_JAR:$REACTIVE_STREAMS_JAR:$M2_REPOS/jakarta/xml/bind/jakarta.xml.bind-api/2.3.3/jakarta.xml.bind-api-2.3.3.jar:."

echo "Using classpath: $CLASSPATH"

java -cp "$CLASSPATH" org.jooq.codegen.GenerationTool "$DIR/gen.xml"
