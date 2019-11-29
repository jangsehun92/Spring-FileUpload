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
	
	//파일업로드 완료(년월일시분 별 폴더 생성 후 저장)
	//업로드시 파일 선택 안했다면 뷰단에서 경고(ajax로 처리해도됨)
	//파일저장에 성공 또는 실패 했다면 로직 추가
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String fileUpload(Model model, @RequestParam("file")MultipartFile file) {
		fileService.save(file);
		return "fileUpload";
	}
	
	//파일 다운로드
	
}
