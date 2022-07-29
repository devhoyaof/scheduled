package com.thread.scheduled.service;

import com.thread.scheduled.exception.ExceptionHandler;
import com.thread.scheduled.log.LogVO;
import com.thread.scheduled.log.OmsResultCode;
import com.thread.scheduled.mappers.BoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SchedulerService {

    private final BoardMapper mapper;
    private final Logger omsLog = LoggerFactory.getLogger("oms");
    protected LogVO logVO;

    public SchedulerService(BoardMapper mapper) {
        this.mapper = mapper;
    }

    public void execute() {
        try {
            logVO = new LogVO();

            logVO.setResultCode(OmsResultCode.SUCCESS);

            List eaiList = mapper.getAllBoard();

            log.info(eaiList.toString());
        } catch (Exception e) {
            ExceptionHandler.handle(logVO, e);
        } finally {
            logVO.setResTime();
            logVO.setLogTime();

            omsLog.info(logVO.ToString());
            ThreadContext.remove("seqId");
        }

    }
}
