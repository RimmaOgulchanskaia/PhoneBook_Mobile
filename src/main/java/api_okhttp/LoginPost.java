package api_okhttp;

import com.google.gson.Gson;
import dto.User;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import utils.BaseAPI;

import java.io.IOException;

public class LoginPost implements BaseAPI {
    public static void main(String[] args) throws IOException {
        User qa_user = User.builder()
                .username("qa_user_qwerty@mail.com")
                .password("Password123!")
                .build();
        Response response = login(qa_user);
        System.out.println(response.isSuccessful());
        System.out.println(response.body().string());
    }

    public static Response login(User user){
        RequestBody requestBody = RequestBody.create(GSON.toJson(user), JSON);
        Request request = new Request.Builder()
                .url(BASE_URL+LOGIN_URL)
                .post(requestBody)
                .build()
                ;
        Response response;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
            //response.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("created exception POST LOGIN");
            return null;
        }
        return response;
    }
}