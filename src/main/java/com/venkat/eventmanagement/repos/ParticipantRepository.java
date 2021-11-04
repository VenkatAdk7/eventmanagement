package com.venkat.eventmanagement.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.venkat.eventmanagement.entities.Participant;

public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> {
	
	Page<Participant> findByEmail(@Param("email") String email, Pageable pageable);

}
