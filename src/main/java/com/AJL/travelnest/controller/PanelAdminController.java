package com.AJL.travelnest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PanelAdminController {

	@GetMapping("panelAdmin")
	public String admin() {
		return "panelAdmin";
	}
}
