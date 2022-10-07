/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.pdfgene;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.BaseColor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font.FontFamily;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;

/**
 *
 * @author abhi
 */
//@WebServlet(urlPatterns = "/PDF")
public class PDF extends HttpServlet {

    public static PdfPCell getCell(String text, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(text));
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            //Create Document instance.
            Document document = new Document();
            String filename = request.getParameter("filename");
            
            //Create OutputStream instance.
            File file = new File(filename+".pdf");

            OutputStream outputStream = new FileOutputStream(file.getAbsolutePath());

            //Create PDFWriter instance.
            PdfWriter.getInstance(document, outputStream);

            //Open the document.
            document.open();

            String Person1Name = request.getParameter("text1");
            String Person2Name = request.getParameter("text2");
            Font f = new Font(FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK);

            Paragraph p1 = new Paragraph("CONTRACT AGREEMENT", FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD, BaseColor.BLACK));
//            p3.setUnderline(0.1F, -2F);
            document.add(new Paragraph("\n"));
            p1.setAlignment(Element.ALIGN_CENTER);
            document.add(p1);

            LineSeparator line = new LineSeparator(1, 100, BaseColor.BLACK, Element.ALIGN_LEFT, 0);
            document.add(new Paragraph("\n"));
            document.add(line);

            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));

            Paragraph p2 = new Paragraph();
//            , FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, BaseColor.BLACK)
//            p2.setAlignment(Element.ALIGN_CENTER);
            p2.add("           This contract is entered into by and between ");
            p2.add(new Chunk(Person1Name, f));
            p2.add(" (First Party), and ");
            p2.add(new Chunk(Person2Name, f));
            p2.add(" (Second Party).The term of this Agreement shall begin on ");
            p2.add(new Chunk("03-10-2022", f));
            p2.add(" and shall continue through\n" + "its termination date of ");
            p2.add(new Chunk("03-10-2023.", f));
            document.add(p2);
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));

            Paragraph p3 = new Paragraph();
            document.add(new Paragraph("Person 1 Signing Agreement"));

            p3.add("1. ");
            p3.add(new Chunk(Person1Name, f));
            p3.add(", I here by Sign this agreement with all my acceptance.");
            document.add(p3);

            document.add(new Paragraph("\n"));
            Paragraph p4 = new Paragraph();
            document.add(new Paragraph("Person 2 Signing Agreement"));
//            String Person2Name = "Party2";
            p4.add("2. ");
            p4.add(new Chunk(Person2Name, f));
            p4.add(", I here by Sign this agreement with all my acceptance.");
            document.add(p4);

//            Paragraph p = new Paragraph();
//            p.add("Valeriane\u00A0Valerius 012\u00A0345\u00A067\u00A089 valerianelogin");
//            p.add("hi");
//            document.add(p);
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));

