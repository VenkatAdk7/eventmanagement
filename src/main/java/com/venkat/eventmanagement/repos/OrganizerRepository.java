package com.venkat.eventmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.venkat.eventmanagement.entities.Organizer;

public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long>{

}
