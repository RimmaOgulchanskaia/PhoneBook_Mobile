package api_okhttp;

import dto.ContactsDto;
import dto.TokenDto;
import dto.User;
import okhttp3.Request;
import okhttp3.Response;
import utils.BaseAPI;

import java.io.IOException;

import static api_okhttp.LoginPost.*;

public class GetAllUserContacts implements BaseAPI {

    public static void main(String[] args) throws IOException {
        User qa_user = User.builder()
                .username("qa_user_qwerty@mail.com")
                .password("Password123!")
                .build();
        Response response = login(qa_user);
        if (response.isSuccessful()) {
            TokenDto token = GSON.fromJson(response.body().string(), TokenDto.class);
            response.close();  //??????
            System.out.println(token.getToken());
            Response response1 = getAllUserContacts(token);
            if (response1.isSuccessful()) {
                ContactsDto contacts = GSON.fromJson(response1.body().string(), ContactsDto.class);
                System.out.println(contacts.getContacts()[0].toString());
            }else
                System.out.println("response1 is null");
        }
    }

    public static Response getAllUserContacts(TokenDto token) {
        Request request = new Request.Builder()
                .url(BASE_URL + ADD_NEW_CONTACT_URL)
                .addHeader("Authorization", token.getToken())
                .get()
                .build();
        Response response;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("created exception GET contacts");
            return null;
        }

    }
}