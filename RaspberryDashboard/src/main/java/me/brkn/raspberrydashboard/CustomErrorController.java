package me.brkn.raspberrydashboard;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {

	private static final String PATH = "/error";

	@Autowired
	private ErrorAttributes errorAttributes;
	// timestamp - The time that the errors were extracted
	// status - The status code
	// error - The error reason
	// exception - The class name of the root exception
	// message - The exception message
	// errors - Any ObjectErrors from a BindingResult exception
	// trace - The exception stack trace
	// path - The URL path when the exception was raised

	@Override
	public String getErrorPath() {
		return PATH;
	}

	@RequestMapping(value = PATH)
	public ModelAndView requestHandler(WebRequest request) {

		Map<String, Object> attributes = errorAttributes.getErrorAttributes(request, true);

		ModelAndView mav = new ModelAndView();
		Integer status = (Integer) attributes.get("status");

		switch (status) {
		case 404:
			handleNotFound(mav, attributes);
			break;
		case 500:
			handleInternalServerError(mav, attributes);
			break;
		default:
			handleInternalServerError(mav, attributes);
			break;
		}
		mav.setViewName("error");

		return mav;
	}

	private void handleNotFound(ModelAndView mav, Map<String, Object> attributes) {
		Date timestamp = (Date) attributes.get("timestamp");
		Integer status = (Integer) attributes.get("status");
		String error = (String) attributes.get("error");
		String path = (String) attributes.get("path");

		mav.addObject("statusCode", status);
		mav.addObject("isNotFoundError", true);
	}

	private void handleInternalServerError(ModelAndView mav, Map<String, Object> attributes) {

		Date timestamp = (Date) attributes.get("timestamp");
		Integer status = (Integer) attributes.get("status");
		String error = (String) attributes.get("error");
		String trace = (String) attributes.get("trace");

		mav.addObject("statusCode", status);
		mav.addObject("isNotFoundError", false);
	}

}
