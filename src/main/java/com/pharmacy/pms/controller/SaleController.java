package com.pharmacy.pms.controller;

import com.pharmacy.pms.model.Sale;
import com.pharmacy.pms.service.MedicineService;
import com.pharmacy.pms.service.SaleService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;
    private final MedicineService medicineService;

    @GetMapping("/checkout")
    public String checkoutForm(Model model) {
        model.addAttribute("medicines", medicineService.findAll());
        return "sale/checkout";
    }

    // Expects: customerName, customerPhone, medicineId[], quantity[]
    @PostMapping("/checkout")
    public String checkout(HttpServletRequest request, Authentication authentication) {
        String customerName = request.getParameter("customerName");
        String customerPhone = request.getParameter("customerPhone");
        String[] medicineIds = request.getParameterValues("medicineId");
        String[] quantities = request.getParameterValues("quantity");

        Map<Long, Integer> cart = new HashMap<>();
        if (medicineIds != null) {
            for (int i = 0; i < medicineIds.length; i++) {
                if (medicineIds[i] == null || medicineIds[i].isBlank()) continue;
                cart.put(Long.valueOf(medicineIds[i]), Integer.parseInt(quantities[i]));
            }
        }

        Sale sale = saleService.checkout(customerName, customerPhone, authentication.getName(), cart);
        return "redirect:/sales/" + sale.getId() + "/invoice";
    }

    @GetMapping("/{id}/invoice")
    public String invoice(@PathVariable Long id, Model model) {
        model.addAttribute("sale", saleService.findById(id));
        return "sale/invoice";
    }
}
