package com.driver.repositories;

import com.driver.model.Hotel;

import java.util.HashMap;
import java.util.Optional;

public class HotelManagementRepository {
    HashMap<String, Hotel> data= new HashMap<>();

    public boolean addingHotel(){
        data.put(hotel.getHotelName(),hotel);
        return true;
    }
    public optional<Hotel> getByHotelName(String hotel){
        if(data.containsKey(hotelName)) {
            return Optional.of(hotel.get(hotel));
        }
        return Optional.empty();
    }
}
