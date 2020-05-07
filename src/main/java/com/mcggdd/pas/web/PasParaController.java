package com.zifeng.pas.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zifeng.pas.entity.PasPara;
import com.zifeng.pas.mapper.PasParaMapper;

@RestController
@RequestMapping("/pasPara")
public class PasParaController {
	@Autowired
    PasParaMapper pasParaMapper;

	@GetMapping("getPasPara")
    public PasPara list() {
        return pasParaMapper.get();
    }
}
