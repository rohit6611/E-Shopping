package icsd.Authentication;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class ICSDAuthentication {

public static HttpSession ckeckauth(HttpServletRequest request) throws ICSDAuthException{
	HttpSession session=request.getSession(false);
	if(session==null) {
		throw new ICSDAuthException("please login first");
	}
	return session;
}
}
