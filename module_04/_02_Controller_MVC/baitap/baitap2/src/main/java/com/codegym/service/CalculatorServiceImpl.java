package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{

    @Override
    public String Calculator(float firstNumber, float secondNumber, String operation) {
        String result="";
        try {

            switch (operation) {
                case "+":
                    result =  ""+(firstNumber + secondNumber);
                    break;
                case "-":
                    result = "" + (firstNumber - secondNumber);
                    break;
                case "*":
                    result = "" + (firstNumber * secondNumber);
                    break;
                case "/":
                    result = "" + (firstNumber / secondNumber);
                    break;
            }
        }
        catch (Exception e){
                result = "Error"+ e.getMessage();

        }
        return result;
    }
}
