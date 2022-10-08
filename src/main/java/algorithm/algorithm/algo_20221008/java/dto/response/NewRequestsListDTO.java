package algorithm.algorithm.algo_20221008.java.dto.response;

import java.util.ArrayList;
import java.util.List;

public class NewRequestsListDTO {

    private List<NewRequestElementDTO> reservations_info = new ArrayList<>();

    public List<NewRequestElementDTO> getReservations_info() {
        return reservations_info;
    }

    @Override
    public String toString() {
        return "NewRequestsListDTO{" +
            "reservations_info=" + reservations_info.toString() +
            '}';
    }
}
