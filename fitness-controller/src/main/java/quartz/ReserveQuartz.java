package quartz;

import mapper.CourseInstanceMapper;
import mapper.ReserveMapper;
import model.CourseInstance;
import model.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import service.ReserveService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class ReserveQuartz {

    @Autowired
    private ReserveMapper reserveMapper;

    @Autowired
    private CourseInstanceMapper courseInstanceMapper;

    //        @Scheduled(cron = "0/5 * * * * ? ")
    @Scheduled(cron = "0 0/30 * * * ? ")
    public void reserveCheck() {
        List<Reserve> reserves = reserveMapper.selectByExample(null);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date current = null;
        try {
            current = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        CourseInstance courseInstance;
        for (Reserve reserve : reserves) {
            courseInstance = courseInstanceMapper.selectByPrimaryKey(reserve.getCourseInstanceId());
            if (current.compareTo(courseInstance.getCourseTime()) > 0) {
                reserve.setStatus("已结束");
            } else if (current.compareTo(courseInstance.getCourseTime()) < 0) {
                reserve.setStatus("待开始");
            } else {
                reserve.setStatus("上课中");
            }
        }
    }
}
