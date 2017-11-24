package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IntegratingGyroscope;

/**
 * Created by matth on 11/20/2017.
 */
@TeleOp(name= "PID")
public class PID extends OpMode{

    ModernRoboticsI2cGyro dog;
    IntegratingGyroscope gyro;
    double If = dog.getIntegratedZValue();
    DcMotor right;
    DcMotor left;
    DcMotor left2;
    DcMotor right2;
    double df = .1;
    DcMotor Mid;

    public void init() {

        right = hardwareMap.dcMotor.get("R");
        left = hardwareMap.dcMotor.get("L");
        right2 = hardwareMap.dcMotor.get("L2");
        left2 = hardwareMap.dcMotor.get("L2");
        left.setDirection(DcMotorSimple.Direction.REVERSE);
        dog = hardwareMap.get(ModernRoboticsI2cGyro.class, "gyro");
        gyro = (IntegratingGyroscope)dog;
Mid = hardwareMap.dcMotor.get("why");
    }

    public void loop() {

        double errorPf = dog.getIntegratedZValue();

        telemetry.addData("position", errorPf);

        if(errorPf>If){
            If = errorPf;
        }


        left.setPower(.25-df*errorPf+If);
        left2.setPower(.25-df*errorPf+If);
        right.setPower(.25+df*errorPf+If);
        right2.setPower(.25+df*errorPf+If);



    }


}