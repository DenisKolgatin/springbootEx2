// UserRepository.java
package ru.netology;

import org.springframework.stereotype.Repository;
import java.util.Collections;
import java.util.List;

@Repository // Делаем бином
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        // Простая хардкод-логика для проверки
        if ("admin".equals(user) && "admin123".equals(password)) {
            return List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if ("guest".equals(user) && "guest123".equals(password)) {
            return List.of(Authorities.READ);
        } else if ("blocked_user".equals(user) && "pass".equals(password)) {
            return Collections.emptyList(); // Вернет пустой список -> вызовет UnauthorizedUser
        }

        // Если пользователь не найден в нашей "базе"
        return Collections.emptyList();
    }
}