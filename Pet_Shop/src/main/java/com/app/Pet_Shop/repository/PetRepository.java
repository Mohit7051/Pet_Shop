package com.app.Pet_Shop.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Pet_Shop.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
