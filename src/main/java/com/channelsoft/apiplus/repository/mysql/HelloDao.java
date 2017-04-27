package com.channelsoft.apiplus.repository.mysql;

import com.channelsoft.apiplus.entity.TestOne;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface HelloDao extends PagingAndSortingRepository<TestOne, String>, JpaSpecificationExecutor<TestOne> {
}
