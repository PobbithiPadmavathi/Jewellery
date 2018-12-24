package com.niit.FrontendProject.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.BackendProject.Dao.CartDao;
import com.niit.BackendProject.Dao.CartItemsDao;
import com.niit.BackendProject.Dao.UserDao;
import com.niit.BackendProject.Model.Cart;
import com.niit.BackendProject.Model.CartItems;
import com.niit.BackendProject.Model.User;

public class CartController
{
//	Product product;
//	@Autowired 
//	ProductDao productDao;
//	
	@Autowired 
	User user;
	@Autowired 
	UserDao userDao;
	
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	
	@Autowired
	CartItems cartItems;
	@Autowired
	CartItemsDao cartItemsDao;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/addtocart/{id}")
	public ModelAndView cart(@PathVariable("id") String id) 
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
	User u = userDao.getUseremail(currusername);
	if (user == null)
	{
		return new ModelAndView("redirect:/");
	} 
	else
	{
		cart = u.getCart();
//		Product product1 = productDao.get(id);
		CartItems cartItem = new CartItems();
		cartItem.setCart(cart);
//		cartItem.setProduct(product1);
//		cartItem.setPrice(product1.getPrice());
		cartItemsDao.saveorupdate(cartItem);
//		cart.setGrandtotal(cart.getGrandtotal() + product1.getPrice());
		cart.setTotalItems(cart.getTotalItems() + 1);
		cartDao.saveorupdate(cart);
		session.setAttribute("items", cart.getTotalItems());
		session.setAttribute("gd", cart.getGrandTotal());
		return new ModelAndView("redirect:/");
		}
		}
		else {
			return new ModelAndView("redirect:/");
		}
	}
	
	@RequestMapping(value = "/viewcart")
	public String viewcart(Model model, HttpSession session) 
	{
		System.out.println(1223);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken))
		{
			String currusername = authentication.getName();
			User u = userDao.getUseremail(currusername);
		        Cart c=u.getCart();
				List<CartItems> cartItem = cartItemsDao.cartItemsList();
				if(cartItem==null ||cartItem.isEmpty())
				{
					session.setAttribute("items",0);
					model.addAttribute("gtotal",0.0);
					model.addAttribute("msg", "no Items is added to cart");
					return "viewcart";		
				}
				
				model.addAttribute("cartItems", cartItem);
				model.addAttribute("gtotal",c.getGrandTotal());
				session.setAttribute("items",c.getTotalItems());
			    session.setAttribute("cartId", c.getCartId());
				return "viewcart";		
	}
//		else
//		{
			return "redirect:/viewcart";
//		}
	}
	
	@RequestMapping(value="/Remove/{carId}")
	public ModelAndView RemoveFromCart(@PathVariable("carId") String id)
	{
		ModelAndView obj= new ModelAndView("redirect:/viewcart");
		cartItems=cartItemsDao.get(id);
		Cart c=cartItems.getCart();
		c.setGrandTotal(c.getGrandTotal()-cartItems.getPrice());
		c.setTotalItems(c.getTotalItems()-1);
		cartDao.saveorupdate(c);
		
		cartItemsDao.delete(cartItems);
		return obj;
	}
	
	@RequestMapping(value="/Removeall")
	public String RemoveallFromCart(Model model,HttpSession session)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken))
		{
			String currusername = authentication.getName();
			User u = userDao.getUseremail(currusername);
		Cart c=cartDao.getCart(u.getCart().getCartId());
		List<CartItems> cartItems=cartItemsDao.getCartItemsList(u.getCart().getCartId());
		for(CartItems g:cartItems)
		{
			cartItemsDao.delete(g);
		}
		c.setGrandTotal(0.0);;
		c.setTotalItems(0);
		cartDao.saveorupdate(c);
		session.setAttribute("items",c.getTotalItems());
		return "redirect:/viewcart";
	}
		else
		{
			return "redirect:/";
		}
	}
	
//	@RequestMapping("/addtocartR/{p_id}")
//	public ModelAndView cart(@PathVariable("p_id") String id) {
//
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (!(authentication instanceof AnonymousAuthenticationToken)) {
//			String currusername = authentication.getName();
//			User u = userDao.getUseremail(currusername);
//			if (user == null) {
//				return new ModelAndView("redirect:/");
//			} else {
//
//				cart = u.getCart();
//				product = productDao.getProduct(id);
//				CartItems cartItem = new CartItems();
//				cartItem.setCart(cart);
//				cartItem.setProduct(product);
//				cartItem.setPrice(product.getP_c());
//				cartItemDao.saveOrUpdate(cartItem);
//				cart.setGrandtotal(cart.getGrandtotal() + product.getP_c());
//				cart.setTotalitems(cart.getTotalitems() + 1);
//				cartDao.saveOrUpdate(cart);
//				session.setAttribute("items", cart.getTotalitems());
//				session.setAttribute("gd", cart.getGrandtotal());
//				return new ModelAndView("redirect:/viewcart");
//			}
//		} else {
//			return new ModelAndView("redirect:/");
//		}
//
//	}
//	@RequestMapping("/addtocartC/{p_id}")
//	public ModelAndView cartc(@PathVariable("p_id") String id) {
//
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (!(authentication instanceof AnonymousAuthenticationToken)) {
//			String currusername = authentication.getName();
//			User u = userDao.getUseremail(currusername);
//			if (user == null) {
//				return new ModelAndView("redirect:/");
//			} else {
//
//				cart = u.getCart();
//				product = productDao.getProduct(id);
//				CartItems cartItem = new CartItems();
//				cartItem.setCart(cart);
//				cartItem.setProduct(product);
//				cartItem.setPrice(product.getP_c());
//				cartItemDao.saveOrUpdate(cartItem);
//				cart.setGrandtotal(cart.getGrandtotal() + product.getP_c());
//				cart.setTotalitems(cart.getTotalitems() + 1);
//				cartDao.saveOrUpdate(cart);
//				session.setAttribute("items", cart.getTotalitems());
//				session.setAttribute("gd", cart.getGrandtotal());
//				return new ModelAndView("redirect:/viewcart");
//			}
//		} else {
//			return new ModelAndView("redirect:/");
//		}
//
//	}


}


