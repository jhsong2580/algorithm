package algorithm.algorithm.algo_20221008.java.dto.request;

public class SimulateElementDTO {
    private int id;
    private int room_number;

    public SimulateElementDTO(int id, int room_number) {
        this.id = id;
        this.room_number = room_number;
    }

    public int getId() {
        return id;
    }

    public int getRoom_number() {
        return room_number;
    }

    @Override
    public String toString() {
        return "SimulateElementDTO{" +
            "id=" + id +
            ", room_number=" + room_number +
            '}';
    }
}
