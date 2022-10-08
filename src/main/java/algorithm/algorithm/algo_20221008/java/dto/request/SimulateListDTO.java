package algorithm.algorithm.algo_20221008.java.dto.request;

import java.util.LinkedList;
import java.util.List;

public class SimulateListDTO {

    private List<SimulateElementDTO> room_assign = new LinkedList<>();

    public void addSimulate(SimulateElementDTO simulateElementDTO){
        room_assign.add(simulateElementDTO);
    }

    public List<SimulateElementDTO> getRoom_assign() {
        return room_assign;
    }

    @Override
    public String toString() {
        return "SimulateListDTO{" +
            "room_assign=" + room_assign.toString() +
            '}';
    }
}
