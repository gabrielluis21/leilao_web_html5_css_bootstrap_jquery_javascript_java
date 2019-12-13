package controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.dao.DaoUsuario;
import model.entidade.Usuario;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DaoUsuario userDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
        BufferedReader br = req.getReader();
        String str = null;
        
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        			
		try {
			JSONObject jsObj = new JSONObject(sb.toString());
			Usuario newUser = this.userDao.GetOneByLogin(jsObj.getString("email"), jsObj.getString("senha"));
			 
	        JSONObject jsonObject = new JSONObject(); 
			jsonObject.put("nome", newUser.getNome());
	        jsonObject.put("idade", newUser.getIdade());  
	        jsonObject.put("cpf", newUser.getCpf());
	        jsonObject.put("rg", newUser.getRg());
	        jsonObject.put("dtNasc", newUser.getDtNasc());
	        jsonObject.put("email", newUser.getEmail());
	        jsonObject.put("ender", newUser.getEndereco());
		}catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().append("Deu erro na hora de entrar!");
		}
	}

}
