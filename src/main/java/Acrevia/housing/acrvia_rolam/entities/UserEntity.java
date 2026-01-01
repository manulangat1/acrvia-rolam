package Acrevia.housing.acrvia_rolam.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.UUID;

@Entity
public class UserEntity {

    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    
}
