package com.charter.rewards.service;


import com.charter.rewards.controller.entity.CustomerTransaction;
import com.charter.rewards.controller.entity.RewardPoints;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RewardsService {
    private final Logger logger = LogManager.getLogger(this.getClass());
    public RewardPoints getRewards(int customerId){
        logger.info("getRewards() -> customerId: {} ", customerId);
//        CustomerTransaction
        CustomerTransaction customerTransaction = getcustomerTransaction(customerId);
        return caluclateRewardsPoints(customerTransaction);
    }

    private CustomerTransaction  getcustomerTransaction(int customerId){
        CustomerTransaction customerTransaction = new CustomerTransaction();
        LocalDate currentDate = LocalDate.now();
        logger.info("getcustomerTransaction() -> currentDate: {}", currentDate);
        customerTransaction.setCustomerId(customerId);
        customerTransaction.setTransactionDate(currentDate);
        customerTransaction.setAmount(120.0);
        return customerTransaction;
    }

    private RewardPoints caluclateRewardsPoints(CustomerTransaction customerTransaction){
        int rewardPoints = 0;
        try {
            if(!String.valueOf(customerTransaction.getAmount()).isEmpty()){
                int amount = (int)customerTransaction.getAmount();
                int quotient = amount/100;
                int remainder = amount % 100;

                rewardPoints = quotient*2;
                if(remainder>50){
                    rewardPoints = rewardPoints+1;
                }
            }
        }catch (Exception e){
            logger.error(e);
        }
        RewardPoints rewardPointsData = new RewardPoints();
        rewardPointsData.setCustomerId(customerTransaction.getCustomerId());
        rewardPointsData.setMonth(customerTransaction.getTransactionDate().getMonth().toString());
        rewardPointsData.setYear(String.valueOf(customerTransaction.getTransactionDate().getYear()));
        rewardPointsData.setPoints(rewardPoints);
        logger.info("caluclateRewardsPoints() -> {}", rewardPointsData);
        return rewardPointsData;
    }
}
