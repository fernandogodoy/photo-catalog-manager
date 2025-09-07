package br.fsg.filereader.web;

import br.fsg.filereader.model.Product;
import br.fsg.filereader.model.Sale;
import br.fsg.filereader.model.Directory;
import br.fsg.filereader.repository.jpa.ProductJpaRepository;
import br.fsg.filereader.repository.jpa.SaleJpaRepository;
import br.fsg.filereader.repository.jpa.DirectoryJpaRepository;
import br.fsg.filereader.enumerator.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductJpaRepository productRepository;
    
    @Autowired
    private SaleJpaRepository saleRepository;
    
    @Autowired
    private DirectoryJpaRepository directoryRepository;

    @GetMapping("/")
    public String home(Model model) {
        // Get dashboard statistics
        List<Product> allProducts = productRepository.findAll();
        List<Product> availableProducts = productRepository.findByStatus(Status.DISPONIVEL);
        List<Product> soldProducts = productRepository.findByStatus(Status.VENDIDO);
        List<Sale> recentSales = saleRepository.findAllOrderByDateDesc();
        List<Directory> directories = directoryRepository.findAll();
        
        model.addAttribute("totalProducts", allProducts.size());
        model.addAttribute("availableProducts", availableProducts.size());
        model.addAttribute("soldProducts", soldProducts.size());
        model.addAttribute("totalDirectories", directories.size());
        model.addAttribute("recentSales", recentSales.size() > 5 ? recentSales.subList(0, 5) : recentSales);
        
        return "index";
    }
}