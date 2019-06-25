package com.paprika.domain;

import lombok.Data;
import javax.persistence.*;

/**
 * @author adam
 * @date 2019/6/24
 * PS: You may say that I'm a dreamer.But I'm not the only one.
 */
@Data
@Entity
@Table(name = "oauth_access_token")
public class OauthAccessTokenInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "authentication_id", columnDefinition = "varchar(128)")
    private String  authenticationId;

    @Column(name = "tokenId", columnDefinition = "varchar(256) COMMENT '令牌id'")
    private String tokenId;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "token", columnDefinition = "blob COMMENT '令牌'")
    private byte[] token;

    @Column(name = "user_name", columnDefinition = "varchar(256) COMMENT '用户名'")
    private String userName;

    @Column(name = "client_id", columnDefinition = "varchar(256) COMMENT '客户端id'")
    private String clientId;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "authentication", columnDefinition = "blob COMMENT '认证'")
    private byte[] authentication;

    @Column(name = "refresh_token", columnDefinition = "varchar(256) COMMENT '刷新令牌'")
    private String  refreshToken;
}
