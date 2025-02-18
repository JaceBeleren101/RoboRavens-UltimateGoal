package Team7159.BasicRobots;

import com.arcrobotics.ftclib.hardware.motors.*;

import com.qualcomm.robotcore.hardware.HardwareMap;

import Team7159.Enums.Direction;

public class BasicMecanum {

    public Motor RFMotor;
    public Motor RBMotor;
    public Motor LFMotor;
    public Motor LBMotor;

    public void init(HardwareMap Map) {

        LFMotor = new Motor(Map, "FLDrive");
        LBMotor = new Motor(Map, "BLDrive");
        RFMotor = new Motor(Map, "FRDrive");
        RBMotor = new Motor(Map, "BRDrive");

        RFMotor.set(0.0);
        RBMotor.set(0.0);
        LFMotor.set(0.0);
        LBMotor.set(0.0);

        //TODO: Figure out which motors need to be reversed, etc. so that the robot actually goes forward lmao
        LFMotor.setInverted(false);
        RFMotor.setInverted(true);
        LBMotor.setInverted(true);
        RBMotor.setInverted(true);

        //for now, we do this (maybe change later-
        LFMotor.setRunMode(Motor.RunMode.RawPower);
        RFMotor.setRunMode(Motor.RunMode.RawPower);
        LBMotor.setRunMode(Motor.RunMode.RawPower);
        RBMotor.setRunMode(Motor.RunMode.RawPower);

        LFMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        RFMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        LBMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        RBMotor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        //:crab: william is gone :crab:
    }

    public void moveStraight(double power) {
        LFMotor.set(power);
        RFMotor.set(power);
        LBMotor.set(power);
        RBMotor.set(power);
    }

    public void stop() {
        LFMotor.set(0);
        RFMotor.set(0);
        LBMotor.set(0);
        RBMotor.set(0);
    }

    public void strafe(Direction direction, double power, double time) throws InterruptedException{
        if(direction == Direction.LEFT){
            LFMotor.set(-power);
            RFMotor.set(power);
            LBMotor.set(power);
            RBMotor.set(-power);
            wait((int)time * 1000);
            stop();
        }else if(direction == Direction.RIGHT){
            LFMotor.set(power);
            RFMotor.set(-power);
            LBMotor.set(-power);
            RBMotor.set(power);
            wait((int)time * 1000);
            stop();
        }else{
            //Throw an exception
        }
    }

    public void octoStrafe(boolean up, boolean down, boolean left, boolean right) {
        if (up) {
            if (right) {
                RFMotor.set(1);
                LFMotor.set(0);
                RBMotor.set(0);
                LBMotor.set(1);
            } else if (left) {
                RFMotor.set(0);
                LFMotor.set(1);
                RBMotor.set(1);
                LBMotor.set(0);
            } else {
                RFMotor.set(1);
                LFMotor.set(1);
                RBMotor.set(1);
                LBMotor.set(1);
            }
        } else if (down) {
            if (right) {
                RFMotor.set(0);
                LFMotor.set(-1);
                RBMotor.set(-1);
                LBMotor.set(0);
            } else if (left) {
                RFMotor.set(-1);
                LFMotor.set(0);
                RBMotor.set(0);
                LBMotor.set(-1);
            } else {
                RFMotor.set(-1);
                LFMotor.set(-1);
                RBMotor.set(-1);
                LBMotor.set(-1);
            }
        }
        else {
            if (right) {
                RFMotor.set(1);
                LFMotor.set(-1);
                RBMotor.set(-1);
                LBMotor.set(1);
            } else if (left) {
                RFMotor.set(-1);
                LFMotor.set(1);
                RBMotor.set(1);
                LBMotor.set(-1);
            }
        }
    }
}