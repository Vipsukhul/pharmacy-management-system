package com.pharmacy.pms.service;

import com.pharmacy.pms.model.Medicine;
import com.pharmacy.pms.model.Sale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final MedicineService medicineService;
    private final SaleService saleService;

    public List<Medicine> stockSummary() {
        return medicineService.findAll();
    }

    public List<Medicine> lowStockReport() {
        return medicineService.lowStock();
    }

    public List<Medicine> expiryReport() {
        return medicineService.expiringInNext30Days();
    }

    public List<Sale> todaysSalesReport() {
        return saleService.todaysSales();
    }

    public double todaysEarnings() {
        return saleService.todaysSales().stream().mapToDouble(Sale::getTotalAmount).sum();
    }
}
