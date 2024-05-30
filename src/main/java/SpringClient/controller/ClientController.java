package SpringClient.controller;

import SpringClient.ImgDto;
import SpringClient.service.Convertor;
import SpringClient.view.MainFrame;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

import static org.springframework.http.MediaType.APPLICATION_JSON;

public class ClientController {
    private MainFrame mainFrame;
    private RestClient restClient;
    private final String uriBase = "http://localhost:8080/";

    public ClientController(MainFrame mainFrame, RestClient restClient) {
        this.mainFrame = mainFrame;
        this.restClient = restClient;
        mainFrame.addListenerFileChooser(new FileChooserListener());
        mainFrame.addListenerSend(new SendListener());
        mainFrame.addListenerReceiveMap(new ReceiveMapListener());
        mainFrame.addListenerReceiveJson(new ReceiveJsonListener());
    }


    private class FileChooserListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.setImage();
        }
    }

    private class SendListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JSONObject json = Convertor.JpegToJson(mainFrame.getFile());
            String image = json.toString();

            ImgDto article = new ImgDto(1, image);
            ResponseEntity<Void> response = restClient.post()
                    .uri(uriBase + "img")
                    .contentType(APPLICATION_JSON)
                    .body(article)
                    .retrieve()
                    .toBodilessEntity();

        }
    }

    private class ReceiveMapListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }

    private class ReceiveJsonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog(null, "Введите число:");

            ImgDto result = restClient.get()
                    .uri(uriBase + "img/"+input)
                    .retrieve()
                    .body(ImgDto.class);

            Convertor.JsonToJpeg(result.getImgBase64data());

            mainFrame.reloadFileChooser();
        }
    }

}
