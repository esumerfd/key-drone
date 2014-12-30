# key-drone

A Clojure library designed to allow an AR Drone to be controlled from the keyboard.

Writen to help me learn clojure so dont read the code.

## Usage

bin/key-drone

Keyboard:
- Arrow right
- Arrow left
- Arrow up
- Arrow down
- u
- d


Design
======
Trying to think functional, so transactions, some input that is transformed and then output.

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
- up arrow
  - ...
