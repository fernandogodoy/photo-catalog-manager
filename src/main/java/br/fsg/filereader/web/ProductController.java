package br.fsg.filereader.web;

import br.fsg.filereader.model.Product;
import br.fsg.filereader.model.Directory;
import br.fsg.filereader.repository.jpa.ProductJpaRepository;
import br.fsg.filereader.repository.jpa.DirectoryJpaRepository;
import br.fsg.filereader.enumerator.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductJpaRepository productRepository;
    
    @Autowired
    private DirectoryJpaRepository directoryRepository;

    @GetMapping
    public String listProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "products/list";
    }
    
    @GetMapping("/available")
    public String listAvailableProducts(Model model) {
        List<Product> products = productRepository.findByStatus(Status.DISPONIVEL);
        model.addAttribute("products", products);
        model.addAttribute("statusFilter", "available");
        return "products/list";
    }
    
    @GetMapping("/sold")
    public String listSoldProducts(Model model) {
        List<Product> products = productRepository.findByStatus(Status.VENDIDO);
        model.addAttribute("products", products);
        model.addAttribute("statusFilter", "sold");
        return "products/list";
    }
    
    @GetMapping("/reserved")
    public String listReservedProducts(Model model) {
        List<Product> products = productRepository.findByStatus(Status.RESERVADO);
        model.addAttribute("products", products);
        model.addAttribute("statusFilter", "reserved");
        return "products/list";
    }
    
    @GetMapping("/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "products/view";
        }
        return "redirect:/products";
    }
    
    @PostMapping("/{id}/reserve")
    public String reserveProduct(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product p = product.get();
            p.reserve();
            productRepository.save(p);
        }
        return "redirect:/products";
    }
    
    @PostMapping("/{id}/provide")
    public String provideProduct(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product p = product.get();
            p.provide();
            productRepository.save(p);
        }
        return "redirect:/products";
    }
    
    @PostMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/products";
    }
    
    @GetMapping("/search")
    public String searchProducts(@RequestParam(required = false) String q, Model model) {
        List<Product> products;
        if (q != null && !q.trim().isEmpty()) {
            products = productRepository.findByUuidContainingOrDirectoryDescriptionContaining(q);
        } else {
            products = productRepository.findAll();
        }
        model.addAttribute("products", products);
        model.addAttribute("searchQuery", q);
        return "products/list";
    }
}