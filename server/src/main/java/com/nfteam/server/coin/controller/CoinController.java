package com.nfteam.server.coin.controller;

import com.nfteam.server.coin.service.CoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/coins")
@Slf4j
public class CoinController {

    private static final List<String> COIN = List.of("SOL", "BTC", "DOGE", "ETH", "ETC");
    private final CoinService coinService;


    @Scheduled(cron = "0 0 4 25 * *")
    @GetMapping("/withdraw-fee")
    public void getWithdrawFee() throws Exception {
        //insert,update
        coinService.saveFeeHistory(COIN);
        coinService.updateFee(COIN);
        log.info("withdraw-fee updated successfully!");
    }

}
