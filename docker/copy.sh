#!/bin/sh

# 复制项目的文件到对应docker路径，便于一键生成镜像。
usage() {
	echo "Usage: sh copy.sh"
	exit 1
}


# copy sql
echo "begin copy sql "
cp ../sql/lokhub_20240305.sql ./mysql/db
cp ../sql/lokhub_nacos_20240423.sql ./mysql/db

# copy html
echo "begin copy html "
cp -r ../lokhub-ui/dist/** ./nginx/html/dist


# copy jar
echo "begin copy lokhub-gateway "
cp ../lokhub-gateway/target/lokhub-gateway.jar ./lokhub/gateway/jar

echo "begin copy lokhub-auth "
cp ../lokhub-auth/target/lokhub-auth.jar ./lokhub/auth/jar

echo "begin copy lokhub-monitor "
cp ../lokhub-monitor/target/lokhub-monitor.jar  ./lokhub/monitor/jar

echo "begin copy lokhub-system "
cp ../lokhub-modules/lokhub-system/target/lokhub-system.jar ./lokhub/modules/system/jar

echo "begin copy lokhub-job "
cp ../lokhub-modules/lokhub-job/target/lokhub-job.jar ./lokhub/modules/job/jar

echo "begin copy lokhub-gen "
cp ../lokhub-modules/lokhub-gen/target/lokhub-gen.jar ./lokhub/modules/gen/jar

echo "begin copy lokhub-project "
cp ../lokhub-modules/lokhub-project/target/lokhub-project.jar ./lokhub/modules/project/jar

echo "begin copy lokhub-workflow "
cp ../lokhub-modules/lokhub-workflow/target/lokhub-workflow.jar ./lokhub/modules/workflow/jar

