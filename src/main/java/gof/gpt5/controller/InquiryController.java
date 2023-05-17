package gof.gpt5.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import gof.gpt5.dto.InquiryBbsDto;
import gof.gpt5.dto.InquiryParamDto;
import gof.gpt5.service.InquiryService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class InquiryController {

	@Autowired
	InquiryService service;

	@PostMapping(value = "/addInquiry")
	public String addInquiry(InquiryBbsDto dto) {
		System.out.println("InquiryController addInquiry " + new Date());

		dto.setFilename(null);

		boolean isS = service.addInquiryBbs(dto);

		if (isS) {
			return "SUCCESS";
		}

		return "FAIL";
	}

	@PostMapping(value = "/imgFileUpload")
	public String imgFileUpload(InquiryBbsDto dto, @RequestParam("files") List<MultipartFile> files,
			HttpServletRequest req) throws Exception {
		// System.out.println("InquiryController fileUpload " + new Date());
		// System.out.println(dto.toString());
		// 경로
		String folderPath = "src/main/resources/static/inqImages/";
		Path currentPath = Paths.get("").toAbsolutePath();
		String absoluteFolderPath = currentPath.resolve(folderPath).toString();
		File folder = new File(absoluteFolderPath);

		if (!folder.exists()) {
			boolean result = folder.mkdirs();
			// System.out.println("폴더 생성 결과: " + result);
		}

		String longFilename = "";

		for (MultipartFile file : files) {
			String uuid = UUID.randomUUID().toString().substring(0, 8);
			String originalFilename = file.getOriginalFilename();
			String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
			String filename = uuid + "_" + originalFilename.substring(0, originalFilename.lastIndexOf(".")) + extension;

			longFilename += filename + "+";

			File destinationFile = new File(absoluteFolderPath, filename);
			// System.out.println("폴더 경로: " + folderPath);
			// System.out.println("절대 폴더 경로: " + absoluteFolderPath);

			try {
				// 이미지 파일을 폴더에 저장
				file.transferTo(destinationFile);
			} catch (IOException e) {
				// 여기에 예외 메시지 출력 코드 추가
				System.out.println("파일 저장 중 예외 발생: " + e.getMessage());
				e.printStackTrace();
				return "NO";
			}

		}

		dto.setFilename(longFilename.substring(0, longFilename.length() - 1));

		System.out.println(longFilename);

		boolean isS = service.addInquiryFileBbs(dto);
		if (isS) {
			System.out.println("fileUpload SUCCESS");
			return "SUCCESS";
		}
		return "FAIL";
		
	}

	@PostMapping(value = "/InquiryBbs")
	public Map<String, Object> getInquiryBbsList(InquiryParamDto param) {
		System.out.println("InquiryController InquiryBbs " + new Date());

		int pn = param.getPageNumber();
		int start = 1 + (pn * 10);
		int end = (pn + 1) * 10;

		param.setStart(start);
		param.setEnd(end);

		// System.out.println(param.toString());

		List<InquiryBbsDto> list = service.InquiryBbs(param);
		int len = service.getInquiryCount(param);

		// System.out.println(list);
		// System.out.println(len);

		Map<String, Object> map = new HashMap<>();

		map.put("list", list);
		map.put("cnt", len);

		return map;

	}

	@PostMapping(value = "/getInquiryBbs")
	public Map<String, Object> getInquiryBbs(int seq, HttpServletRequest req) throws Exception {
		System.out.println("InquiryController getInquiryBbs " + new Date());

		InquiryBbsDto dto = service.getInquiryBbs(seq);

		String filenames = dto.getFilename();

		if (filenames != null) {
			String[] fileArr = filenames.split("\\+");

			List<String> list = new ArrayList<>();

			for (String filename : fileArr) {
				list.add(filename);
			}

			Map<String, Object> map = new HashMap<>();
			map.put("list", list);
			map.put("dto", dto);

			return map;

		}else {
			filenames = "a3fbe4f7_이미지없음.png";

			List<String> list = new ArrayList<>();

			list.add(filenames);

			Map<String, Object> map = new HashMap<>();
			map.put("list", list);
			map.put("dto", dto);


			return map;
		}

	}
	
	@PostMapping(value = "/deleteInquiryBbs")
	public String deleteInquiryBbs(int seq) {
		System.out.println("InquiryController deleteInquiryBbs " + new Date());
		
		System.out.println(seq);
		
		
		boolean isS = service.deleteInquiryBbs(seq);
		
		if(isS) {
			return "SUCCESS";
		}
		
		return "FAIL";

	}
	
	
}
