package com.codegym.model.service;

import org.springframework.stereotype.Service;

@Service
public class ConCurrencyServiceImpl implements ConvertCurrencyService {

    @Override
    public double convert(String usd) {
        return Double.parseDouble(usd) * 23000;
    }
}
