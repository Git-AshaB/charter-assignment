package com.charter.rewards.controller;

import com.charter.rewards.controller.entity.RewardPoints;
import com.charter.rewards.service.RewardsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RewardsController {
    @Autowired
    RewardsService rewardsService;

    private final Logger logger = LogManager.getLogger(this.getClass());
    @GetMapping("/rewards/{id}")
    public ResponseEntity<RewardPoints> getRewards(@PathVariable int id){
        logger.info("getRewards() -> {} ", id);
        RewardPoints rewardPointsData = rewardsService.getRewards(id);

        HttpHeaders header = new HttpHeaders();
        return new ResponseEntity<>(rewardPointsData, header, HttpStatus.OK);
    }
}
