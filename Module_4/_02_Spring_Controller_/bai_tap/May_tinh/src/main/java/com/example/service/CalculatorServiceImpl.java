package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double operator(double number1, double number2, String operator) {
        double result;
        switch (operator){
            case "Addition":
                result = number1 + number2;
                break;
            case "Subtraction":
                result = number1 - number2;
                break;
            case "Multiplication":
                result = number1*number2;
                break;
            default:
                result = number1/number2;
        }
        return result;
    }
}
