package com.security.lab7.auth;

import com.security.lab7.auth.dto.RegistrationForm;
import com.security.lab7.auth.dto.UserLoginForm;
import com.security.lab7.validators.RegistrationValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;
	private final RegistrationValidator registrationValidator;

	@InitBinder("registrationForm")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(registrationValidator);
	}

	@GetMapping("/registration")
	public String registrationPage(RegistrationForm registrationForm) {
		return "registration";
	}

	@PostMapping("/registration")
		public void register(@Valid RegistrationForm registrationForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return;
		}

		model.addAttribute("loginResult", authService.register(registrationForm));
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@PostMapping("/login")
	public void login(UserLoginForm loginForm, Model model) {
		model.addAttribute("loginResult", authService.login(loginForm));
	}
}
