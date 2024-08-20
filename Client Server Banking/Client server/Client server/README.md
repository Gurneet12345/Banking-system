Jaga Tranvo   

Coded in Eclipse.

MultiThreaded Server runs endlessly and listens to incoming clients connection and services them accordingly.
Clients will be able to connect to the server and create and access their accounts.

+Server+

Main1 - Starts Server

Server - Gui,Endless looping server that listens to requests

ServerThread - Server creates these threads for each clients who wants to connect

Database - Server uses this to store/retrive client information

RandomNums - Database uses this to generate and manage randomized account numbers

Person - Class that is made to store client information such as username and password

Account - Class stored within each Person, that holds current balance

======================================================================================================

+Client+

Main2 - Starts Client

Client - Gui that connects to the Server

Person - Class that is made to store client information such as username and password

Account - Class stored within each Person, that holds current balance
