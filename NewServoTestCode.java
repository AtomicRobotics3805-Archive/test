package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by matth on 11/24/2017.
 */



public class NewServoTestCode extends OpMode{
    Servo grabber2;
    Servo grabber;
    double t;

    public void init(){

        grabber = hardwareMap.servo.get("grabberH");
    }

    public void loop(){

        grabber.setPosition(t);
        telemetry.addData("servo position", + t);

    }
}
