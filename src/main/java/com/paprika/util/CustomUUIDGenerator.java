package com.paprika.util;

import com.paprika.domain.OauthClientDetailInfo;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDGenerator;
import java.io.Serializable;

/**
 * 自定义UUID生成器，使得保存实体类时可以在保留主键生成策略的情况下自定义表的主键
 *
 * @author adam
 * @date 2019/7/1
 */
public class CustomUUIDGenerator extends UUIDGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        if (object == null){
            throw new HibernateException(new NullPointerException());
        }
        if ((((OauthClientDetailInfo) object).getClientId()) == null) {
            return super.generate(session, object) ;
        } else {
            return ((OauthClientDetailInfo) object).getClientId();
        }
    }
}
