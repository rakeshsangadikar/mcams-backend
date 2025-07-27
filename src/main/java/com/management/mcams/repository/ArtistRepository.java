package com.management.mcams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.mcams.entity.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
