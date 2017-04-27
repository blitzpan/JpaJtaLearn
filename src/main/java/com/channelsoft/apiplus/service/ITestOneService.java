package com.channelsoft.apiplus.service;

import com.channelsoft.apiplus.entity.TestOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-4-25.
 */

public interface ITestOneService {
    public void insert(TestOne test1) throws Exception;
}
