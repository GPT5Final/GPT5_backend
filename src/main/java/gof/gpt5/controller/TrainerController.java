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
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import gof.gpt5.dto.ImageDto;
import gof.gpt5.dto.TrainerDto;
import gof.gpt5.dto.TrainerLikeDto;
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

        for (TrainerDto trainer : trainers) {
            ImageDto firstImage = service.getFirstImage(trainer.getSeq());
            trainer.setFirstImage(firstImage);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("trainers", trainers);
        result.put("totalCount", totalCount);

        return result;
    }

    @GetMapping(value = "getTrainer")
    public TrainerDto getTrainer(int seq) {
        TrainerDto trainer = service.getTrainer(seq);
        List<ImageDto> allImages = service.getAllImages(seq);
        trainer.setImages(allImages);
        return trainer;
    }
    
    @GetMapping(value = "/topTrainer")
    public TrainerDto getTopTrainer() {
        TrainerDto trainer = service.getTopTrainer();
        ImageDto firstImage = service.getFirstImage(trainer.getSeq());
        trainer.setFirstImage(firstImage);
        return trainer;
    }
    
    

    @PostMapping(value = "/trainerwrite")
    public String trainerwrite(TrainerDto dto, @RequestParam("file") List<MultipartFile> files) {
        String folderPath = "src/main/resources/static/images/";
        Path currentPath = Paths.get("").toAbsolutePath();
        String absoluteFolderPath = currentPath.resolve(folderPath).toString();
        File folder = new File(absoluteFolderPath);

        if (!folder.exists()) {
            boolean result = folder.mkdirs();
            System.out.println("폴더 생성 결과: " + result);
        }
        // TrainerDto를 저장
        boolean b = service.writeTrainer(dto);
        if(!b) {
            return "NO";
        }

        for (MultipartFile file : files) {
            // 새로운 파일 이름 생성    	
            String uuid = UUID.randomUUID().toString().substring(0, 8);
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName = uuid + "_" + originalFilename.substring(0, originalFilename.lastIndexOf(".")) + extension;

            // 이미지 파일을 저장할 파일 객체를 생성
            File destinationFile = new File(absoluteFolderPath, newFileName);
            try {
                // 이미지 파일을 폴더에 저장
                file.transferTo(destinationFile);
            } catch (IOException e) {
                // 여기에 예외 메시지 출력 코드 추가
                System.out.println("파일 저장 중 예외 발생: " + e.getMessage());
                e.printStackTrace();
                return "NO";
            }
            
            // 이미지 파일 정보를 DTO에 설정
            ImageDto imageDto = new ImageDto();
            imageDto.settrainerSeq(dto.getSeq());
            imageDto.setFilename(originalFilename);
            imageDto.setNewfilename(newFileName);
            imageDto.setFilesize(file.getSize());

            // 이미지 파일 정보를 데이터베이스에 저장
            boolean imageInfoResult = service.writeImageInfo(imageDto);
            if (!imageInfoResult) {
                System.out.println("이미지 파일 정보 저장 실패");
                return "NO";
            }

            // 이미지 파일 경로를 TrainerDto에 설정
            dto.setFilename(file.getOriginalFilename());
            dto.setNewfilename(newFileName);

            // 여기에 저장 경로 및 파일 정보 출력 코드 추가
            System.out.println("원본 파일 이름: " + originalFilename);
            System.out.println("새로운 파일 이름: " + newFileName);
            System.out.println("저장 경로: " + folderPath + newFileName);
        }
        
        return "YES";
    }

    
    // 글 수정
    @PostMapping(value = "/trainerupdate")
    public String trainerupdate(TrainerDto dto, @RequestParam(value = "file", required = false) List<MultipartFile> files) {
        boolean isS = service.updateTrainer(dto);

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

                ImageDto imageDto = new ImageDto();
                imageDto.settrainerSeq(dto.getSeq());
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
    
    
    // 글 삭제
    @PostMapping(value = "trainerdelete")
    public String trainerdelete(int seq) {
        boolean b = service.deleteTrainer(seq);
        if(b == false) {
            return "NO";
        }
        return "YES";
    }

    @PostMapping(value = "/toggleLike", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> toggleLike(@RequestBody TrainerLikeDto dto) {
        System.out.println("toggleLike 요청: " + dto); // 요청 객체 출력
        int ptSeq = dto.getptSeq();
        String nickname = dto.getNickname();

        // ptSeq가 pt 테이블에 존재하는지 확인
        boolean existsPtSeq = service.existsPtSeq(ptSeq);
        if (!existsPtSeq) {
            // ptSeq가 pt 테이블에 존재하지 않는 경우 에러 메시지를 반환
            Map<String, Object> result = new HashMap<>();
            result.put("error", "Invalid ptSeq: " + ptSeq);
            return result;
        }

        boolean success = service.toggleLike(ptSeq, nickname); // 수정: isLiked 값 제거

        Map<String, Object> result = new HashMap<>();
        result.put("success", success);

        if (success) {
            int updatedLikes = service.countLikesByTrainer(ptSeq);
            result.put("updatedLikes", updatedLikes);
            System.out.println("Toggle Like 호출됨: ptSeq=" + ptSeq + ", nickname=" + nickname);
        }

        return result;
    }


}
