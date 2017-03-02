#!/bin/bash

#q9_jobid_8_stageid_17_ResultTask_1_execid_1.java

files=`ls q*.java`
for i in $files
do
	echo $i
	q=${i%_jobid*}
        mkdir -p $q/java
	mv $i $q/java
done

files=`ls q*.stack`
for i in $files
do
	echo $i
	q=${i%_jobid*}
        mkdir -p $q/stack
	mv $i $q/stack
done
