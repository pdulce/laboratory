package com.mylabs.pds.controller;

import com.mylabs.pds.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @GetMapping("/write")
    public String writeExcel() {
        try {
            excelService.writeToExcel();
            return "Datos escritos en Excel correctamente.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al escribir en Excel.";
        }
    }
}
