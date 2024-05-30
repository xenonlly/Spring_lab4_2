package client;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface MyApi {
    @POST("/img")
    Call<ImgDto> save(@Body ImgDto imgEntity);

    @GET("/img/{id}")
    Call<ImgDto> getImgById(@Path("id") int id);

    @GET("/img")
    Call<List<ImgDto>> getAllBase64();
}
