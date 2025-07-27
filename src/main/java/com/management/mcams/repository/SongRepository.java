package com.management.mcams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.mcams.entity.Song;

public interface SongRepository extends JpaRepository<Song, Long> {

}
