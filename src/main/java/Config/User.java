package Config;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.apache.maven.surefire.shared.lang3.RandomStringUtils;

@Value
@AllArgsConstructor
public class User {
    String name;
    String email;
    String currentAddress;
    String permanentAddress;

    public static User getRandomUser(){
        return new User(RandomStringUtils.randomAlphabetic(5),
                RandomStringUtils.randomAlphabetic(6) + "@itfbgroup.ru",
                RandomStringUtils.randomAlphabetic(20),
                RandomStringUtils.randomAlphabetic(25));
    }
}
