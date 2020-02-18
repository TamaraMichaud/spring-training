package com.tamara.springboottraining1.service;

import java.util.Date;

public interface CalculateContent {

    void encryptMD5();
    void decryptMD5();
    String dateTransform(Date dateValue, String newFormat); // TODO: enum format options

}
