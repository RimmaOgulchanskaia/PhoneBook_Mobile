package utils;

import dto.User;
import static utils.RandomUtils.*;

public class UserFabric {
    public static User createUser (){
        return User.builder()
                .username(generateEmail(15))
                .password("Password123!")
                .build();
    }

    public static User createUserWrongEmail (String email){
        return User.builder()
                .username(email)
                .password("Password123!")
                .build();
    }

    public static User createUserWrongPassword (String password){
        return User.builder()
                .username(generateEmail(15))
                .password(password)
                .build();
    }
}
