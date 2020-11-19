package com.emusicstore.controller;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class HomeController {
@Autowired
private ProductDao productDao;

private Path path;

@RequestMapping("/")
public String home() {
	return "home";
}

@RequestMapping("/productList")
public String getProducts(Model model) {
	List<Product> products = productDao.getAllProducts();
	model.addAttribute("products", products);
	return "productList";
}

@RequestMapping("/productList/viewProduct/{productId}")
public String viewProduct(@PathVariable Long productId, Model model) {
	Product product = productDao.getProductById(productId);
	model.addAttribute(product);
	return "viewProduct";
}

@RequestMapping("/admin")
public String adminPage() {
	return "admin";
	
}

@RequestMapping("admin/productInventory")
public String productInventory(Model model) {
	List<Product> products = productDao.getAllProducts();
	model.addAttribute("products", products);
	return "productInventory";
}

@RequestMapping("admin/productInventory/addProduct")
public String addProduct(Model model) {
	Product product = new Product();
	model.addAttribute("product", product);
	return "addProduct";
}

@PostMapping(value = "admin/productInventory/addProduct")
public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result,
                         HttpServletRequest request) {
	if (result.hasErrors()){
		return "addProduct";
	}
	productDao.addProduct(product);
	MultipartFile productImage = product.getProductImage();
	String rootDirectory = request.getSession().getServletContext().getRealPath("/");
	path = Paths.get(rootDirectory + "\\resources\\images\\" + product.getProductId() + ".png");
	if (productImage != null && !productImage.isEmpty()) {
		try {
			productImage.transferTo(new File(path.toString()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("product image saving failed.", e);
		}
	}
	return "redirect:/admin/productInventory";
}

@RequestMapping("admin/productInventory/deleteProduct/{id}")
public String deleteProduct(@PathVariable Long id, Model model, HttpServletRequest request) {
	String rootDirectory = request.getSession().getServletContext().getRealPath("/");
	path = Paths.get(rootDirectory + "\\resources\\images\\" + id + ".png");
	if (Files.exists(path)) {
		try {
			Files.delete(path);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("product image can not delete.", e);
		}
	}
	productDao.deleteProduct(id);
	return "redirect:/admin/productInventory";
}

@RequestMapping("/admin/productInventory/editProduct/{id}")
public String editProduct(@PathVariable("id") Long id, Model model) {
	Product product = productDao.getProductById(id);
	model.addAttribute(product);
	return "editProduct";
}
@PostMapping(value = "admin/productInventory/editProduct")
public String editProduct(@Valid @ModelAttribute("product") Product product,BindingResult result,
                          HttpServletRequest request) {
	if (result.hasErrors()){
		return "editProduct";
	}
	MultipartFile productImage = product.getProductImage();
	String rootDirectory = request.getSession().getServletContext().getRealPath("/");
	path = Paths.get(rootDirectory + "\\resources\\images\\" + product.getProductId() + ".png");
	if (productImage != null && !productImage.isEmpty()) {
		try {
			productImage.transferTo(new File(path.toString()));
		} catch (IOException e) {
			throw new RuntimeException("product image saving failed.", e);
		}
	}
	productDao.editProduct(product);
	return "redirect:/admin/productInventory";
}

}
