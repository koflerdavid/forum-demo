# How to

Der Aufruf `mvn --version` auf der Kommandozeile sollte ergeben, 
dass Java 1.8 verwendet wird.
Also etwas aehnliches wie

    Apache Maven 3.6.1 (d66c9c0b3152b2e69ee9bac180bb8fcc8e6af555; 2019-04-04T21:00:29+02:00)
    Maven home: /home/david/.sdkman/candidates/maven/current
    Java version: 1.8.0_222, vendor: Eclipse OpenJ9, runtime: /home/david/.sdkman/candidates/java/8.0.222.j9-adpt/jre
    Default locale: en_GB, platform encoding: UTF-8
    OS name: "linux", version: "5.1.19-300.fc30.x86_64", arch: "amd64", family: "unix"

Mit `mvn clean package` wird das Projekt gebaut. 
Danach kann man mit `mvn test` die Tests ausfuehren.
