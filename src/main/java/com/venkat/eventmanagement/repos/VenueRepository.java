package com.venkat.eventmanagement.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.venkat.eventmanagement.entities.Venue;

public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {

	Page<Venue> findByPostalCode(@Param("postalCode") String postalCode, Pageable pageable);
}
