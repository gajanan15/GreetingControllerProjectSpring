package com.bridgelabz.greetingcontroller.greetingcontroller.service.implementation;


import com.bridgelabz.greetingcontroller.greetingcontroller.Exception.GreetingControllerException;
import com.bridgelabz.greetingcontroller.greetingcontroller.model.Greeting;
import com.bridgelabz.greetingcontroller.greetingcontroller.model.User;
import com.bridgelabz.greetingcontroller.greetingcontroller.repository.IGreetingRepository;
import com.bridgelabz.greetingcontroller.greetingcontroller.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = user.toString().isEmpty() ? "Hello World" : user.getFirstName() + " " + user.getLastName();
        Greeting greeting = new Greeting();
        greeting.setIncrementAndGet(counter.incrementAndGet());
        greeting.setFormat(message);
        return greetingRepository.save(greeting);
    }

    @Override
    public List<Greeting> getAllGreeting() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting getUserById(Long id) {
        return greetingRepository.findById(id).orElseThrow(()->new GreetingControllerException("No Record Found", GreetingControllerException.ExceptionType.NO_RECORD_FOUND));
    }

    @Override
    public Greeting deleteGreeting(Long id){
        Greeting greeting = greetingRepository.getOne(id);
        greetingRepository.delete(greeting);
        return greeting;
    }

    @Override
    public Greeting updateGreetingById(Long id, String firstName, String lastName) {
        Greeting update=greetingRepository.findById(id).orElseThrow(()->new GreetingControllerException("No Record Found", GreetingControllerException.ExceptionType.NO_RECORD_FOUND));
        update.setFormat(firstName+" "+lastName);
        return greetingRepository.save(update);
    }
}
