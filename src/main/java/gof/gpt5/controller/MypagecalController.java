package gof.gpt5.controller;

import gof.gpt5.dto.MypagecalDto;
import gof.gpt5.service.MypagecalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MypagecalController {

    @Autowired
    MypagecalService serivce;

    @PostMapping(value = "/addcal")
    public String addcal(MypagecalDto dto){
        System.out.println("MypagecalController addcal" + new Date());
        System.out.println(dto);

        boolean b = serivce.addcal(dto);
        if(!b){
            return "NO";
        }
        return "YES";
    }
}
