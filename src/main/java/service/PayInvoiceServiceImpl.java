package service;


import Db.DataClass;
import ExceptionHandler.NotFoundException;
import model.CheckInvoice;
import model.PayInvoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class PayInvoiceServiceImpl implements PayInvoiceService {

//    @Override
//    public String isUserAutheticated(String name, String password) {
//        String credentials = name +":" +password;
//
//        try{
//            credentials=Base64.getEncoder().encodeToString(credentials.getBytes());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return credentials;
//    }

    private Map<Long,PayInvoice> invoiceMap = DataClass.getInvoices();

    @Override
    public List<PayInvoice> getAllInvoices(){
        return new ArrayList<>(invoiceMap.values());
    }


    @Override
    public PayInvoice getInvoice(Long id){

        PayInvoice payInvoice = invoiceMap.get(id);

        if (payInvoice==null){
            throw new NotFoundException("Invoice with refNumber " + id+" not found");
        }

        return payInvoice;
    }

    @Override
    public PayInvoice addInvoice(PayInvoice payInvoice){
        payInvoice.setId(invoiceMap.size() + 1L);
        invoiceMap.put(payInvoice.getId(),payInvoice);
        return payInvoice;
    }

    @Override
    public void printInvoice(PayInvoice payInvoice) {
        System.out.println("id: " + payInvoice.getId() + " amount:"
                + payInvoice.getAmount() + " currency:" + payInvoice.getCurrency() + " transactionId:"
                + payInvoice.getTransactionId() + " agent:"
                + payInvoice.getAgent() + " pmbm:"
                + payInvoice.getPbmb());
    }
}
