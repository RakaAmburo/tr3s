package com.project.tres.controller;

import java.io.File;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import org.apache.commons.io.FileUtils;

@RestController
public class Restart {
	
	@GetMapping("/restart")
	  public String retrieveAllStudents() {
		File f = new File("restart");
		f.setLastModified(System.currentTimeMillis());
	    return "Restarting";
	  }

}
