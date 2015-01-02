# key-drone

A Clojure library designed to allow an AR Drone to be controlled from the keyboard. This is an extensio of the awesome work by @gigasquid on https://github.com/gigasquid/clj-drone.

Writen to help me learn clojure so feel free to send me code improvement ideas.

## Install

- git clone https://github.com/esumerfd/key-drone
- lein install
- lein uberjar

## Usage

bin/key-drone

Keyboard (VI ish keys)

| Key                      | Action          | Description                                                        |
| ------------------------ | --------------- |--------------------------------------------------------------------|
| t                        | takeoff         | up to 1 m and hover                                                |
| g                        | land            | controlled decent to ground                                        |
| l                        | tilt right      | angle props down to left for 1 second to make drone move right     |
| h                        | tilt left       | angle props down to right for 1 second to make drone move left     |
| k                        | tilt forward    | angle props down to back for 1 second to make drone move forward   |
| j                        | tilt backward   | angle props down to front for 1 second to make drone move backward |
| u                        | up              | increase rotations to increase altitude                            |
| d                        | down            | decrease rotations to decrease altitude                            |
| e                        | emergency       | reset after crash                                                  |
| q                        | quit            | exit the program. Please land first.                               |

Backlog
=======
- speed control
- config loading
- flight sequences
- drone re-initialize if network not available

Design
======
Trying to think functional, so transactions, some input that is transformed and then output.

- App startup
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
- Control Loop
  - input: control handler
  - transformation: pressed keys to control handler
  - output: void
- Movement
  - input: keystroke
  - transformation: movement operation
  - output: :quit symbol or any other.

