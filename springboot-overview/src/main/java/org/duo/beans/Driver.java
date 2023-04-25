package org.duo.beans;

/**
 * @Auther:duo
 * @Date: 2023-01-09 - 01 - 09 - 14:26
 * @Description: org.duo.beans
 * @Version: 1.0
 */
public class Driver {

    private int id;
    private String name;
    private Car car;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
