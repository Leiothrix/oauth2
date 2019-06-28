package com.paprika.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * @author adam
 * @date 2019/6/27
 */
public class CustomBCrypt {
    /**
     * 明文变为BCrypt编码
     *
     * @param password 密码原文
     */
    public String encode(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static void main(String[] args) {
        CustomBCrypt customBCrypt = new CustomBCrypt();
        System.out.println(customBCrypt.encode("xmCRf6"));
    }
}
