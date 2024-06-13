package com.kickoffHandsOn.wings1_t4_car_data_api.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "carData")
public class CarData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

   // @NotEmpty(message = "model field is required")
    @Column(name = "model")
    private String model;

    //@NotNull(message = "manufacturedYear field is required")
    @Column(name = "manufacturedYear")
    private int manufacturedYear;

    //@NotEmpty(message = "company field is required")
    @Column(name = "company")
    private String company;

    //@NotEmpty(message = "bodyType field is required")
    @Column(name = "bodyType")
    private String bodyType;


    //@NotNull(message = "price field is required")
    @Column(name = "price")
    private double price;

    //@NotEmpty(message = "fuelType field is required")
    @Column(name = "fuelType")
    private String fuelType;

    //@NotNull(message = "seatingCapacity field is required")
    @Column(name = "seatingCapacity")
    private int seatingCapacity;

    public CarData() {
    }

    public CarData(String model, int manufacturedYear, String company, String bodyType, double price, String fuelType, int seatingCapacity) {
        this.model = model;
        this.manufacturedYear = manufacturedYear;
        this.company = company;
        this.bodyType = bodyType;
        this.price = price;
        this.fuelType = fuelType;
        this.seatingCapacity = seatingCapacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(int manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String toString() {
        return "car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", manufacturedYear=" + manufacturedYear +
                ", company='" + company + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", price=" + price +
                ", fuelType='" + fuelType + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                '}';
    }
}
