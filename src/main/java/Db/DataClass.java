package Db;

import model.CheckInvoice;
import model.PayInvoice;

import java.util.HashMap;
import java.util.Map;

public class DataClass {

    private static Map<Long,PayInvoice> invoices = new HashMap<>();

    public static Map<Long, PayInvoice> getInvoices() {
        return invoices;
    }

    public static void setInvoices(Map<Long, PayInvoice> invoices) {
        DataClass.invoices = invoices;
    }
}

