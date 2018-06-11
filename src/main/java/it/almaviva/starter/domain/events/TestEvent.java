package it.almaviva.starter.domain.events;

import lombok.*;

@Data
public class TestEvent {
    private String payload = "Test Event";
}
