package br.com.icardapio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.icardapio.entity.Product;
import br.com.icardapio.entity.User;
import br.com.icardapio.util.CustomUserDetails;
import br.com.icardapio.util.LogoutSuccessHandlerVh;
import br.com.icardapio.util.TargetURL;

@Controller
public class LoginController {

	@RequestMapping(value = "{tenant}/login", method = RequestMethod.GET)
	public String login_map(@PathVariable String tenant, Model model, final RedirectAttributes redirectAttributes) {
		User user = new User();
		model.addAttribute("subdomain", tenant);
		model.addAttribute("user", user);
		model.addAttribute("error", "false");
		TargetURL.setDefaultUrl(tenant);
		return "login";
	}

	@RequestMapping(value = "{tenant}/postLogin", method = RequestMethod.POST)
	public String login_injection(@PathVariable String tenant, @ModelAttribute("user") User user, Model model,
			HttpSession session) {

		model.addAttribute("tenant", tenant);
		model.addAttribute("user", user);

		TargetURL.setDefaultUrl(tenant);

		// read principal out of security context and set it to session
		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) 
				SecurityContextHolder.getContext().getAuthentication();
		validatePrinciple(authentication.getPrincipal());
		User loggedInUser = ((CustomUserDetails) authentication.getPrincipal()).getUserDetails();
		model.addAttribute("currentUser", loggedInUser.getUsername());
		session.setAttribute("userId", loggedInUser.getId());
		return "redirect:/" + tenant;

	}

	private void validatePrinciple(Object principal) {
		if (!(principal instanceof CustomUserDetails)) {
			throw new IllegalArgumentException("Principal can not be null!");
		}
	}

	@RequestMapping(value = "{tenant}/loginError", method = RequestMethod.GET)
	public String loginError(@PathVariable String tenant, Model model) {
		model.addAttribute("error", "true");
		TargetURL.setDefaultUrl(tenant);
		return "login";
	}

	@RequestMapping(value = "{tenant}/logout", method = RequestMethod.GET)
	public void logout(@PathVariable String tenant, HttpServletRequest request, HttpServletResponse response) {
		TargetURL.setDefaultUrl(tenant);
		LogoutSuccessHandlerVh efetuaLogout = new LogoutSuccessHandlerVh();
		try {
			efetuaLogout.onLogoutSuccess(request, response, SecurityContextHolder.getContext().getAuthentication());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@PreAuthorize("hasRole('admin')")
	@RequestMapping(value = "/{tenant}/addProduct", method = RequestMethod.POST)
	public String addProduct(@PathVariable String tenant, @ModelAttribute("product") Product product, Model model,
			final RedirectAttributes redirectAttributes) {
		//product = restaurantService.addProduct(product);
		model.addAttribute("product", product);
		redirectAttributes.addFlashAttribute("message", "Produto adicionado com sucesso");
		return "redirect:/" + tenant;
	}

	/*
	 * @PreAuthorize("hasRole('admin')")
	 * 
	 * @RequestMapping(value = "/addProduct", method = RequestMethod.POST) public
	 * String addProduct(@ModelAttribute("product") Product product, Model model,
	 * final RedirectAttributes redirectAttributes) { product =
	 * facade.addProduct(product); model.addAttribute("product", product);
	 * 
	 * redirectAttributes.addFlashAttribute("message",
	 * "Produto adicionado com sucesso"); return "redirect:/"; }
	 */

	@PreAuthorize("hasRole('admin')")
	@RequestMapping(value = "{tenant}/removeProduct", method = RequestMethod.GET)
	public String removeProduct(@PathVariable String tenant, @ModelAttribute("categoryId") Long categoryId,
			@ModelAttribute("productId") Long productId, final RedirectAttributes redirectAttributes) {
		//restaurantService.removeProduct(categoryId, productId);
		TargetURL.setDefaultUrl(tenant);
		redirectAttributes.addFlashAttribute("message", "Produto removido com sucesso");
		return "redirect:/" + tenant;
	}

}
