package com.paprika.dao;

import com.paprika.domain.OauthClientDetailInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author adam
 * @date 2019/6/28
 */
@Repository
public interface OauthClientDetailRepository extends JpaSpecificationExecutor<OauthClientDetailInfo>, JpaRepository<OauthClientDetailInfo,String> {
}
