package gof.gpt5.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import gof.gpt5.dto.TrainerDto;
import gof.gpt5.dto.TrainersParam;
import gof.gpt5.service.TrainerService;

@RestController
public class TrainerController {
    @Autowired
    TrainerService service;

    @GetMapping(value = "trainerlist")
    public Map<String, Object> trainerlist(TrainersParam param, @RequestParam("nickname") String nickname){
        List<TrainerDto> trainers = service.trainerlist(param, nickname);
        int totalCount = service.getAllTrainer(param);

        Map<String, Object> result = new HashMap<>();
        result.put("trainers", trainers);
        result.put("totalCount", totalCount);

        return result;
    }


    @GetMapping(value = "getTrainer")
    public TrainerDto getTrainer(int seq) {
        return service.getTrainer(seq);
    }
    

    @PostMapping(value = "/trainerwrite")
    public String trainerwrite(TrainerDto dto, @RequestParam("file") MultipartFile file) {
        // 이미지를 저장할 폴더 경로
    	String folderPath = "src/main/resources/static/images/";
    	Path currentPath = Paths.get("").toAbsolutePath();
    	String absoluteFolderPath = currentPath.resolve(folderPath).toString();
    	File folder = new File(absoluteFolderPath);

    	if (!folder.exists()) {
    	    boolean result = folder.mkdirs();
    	    System.out.println("폴더 생성 결과: " + result);
    	}

    	// 새로운 파일 이름 생성    	
    	String uuid = UUID.randomUUID().toString().substring(0, 8);
    	String originalFilename = file.getOriginalFilename();
    	String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
    	String newFileName = uuid + "_" + originalFilename.substring(0, originalFilename.lastIndexOf(".")) + extension;
//    	String newFileName = uuid + "_" + originalFilename.substring(0, originalFilename.lastIndexOf(".")) + extension.replaceFirst("\\.\\w+$", "");

        // 이미지 파일을 저장할 파일 객체를 생성
    	File destinationFile = new File(absoluteFolderPath, newFileName);
//    	File destinationFile = new File(absoluteFolderPath + newFileName);
    	System.out.println("폴더 경로: " + folderPath);
    	System.out.println("절대 폴더 경로: " + absoluteFolderPath);
        try {
            // 이미지 파일을 폴더에 저장
            file.transferTo(destinationFile);
        } catch (IOException e) {
            // 여기에 예외 메시지 출력 코드 추가
            System.out.println("파일 저장 중 예외 발생: " + e.getMessage());
            e.printStackTrace();
            return "NO";
        }

        // 이미지 파일 경로를 TrainerDto에 설정
        dto.setFilename(file.getOriginalFilename());
        dto.setNewfilename( newFileName);
//        dto.setFilename("resources/static/images/" + file.getOriginalFilename());
//        dto.setNewfilename("resources/static/images/" + newFileName);
//        dto.setFilename("images/" + file.getOriginalFilename());
//        dto.setNewfilename("images/" + newFileName);

        
        // 여기에 저장 경로 및 파일 정보 출력 코드 추가
        System.out.println("원본 파일 이름: " + originalFilename);
        System.out.println("새로운 파일 이름: " + newFileName);
        System.out.println("저장 경로: " + folderPath + newFileName);

        boolean b = service.writeTrainer(dto);
        if(!b) {
            return "NO";
        }
        return "YES";
    }


    
    
    
    // 글 수정
    @PostMapping(value = "/trainerupdate")
    public String trainerupdate(TrainerDto dto) {
        boolean isS = service.updateTrainer(dto);
        if (!isS) {
            return "NO";
        }
        return "YES";
    }
    
    // 글 삭제
    @PostMapping(value = "trainerdelete")
    public String trainerdelete(int seq) {
        boolean b = service.deleteTrainer(seq);
        if(b == false) {
            return "NO";
        }
        return "YES";
    }
    
    @PostMapping(value = "/toggleLike")
    public Map<String, Object> toggleLike(@RequestPart("pt_seq") int pt_seq,
                                          @RequestPart("nickname") String nickname,
                                          @RequestPart("isLiked") boolean isLiked) {

        boolean success = service.toggleLike(pt_seq, nickname, isLiked);

        Map<String, Object> result = new HashMap<>();
        result.put("success", success);

        if (success) {
            int updatedLikes = service.countLikesByTrainer(pt_seq);
            result.put("updatedLikes", updatedLikes);
        }

        return result;
    }

}
