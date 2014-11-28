package ru.vsprog.springinaction.chapter10;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import ru.vsprog.springinaction.chapter7.Spittle;

import java.io.Serializable;

/**
 * Переопределяем поведение функции "обработчик разрешений" hasPermission().
 *
 * Created by vsa
 * Date: 28.11.14.
 */
public class SpittlePermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object target, Object permission) {
        if (target instanceof Spittle) {
            Spittle spittle = (Spittle) target;
            if ("delete".equals(permission)) {
                return spittle.getSpitter().getUserName().equals(authentication.getName())
                        || hasProfanity(spittle);
            }
        }
        throw new UnsupportedOperationException("hasPermission not supported for object <" + target +
                "> and permission <" + permission + ">");
    }

    private boolean hasProfanity(Spittle spittle) {
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        throw new UnsupportedOperationException();
    }
}
