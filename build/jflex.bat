REM @echo off
REM Please adjust JFLEX_HOME to suit your needs
REM (please do not add a trailing backslash)

REM set JFLEX_HOME=D:\Libraries\Downloads\jflex-1.6.1

java -Xmx128m -jar lib\jflex-1.6.1.jar -nobak -d src\main\java\com\ajsg2\minimaljava\lex generators\minimaljava_cup.flex