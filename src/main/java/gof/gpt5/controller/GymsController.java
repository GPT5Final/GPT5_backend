package gof.gpt5.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gof.gpt5.dto.GimageDto;
import gof.gpt5.dto.GymsDto;
import gof.gpt5.dto.GymsLikeDto;
import gof.gpt5.dto.ImageDto;
import gof.gpt5.dto.TrainerDto;
import gof.gpt5.dto.TrainerLikeDto;
import gof.gpt5.dto.TrainersParam;
import gof.gpt5.service.GymsService;

@RestController
public class GymsController {

    @Autowired
    GymsService service;

    @GetMapping(value = "gymslist")
    public Map<String, Object> gymsList(TrainersParam param, @RequestParam("nickname") String nickname) {
    	List<GymsDto> gyms = service.gymslist(param, nickname);
        int totalCount = service.getAllGyms(param);

        System.out.println(gyms.toString());
        for (GymsDto gym : gyms) {
        	
            GimageDto firstImage = service.getFirstImage(gym.getgSeq());
            gym.setFirstImage(firstImage);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("gyms", gyms);
        result.put("totalCount", totalCount);

        return result;
    }
    
    
    //TODO 조회
    @GetMapping(value = "getGym")
    public GymsDto getGym(int gSeq) {
    	GymsDto gym = service.getGym(gSeq);
        List<GimageDto> allImages = service.getAllImages(gSeq);
        gym.setImages(allImages);
        return gym;
    }
    
    @GetMapping(value = "/topGym")
    public GymsDto getTopGym() {
    	GymsDto gym = service.getTopGym();
        GimageDto firstImage = service.getFirstImage(gym.getgSeq());
        gym.setFirstImage(firstImage);
        return gym;
    }

    //TODO 생성
    @PostMapping(value = "/gymwrite")
    public String writeGyms(GymsDto gymsDto, @RequestParam("file") List<MultipartFile> files) {
    	int gSeq = -1;
    	String folderPath = "src/main/resources/static/images/";
        Path currentPath = Paths.get("").toAbsolutePath();
        String absoluteFolderPath = currentPath.resolve(folderPath).toString();
        File folder = new File(absoluteFolderPath);

        if (!folder.exists()) {
            boolean result = folder.mkdirs();
            System.out.println("폴더 생성 결과: " + result);
        }

        for (MultipartFile file : files) {
            String uuid = UUID.randomUUID().toString().substring(0, 8);
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName = uuid + "_" + originalFilename.substring(0, originalFilename.lastIndexOf(".")) + extension;

            File destinationFile = new File(absoluteFolderPath, newFileName);
            try {
                file.transferTo(destinationFile);
            } catch (IOException e) {
                System.out.println("파일 저장 중 예외 발생: " + e.getMessage());
                e.printStackTrace();
                return "NO";
            }

            gymsDto.setFilename(file.getOriginalFilename());
            gymsDto.setNewfilename(newFileName);
        

	        gSeq = service.writeGyms(gymsDto);
	        if(gSeq == -1) {
	            return "NO";
        	}
        }

        for (MultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            String newFileName = gymsDto.getNewfilename();

            GimageDto imageDto = new GimageDto();
            imageDto.setgimSeq(gSeq);
            imageDto.setFilename(originalFilename);
            imageDto.setNewfilename(newFileName);
            imageDto.setFilesize(file.getSize());

            boolean imageInfoResult = service.writeImageInfo(imageDto);
            if (!imageInfoResult) {
                System.out.println("이미지 파일 정보 저장 실패");
                return "NO";
            }
            System.out.println("원본 파일 이름: " + originalFilename);
            System.out.println("새로운 파일 이름: " + newFileName);
            System.out.println("저장 경로: " + folderPath + newFileName);
        }
        
        return "YES";
    }



    
    
    //TODO 수정
    @PostMapping(value = "/gymupdate")
    public String updateGym(@RequestParam("gymsDto") String gymsDtoStr, @RequestParam(value = "file", required = false) List<MultipartFile> files) throws JsonMappingException, JsonProcessingException {
    	GymsDto gymsDto = new ObjectMapper().readValue(gymsDtoStr, GymsDto.class);
        boolean isS = service.updateGym(gymsDto);

        if (!isS) {
            return "NO";
        }

        if (files != null && !files.isEmpty()) {
            String folderPath = "src/main/resources/static/images/";
            Path currentPath = Paths.get("").toAbsolutePath();
            String absoluteFolderPath = currentPath.resolve(folderPath).toString();
            File folder = new File(absoluteFolderPath);

            if (!folder.exists()) {
                boolean result = folder.mkdirs();
                System.out.println("폴더 생성 결과: " + result);
            }

            for (MultipartFile file : files) {
                String uuid = UUID.randomUUID().toString().substring(0, 8);
                String originalFilename = file.getOriginalFilename();
                String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
                String newFileName = uuid + "_" + originalFilename.substring(0, originalFilename.lastIndexOf(".")) + extension;

                File destinationFile = new File(absoluteFolderPath, newFileName);
                try {
                    file.transferTo(destinationFile);
                } catch (IOException e) {
                    System.out.println("파일 저장 중 예외 발생: " + e.getMessage());
                    e.printStackTrace();
                    return "NO";
                }

                GimageDto imageDto = new GimageDto();
                imageDto.setgimSeq(gymsDto.getgSeq());
                imageDto.setFilename(originalFilename);
                imageDto.setNewfilename(newFileName);
                imageDto.setFilesize(file.getSize());

                boolean imageInfoResult = service.writeImageInfo(imageDto);
                if (!imageInfoResult) {
                    System.out.println("이미지 파일 정보 저장 실패");
                    return "NO";
                }

                System.out.println("원본 파일 이름: " + originalFilename);
                System.out.println("새로운 파일 이름: " + newFileName);
                System.out.println("저장 경로: " + folderPath + newFileName);
            }
        }
        return "YES";
    }

    //TODO 삭제
    @PostMapping(value = "gymdelete")    
    public String deleteGyms(int gSeq) {
        boolean b = service.deleteGym(gSeq);
        if(b == false) {
            return "NO";
        }
        return "YES";
    }
    

    @PostMapping(value = "/gtoggleLike", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> gtoggleLike(@RequestBody GymsLikeDto dto) {
        System.out.println("gtoggleLike 요청: " + dto); // 요청 객체 출력
        int gymSeq = dto.getgymSeq();
        String nickname = dto.getNickname();
        
     // 테이블에 존재하는지 확인
        boolean existsGymSeq = service.existsGymSeq(gymSeq);
        if (!existsGymSeq) {
            // gymSeq가 테이블에 존재하지 않는 경우 에러 메시지를 반환
            Map<String, Object> result = new HashMap<>();
            result.put("error", "Invalid gymSeq: " + gymSeq);
            return result;
        }
        
        boolean success = service.gtoggleLike(gymSeq, nickname); // 수정: isLiked 값 제거

        Map<String, Object> result = new HashMap<>();
        result.put("success", success);

        if (success) {
            int updatedLikes = service.countLikesByGyms(gymSeq);
            result.put("updatedLikes", updatedLikes);
            System.out.println("Toggle Like 호출됨: gymSeq=" + gymSeq + ", nickname=" + nickname);
        }

        return result;
    }
}