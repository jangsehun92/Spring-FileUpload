package jsh.project.fileupload.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jsh.project.fileupload.service.FileService;

@Controller
public class FileController {
	private static final Logger logger = LoggerFactory.getLogger(FileController.class); 
	
	private final FileService fileService;
	
	public FileController(FileService fileService) {
		this.fileService = fileService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "fileUpload";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String fileUpload(Model model, @RequestParam("file")MultipartFile file) {
		if(file.getSize() == 0) {
			logger.info("업로드 할 파일이 없습니다.");
			return "fileUpload";
		}
		return fileService.save(file)?"fileUploadOk":"fileUpload";
	}
	
}
