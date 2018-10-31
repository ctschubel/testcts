# Test application.. for testing you know?
* Port is 8081
* test database is a MySQL docker Container started with:
  * `docker run --name test-mysql -p 3306:3306 -p 33060:33060 -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=testmysql -e MYSQL_USER=test -e MYSQL_PASSWORD=test -d mysql:latest`