# key-drone

A Clojure library designed to allow an AR Drone to be controlled from the keyboard.

Writen to help me learn clojure so dont read the code.

## Usage

bin/key-drone

Keyboard (VI ish keys):
- t - takeoff
- g - land
- l - tilt right
- h - tilt left
- k - tilt forward
- j - tilt backward
- u - up
- d - down
- q - quit


Design
======
Trying to think functional, so transactions, some input that is transformed and then output.

Design Strategies:
- all state passed by argument
- 

Transaction initiation:
- app startup
  - Configuration
    - input: configuration file. 
    - transform: convert json into data structure.
    - output: imulatable data struct in memory.
  - Network
    - input: network configuratio.
    - transform: format data packet header.
    - output: ping network
  - Drone Initialize
    - input: network
    - transform: none
    - output: ping drone

Transaction initiation:
- Control Loop
  - input: keystroke
  - transformation: movement operation
  - output: success/failure of movement
- Movement
  - input: keystroke
  - movement operation
  - output: success/failure of transformation

