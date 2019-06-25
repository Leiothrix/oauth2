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
@Table(name = "oauth_client_details")
public class OauthClientDetailInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id", columnDefinition = "varchar(128)")
    private String  clientId;

    @Column(name = "resource_ids", columnDefinition = "varchar(256) COMMENT '资源id'")
    private String resourceIds;

    @Column(name = "client_secret", columnDefinition = "varchar(256) COMMENT '客户端密钥'")
    private String clientSecret;

    @Column(name = "scope", columnDefinition = "varchar(256) COMMENT '范围'")
    private String scope;

    @Column(name = "authorized_grant_types", columnDefinition = "varchar(256) COMMENT '授权类型'")
    private String authorizedGrantTypes;

    @Column(name = "web_server_redirect_uri", columnDefinition = "varchar(256) COMMENT '授权重定向url'")
    private String webServerRedirectUri;

    @Column(name = "authorities", columnDefinition = "varchar(256) COMMENT '当局'")
    private String  authorities;

    @Column(name = "access_token_validity", columnDefinition = "int(11) COMMENT '令牌是否有效'")
    private Integer accessTokenValidity;

    @Column(name = "refresh_token_validity", columnDefinition = "int(11) COMMENT '刷新令牌有效期'")
    private Integer refreshTokenValidity;

    @Column(name = "additional_information", columnDefinition = "varchar(4096) COMMENT '附加信息'")
    private String  additionalInformation;

    @Column(name = "autoapprove", columnDefinition = "varchar(256) COMMENT '自动批准'")
    private String autoApprove;

}
