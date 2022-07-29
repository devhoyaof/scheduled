package com.thread.scheduled.exception;

import com.thread.scheduled.log.LogVO;
import com.thread.scheduled.log.OmsResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;

@Slf4j
public class ExceptionHandler {
    public static void handle(LogVO logVO, Exception e) {
        if (e instanceof CommonException) {
            CommonException commonException = (CommonException) e;
            log.error("☆☆☆☆☆☆☆☆ Common Error : {} ☆☆☆☆☆☆☆☆", e.getMessage(), e);
        } else if (e instanceof DataAccessException) {
            log.error("☆☆☆☆☆☆☆☆ DataAccess Error : {} ☆☆☆☆☆☆☆☆", e.getMessage(), e);
            logVO.setResultCode(OmsResultCode.SERVICE_DB_ERROR);
        } else {

        }
    }
}
