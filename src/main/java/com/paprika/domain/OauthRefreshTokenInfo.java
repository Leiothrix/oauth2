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
@Table(name = "oauth_refresh_token")
public class OauthRefreshTokenInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "varchar(128)")
    private String  id;

    @Column(name = "token_id", columnDefinition = "varchar(256) COMMENT '令牌id'")
    private String tokenId;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "token", columnDefinition = "blob COMMENT '令牌'")
    private byte[] token;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "authentication", columnDefinition = "blob COMMENT '认证'")
    private byte[] authentication;
}
