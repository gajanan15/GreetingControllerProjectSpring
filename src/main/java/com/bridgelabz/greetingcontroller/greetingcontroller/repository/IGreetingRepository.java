package com.bridgelabz.greetingcontroller.greetingcontroller.repository;

import com.bridgelabz.greetingcontroller.greetingcontroller.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGreetingRepository extends JpaRepository<Greeting, Long> {
}
