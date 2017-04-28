package com.channelsoft.apiplus.repository.mysql;

import com.channelsoft.apiplus.entity.mysql.TestOne;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HelloDao extends PagingAndSortingRepository<TestOne, String>, JpaSpecificationExecutor<TestOne> {
}
