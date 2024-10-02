package dto;

import lombok.*;



@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class CarDto {
    private  String city;//location
    // private String serialNumber;
    private String manufacture;
    private String model;
    private String year;
    private String fuel;
    private  int seats;         //int
    private String carClass;
    private String carRegNumber;
    private double  pricePerDay;    //double
    private String about;
    // private String city;
    // private double lat;
    // private double lng;
    private String image;
    // private String owner;
    //private String bookedPeriods;

}


