package edu.bilkent.bilbilet.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import edu.bilkent.bilbilet.model.Hotel;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class AddHotel {
    @NotNull
    private Hotel hotel;

}
