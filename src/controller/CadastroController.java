package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.dao.DaoUsuario;
import model.entidade.Usuario;

@WebServlet("/CadastroController")
public class CadastroController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DaoUsuario userDao;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("Served at: ").append(req.getContextPath());
	}
	
	@SuppressWarnings({ "null" })
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
        BufferedReader br = req.getReader();
        String str = null;
        DateFormat dtFormate = null;
        this.userDao = new DaoUsuario();
		Usuario usuario = new Usuario();
        
		while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        
        try{
        	JSONObject jObj = new JSONObject(sb.toString());
        	usuario.setNome(jObj.getString("nome"));
        	usuario.setIdade(jObj.getInt("idade"));
        	usuario.setCpf(jObj.getString("cpf"));
        	usuario.setRg(jObj.getString("rg"));
        	usuario.setDtNasc(dtFormate.parse(jObj.get("dtNasc").toString()));
        	usuario.setEmail(jObj.get("email").toString());
        	usuario.setEndereco(jObj.getString("emder"));
              
        	resp.setContentType("text/plain");
        	resp.setCharacterEncoding("UTF-8");
        
	
			this.userDao.create(usuario);
			Usuario newUser = userDao.GetOne(usuario);
			 
            JSONObject jsonObject = new JSONObject(); 
			jsonObject.put("nome", newUser.getNome());
            jsonObject.put("idade", newUser.getIdade());  
            jsonObject.put("cpf", newUser.getCpf());
            jsonObject.put("rg", newUser.getRg());
            jsonObject.put("dtNasc", newUser.getDtNasc());
            jsonObject.put("email", newUser.getEmail());
            jsonObject.put("ender", newUser.getEndereco());
            
            resp.getWriter().print(jsonObject);
		}catch (Exception e){
			e.printStackTrace();
			resp.getWriter().append("Deu erro na hora de salvar!");
		}
	}

}
