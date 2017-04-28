package com.channelsoft.apiplus.service;

import com.channelsoft.apiplus.entity.oracle.Test2;
import com.channelsoft.apiplus.entity.mysql.TestOne;

/**
 * Created by Administrator on 2017-4-25.
 */

public interface ITestOneService {
    void insert(TestOne test1) throws Exception;
    void insertTwo(TestOne test1, Test2 test2) throws Exception;
    void insertTwoFail(TestOne test1, Test2 test2) throws Exception;
    void insertTwoFailOne(TestOne test1, Test2 test2) throws Exception;
}
