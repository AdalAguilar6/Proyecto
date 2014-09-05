/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.reportes;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author LuisG
 */
@WebServlet(name = "ReporteEmpleado", urlPatterns = {"/ReporteEmpleado"})
public class ReporteEmpleado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     /*   try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ReporteU</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ReporteU at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
       // }
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

        try {
            byte[] bytes;
            JRResultSetDataSource jrds;
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/Produccion");
            Connection cn = ds.getConnection();
            Statement st = cn.createStatement();
            /*ResultSet rs = st.executeQuery(" SELECT "
                    + "e.idEmpleado, "                    
                    + "e.apellido,e.idpuesto,e.idEstado,e.idUsuario,e.nombre "
                    + "FROM  "
                    + "empleado e;");*/
            
            ResultSet rs = st.executeQuery(" SELECT e.`idEmpleado` AS idEmpleado," +
                "     e.`nombre` AS nombre,   e.`apellido` AS apellido," +
                "     (select p.nombre" +
                "        from puesto p" +
                "        where p.`idPuesto` = e.`idPuesto`) AS Puesto," +
                "     (select t.nombre" +
                "        from tipo t" +
                "        where t.`idTipo` = e.`idEstado`) AS Estado," +
                "     e.`idUsuario` AS idUsuario     " +
                "FROM empleado e        ;");
            

            jrds = new JRResultSetDataSource(rs);

            // se debe agregar el EJB "busquedasGen"
//            JRBeanCollectionDataSource dataSource;
//            Collection reportRows = busquedasGen.listaBeneficiario();
//            dataSource = new JRBeanCollectionDataSource(reportRows);
            InputStream is = getServletConfig()
                    .getServletContext().getResourceAsStream("/Reportes/empleado.jasper");
//          File reportFile = new File("/home/paul/Reportes/rptVehiculos.jasper");

            //File reportFile = new File("\\web\\reportes\\reportBeneficiarios.jasper");
            //InputStream is = new FileInputStream(reportFile);
            HashMap m = new HashMap();
            m.clear();
            bytes = JasperRunManager.runReportToPdf(is, m, jrds);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream ouputStream = response.getOutputStream();
            ouputStream.write(bytes, 0, bytes.length);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
            // display stack trace in the browser
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            response.setContentType("text/plain");
            response.getOutputStream().print(stringWriter.toString());
        }
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
