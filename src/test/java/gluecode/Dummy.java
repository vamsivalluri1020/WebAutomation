package gluecode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dummy 
{
	public static void main(String[] args) 
	{
		/*WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");*/
		String temp="G-456789 is your google verification code";
		Pattern p=Pattern.compile("[0-9]{6}");
        Matcher m=p.matcher(temp);
        m.find();
        System.out.println(m.group());

	}

}
