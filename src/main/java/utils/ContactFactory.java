package utils;
import dto.Contact;

import static utils.RandomUtils.*;


public class ContactFactory {

    public static Contact createPositiveContact(){
        return Contact.builder()
                .name(generateString(5))
                .lastName(generateString(10))
                .email(generateEmail(12))
                .phone(generatePhone(10))
                .address(generateString(10))
                .description("description")
                .build();
    }

    public static Contact createNegativeContact_WrongEmail(String email){
        return Contact.builder()
                .name(generateString(5))
                .lastName(generateString(10))
                .email(email)
                .phone(generatePhone(10))
                .address(generateString(10))
                .description("description")
                .build();
    }
    public static Contact createNegativeContact_WrongPhone(String phone){
        return Contact.builder()
                .name(generateString(5))
                .lastName(generateString(10))
                .email(generateString(12))
                .phone(phone)
                .address(generateString(10))
                .description("description")
                .build();
    }
    public static Contact createNegativeContact_WrongName(String name){
        return Contact.builder()
                .name(name)
                .lastName(generateString(10))
                .email(generateString(12))
                .phone(generatePhone(10))
                .address(generateString(10))
                .description("description")
                .build();
    }

}
