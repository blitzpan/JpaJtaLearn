package com.channelsoft.apiplus.service;

import com.channelsoft.apiplus.entity.Test2;
import com.channelsoft.apiplus.entity.TestOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-4-25.
 */

public interface ITestOneService {
    void insert(TestOne test1) throws Exception;
    void insertTwo(TestOne test1, Test2 test2) throws Exception;
    void insertTwoFail(TestOne test1, Test2 test2) throws Exception;
    void insertTwoFailOne(TestOne test1, Test2 test2) throws Exception;
}
