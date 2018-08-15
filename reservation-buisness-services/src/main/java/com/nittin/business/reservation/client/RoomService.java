package com.nittin.business.reservation.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nittin.business.reservation.domain.Room;

@FeignClient(value="ROOMSERVICES")//,fallback=RoomReservationController.class)
public interface RoomService {
	
	@RequestMapping(value="/rooms",method=RequestMethod.GET)
	 List<Room> findAll(@RequestParam(name="roomNumber",required=false)String roomNumber);

}
