package SpringClient;

import SpringClient.controller.ClientController;
import SpringClient.view.MainFrame;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

public class Main {
    public static void main(String[] args) {
        RestClient restClient = RestClient.create();

        MainFrame mainFrame = new MainFrame();
        ClientController controller = new ClientController(mainFrame,restClient);



//        String uriBase ="http://localhost:8080/";
//        ImgDto article = new ImgDto(1, "HowtouseRestClient");
//        ResponseEntity<Void> response = restClient.post()
//                .uri(uriBase + "img")
//                .contentType(APPLICATION_JSON)
//                .body(article)
//                .retrieve()
//                .toBodilessEntity();
//
//        ImgDto result = restClient.get()
//                .uri(uriBase + "img")
//                .retrieve()
//                .body(ImgDto.class);
//
//        ImgDto result2 = restClient.get()
//                .uri(uriBase + "img/0")
//                .retrieve()
//                .body(ImgDto.class);
    }
}
