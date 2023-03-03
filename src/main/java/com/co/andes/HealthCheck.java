package com.co.andes;

import org.apache.log4j.Logger;

import java.util.Timer;

/**
 * Hello world!
 *
 */
public class HealthCheck
{
    final static Logger logger = Logger.getLogger(HealthCheck.class);

    public static void main( String[] args )
    {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TaskTimer(), 0, 10000);
    }
}
