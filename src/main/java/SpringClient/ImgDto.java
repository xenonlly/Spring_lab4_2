package SpringClient;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ImgDto {
    private int id;
    private String imgBase64data;

    public ImgDto() {
    }

    public ImgDto(int id, String imgBase64data) {
        this.id = id;
        this.imgBase64data = imgBase64data;
    }

    public ImgDto(String imgBase64data) {
        this.imgBase64data = imgBase64data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImgBase64data(String imgBase64data) {
        this.imgBase64data = imgBase64data;
    }
}
