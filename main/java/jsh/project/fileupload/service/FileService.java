package jsh.project.fileupload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	private static final String SAVE_PATH = "/Users/jangsehun/Documents/eclipse_workspace/fileUpload";
	private static final String PREFIX_URL = "/Users/jangsehun/Documents/eclipse_workspace/fileUpload/";
	
	public String restore(MultipartFile file) {
		String url = null;
		
		return url;
	}
	
	//실제로 파일을 처리하는 함수
	public boolean writerFile(MultipartFile file) {
		
		return true;
	}
}
