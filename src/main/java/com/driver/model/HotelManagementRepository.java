package com.driver.model;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public class HotelManagementRepository
    {
        public HashMap<String, Hotel> data= new HashMap<>();
        public HashMap<Integer, User> userData =new HashMap<>();
          HashMap<String,Booking> bookingData=new HashMap<>();
        public  String addHotel(Hotel hotel)
        {
            if(data.containsKey(hotel.getHotelName()))
                return "FAILURE";

            if(hotel.getHotelName()==null||hotel==null)
                return "FAILURE";
            data.put(hotel.getHotelName(),hotel);
                return "SUCCESS";
        }
        public int addUser(User user)
        {
            userData.put(user.getAadharCardNo(),user);
            return user.getAadharCardNo();
        }
       public String getHotelWithMostFacilities()
       {
           String ans="";
           int facitiesNo=0;
           for(String hotelName:data.keySet())
           {
               Hotel hotel=data.get(hotelName);
               if(hotel.getFacilities().size()>facitiesNo)
               {
                   ans=hotelName;
                   facitiesNo=hotel.getFacilities().size();
               }
               else if(hotel.getFacilities().size()==facitiesNo)
               {
                   if(hotelName.compareTo(ans)<0)
                   {
                       ans=hotelName;
                   }

               }
           }
           return ans;
       }
       public int bookARoom(Booking booking)
       {
         UUID uuid= UUID.randomUUID();
         String bookingID=uuid.toString();
         booking.setBookingId(bookingID);
         Hotel hotel=data.get(booking.getHotelName());
         int noOfRooms=booking.getNoOfRooms();

         if(noOfRooms>hotel.getAvailableRooms())
         {
             return -1;
         }
         booking.setAmountToBePaid(noOfRooms* hotel.getPricePerNight());
         hotel.setAvailableRooms(hotel.getAvailableRooms()-noOfRooms);
         bookingData.put(bookingID,booking);
         data.put(booking.getHotelName(),hotel);
         return booking.getAmountToBePaid();
       }

       public int getBookings(int aadharCardNo)
       {
           int ans=0;
           for(String bookingId:bookingData.keySet())
           {
               Booking booking=bookingData.get(bookingId);
               if(booking.getBookingAadharCard()==aadharCardNo)
               {
                   ans++;
               }
           }
         return ans;
       }
       public Hotel updateFacilities(List<Facility> newFacilities,String hotelName)
       {
           Hotel hotel=data.get(hotelName);
           List<Facility> currentFacilities= hotel.getFacilities();
           for(Facility facility:newFacilities)
           {
               if(currentFacilities.contains(facility))
               {
                   continue;
               }
               else
               {
                   currentFacilities.add(facility);
               }
               hotel.setFacilities(currentFacilities);
               data.put(hotelName,hotel);
           }
           return hotel;
       }
}
