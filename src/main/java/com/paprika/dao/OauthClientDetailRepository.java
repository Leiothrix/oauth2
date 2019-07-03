package com.paprika.dao;

import com.paprika.domain.OauthClientDetailInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author adam
 * @date 2019/6/28
 */
@Repository
public interface OauthClientDetailRepository extends JpaSpecificationExecutor<OauthClientDetailInfo>, JpaRepository<OauthClientDetailInfo,String> {
    /**
     * 通过第三方应用id查找应用具体信息
     *
     * @param clientId 第三方应用id
     * @return 应用具体信息
     */
    OauthClientDetailInfo findByClientId(@Param("clientId") String  clientId);
}
