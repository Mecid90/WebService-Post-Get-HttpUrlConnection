package service;

import model.CheckInvoice;
import model.PayInvoice;
import org.hibernate.annotations.Check;

import java.util.List;

public interface PayInvoiceService {


     public void printInvoice(PayInvoice payInvoice);

     public PayInvoice addInvoice(PayInvoice payInvoice);

     public List<PayInvoice> getAllInvoices();

     public PayInvoice getInvoice(Long id);
}
