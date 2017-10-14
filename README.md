## Overview

This is a example of how to use Spring MVC Portlet.

The application allows a user to select her favorite sport.

## Configuration

The project uses an in-memory database to store the user's favorite sport.

## Logging

The application logs to catalina.out.

## Tests

Use Maven to run the unit tests:

   mvn -e clean test


## Build and Deploy 


To build the application use: mvn -e clean package

Then copy the springmvcportlet.war from the target folder to your Tomcat's 
webapps folder (where you have uPortal running).

If you have never deployed the portlet into uPortal locally you will need
to go through the process of registering a new portlet in portal administration.

The portlet functional name is springmvcportlet

After registering the portlet, you can add the portlet to a tab using the
Customize menu - just search on spring.  



