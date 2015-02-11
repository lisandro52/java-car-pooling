package ttps;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class salir extends ActionSupport {
public String execute() throws Exception{
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("email", null);
		session.put("id", null);
		session.put("usrLogin", null);
		return SUCCESS;
}

}
