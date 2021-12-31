# File-monitoring:

A POC application to create:
- Maven Multi-Modules with Springboot
- Chain of Responsibility pattern with apache commons-chain library
- File Monitoring with apache commons-io


# Command To Start The Temporary DB:
docker pull mysql
docker run --name mysql-locl -e MYSQL_ROOT_PASSWORD=default -v $HOME/mysql/data:/var/lib/mysql -p 33060:3306 -d mysql

docker pull ibmcom/db2
docker run -itd --name db2-locl --privileged=true -p 50000:50000 -e LICENSE=accept -e DB2INST1_PASSWORD=default -e DBNAME=testdb -v $HOME/db2/data:/database ibmcom/db2
