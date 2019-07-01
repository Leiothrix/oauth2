package com.paprika.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author adam
 * @date 2019/6/24
 * PS: You may say that I'm a dreamer.But I'm not the only one.
 */
@Data
@Entity
@Table(name = "oauth_code")
public class OauthCodeInfo {
    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    @Column(name = "id", columnDefinition = "varchar(128)")
    private String  id;

    @Column(name = "code", columnDefinition = "varchar(256) COMMENT '代码'")
    private String  code;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "authentication", columnDefinition = "blob COMMENT '认证'")
    private byte[] authentication;
}
