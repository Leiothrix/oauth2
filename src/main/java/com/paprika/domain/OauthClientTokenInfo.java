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
@Table(name = "oauth_client_token")
public class OauthClientTokenInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "authentication_id", columnDefinition = "varchar(128)")
    private String  authenticationId;

    @Column(name = "token_id", columnDefinition = "varchar(256) COMMENT '令牌id'")
    private String tokenId;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "token", columnDefinition = "blob COMMENT '令牌'")
    private byte[] token;

    @Column(name = "user_name", columnDefinition = "varchar(256) COMMENT '用户名'")
    private String userName;

    @Column(name = "client_id", columnDefinition = "varchar(256) COMMENT '客户端id'")
    private String clientId;
}
