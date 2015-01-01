# key-drone

A Clojure library designed to allow an AR Drone to be controlled from the keyboard.

Writen to help me learn clojure so dont read the code.

## Install

- git clone https://github.com/esumerfd/key-drone
- lein install
- lein uberjar

## Usage

bin/key-drone

Keyboard (VI ish keys)
| Key                    | Action        |
|------------------------|---------------|
| t                      | takeoff       |
| g                      | land          |
| l                      | tilt right    |
| h                      | tilt left     |
| k                      | tilt forward  |
| j                      | tilt backward |
| u                      | up            |
| d                      | down          |
| q                      | quit          |


Design
======
Trying to think functional, so transactions, some input that is transformed and then output.

Transaction initiation:
- Control Loop
  - input: keystroke
  - transformation: movement operation
  - output: success/failure of movement
- Movement
  - input: keystroke
  - transformation: movement operation
  - output: success/failure of transformation

Transaction initiation:
- app startup
  - Configuration
    - input: configuration file. 
    - transform: convert json into data structure.
    - output: imulatable data struct in memory.
  - Network
    - input: network configuration.
    - transform: format data packet header.
    - output: ping network
  - Drone Initialize
    - input: network
    - transform: none
    - output: ping drone


