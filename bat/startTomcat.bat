set "CURRENT_DIR=%cd%"
set "CATALINA_HOME=D:\software\Tomcat"
set JRE_HOME=D:\ptc\FX24_latest_build\Java\jre
set CLASSPATH=%JRE_HOME%\lib
set PATH=%PATH%;%JRE_HOME%\bin
set JAVA=java
set CATALINA_OPTS=-server -Xnoagent -Xdebug -Xrunjdwp:transport=dt_socket,address=5888,server=y,suspend=n
call %CATALINA_HOME%\bin\startup.bat 
rem call %CATALINA_HOME%\bin\cataline start 

echo 关闭的话，只是最后一句改成直接调shutdown.bat.