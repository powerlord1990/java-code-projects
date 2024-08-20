package javacode.projects.core.task2;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;

public class Main {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy:MM:dd##:HH:mm:ss:SSS", locale = "ru")
    private static final LocalDateTime date = LocalDateTime.now();

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(date));
    }
}
