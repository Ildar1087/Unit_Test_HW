import org.junit.jupiter.api.Test;
import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.*;

import seminars.second.hw.Car;
import seminars.second.hw.Motorcycle;
import seminars.second.hw.Vehicle;

/*Задание 1.
        Проект Vehicle. Написать следующие тесты с использованием JUnit:
- Проверить, что экземпляр объекта Car также является экземпляром транспортного
средства (используя оператор instanceof).
 - Проверить, что объект Car создается с 4-мя колесами.
 - Проверить, что объект Motorcycle создается с 2-мя колесами.
 - Проверить, что объект Car развивает скорость 60 в режиме тестового вождения
(используя метод testDrive()).
 - Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового
вождения (используя метод testDrive()).
 - Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция
движения транспорта) машина останавливается (speed = 0).
 - Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция
движения транспорта) мотоцикл останавливается (speed = 0).
В этом проекте, вы будете работать с проектом ""Vehicle"", который представляет
собой иерархию классов, включающую абстрактный базовый класс ""Vehicle"" и два
его подкласса ""Car"" и ""Motorcycle"".
Базовый класс ""Vehicle"" содержит абстрактные методы ""testDrive()"" и ""park()"",
а также поля ""company"", ""model"", ""yearRelease"", ""numWheels"" и ""speed"".
Класс ""Car"" расширяет ""Vehicle"" и реализует его абстрактные методы. При создании
объекта ""Car"", число колес устанавливается в 4, а скорость в 0. В методе
""testDrive()"" скорость устанавливается на 60, а в методе ""park()"" - обратно в 0.
Класс ""Motorcycle"" также расширяет ""Vehicle"" и реализует его абстрактные методы.
При создании объекта ""Motorcycle"", число колес устанавливается в 2, а скорость в 0.
В методе ""testDrive()"" скорость устанавливается на 75, а в методе ""park()"" - обратно в 0. */


class VehicleTest {

    private Car car;
    private Motorcycle motorcycle;
    private final int carWheelsNumber = 4;
    private final int carTestDriveSpeed = 60;
    private final int motorCycleTestDriveSpeed = 75;
    private final int vehicleParkSpeed = 0;
    private final int motorCycleWheelNumber = 2;

    @BeforeEach
    public void prepareTestData() {
        this.car = new Car("lada", "VestaSW", 2021);
        this.motorcycle = new Motorcycle("yava", "yava", 1989);
    }

    @Test
    public void isCarInstanceOfVehicle() {
        assertThat(this.car).isInstanceOf(Vehicle.class);
    }

    @Test
    public void isCarHasFourWheels() {
        assertThat(this.car.getNumWheels()).isEqualTo(this.carWheelsNumber);
    }

    @Test
    public void isMotorCycleHasTwoWheels() {
        assertThat(this.motorcycle.getNumWheels())
                .isEqualTo(this.motorCycleWheelNumber);
    }

    @Test
    public void isCarTestDriveSpeedValid(){
        this.car.testDrive();
        assertThat(this.car.getSpeed()).isEqualTo(carTestDriveSpeed);
    }

    @Test
    public void isMotorCycleTestDriveSpeedValid() {
        this.motorcycle.testDrive();
        assertThat(this.motorcycle.getSpeed()).isEqualTo(motorCycleTestDriveSpeed);
    }

    @Test
    public void isCarParkSpeedValid() {
        this.car.testDrive();
        this.car.park();
        assertThat(this.car.getSpeed()).isEqualTo(vehicleParkSpeed);
    }

    @Test
    public void isMotorCycleParkSpeedValid() {
        this.motorcycle.testDrive();
        this.motorcycle.park();
        assertThat(this.motorcycle.getSpeed()).isEqualTo(vehicleParkSpeed);
    }
}