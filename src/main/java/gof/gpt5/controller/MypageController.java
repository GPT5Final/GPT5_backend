package gof.gpt5.controller;

import gof.gpt5.dto.MypageDto;
import gof.gpt5.naver.NaverCloud;
import gof.gpt5.service.MypageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

@RestController
public class MypageController {

    @Autowired
    MypageService serivce;

    @PostMapping(value = "/addcal")
    public String addcal(MypageDto dto){
        System.out.println("MypagecalController addcal" + new Date());
        System.out.println(dto);

        boolean b = serivce.addcal(dto);
        if(!b){
            return "NO";
        }
        return "YES";
    }

    // STT : 음성인식 wav -> string
    @PostMapping(value = "fileUpload")
    public String fileUpload(@RequestParam("uploadFile")MultipartFile uploadFile,
                             HttpServletRequest req) {
        System.out.println("NaverCloudController STT " + new Date());

        String uploadpath = req.getServletContext().getRealPath("/upload");

        String filename = uploadFile.getOriginalFilename();
        String filepath = uploadpath + "/" + filename;

        System.out.println(filepath);

        try {
            BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            os.write(uploadFile.getBytes());
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

        // Naver Cloud AI
        String resp = NaverCloud.stt(filepath);

        return resp;
    }

    @GetMapping(value = "tts_proc")
    public String tts_proc(String str, HttpServletRequest req) {
        System.out.println("NaverCloudController ttc_proc " + new Date());
        System.out.println("str:" + str);

        String path = req.getServletContext().getRealPath("/upload");

        boolean b = NaverCloud.tts(str, path);
        if(b == false) {
            return "NG";
        }

        return "OK";
    }

    @PostMapping(value = "chatBot")
    public String chatBot(String msg) {
        System.out.println("NaverCloudController chatBot " + new Date());

        String json = NaverCloud.chatBot(msg);
        return json;
    }

}
