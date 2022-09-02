package com.Sakila.api.SakilaApp;

import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;


@SpringBootApplication
@RestController
@RequestMapping("/Home")
@CrossOrigin
public class SakilaAppApplication {

	//Repositories
	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	//Constructors
	public SakilaAppApplication(ActorRepository actorRepository){
		this.actorRepository = actorRepository;
	}

	//Main
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/brand/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = " https://app.wombo.art";
		driver.get(url);
		ArrayList<String> titles = new ArrayList<>();
		try {
			File myObj = new File("src/main/java/com/Sakila/api/SakilaApp/titles.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				titles.add(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println(titles);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		for(int i = 0; i<titles.size(); i++){
			driver.findElement(By.tagName("input")).sendKeys(titles.get(i));
			driver.findElement(By.xpath("//img[@alt='Realistic']")).click();
			driver.findElement(By.xpath("//button[text()='Create']")).click();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5000));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='ArtCard__CardImage-sc-67t09v-2 dOXnUm']")));

			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
			WebElement imageElement = driver.findElement(By.xpath("//*[@class='ArtCard__CardImage-sc-67t09v-2 dOXnUm']"));
			String src = imageElement.getAttribute("src");
			System.out.println("----------------------");
			System.out.println(src);


			BufferedImage image = ImageIO.read(new URL(src));
			File outputFile = new File("src/main/cards/"+ titles.get(i) +".png");
			ImageIO.write(image, "png", outputFile);
			driver.navigate().refresh();
		}
		driver.close();
		SpringApplication.run(SakilaAppApplication.class, args);
	}

	//Mapping methods
	@GetMapping("/allActors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){
		return actorRepository.findAll();
	}

	@GetMapping("/findActor")
	public @ResponseBody
	Iterable<Actor> getActor(String fname, String lname){
		return actorRepository.searchByFirstAndOrLastName(fname, lname);
	}

	@PostMapping("/addActor")
	public @ResponseBody
	void addActor(@RequestParam String first_name, @RequestParam String last_name){
		actorRepository.save(new Actor(first_name, last_name));
	}

	@GetMapping("/allCategories")
	public @ResponseBody
	Iterable<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
}
