# File-Monitoring Application:

- This is a POC application to monitor events(Create, Update, Delete, etc.) to a file/directory and then for each triggered event
execute a series of actions/tasks using the chain of responsibility pattern.

- The directories to monitor and the task to be executed must be dynamically configurable by passing the configs file path either
through VM args or application properties.
  - Example: 
    - **[monitoring-config.yaml](application/src/main/resources/monitoring/monitoring-config.yaml)** to configure the file monitoring events and the corresponding command chains to be executed.
    - **[chain-config.yml](chain-catalog/src/main/resources/chain/chain-config.yml)** to configure the details of commands (command name, execution sequence, etc.) for each of the chains. 

# The solution is created using:
- Spring Boot CommandLineRunner as this is a console application.
- Maven Multi-Modules to split the code properly to ensure high cohesion.
- Abstract Factory and Dependency Injection patterns to ensure low coupling.
- Apache commons-chain library to implement the chain-of-responsibility pattern in a more standardized manner.
- Apache commons-io to capture the  file monitoring events.
- Log4j2 to efficiently manage the rolling of log files.
- Creating multiple database connection that can be used with spring boot.
    ```shell
    # Command To Start The Temporary DB In a Docker Container:
    #---------------------------------------------------------
    # docker pull mysql
    docker run --name mysql-locl -e MYSQL_ROOT_PASSWORD=default -v $HOME/mysql/data:/var/lib/mysql -p 33060:3306 -d mysql
    
    #docker pull ibmcom/db2
    docker run -itd --name db2-locl --privileged=true -p 50000:50000 -e LICENSE=accept -e DB2INST1_PASSWORD=default -e DBNAME=testdb -v $HOME/db2/data:/database ibmcom/db2
    ```
    
    
# Deployment Instructions:

- Run the application using the command: `java -jar file-monitoring-0.0.1-SNAPSHOT.jar`

- You can also provide the following optional VM-Args to the above command:
   ` -Dmonitoring-events.config.yml.path=/c/Users/lenovo/Desktop/monitoring-config.yaml`
   `-Dchain.config.yml.path=/c/Users/lenovo/Desktop/chain-config.yaml`
   `-Dfile.monitoring.app.logs.path=/c/Users/lenovo/Desktop/logs`
   `-Dfile.monitoring.app.logs.level=info`

- The command to run the application with all the optional VM args:
  ```bash
  java -jar -Dchain.config.yml.path=/c/Users/lenovo/Desktop/chain-config.yaml -Dmonitoring-events.config.yml.path=/c/Users/lenovo/Desktop/monitoring-config.yaml -Dfile.monitoring.app.logs.path=/c/Users/lenovo/Desktop/logs -Dfile.monitoring.app.logs.level=info file-monitoring-0.0.1-SNAPSHOT.jar
  ```


