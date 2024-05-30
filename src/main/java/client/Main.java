package client;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main {

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final MyApi api = retrofit.create(MyApi.class);


    public static void main(String[] args) {
        // Пример использования методов
        sendBase64String("SGVsbG8gV29ybGQ="); // отправка строки
        getBase64StringById(1); // получение строки по ID
//        getAllBase64Strings(); // получение всех строк
    }

    // Метод для отправки строки на сервер
    public static void sendBase64String(String base64String) {
        ImgDto dto = new ImgDto(base64String);
        api.save(dto).enqueue(new Callback<ImgDto>() {
            @Override
            public void onResponse(Call<ImgDto> call, Response<ImgDto> response) {
                if (response.isSuccessful()) {
                    System.out.println("Saved entity ID: " + response.body().getId());
                }
            }

            @Override
            public void onFailure(Call<ImgDto> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    // Метод для получения строки по ID
    public static void getBase64StringById(int id) {
        api.getImgById(id).enqueue(new Callback<ImgDto>() {
            @Override
            public void onResponse(Call<ImgDto> call, Response<ImgDto> response) {
                if (response.isSuccessful()) {
                    System.out.println("Base64 data: " + response.body().getImgBase64data());
                }
            }

            @Override
            public void onFailure(Call<ImgDto> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    // Метод для получения всех строк
//    public static void getAllBase64Strings() {
//        api.getAllBase64().enqueue(new Callback<List<ImgEntity>>() {
//            @Override
//            public void onResponse(Call<List<ImgEntity>> call, Response<List<ImgEntity>> response) {
//                if (response.isSuccessful()) {
//                    List<ImgEntity> entities = response.body();
//                    entities.forEach(e -> System.out.println("ID: " + e.getId() + ", Data: " + e.getData()));
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<ImgEntity>> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
//    }
}
