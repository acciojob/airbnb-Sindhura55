package com.driver;

public class HotelAlreadyExistsException extends RuntimeException{
  public  HotelAlreadyExistsException(String hotelName){
      super("Hotel name:" hotelName"already exists");
  }

}
