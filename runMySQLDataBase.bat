@ECHO OFF
REM Author: ctschubel
echo Starting docker-machine...

REM Check if docker-machine default is running
FOR /F "tokens=*" %%g IN ('docker-machine active') do (SET active=%%g)

IF NOT %active%==default GOTO startDockerMachine
:continue
echo Docker-Machine default was successfully started! :)

echo Starting MySQL Database...
docker run --rm --name test-mysql -p 3306:3306 -p 33060:33060 -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=testmysql -e MYSQL_USER=test -e MYSQL_PASSWORD=test -d mysql:latest
IF errorlevel 1 GOTO error

echo wait for mysql to start up...
FOR /L %%i IN (10,10,60) DO (
    ping -n 10 localhost> nul
    echo %%i of 60 seconds waited...
)

echo MySQL was successfully started! :)
goto end

REM <!--------------------------------------------------------- FUNCTIONS ----------------------------------------------------->
:error
echo MySQL could not be started!
GOTO end

:startDockerMachine
docker-machine start
GOTO continue

:end

