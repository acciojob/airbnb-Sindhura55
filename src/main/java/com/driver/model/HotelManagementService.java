package com.driver.model;




import java.util.List;

public class HotelManagementService {

    HotelManagementRepository hotelRepository=new HotelManagementRepository();


    public String addHotel(Hotel hotel)
    {
       return  hotelRepository.addHotel(hotel);
    }
   public int addUser(User user){
        return hotelRepository.addUser(user);
   }
   public String getHotelWithMostFacilities()
   {
        return  hotelRepository.getHotelWithMostFacilities();
   }
   public int bookARoom(Booking booking)
   {
      return hotelRepository.bookARoom(booking);
   }
   public int getBookings(int aadharCardNo)
   {
       return hotelRepository.getBookings(aadharCardNo);
   }
  public  Hotel updateFacilities(List<Facility> newFacilities,String hotelName)
  {
      return hotelRepository.updateFacilities(newFacilities,hotelName);
  }


}
