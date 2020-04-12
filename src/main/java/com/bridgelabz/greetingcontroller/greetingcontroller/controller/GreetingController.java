package com.bridgelabz.greetingcontroller.greetingcontroller.controller;

import com.bridgelabz.greetingcontroller.greetingcontroller.model.Greeting;
import com.bridgelabz.greetingcontroller.greetingcontroller.model.User;
import com.bridgelabz.greetingcontroller.greetingcontroller.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    IGreetingService greetingService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "fName", defaultValue = "World") String firstName, @RequestParam(value = "lName") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/greetings")
    public List<Greeting> getAllGreeting() {
        return greetingService.getAllGreeting();
    }


    @RequestMapping("/greetinguser/{incrementAndGet}")
    public Greeting getUser(@PathVariable("incrementAndGet") Long incrementAndGet) {
        return greetingService.getUserById(incrementAndGet);
    }


    @PutMapping("/greeting/updateuser")
    public String saveOrUpdate(@RequestParam(value = "id") Long incrementAndGet,
                                 @RequestParam(value = "fName", defaultValue = "World") String firstName,
                                 @RequestParam(value = "lName") String lastName) {
        greetingService.updateGreetingById(incrementAndGet, firstName, lastName);
        return "Record Updated";
    }

    @DeleteMapping("/greeting/{incrementAndGet}")
    public String deleteUser(@PathVariable Long incrementAndGet) {
        greetingService.deleteGreeting(incrementAndGet);
        return "User Has Been Deleted";
    }

    @PostMapping("/post/greeting")
    public Greeting greeting(@RequestBody Greeting greeting) {
        User user = new User();
        user.setFirstName(greeting.getFormat());
        return greetingService.addGreeting(user);
    }

}
