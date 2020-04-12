package com.bridgelabz.greetingcontroller.greetingcontroller.service;


import com.bridgelabz.greetingcontroller.greetingcontroller.model.Greeting;
import com.bridgelabz.greetingcontroller.greetingcontroller.model.User;

import java.util.List;


public interface IGreetingService {
    Greeting addGreeting(User user);
    List<Greeting> getAllGreeting();
    Greeting getUserById(Long id);
    Greeting deleteGreeting(Long id);
    Greeting updateGreetingById(Long id,String firstName,String lastName);
}
