package be.pxl.publictms;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Handles requests for the application home page.
 * @author Laurens Putseys
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	/**
         * Test methode om te kijken als spring restFul webservice werkt.
         * @return String
         */
	@RequestMapping(value = "test",method = RequestMethod.GET)
        public @ResponseBody String testMethod() {
            return "Succes!";
        }
        /**
        * Geeft foutmeldingen terug
        * @param ex
        * @return String
        */
	@ExceptionHandler(Exception.class)
        public @ResponseBody String handleUncaughtException(Exception ex){
            System.out.println(ex.toString());
            return ex.toString();
        }
}
