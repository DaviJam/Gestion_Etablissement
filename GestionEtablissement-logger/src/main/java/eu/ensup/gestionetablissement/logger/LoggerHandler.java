package eu.ensup.gestionetablissement.logger;

import org.apache.log4j.PropertyConfigurator;

public class LoggerHandler {
    public boolean haveProperties = false;
    public LoggerHandler() {
        if (! haveProperties) {
        	this.haveProperties = true;
        	
            PropertyConfigurator.configure(this.getClass().getResource("/log4j.properties"));
        }
    }
}