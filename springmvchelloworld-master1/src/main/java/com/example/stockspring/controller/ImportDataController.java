package com.example.stockspring.controller;

import java.io.IOException;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.ExcelModel;

public interface ImportDataController {
	
	public ModelAndView fileUploadPage(); 
		public String fileUpload(@Validated ExcelModel file, BindingResult result, ModelMap model) throws IOException;

}
