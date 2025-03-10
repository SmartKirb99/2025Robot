// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;

/** Add your docs here. */
public class Constants {
    public class OIConstants {
        public static int kDriverPort = 0;
        public static int kOperatorPort = 1;
    }

    public class ElevatorConstants {
        public static int kElevatorID = 15;

        public static final double kP = 0.02;
        public static final double kI = 0;
        public static final double kD = 0;
        public static final double kMaxVelocity = 100;
        public static final double kMaxAcceleration = 100;
        public static final double kMaxError = 0.5;

        public static final double kConvertionFactor = (( 16 / 1 ) / 6 + (3 / 4));
        public static final double kStageFour = 180;
        public static final double kStageThree = 86;
        public static final double kStageTwo = 36;
        public static final double kStageOne = 5.71;
        public static final double kIntake = 20;
        public static final double kMaxHeight = 171;
        public static final double kMinHeight = 0;


    }

    public class ClimberConstants {
        public static final int kClimberMotorOneID = 14;
        public static final int kClimberMotorTwoID = 18;
    }

    public class CoralManipulatorConstants {
        public static final int kWristMotorID = 16;
        public static final int kIntakeMotorID = 17;

        public static final double kStowAngle = 4; // TO-DO: Tune this
        public static final double kStage1Angle = 19; // TO-DO: Tune this
        public static final double kStage2Angle = -38;
        public static final double kStage3Angle = -37;
        public static final double kStage4Angle = -40;
        public static final double kMaxAngle = 14.75;
        public static final double kMinAngle = 0;
        public static final double kIntakeAngle = -19.69;
        public static final double kMaxVelocity = 1000;
        public static final double kMaxAcceleration = 1000;
        public static final double kMaxAllowedError = 0.01;
        public static final double kConvertionFactor = (360/(125/1));
    }

    public class ArmConstants{
        public static final int armMotorId = 14;
        public static final int followingMotorId = 18;

        public static final double kStowAngle = 0;
        public static final double kStage1Angle = 170;
        public static final double kStage2Angle = 32.8;
        public static final double kStage3Angle = 80;
        public static final double kHumanStageAngle = 22;
        public static final double kTippedCoralAngle = 159.52;
        public static final double kMaxAngle = 180; // Change if we need a different max angle
        public static final double kClawHeightOffset = 0.3;
        public static final double kClawLengthOffset = 0.25;
        public static final double kArmLength = 0.5;

        public static final double kP = 0.15;
        public static final double kI = 0;
        public static final double kD = 0;
        public static final double kS = 0;
        public static final double kG = 0;
        public static final double kV = 0;
        public static final double kA = 0;

        public static final double kMaxRadsPerSecond = 0;
        public static final double kMaxRadsPerSecondPerSecond = 0;
    }

    public class AlgeaManipulatorConstants{


        public static final int kShooterOne = 100;
        public static final int kShooterTwo = 101;
        public static final int kArticulator = 102;



    }

    public class LEDConstants{

        public static final int kBlinkInPort = 103;
    }

    public static final class LimelightConstants {

    public static double kGoalHeightMeters = Units.inchesToMeters(57.88);
    public static double kLimelightLensHeightMeters = 0.2;
    public static double kMountAngleRadians = Units.degreesToRadians(0);
    }
}
