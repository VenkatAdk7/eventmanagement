package com.venkat.eventmanagement.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.venkat.eventmanagement.entities.Event;
import com.venkat.eventmanagement.repos.EventRepository;

@RepositoryRestController
@RequestMapping("/events")
public class EventKickOffController {
	
	@Autowired
	private EventRepository eventRepository;
	
	@PostMapping("/start/{id}")
	public ResponseEntity start(@PathVariable Long id) {
		Optional<Event> event = eventRepository.findById(id);
		Event myEvent = event.get();
		if (myEvent == null) {
			throw new ResourceNotFoundException();
		}
		myEvent.setStarted(true);
		eventRepository.save(myEvent);
		return ResponseEntity.ok(myEvent.getName() + "has started");
	}
}
