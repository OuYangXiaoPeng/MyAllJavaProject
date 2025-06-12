package servlet;

import model.Goods;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.GoodsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "admin_goods_edit",urlPatterns = "/admin/goods_edit")
public class AdminGoodsEditServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> list = upload.parseRequest(request);
            Goods g = new Goods();
            int pageNumber =1;
            int type=0;
            for(FileItem item:list) {
                if(item.isFormField()) {
                    String fieldName = item.getFieldName();
                    if (fieldName.equals("id")) {
                        g.setId(Integer.parseInt(item.getString("utf-8")));
                    } else if (fieldName.equals("name")) {
                        g.setName(item.getString("utf-8"));
                    } else if (fieldName.equals("price")) {
                        g.setPrice(Float.parseFloat(item.getString("utf-8")));
                    } else if (fieldName.equals("intro")) {
                        g.setIntro(item.getString("utf-8"));
                    } else if (fieldName.equals("cover")) {
                        g.setCover(item.getString("utf-8"));
                    } else if (fieldName.equals("image1")) {
                        g.setImage1(item.getString("utf-8"));
                    } else if (fieldName.equals("image2")) {
                        g.setImage2(item.getString("utf-8"));
                    } else if (fieldName.equals("stock")) {
                        g.setStock(Integer.parseInt(item.getString("utf-8")));
                    } else if (fieldName.equals("typeid")) {
                        g.setTypeid(Integer.parseInt(item.getString("utf-8")));
                    } else if (fieldName.equals("pageNumber")) {
                        pageNumber = Integer.parseInt(item.getString("utf-8"));
                    } else if (fieldName.equals("type")) {
                        type = Integer.parseInt(item.getString("utf-8"));
                    }
                }else {
                    if(item.getInputStream().available()<=0)continue;
                    String fileName = item.getName();
//                    fileName = fileName.substring(fileName.lastIndexOf("."));
//                    fileName = "/"+new Date().getTime()+fileName;
                    String path = this.getServletContext().getRealPath("/picture/")+fileName;
                    InputStream in = item.getInputStream();
                    FileOutputStream out = new FileOutputStream(path);
                    byte[] buffer = new byte[1024];
                    int len=0;
                    while( (len=in.read(buffer))>0 ) {
                        out.write(buffer);
                    }
                    in.close();
                    out.close();
                    item.delete();
                    String fieldName = item.getFieldName();
                    if (fieldName.equals("cover")) {
                        g.setCover("/picture/" + fileName);
                    } else if (fieldName.equals("image1")) {
                        g.setImage1("/picture/" + fileName);
                    } else if (fieldName.equals("image2")) {
                        g.setImage2("/picture/" + fileName);
                    }
                }
            }
            gService.update(g);
            request.getRequestDispatcher("/admin/goods_list?pageNumber="+pageNumber+"&type="+type).forward(request, response);
        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

