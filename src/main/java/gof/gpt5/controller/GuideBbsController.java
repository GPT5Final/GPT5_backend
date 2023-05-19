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

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import gof.gpt5.dto.GuideBbsDto;
import gof.gpt5.dto.GuideBbsParamDto;
import gof.gpt5.service.GuideBbsService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class GuideBbsController {

	@Autowired
	GuideBbsService service;

	@PostMapping(value = "/addGuide")
	public String addGuide(GuideBbsDto dto) {
		System.out.println("GuideController addGuide " + new Date());

		dto.setFilename(null);

		boolean isS = service.addGuideBbs(dto);

		if (isS) {
			return "SUCCESS";
		}

		return "FAIL";
	}

	@PostMapping(value = "/GuideFileUpload")
	public String fileUpload(GuideBbsDto dto, @RequestParam("files") List<MultipartFile> files,
			HttpServletRequest req) throws Exception {
		// System.out.println("GuideController fileUpload " + new Date());
		// System.out.println(dto.toString());
		// 경로
		String folderPath = "src/main/resources/static/GuideImages/";
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

		boolean isS = service.addGuideFileBbs(dto);
		if (isS) {
			System.out.println("fileUpload SUCCESS");
			return "SUCCESS";
		}
		return "FAIL";

	}

	@PostMapping(value = "/GuideBbs")
	public Map<String, Object> getGuideBbsList(GuideBbsParamDto param) {
		System.out.println("GuideController GuideBbs " + new Date());

		int pn = param.getPageNumber();
		int start = 1 + (pn * 10);
		int end = (pn + 1) * 10;

		param.setStart(start);
		param.setEnd(end);

		 System.out.println(param.toString());

		List<GuideBbsDto> list = service.GuideBbs(param);
		int len = service.getGuideCount(param);

		//System.out.println(list);
		System.out.println(len);

		Map<String, Object> map = new HashMap<>();

		map.put("list", list);
		map.put("cnt", len);

		return map;

	}

	@PostMapping(value = "/getGuideBbs")
	public Map<String, Object> getGuideBbs(int seq, HttpServletRequest req) throws Exception {
		System.out.println("GuideController getGuideBbs " + new Date());

		GuideBbsDto dto = service.getGuideBbs(seq);

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
			filenames = "89b3e1dc_이미지없음.png";
			
			List<String> list = new ArrayList<>();
			
			list.add(filenames);
			
			Map<String, Object> map = new HashMap<>();
			map.put("list", list);
			map.put("dto", dto);
			
			
			return map;
		}	
	
	}
	

	@PostMapping(value = "/deleteGuideBbs")
	public String deleteGuideBbs(int seq) {
		System.out.println("GuideController deleteGuideBbs " + new Date());

		System.out.println(seq);

		boolean isS = service.deleteGuideBbs(seq);

		if (isS) {
			return "SUCCESS";
		}

		return "FAIL";

	}
	
	
}
