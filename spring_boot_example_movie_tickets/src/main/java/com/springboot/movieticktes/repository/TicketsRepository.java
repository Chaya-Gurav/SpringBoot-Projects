package com.springboot.movieticktes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.movieticktes.entities.Ticket;

public interface TicketsRepository extends JpaRepository<Ticket, Integer> {

}
