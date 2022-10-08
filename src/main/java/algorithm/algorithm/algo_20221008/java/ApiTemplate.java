package algorithm.algorithm.algo_20221008.java;

import dto.GetAuthDTO;
import dto.request.ReplyListDTO;
import dto.request.SimulateListDTO;
import dto.response.NewRequestsListDTO;
import dto.response.ScoreDTO;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ApiTemplate {

    private static final String BASE_URL = "https://68ecj67379.execute-api.ap-northeast-2.amazonaws.com/api";

    public Map getAuthToken(String xAuthToken, int problem) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("X-Auth-Token", xAuthToken);

        GetAuthDTO getAuthDTO = new GetAuthDTO(problem);
        HttpEntity<GetAuthDTO> httpEntity = new HttpEntity<>(getAuthDTO, httpHeaders);
        String targetURL = BASE_URL + "/start";
        ResponseEntity<Map> exchange = restTemplate.exchange(
            urlBuilder("/start"),
            HttpMethod.POST,
            httpEntity,
            Map.class
        );
        return exchange.getBody();
    }

    public NewRequestsListDTO getRequests(String authKey) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Object> httpEntity = getBasicEntityByAuthKey(authKey);

        ResponseEntity<NewRequestsListDTO> exchange = restTemplate.exchange(
            urlBuilder("/new_requests"),
            HttpMethod.GET,
            httpEntity,
            NewRequestsListDTO.class
        );

        return exchange.getBody();
    }

    public Map reply(String authKey, ReplyListDTO replyListDTO) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Object> httpEntity = getBasicEntityByAuthKey(authKey, replyListDTO);

        ResponseEntity<Map> exchange = restTemplate.exchange(
            urlBuilder("/reply"),
            HttpMethod.PUT,
            httpEntity,
            Map.class
        );

        if (!exchange.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("reply error");
        }
        return exchange.getBody();
    }

    public Map simulate(String authKey, SimulateListDTO simulateListDTO) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Object> httpEntity = getBasicEntityByAuthKey(authKey, simulateListDTO);

        ResponseEntity<Map> exchange = restTemplate.exchange(
            urlBuilder("/simulate"),
            HttpMethod.PUT,
            httpEntity,
            Map.class
        );

        if (!exchange.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("simulate error");
        }
        return exchange.getBody();
    }

    public ScoreDTO getScore(String authKey) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Object> httpEntity = getBasicEntityByAuthKey(authKey);

        ResponseEntity<ScoreDTO> exchange = restTemplate.exchange(
            urlBuilder("/score"),
            HttpMethod.GET,
            httpEntity,
            ScoreDTO.class
        );

        return exchange.getBody();
    }

    private HttpEntity<Object> getBasicEntityByAuthKey(String authKey, Object body) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", authKey);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> httpEntity = new HttpEntity<>(body, httpHeaders);
        return httpEntity;
    }

    private HttpEntity<Object> getBasicEntityByAuthKey(String authKey) {
        return getBasicEntityByAuthKey(authKey, null);
    }

    private String urlBuilder(String uri) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BASE_URL);
        stringBuilder.append(uri);
        return stringBuilder.toString();
    }
}
