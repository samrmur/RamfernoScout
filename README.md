# Guide to the Scouting Application
### Introduction
The Ramferno Scouting application uses a local database installed on a computer which acts as a server for all android phones to connect. The phones and server must be connected to the same network (In other words, the same router, hotspot, etc.). Once they are are the same network, users on the application may enter the IP Address that is set for the computer and start adding data to & retreiving data from the server. Additional software and files will need to be added to a computer so that it can act as a database server.

### Additional Files
This application requires additional sources outside of the actual application itself. The following links below are what you need to run the application properly.
* WAMP Server - http://www.wampserver.com/en/
* Server Files - To be included

### Downloading & Setting Up WAMP Server
Download either the 32 bit or 64 bit version of WAMP Server. Once it is complete there will be a new folder inside your Local Disk (C:) folder called "wamp64" or "wamp32" depending on the bit version you downloaded. If you don't have one, go into the WAMP server folder, look for "wampmanager.exe", right click on it and create a shortcut to the desktop (You don't have to do this but it will be easier when running your server).

<p align="center">
  <img src="http://i.imgur.com/WGzNWuA.png">
</p>

After creating the shortcut, open up the server for the first time. You will know the server is running if a WAMP Server icon appears in System Tray at the lower-rght part of your screen. It is running properly if the icon is green. 

<p align="center">
  <img src="http://i.imgur.com/jT4MkWE.png">
</p>

Next, two server files will need to be edited in order for the server 
