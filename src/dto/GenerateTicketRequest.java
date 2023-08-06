package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import models.Gate;
import models.Vehicle;

@Getter
@Setter
@AllArgsConstructor
public class GenerateTicketRequest {
    private Gate entryGate;

    private Vehicle vehicle;
}
