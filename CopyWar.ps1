cd  C:\xampp\tomcat\bin
start C:\xampp\tomcat\bin\startup.bat
cd C:\Users\daori\Documents\ECOLE\Dada\Job7\Gestion_Etablissement
mvn clean
mvn install -Pclient 
Copy-Item -Path C:\Users\daori\Documents\ECOLE\Dada\Job7\Gestion_Etablissement\GestionEtablissement-presentation\target\etablissement.war -Destination C:\xampp\tomcat\webapps -PassThru
