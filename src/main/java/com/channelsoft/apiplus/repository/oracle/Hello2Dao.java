package com.channelsoft.apiplus.repository.oracle;

import com.channelsoft.apiplus.entity.Test2;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Hello2Dao extends PagingAndSortingRepository<Test2, String>, JpaSpecificationExecutor<Test2> {
}
