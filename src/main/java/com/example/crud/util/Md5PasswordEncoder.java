package com.example.crud.util;

import org.springframework.security.crypto.password.PasswordEncoder;

public class Md5PasswordEncoder implements PasswordEncoder {
    MD5 md5 = new MD5();

    @Override
    public String encode(CharSequence cs) {
        return md5.getHashString(cs.toString());
    }

    @Override
    public boolean matches(CharSequence cs, String string) {
        String hashSenha = md5.getHashString(cs.toString());

        return hashSenha.equals(string);
    }
}
