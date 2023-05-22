package edu.bilkent.bilbilet.model;

import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripReview {
	@Id
	@NotNull
	private int review_id;

	@NotNull
	private int ticket_id;

}
