package com.group.libraryapp.controller.practice;

import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import com.group.libraryapp.dto.practice.CalculatorSumRequest;
import com.group.libraryapp.dto.practice.DateResponseDTO;
import com.group.libraryapp.dto.practice.PlusMinusMultiplyRequest;
import com.group.libraryapp.dto.practice.PlusMinusMultiplyResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlusMinusMultiply {

    @GetMapping("/api/v1/calc")
    public PlusMinusMultiplyResult addTwoNumber(@RequestParam int num1, int num2){
        return new PlusMinusMultiplyResult(num1,num2);
    }

    @GetMapping("/api/v1/day-of-the-week")
    public DateResponseDTO getDate(@RequestParam String date){
        DateResponseDTO dateResponseDTO = new DateResponseDTO(date);
        return dateResponseDTO;
    }

    @PostMapping("/api/v1/addNums")
    public int getSum(@RequestBody CalculatorSumRequest rq){
        return rq.getNumbers()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
