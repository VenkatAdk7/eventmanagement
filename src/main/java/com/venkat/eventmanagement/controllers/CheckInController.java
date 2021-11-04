package com.venkat.eventmanagement.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.venkat.eventmanagement.entities.Participant;
import com.venkat.eventmanagement.exceptions.AlreadyCheckedInException;
import com.venkat.eventmanagement.repos.ParticipantRepository;

@RepositoryRestController
@RequestMapping("/events")
public class CheckInController {
	
	@Autowired
	private ParticipantRepository participantRepository; 
	
	@PostMapping("/checkin/{id}")
	public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id, PersistentEntityResourceAssembler assembler) {
		Optional<Participant> participant = participantRepository.findById(id);
		Participant myParticipant = participant.get();
		
		if (participant != null) {
			if (myParticipant.getCheckedIn()) {
				throw new AlreadyCheckedInException();
			}
			myParticipant.setCheckedIn(true);
			participantRepository.save(myParticipant);
		}
		
		return ResponseEntity.ok(assembler.toFullResource(myParticipant));
	}
}
