
package com.niit.FrontendProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.BackendProject.Dao.CartDao;
import com.niit.BackendProject.Dao.ProductDao;
import com.niit.BackendProject.Model.Cart;
import com.niit.BackendProject.Model.Product;

@Controller
public class HomeController {

	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/gallery")
	public String gallery(Model model)
	{
		List<Product> products=productDao.prodList();
		model.addAttribute("products", products);
		return "gallery";
	}
	
//	@RequestMapping("/viewcart")
//	public String viewCart(Model model)
//	{
//		List<Cart> carts=cartDao.cartList();
//		model.addAttribute("cart", carts);
//		return "viewcart";
//	}
}
