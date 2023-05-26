package edu.bilkent.bilbilet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.bilkent.bilbilet.exception.ExceptionLogger;
import edu.bilkent.bilbilet.model.Hotel;
import edu.bilkent.bilbilet.request.AddHotel;
import edu.bilkent.bilbilet.response.Response;
import edu.bilkent.bilbilet.service.HotelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/hotel")
public class HotelController {

    private final HotelService hotelService;

    @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "add")
    public ResponseEntity<Object> addHotel(@Valid @RequestBody AddHotel hotelInfo) {
        try {
            Hotel newHotel = hotelService.addHotel(hotelInfo);
            return Response.create("Hotel created successfully", HttpStatus.OK, newHotel);
        } catch (Exception e) {
            return Response.create(ExceptionLogger.log(e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}