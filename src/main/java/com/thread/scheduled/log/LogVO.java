package com.thread.scheduled.log;

import com.thread.scheduled.util.DateUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.util.Random;

@Getter
@Setter
public class LogVO {

    /***********************필수로그 Start************************/
    private String seqId = "";                      // YYYYMMDDHHmmSSsss(17자리)+RANDOM(4자리)+SVC Name(4자리)
    private String logTime = "";                    // 로그를 파일에 Write 시점 시간 (14)
    private String logType = "";                    // SVC : 서비스       (3)
    private String sid = "";                        // 동합 ID (CTN 또는 전사 서비스 공동 ID) (32)
    private OmsResultCode resultCode;               // 서비스 상태 코드 (8)
    private String reqTime = "";                    // 서비스 전체 요청 완료 시간 (17)
    private String resTime = "";                    // 서비스 전체 응답 완료 시간 (17)
    private String svcName = "";                    // 서비스 명 (32)

    public LogVO() { setReqTime(); }

   public void setSvcName(String svcName) {
        setSeqId(svcName);
        this.svcName = svcName;
   }

   public void setSeqId(String projectName) {
        if(this.seqId.equalsIgnoreCase("")) {
            String dTime = DateUtils.getNowDateTimeMilliseconds();
            Random random = new Random();

            Integer a = random.nextInt(10000);

            String rand01 = String.format("%04d", a);

            this.seqId = dTime + "." + rand01 + "." + projectName;
        }
   }

   public void setLogTime() { this.logTime = DateUtils.getNowDateTimeMilliseconds(); }
   public void setReqTime() { this.reqTime = DateUtils.getNowDateTimeMilliseconds(); }
   public void setResTime() { this.resTime = DateUtils.getNowDateTimeMilliseconds(); }

    public String getSeqForLog() {
        return "[" + this.getSeqId() + "] ";
    }

    public String ToString() {
        StringBuilder sb = new StringBuilder();

        /*************************필수값*************************************/
        sb.append("SEQ_ID=").append(seqId).append("|");
        sb.append("LOG_TIME=").append(logTime).append("|");
        sb.append("LOG_TYPE=").append(logTime).append("|");
        sb.append("SID=").append(sid).append("|");
        sb.append("RESULT_CODE=").append(ObjectUtils.isEmpty(resultCode) ? "" : resultCode.value()).append("|");
        sb.append("REQ_TIME=").append(reqTime).append("|");
        sb.append("RSP_TIME=").append(resTime).append("|");
        sb.append("SVC_NAME=").append(svcName);

        return sb.toString();
    }

}
