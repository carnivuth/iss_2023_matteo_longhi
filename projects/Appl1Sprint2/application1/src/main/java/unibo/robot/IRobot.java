package unibo.robot;

public interface IRobot {
     String doStep();
     String goHome();
     RobotResponse[] doBoundaryWalk();
     String moveForward();
     String moveBackwad();
     String turnLeft();
     String turnRight();


}
