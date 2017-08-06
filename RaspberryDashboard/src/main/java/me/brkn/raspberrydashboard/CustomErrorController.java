package me.brkn.raspberrydashboard;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {

	private static final Logger logger = LoggerFactory.getLogger(CustomErrorController.class);

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
		case 403:
			handleNotAuthorized(mav, attributes);
			break;
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

	private void handleNotAuthorized(ModelAndView mav, Map<String, Object> attributes) {
		Integer status = (Integer) attributes.get("status");
		String error = (String) attributes.get("error");
		String path = (String) attributes.get("path");

		String errorString = "Status: " + status + " | Error: " + error + " | Path: " + path;
		logger.error(errorString);

		mav.addObject("statusCode", status);
		mav.addObject("errorType", "NotAuthorized");
	}

	private void handleNotFound(ModelAndView mav, Map<String, Object> attributes) {
		Integer status = (Integer) attributes.get("status");
		String error = (String) attributes.get("error");
		String path = (String) attributes.get("path");

		String errorString = "Status: " + status + " | Error: " + error + " | Path: " + path;
		logger.error(errorString);

		mav.addObject("statusCode", status);
		mav.addObject("errorType", "NotFoundError");
	}

	private void handleInternalServerError(ModelAndView mav, Map<String, Object> attributes) {
		Integer status = (Integer) attributes.get("status");
		String error = (String) attributes.get("error");
		String trace = (String) attributes.get("trace");

		String errorString = "Status: " + status + " | Error: " + error + "\n" + trace;
		logger.error(errorString);

		mav.addObject("statusCode", status);
		mav.addObject("errorType", "InternalServerError");
	}

}
