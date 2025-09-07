package br.fsg.filereader.web;

import br.fsg.filereader.model.Sale;
import br.fsg.filereader.model.Product;
import br.fsg.filereader.repository.jpa.SaleJpaRepository;
import br.fsg.filereader.repository.jpa.ProductJpaRepository;
import br.fsg.filereader.enumerator.Status;
import br.fsg.filereader.type.Money;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Controller
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleJpaRepository saleRepository;
    
    @Autowired
    private ProductJpaRepository productRepository;

    @GetMapping
    public String listSales(Model model) {
        List<Sale> sales = saleRepository.findAllOrderByDateDesc();
        model.addAttribute("sales", sales);
        return "sales/list";
    }
    
    @GetMapping("/new")
    public String newSale(Model model) {
        List<Product> availableProducts = productRepository.findByStatus(Status.DISPONIVEL);
        model.addAttribute("availableProducts", availableProducts);
        model.addAttribute("sale", new Sale());
        return "sales/form";
    }
    
    @PostMapping
    public String createSale(@RequestParam String client,
                           @RequestParam String address,
                           @RequestParam String amount,
                           @RequestParam String quantity,
                           @RequestParam List<Long> productIds,
                           Model model) {
        try {
            List<Product> products = new ArrayList<>();
            for (Long productId : productIds) {
                Optional<Product> product = productRepository.findById(productId);
                if (product.isPresent()) {
                    products.add(product.get());
                }
            }
            
            Sale sale = new Sale.Builder()
                    .withClient(client)
                    .withEndereco(address)
                    .withAmount(amount)
                    .withQuantity(quantity)
                    .withProducts(products)
                    .build();
                    
            saleRepository.save(sale);
            
            return "redirect:/sales";
        } catch (Exception e) {
            model.addAttribute("error", "Erro ao criar venda: " + e.getMessage());
            List<Product> availableProducts = productRepository.findByStatus(Status.DISPONIVEL);
            model.addAttribute("availableProducts", availableProducts);
            model.addAttribute("sale", new Sale());
            return "sales/form";
        }
    }
    
    @GetMapping("/{id}")
    public String viewSale(@PathVariable Long id, Model model) {
        Optional<Sale> sale = saleRepository.findById(id);
        if (sale.isPresent()) {
            model.addAttribute("sale", sale.get());
            return "sales/view";
        }
        return "redirect:/sales";
    }
    
    @PostMapping("/{id}/deliver")
    public String deliverSale(@PathVariable Long id) {
        Optional<Sale> sale = saleRepository.findById(id);
        if (sale.isPresent()) {
            Sale s = sale.get();
            s.delivered();
            saleRepository.save(s);
        }
        return "redirect:/sales";
    }
    
    @GetMapping("/history")
    public String salesHistory(Model model) {
        List<Sale> sales = saleRepository.findAllOrderByDateDesc();
        model.addAttribute("sales", sales);
        return "sales/history";
    }
}