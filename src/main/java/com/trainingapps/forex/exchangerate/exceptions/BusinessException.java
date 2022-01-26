package com.trainingapps.forex.exchangerate.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException {

    private String errorCode;
    private String errorMessage;
}
