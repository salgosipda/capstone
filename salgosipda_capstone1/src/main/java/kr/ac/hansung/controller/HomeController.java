package kr.ac.hansung.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.hansung.model.Estate;
import kr.ac.hansung.service.EstateService;

@Controller
public class HomeController {

	@Autowired
	private EstateService estateservice;
	Estate estateee = new Estate();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws IOException, ParseException {

		//매물 크롤링
		//estateservice.insert(); 
		
		// DB���� �Ź� ��������
		List<Estate> estates = estateservice.getCurrent();

		// home.jsp ȣ��
		model.addAttribute("estates", estates);

		return "home";
	}

	

}
