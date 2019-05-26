package br.com.icardapio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.icardapio.entity.Category;
import br.com.icardapio.entity.Product;
import br.com.icardapio.entity.Restaurant;
import br.com.icardapio.multitenancy.CurrentTenantResolver;
import br.com.icardapio.service.CategoryService;
import br.com.icardapio.service.RestaurantService;
import br.com.icardapio.util.TargetURL;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CurrentTenantResolver<Long> tenantResolver;

	@RequestMapping("favicon.ico")
	@ResponseBody
	void Favicon() {
	}

	@RequestMapping("/{tenant}")
	public String home(@PathVariable String tenant, Model model) {
		Restaurant restaurant = restaurantService.getRestaurant();
		model.addAttribute("restaurant", restaurant);

		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);
		TargetURL.setDefaultUrl(tenant);
		return "home";
	}

	@RequestMapping("/")
	public String landing(@ModelAttribute("tenant") Restaurant tenant, Model model) {

		Restaurant master = restaurantService.getRestaurantbyId(tenantResolver.getMasterTenantId());
		model.addAttribute("restaurant", master);
		model.addAttribute("tenant", tenant);

		return "landing";
	}

	@RequestMapping(value = "/addRestaurant", method = RequestMethod.POST)
	public String addRestaurant(@ModelAttribute("tenant") Restaurant restaurant, Model model,
			final RedirectAttributes redirectAttributes) {
		restaurantService.addRestaurant(restaurant);
		return "redirect:" + getRestaurantFullUrl(restaurant);
	}

	@RequestMapping(value = "/createMasterData", method = RequestMethod.GET)
	public String createMasterData(final RedirectAttributes redirectAttributes) {
		restaurantService.createMasterData();
		redirectAttributes.addFlashAttribute("message", "Dados de teste criados com sucesso");
		return "redirect:/";
	}

	@ModelAttribute("tenant")
	public Restaurant getRestaurantObject() {
		return new Restaurant();
	}

	@ModelAttribute("product")
	public Product getProductObject() {
		return new Product();
	}

	protected String getRestaurantFullUrl(Restaurant restaurant) {
		return "https://icardapio.herokuapp.com/" + restaurant.getSubdomain();
		// mudar aqui a url para o deploy local
	}

}
