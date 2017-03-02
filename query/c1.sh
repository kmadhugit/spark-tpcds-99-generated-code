#!/bin/bash


for i in {1..99}
do
	e=$((i-1+100))
	echo application_1488378032089_0$e
	echo q$i
	mv event/application_1488378032089_0$e.lz4 q$i
done
