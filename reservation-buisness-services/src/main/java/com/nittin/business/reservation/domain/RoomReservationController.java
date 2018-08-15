package com.nittin.business.reservation.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nittin.business.reservation.client.RoomService;

@RestController
public class RoomReservationController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping(value="/rooms1",method=RequestMethod.GET)
	public List<Room> getAllRooms(){
		ResponseEntity<List<Room>> roomResponse = this.restTemplate.exchange("http://ROOMSERVICES/rooms", HttpMethod.GET,null,
				new ParameterizedTypeReference<List<Room>>(){});
		return roomResponse.getBody();
		
	}
	
	@RequestMapping(value="/rooms",method=RequestMethod.GET)
	public List<Room> getRooms(){
		return roomService.findAll(null);
		
	}

}
