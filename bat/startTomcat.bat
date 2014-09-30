set "CURRENT_DIR=%cd%"
set "CATALINA_HOME=D:\software\Tomcat"
set JRE_HOME=D:\ptc\FX24_latest_build\Java\jre
set CLASSPATH=%JRE_HOME%\lib
set PATH=%PATH%;%JRE_HOME%\bin
set JAVA=java
call %CATALINA_HOME%\bin\startup.bat 

echo 关闭的话，只是最后一句改成直接调shutdown.bat.