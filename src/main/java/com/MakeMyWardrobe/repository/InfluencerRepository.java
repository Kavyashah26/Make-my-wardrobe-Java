package com.MakeMyWardrobe.repository;

import org.springframework.stereotype.Repository;
import com.MakeMyWardrobe.models.Influencer;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InfluencerRepository extends JpaRepository<Influencer, Integer> {

}


/*
 
  package com.java.urlShortner.main.myPack.repository;

import com.java.urlShortner.main.myPack.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // No need to implement findById method here.
    // It is already provided by JpaRepository.
}

  
*/