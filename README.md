# Test application.. to test things out, you know?
* Port is 8081
* test database is a MySQL docker Container started with:
  * `docker run --name test-mysql -p 3306:3306 -p 33060:33060 -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=testmysql -e MYSQL_USER=test -e MYSQL_PASSWORD=test -d mysql:latest`
  * Or with runMySQLDataBase.bat batch script.
* Docker Befehl zum erzeugen eines Images für das Project:
  * `docker build -f Dockerfile -t testapp:0.0.x . `
* Zum ausführen des Containers:
  * `docker run --name <name> -p 8081:8081 testapp:0.0.x`.
* First maven install project, then build image and after that you can start a container.