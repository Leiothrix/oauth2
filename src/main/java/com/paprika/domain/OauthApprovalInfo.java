package com.paprika.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author adam
 * @date 2019/6/24
 * PS: You may say that I'm a dreamer.But I'm not the only one.
 */
@Data
@Entity
@Table(name = "oauth_approvals")
public class OauthApprovalInfo {
    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    @Column(name = "id", columnDefinition = "varchar(128)")
    private String  id;

    @Column(name = "user_id", columnDefinition = "varchar(256) COMMENT '用户id'")
    private String  userId;

    @Column(name = "client_id", columnDefinition = "varchar(256) COMMENT '客户端id'")
    private String clientId;

    @Column(name = "scope", columnDefinition = "varchar(256) COMMENT '范围'")
    private String scope;

    @Column(name = "status", columnDefinition = "varchar(10) COMMENT '状态'")
    private String status;

    @Column(name = "expires_at", columnDefinition = "datetime COMMENT '过期时间'")
    private LocalDateTime expiresAt;

    @Column(name = "last_modified_at", columnDefinition = "datetime COMMENT '最后修改时间'")
    private LocalDateTime lastModifiedAt;
}
