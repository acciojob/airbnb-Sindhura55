package com.driver.services;

import com.driver.repositories.HotelManagementRepository;

public class HotelManagementService
{
    HotelManagementRepository hotelRepository=new HotelManagementRepository();
    public boolean hotels(Hotel hotel) throws HotelAlreadyExistsException{
        Optional<Hotel> hotelOpt=hotelRepository.getByHotelname());
        if(hotelOpt.isPresent()){
         throw new HotelAlreadyExistsException(hotel.getHotelName());
        }
        return hotelRepository.addingHotel(hotel);
    }
}
