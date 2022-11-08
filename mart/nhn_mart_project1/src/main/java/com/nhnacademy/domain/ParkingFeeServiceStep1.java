package com.nhnacademy.parking.parkingSystem;

import com.nhnacademy.parking.car.Car;
import com.nhnacademy.parking.exceptions.InvalidEnterTimeException;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Slf4j
public class ParkingFeeServiceStep1 implements ParkingFee {
    private static final Logger logger = LogManager.getLogger(ParkingFeeServiceStep1.class);

    public long calParkingFee(LocalDateTime enterTime, LocalDateTime exitTime) {
        if (logger.isInfoEnabled()) {
            log.info("\nEnter Time: {}. \nExit Time:  {}.", enterTime, exitTime);
        }
        // 최대 금액 계산,일일 최대 요금 * 주차일(day) 수
        // 주차일 수는 가 아닌 24:00 정각을 넘었느냐 기준이 아닌 24시간이 지났냐 기준.
        long parkingDay = ChronoUnit.DAYS.between(enterTime, exitTime);

        if (parkingDay < 0) {
            throw new InvalidEnterTimeException(enterTime);
        }

        long MaxFee = DAILY_MAX_FEE * (1 + parkingDay);
        if (logger.isDebugEnabled()) {
            log.debug("MaxFee: {}.", MaxFee);
        }

        // 총 주차 시간(초 단위)
        long parkingTime = Duration.between(enterTime, exitTime).getSeconds();
        long totalFee = BASE_FEE;

        if (parkingTime <= SECONDS_OF_MINUTE * FREE_TIME) {
            return 0;
        }

        if (parkingTime <= SECONDS_OF_MINUTE * BASE_TIME) {
            return totalFee;
        }

        parkingTime -= SECONDS_OF_MINUTE * BASE_TIME;

        totalFee += EXTRA_FEE * (parkingTime / (SECONDS_OF_MINUTE * EXTRA_MINUTE) +
                (parkingTime % (SECONDS_OF_MINUTE * EXTRA_MINUTE) == 0 ? 0 : 1));

        if (totalFee > MaxFee) {
            totalFee = MaxFee;
        }

        return totalFee;
    }

    public long calParkingFee(LocalDateTime enterTime, LocalDateTime exitTime, Car car) {
        return calParkingFee(enterTime, exitTime);
    }
}
