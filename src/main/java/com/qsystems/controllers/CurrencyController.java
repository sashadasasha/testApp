package com.qsystems.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qsystems.persists.Currency;
import com.qsystems.persists.CurrencyRepository;
import com.qsystems.utils.JSONWriter;
import com.qsystems.utils.RequestBodyFromClient;
import com.qsystems.utils.ResponseJsonFromServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Created by Kornyukhina Sasha
 */
@Controller
public class CurrencyController {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyController.class);
    /**
     * Просто будем считать, что текущая дата - 4 сентября 2020 года,
     * потому что у нас сформированная таблица с данными (по тз так), а мы не получаем их свежими.
     * Дата приходит от клиента
     */
    private static LocalDate currentDate;

    @Autowired
    private CurrencyRepository currencyRepository;

    @RequestMapping("/")
    public String index(Model model) {
        logger.info("Main page loaded");
        ArrayList<Currency> currencyList = new ArrayList<>();
        currencyRepository.findAll().forEach(currency->{
            currencyList.add(currency);
        });
        model.addAttribute("currencies", currencyList);
        return "index";
    }

    @RequestMapping (value = "/currentDate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String currentCourse(@RequestBody RequestBodyFromClient body) throws JsonProcessingException {
        Currency targetCurrency = currencyRepository.findById(Integer.parseInt(body.getId())).get();
        currentDate = LocalDate.parse(body.getDate(), DateTimeFormatter.ISO_DATE_TIME);
        ResponseJsonFromServer jsonFromServer = new ResponseJsonFromServer();
        targetCurrency.getList().forEach(val ->{
            if (val.getDate().equals(currentDate)) {
               jsonFromServer.setCurrentDate(val.getDate().toString());
               jsonFromServer.setCurrentValue(val.getCurrencyValue());
            } else if (val.getDate().equals(currentDate.minusDays(1))) {
                jsonFromServer.setDayBeforeDate(val.getDate().toString());
                jsonFromServer.setDayBeforeValue(val.getCurrencyValue());
            } else if (val.getDate().equals(currentDate.minusDays(2))) {
                jsonFromServer.setTwoDaysBeforeDate(val.getDate().toString());
                jsonFromServer.setTwoDaysBeforeValue(val.getCurrencyValue());
            }
        });
        logger.info("Get current course");
        return JSONWriter.getJSONFromObject(jsonFromServer);
    }

}
