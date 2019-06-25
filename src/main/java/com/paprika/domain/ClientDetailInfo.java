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
@Table(name = "clientdetails")
public class ClientDetailInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appId", columnDefinition = "varchar(128)")
    private String  appId;

    @Column(name = "resource_ids", columnDefinition = "varchar(256) COMMENT '资源id'")
    private String resourceIds;

    @Column(name = "app_secret", columnDefinition = "varchar(256) COMMENT '应用密钥'")
    private String appSecret;

    @Column(name = "scope", columnDefinition = "varchar(256) COMMENT '范围'")
    private String scope;

    @Column(name = "grant_types", columnDefinition = "varchar(256) COMMENT '授权类型'")
    private String grantTypes;

    @Column(name = "redirect_url", columnDefinition = "varchar(256) COMMENT '重定向Url'")
    private String redirectUrl;

    @Column(name = "authorities", columnDefinition = "varchar(256) COMMENT '授权'")
    private String  authorities;

    @Column(name = "access_token_validity", columnDefinition = "int(11) COMMENT '令牌合法性'")
    private Integer accessTokenValidity;

    @Column(name = "refresh_token_validity", columnDefinition = "int(11) COMMENT '刷新令牌有效期'")
    private Integer refreshTokenValidity;

    @Column(name = "additional_information", columnDefinition = "varchar(4096) COMMENT '附加信息'")
    private String  additionalInformation;

    @Column(name = "auto_approve_scopes", columnDefinition = "varchar(256) COMMENT '自动批准范围'")
    private String autoApproveScopes;

}
