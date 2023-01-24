package controller;

import model.CheckInvoice;
import model.PayInvoice;
import service.PayInvoiceService;
import service.PayInvoiceServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/index")
public class IndexController {

    private PayInvoiceService payInvoiceService = new PayInvoiceServiceImpl();

//    @Path("/payInvoice")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public void payInovice(PayInvoice payInvoice){
//
//        payInvoiceService.addInvoice(payInvoice);
//        payInvoiceService.printInvoice(payInvoice);
//    }

    @Path("/payInvoice")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void payInovice(PayInvoice payInvoice){

        payInvoiceService.addInvoice(payInvoice);

        payInvoiceService.printInvoice(payInvoice);

    }

    @Path("/{refNumber}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void payInvoice(@PathParam("refNumber") Long id){

        PayInvoice pay = payInvoiceService.getInvoice(id);
        payInvoiceService.printInvoice(pay);
    }

    @Path("/getInvoices")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<PayInvoice> getAllInvoices(){

        return payInvoiceService.getAllInvoices();
    }


//    @Path("/checkInvoice/invoiceRef={refNumber}")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public String checkInovice(@QueryParam("refNumber") String number){
//
//        return "success";
//    }
}
