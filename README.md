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

Next, two server files will need to be edited in order for the server to detect wireless connections. On normal install, WAMP Server will only connect to devices or software that are actually connected or are run locally on the server. To fix this, left-click on the server icon, hover over Apache, and open both "httpd.conf" and "httpd-vhosts.conf" in Notepad.

<p align="center">
  <img src="">
</p>

In the "httpd.conf" file, two sections will need to be edited. The first section is a directory that is denying acces to the server's filesystem, change everything in the directory block to the directory block provided below. The second section controls who can retrieve data from the server. Change that section to block provided in the second picture then save the file and exit it.

<p align="center">
  <img src="">
</p>

In the "httpd-vhosts.conf" file, only one section will need to be edited. In the directory block of the file, change it to the block provided in the picture below then save the file and exit it.

<p align="center">
  <img src="">
</p>

As a final check, right-click on the WAMP server icon, hover over Wamp Settings, and click on "Check httpd.conf syntax". This will check the file for any errors that may have occured. If an error comes up, look through the file again and make sure that there were no mistakes when editing the files. If no error pops up, left-click the WAMP server icon and click on "Restart All Services". If there are no errors, the server will restart and the server icon will come up as green again. Once that is done, the server is ready to take on wireless connections.

### Importing MySQL Database & Adding PHP Files to the Server
