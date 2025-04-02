package com.daviddiazm.housing.category.infrastructure.scheduleds;

import com.daviddiazm.housing.category.domain.ports.in.HouseServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class HouseScheduled {
    private final HouseServicePort houseServicePort;

    @Scheduled(cron = "0 0 0 * * ?")
    public void updateStateTodayHouses () {
        houseServicePort.updateStateHouses();
    }
}
