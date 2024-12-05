# Example Flywheel Project

Please don't copy code from this repository - it doesn't help you build a deeper understanding of whats going on here.

## Installing Libraries

Some of the hardware this project requires doesn't come in base WPILib, so you have to install the following libraries.

Use the command pallet, and run `WPILib: Manage Vendor Libraries` > `Install vendor libraries (online)`.

### Playing With Fusion
This library provides the `TimeOfFlight` sensor class.
```
https://www.playingwithfusion.com/frc/playingwithfusion2024.json
```

### REV Robotics REVLib
This library provides the `CANSparkMax` motor class.
```
https://software-metadata.revrobotics.com/REVLib-2024.json
```

### CTRE Pheonix
This library provides the `WPI_VictorSPX` motor class. We need version 5 of the library, but in order to install version 5 you must install version 6 first:
```
https://maven.ctr-electronics.com/release/com/ctre/phoenix6/latest/Phoenix6-frc2024-latest.json
```
Then we can install v5:
```
https://maven.ctr-electronics.com/release/com/ctre/phoenix/Phoenix5-frc2024-latest.json
```