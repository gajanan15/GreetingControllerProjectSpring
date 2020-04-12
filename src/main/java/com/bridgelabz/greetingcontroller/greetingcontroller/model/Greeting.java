package com.bridgelabz.greetingcontroller.greetingcontroller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Greeting")
public class Greeting {

    @Id
    private Long incrementAndGet;

    @Column(name = "message")
    private String format;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Long getIncrementAndGet() {
        return incrementAndGet;
    }

    public void setIncrementAndGet(long incrementAndGet) {
        this.incrementAndGet = incrementAndGet;
    }
}