//            TERMS AND CONDITIONS
            Paragraph p5 = new Paragraph();
            p5.add(new Chunk("TERMS AND CONDITIONS", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD, BaseColor.BLACK)));
            p5.setAlignment(Element.ALIGN_CENTER);
            document.add(p5);
            document.add(new Paragraph("\n"));

            Paragraph p6 = new Paragraph();
            p6.add(new Chunk("Conditions of use", FontFactory.getFont(FontFactory.HELVETICA, 15, Font.BOLD, BaseColor.BLACK)));
            p6.add("\n");
            p6.add("By using this website, you certify that you have read and reviewed this Agreement and that you\n"
                    + "agree to comply with its terms. If you do not want to be bound by the terms of this Agreement, you\n"
                    + "are advised to leave the website accordingly. This only grants use and access to this website, its\n"
                    + "products, and its services to those who have accepted its terms.");
            document.add(p6);
            document.add(new Paragraph("\n"));

            Paragraph p7 = new Paragraph();
            p7.add(new Chunk("Privacy policy", FontFactory.getFont(FontFactory.HELVETICA, 15, Font.BOLD, BaseColor.BLACK)));
            p7.add("\n");
            p7.add("Before you continue using our website, we advise you to read our privacy policy regarding our\n"
                    + "user data collection. It will help you better understand our practices.");
            document.add(p7);
            document.add(new Paragraph("\n"));

            Paragraph p8 = new Paragraph();
            p8.add(new Chunk("User accounts", FontFactory.getFont(FontFactory.HELVETICA, 15, Font.BOLD, BaseColor.BLACK)));
            p8.add("\n");
            p8.add("As a user of this website, you may be asked to register with us and provide private information.\n"
                    + "You are responsible for ensuring the accuracy of this information, and you are responsible for\n"
                    + "maintaining the safety and security of your identifying information. You are also responsible for all\n"
                    + "activities that occur under your account or password. If you think there are any possible issues\n"
                    + "regarding the security of your account on the website, inform us immediately so we may address\n"
                    + "them accordingly.We reserve all rights to terminate accounts, edit or remove content and cancel\n"
                    + "orders at our sole discretion.");
            document.add(p8);
            document.add(new Paragraph("\n"));

            Paragraph p9 = new Paragraph();
            p9.add(new Chunk("Applicable law", FontFactory.getFont(FontFactory.HELVETICA, 15, Font.BOLD, BaseColor.BLACK)));
            p9.add("\n");
            p9.add("By visiting this website, you agree the laws, without regard to principles of conflict laws, will govern\n"
                    + "these terms and conditions, or any dispute of any sort that might come between Harry and Rama,\n"
                    + "or its business partners and associates.");
            document.add(p9);
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));

            Paragraph p10 = new Paragraph();
            p10.add(new Chunk("Disputes", FontFactory.getFont(FontFactory.HELVETICA, 15, Font.BOLD, BaseColor.BLACK)));
            p10.add("\n");
            p10.add("Any dispute relating to your visit to this website or products you purchase from us shall be\n"
                    + "arbitrated by state or federal court and you consent to exclusive jurisdiction and venue of such\n"
                    + "courts.");
            document.add(p10);
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));

//            ADDRESS
            float[] columnWidths = {110, 70};
            PdfPTable table5 = new PdfPTable(columnWidths);

            table5.getDefaultCell().setBorder(Rectangle.NO_BORDER);
            table5.setWidthPercentage(100);
            table5.setSpacingBefore(0f);
            table5.setSpacingAfter(0f);

            PdfPCell cell2 = new PdfPCell(new Paragraph());
            cell2.setBorder(Rectangle.NO_BORDER);
            Font boldFont = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
            Font normalFont = new Font(Font.FontFamily.HELVETICA, 11, Font.ITALIC);
            Phrase firstLine = new Phrase("Person 1 Details", boldFont);
            Phrase SecondLine = new Phrase("Person 2 Details", boldFont);

            cell2.setColspan(2);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            table5.addCell(cell2);
            table5.addCell(firstLine);
            table5.addCell(SecondLine);

            table5.addCell(""+Person1Name+",");
            table5.addCell(""+Person2Name+",");

            table5.addCell("9123456780,");
            table5.addCell("9012345678,");

            table5.addCell("sample1@gmail.com,");
            table5.addCell("sample2@gmail.com,");

            table5.addCell("eMudhra1,");
            table5.addCell("eMudhra2,");

            table5.addCell("Bengaluru.");
            table5.addCell("Bengaluru.");

            table5.addCell("\n");
            table5.addCell("\n");
            table5.addCell("\n");
            table5.addCell("\n");

            Phrase firstsig = new Phrase("APPLICANT SIGNATURE", boldFont);
            Phrase Secondsig = new Phrase("APPLICANT SIGNATURE", boldFont);
            table5.addCell(firstsig);
            table5.addCell(Secondsig);

            document.add(table5);

            //Close document and outputStream.
            document.close();
            outputStream.close();
            PrintWriter out = response.getWriter();
            System.out.println("Pdf created successfully.");
            System.out.println(file.getAbsolutePath());
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("Download.jsp");
            request.setAttribute("filename",filename);
            request.setAttribute("filepath",file.getAbsolutePath());
            dispatcher.forward( request, response );
            
//            response.sendRedirect("Download.jsp");
//            out.print("<center><h1>Pdf created successfully</h1>");
//            String p = "http://localhost:8080/pdfgene";
//            out.print("<button><a href='"+p+"' style='text-decoration: none;color:Black;'>Back</a></button></center>");  // relative if on same level as servlet

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
