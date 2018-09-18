# Scrabble Game - Possible Design

**Disclaimer:**
- I am just giving my possible design on the whole system’s architecture, details should be implemented later concerning actual specifications.

- It is possible that my design has severe flaws that even can not meet the final requirements. Hence think twice before you deciding to use some of them. Another, modifications on my design is welcomed, especially regarding on actual problems.

- Please do not share with others or put as public.

## System Architecture

Basic Client/ Server architecture

 ### System Structure
  - A server can be connected with multiple clients as a star-pattern
![sys structure](https://github.com/Casuy/scrabble/blob/master/C:S%20structure.png)

 ### Connections
  - Here connections between clients and server are TCP connections
  - Those connections should be maintained even if there is no communication, in case of immediately upcoming message requests
  - Implemented through socket in java

 ### Server
  - Should be capable to govern a set of connections that link to clients
  - Messages to update grid should be sent to each client simultaneously—broadcast thru TCP
  - *A mechanism for ACK message from clients would help in eliminating mismatches between grids on each client.*
  - Mechanism for processing occasionally unexpected disconnects to clients (network failures, etc.)

 ### Client
  - Should be able to initialise a message (logins, user operations, etc.) and send it to remote server
  - Needs to hold the TCP connection to the server as well as listen to it in case of the coming of message from server (grid update message)

## Functional Requirements
Here I just extract the possible requirements from the ppt, and I am not sure about whether some hidden requirements existed. If some, just add them to your analysis of requirements.

 ### Clients
  - **Login:**
    - Username
  - **Games:**
    - Create a game and invite other users.
    - Join other's game.
    - Quit from a game.
  - **In Game:**
    - Submit tile placement.
    - Pass turn.
    - Issue a vote.
    - Submit votes on others' words. 
 ### Server
  - **Connections:**
    - Accept incoming connections from clients
    - Handle disconnections from clients
    - *Unexpected disconnects -> robustness control, server not crash*
  - **Games:**
    - Maintain a set of games that currently running on it
    - Create a new game once a valid client intends to.
    - Destroy a game once it is finished -> thinking of the clients to go after this, still not mentioned in ppt.
  - **Communication with clients:**
    - Client logins -> judge if the name has already existed
    - Client joining a game -> judge if allowed:
      - allowing: game not started nor not full, still waiting for others
      - not allowing: game started or full, may put the game invisible to new connected clients
    - Client starting a game -> no limitation, create new threads to handle new games,
    - Client voting on others’ words/ own words -> get and record clients votes, deciding:
      - if a valid word: removing the word from grid? (not sure), changing user scores.
      - if not valid: making no changes, game continuing

## GUI Design

- For my understanding, GUI in this project is only for demonstration of the game, also providing some visual functionalities to users directly (voting fields, etc.). Hence, there is no need to implement this at the very first place.

- Instead, all of the development on the system could be done through basic console IO operations so far, which would provide you with not only actual form of data flows but also less bugs that you may collide once you implemented a GUI already.
