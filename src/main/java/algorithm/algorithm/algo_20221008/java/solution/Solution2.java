package algorithm.algorithm.algo_20221008.java.solution;

import dto.request.ReplyElementDTO;
import dto.request.ReplyListDTO;
import dto.request.SimulateElementDTO;
import dto.request.SimulateListDTO;
import dto.response.NewRequestElementDTO;
import dto.response.NewRequestsListDTO;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution2 {

    private Map<Integer, List<NewRequestElementDTO>> replyStorage = new HashMap();
    private Map<Integer, List<SimulateElementDTO>> simulateStorage = new HashMap<>();
    private List<NewRequestElementDTO> requests = new LinkedList<>();
    private int H;
    private int W;
    private int MAX_AMOUNT;
    private static RoomInfo[][] rooms;
    public Solution2(int problem) {
        if(problem == 1){
            H = 3;
            W = 20;
            MAX_AMOUNT = 10;
        }else if(problem == 2){
            H = 10;
            W = 200;
            MAX_AMOUNT = 50;
        }
        rooms = new RoomInfo[H][W];
        for(int i=0; i<H; i++){
            for(int j=0;j<W; j++){
                rooms[i][j] = new RoomInfo();
            }
        }
    }

    public void settingRequest(NewRequestsListDTO newRequestsListDTO) {
        for (NewRequestElementDTO newRequestElementDTO : newRequestsListDTO.getReservations_info()) {
            requests.add(newRequestElementDTO);

        }
        Collections.sort(requests);
    }

    public SimulateListDTO getSimulateList(int curDate){
        SimulateListDTO simulateListDTO = new SimulateListDTO();
        if(simulateStorage.get(curDate) == null){
            return new SimulateListDTO();
        }
        for (SimulateElementDTO simulateElementDTO : simulateStorage.get(curDate)) {
            simulateListDTO.addSimulate(simulateElementDTO);
        };
        return simulateListDTO;
    }

    public ReplyListDTO getReplyList(int curDate) {
        ReplyListDTO replyListDTO = new ReplyListDTO();
        List<NewRequestElementDTO> alreadyReplied = new LinkedList<>();
        for (NewRequestElementDTO request : requests) {
            ReplyElementDTO replyElementDTO = new ReplyElementDTO(request.getId());
            if(request.getAmount() <= MAX_AMOUNT/2 && getMaxReplyDate(curDate, request) != curDate){
                continue;
            }
            int roomNumber = checkAvailable(request);
            if (roomNumber != -1) {
                alreadyReplied.add(request);
                replyElementDTO.requestAccept();
                replyListDTO.addReply(replyElementDTO);
                SimulateElementDTO simulateElementDTO = new SimulateElementDTO(request.getId(),
                    roomNumber);
                if (simulateStorage.containsKey(request.getCheck_in_date())) {
                    simulateStorage.get(request.getCheck_in_date()).add(simulateElementDTO);
                } else {
                    LinkedList<SimulateElementDTO> list = new LinkedList<>();
                    list.add(simulateElementDTO);
                    simulateStorage.put(request.getCheck_in_date(), list);
                }
            }else {
                    alreadyReplied.add(request);
                    replyElementDTO.requestRefuse();
                    replyListDTO.addReply(replyElementDTO);
            }
        }

        for (NewRequestElementDTO replied : alreadyReplied) {
            requests.remove(replied);
        }
        return replyListDTO;
    }

    private void settingRoom(NewRequestElementDTO request, int h, int w){
        for(int j = w; j< w + request.getAmount(); j++){
            rooms[h][j].appendDate(request.getCheck_in_date(), request.getCheck_out_date());
        }
    }
    private int checkAvailable(NewRequestElementDTO request) {
        for (int i = 0; i < H; i++) {
            int j = 0;
            int roomCount = 0;
            int startWidth = -1;
            while (j < W) {
                if (!rooms[i][j].isAvailable(request.getCheck_in_date(), request.getCheck_out_date())) {
                    j++;
                    roomCount = 0;
                    startWidth = -1;
                    continue;
                }
                if(startWidth == -1){
                    startWidth = j;
                }
                roomCount++;
                j++;
                if (roomCount == request.getAmount()) {
                    settingRoom(request, i, startWidth);
                    return getRoomNumber(i, startWidth);
                }
            }
        }
        return -1;
    }

    private int getMaxReplyDate(int curDate, NewRequestElementDTO newRequestElementDTO) {
        return Math.min(curDate + 14, newRequestElementDTO.getCheck_in_date() - 1);
    }

    public int getRoomNumber(int height, int width) {
        height += 1;
        width += 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(height / 10);
        stringBuilder.append(height % 10);
        stringBuilder.append(width / 100);
        width -= (width / 100) * 100;
        stringBuilder.append(width / 10);
        stringBuilder.append(width % 10);

        return Integer.parseInt(stringBuilder.toString());
    }

}

class RoomInfo {


    private List<Date> checkInOut = new LinkedList<>();

    public void appendDate(int checkIn, int checkOut) {
        Date date = new Date(checkIn, checkOut);
        checkInOut.add(date);
//        Collections.sort(checkInOut);
    }

    public boolean isAvailable(int checkIn, int checkOut){
        for (Date date : checkInOut) {
            if (!date.notDup(checkIn, checkOut)) {
                return false;
            }
        }
        return true;
    }
}

class Date implements Comparable{
    private int checkIn;
    private int checkOut;

    public Date(int checkIn, int checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public boolean notDup(int checkIn, int checkOut){
        return checkOut <= this.checkIn || checkIn >= this.checkOut;
    }
    public int getCheckIn() {
        return checkIn;
    }

    public int getCheckOut() {
        return checkOut;
    }

    @Override
    public int compareTo(Object o) {
        Date target = (Date) o;
        if (this.checkIn < ((Date) o).getCheckIn()) {
            return 1;
        }
        return -1;
    }
}