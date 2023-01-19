package hellocucumber;

import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
    TEACHER_USERNAME = "teacher"
    TEACHER_PASSWORD = "sandBox1#"
    ADMIN_USERNAME = "admin"
    ADMIN_PASSWORD = "Ah*yaWTF1"
    COURSE_NAME = "My first course"

    // $$*TODO* explain what this step does$$
    @Given("an example scenario")
    public void anExampleScenario() {
    }

    // $$*TODO* explain what this step does$$
    @When("all step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
    }

    // $$*TODO* explain what this step does$$
    @Then("the scenario passes")
    public void theScenarioPasses() {
    }

    @Given("successful 'Teacher' Login")
    public void successfulTeacherLogin(){
        courseName = COURSE_NAME
        username = TEACHER_PASSWORD
        password = TEACHER_PASSWORD
        // locate and click on web element -> login
        driver.findElement(By.linkText("Log in")).click();

        // locate the username input box and enter username
        // $x("//*[@id='username']")
        // driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']"))).sendKeys(username);

        // locate the password input box and enter password
        // $x("//*[@name='password' and @type='password']")
        driver.findElement(By.xpath("//*[@name='password' and @type='password']")).sendKeys(password);

        // locate Log in button and press
        // $x("//*[@id='loginbtn']")
        driver.findElement(By.id("loginbtn")).click();

        // now to check if login process succeeded -> find the element which indicates it succeeded
        // $x("//*[contains(text(),'Welcome, Teacher!')]")
        driver.findElement(By.xpath("//*[contains(text(),'Welcome back, Eitam!')]"));

        // example of how we can save the element and then operate with it
        // find my courses -> click on it
        // $x("//*[contains(text(),'My courses') and @role='menuitem']")
        WebElement myCoursesTab = driver.findElement(By.xpath("//*[contains(text(),'My courses') and @role='menuitem']"));
        myCoursesTab.click();

        // find course -> click on it
        // $x("//*[@class='multiline' and contains(text(),'Demo course')]")[0].click()
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='multiline' and contains(text(),'" + courseName + "')]"))).click();
        
        // locate and click on Forum element -> click
        driver.findElement(By.xpath("//*[@id=\"module-1\"]/div/div[1]/div/div[1]/div/div[2]/div[2]/a")).click();
    }

    @When("'Teacher' add a 'New Discussion topic")
    public void addNewDiscussionTopic(){
        // locate and click on 'add discussion topic'
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/div[1]/div/div[2]/a")).click();
        // enter the subject name
        driver.findElement(By.xpath("//*[@id=\"id_subject\"]")).sendKeys(subject);
        // enter the message content
        driver.findElement(By.xpath("//*[@id=\"id_messageeditable\"]")).sendKeys(message);

        // upload a new file
        // Click the "Advanced" button
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/div[2]/div[2]/form/div[4]/div[2]/fieldset/div/div[3]/span/input")).click();
        // Find the file upload field and click on it
        WebElement fileInput = driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/form/fieldset[1]/div[2]/div[4]/div[2]/fieldset/div/div[2]/div[1]/div[1]/div[1]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('hidden');", fileInput);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/form/fieldset[1]/div[2]/div[4]/div[2]/fieldset/div/div[2]/div[1]/div[1]/div[1]/a"))).click();

        // Uploading the file
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[9]/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div/div/form/div/div[1]/div/input")));
        File file = new File("./Files/CamScanner 01-23-2022 12.02 (1) (2).pdf");
        driver.findElement(By.xpath("/html/body/div[9]/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div/div/form/div/div[1]/div/input")).sendKeys(file.getAbsolutePath());

        // Click the "Post to forum" button
        driver.findElement(By.xpath("/html/body/div[9]/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div/button")).click();

        WebElement element = driver.findElement(By.xpath("/html/body/div[4]/div[4]/div/div[3]/div/section/div[2]/form/div[3]/div[2]/fieldset/div/div[1]/span"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        // Check if the element is displayed
        if (element.isDisplayed()) {
            // Element is visible, so we can click on it
            element.click();
        } else {
            // Element is not visible, so we need to scroll it into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            // Now that the element is in view, we can click on it
            element.click();
        }
    }

    @Then("receive a successful upload message")
    public void receiveSuccessfulUploadMessage(){
        // now to check if login process succeeded -> find the element which indicates it succeeded
        // $x("//*[contains(text(),'Welcome, Teacher!')]")
        WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[3]/div/section/span[1]/div"));
        String text = element.getText();

        // check if the text is correct
        if (text.equals("Your post was successfully added.\n" +
                "You have 30 mins to edit it if you want to make any changes.\n" +
                "×\n" +
                "Dismiss this notification")) {
            System.out.println("The text is correct!");
        } else {
            System.out.println("The text is incorrect. Expected: 'The text I expect to see', actual: '" + text + "'");
        }
    }

    @Given("successful 'Administrator' Login")
    public void successfulAdminLogin(){
        courseName = COURSE_NAME
        username = ADMIN_USERNAME
        password = ADMIN_PASSWORD
        // locate and click on web element -> login
        driver.findElement(By.linkText("Log in")).click();

         // locate the username input box and enter username
        // $x("//*[@id='username']")
        // driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']"))).sendKeys(username);

        // locate the password input box and enter password
        // $x("//*[@name='password' and @type='password']")
        driver.findElement(By.xpath("//*[@name='password' and @type='password']")).sendKeys(password);

       // locate Log in button and press
        // $x("//*[@id='loginbtn']")
        driver.findElement(By.id("loginbtn")).click();

        // now to check if login process succeeded -> find the element which indicates it succeeded
        // $x("//*[contains(text(),'Welcome, Teacher!')]")
        driver.findElement(By.xpath("//*[contains(text(),'Welcome back, Eitam!')]"));
    }

    @When("'Administrator' enter 'My First Course Page'")
    public void adminEnterToCourse(){
        // example of how we can save the element and then operate with it
        // find my courses -> click on it
        // $x("//*[contains(text(),'My courses') and @role='menuitem']")
        WebElement myCoursesTab = driver.findElement(By.xpath("//*[contains(text(),'My courses') and @role='menuitem']"));
        myCoursesTab.click();
        
        // example of how we can save the element and then operate with it
        // find my courses -> click on it
        // $x("//*[contains(text(),'My courses') and @role='menuitem']")
        WebElement myCoursesTab = driver.findElement(By.xpath("//*[contains(text(),'My courses') and @role='menuitem']"));
        myCoursesTab.click();

        // find course -> click on it
        // $x("//*[@class='multiline' and contains(text(),'Demo course')]")[0].click()
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='multiline' and contains(text(),'" + courseName + "')]"))).click();
        
        // locate and click on Forum element -> click
        driver.findElement(By.xpath("//*[@id=\"module-1\"]/div/div[1]/div/div[1]/div/div[2]/div[2]/a")).click();

        // locate and click on Forum element -> click
        driver.findElement(By.xpath("//*[@id=\"module-1\"]/div/div[1]/div/div[1]/div/div[2]/div[2]/a")).click();

        // Click the "Settings" button
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[2]/nav/ul/li[2]/a")).click();

        // Click the "Attachment and word counts" button
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/form/fieldset[3]/div[1]/div/a")).click();

        // Find the drop-down list element
        WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"id_maxbytes\"]"));

        // Create a new Select object for the drop-down list
        Select dropdown = new Select(dropdownElement);

        // Select the desired value from the drop-down list
        dropdown.selectByValue("10240");

        // Click the "save and return to course" button
        driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[3]/div/section/div[2]/form/div[4]/div[2]/fieldset/div/div[1]/span/input")).click();

    }

    @Then("get the course page")
    public void getTheCoursePage(){
        // Get the current URL of the page
        String currentUrl = driver.getCurrentUrl();

        // Check if the current URL is the expected URL
        if (currentUrl.equals("https://localhost/course/view.php?id=2#section-0")) {
            System.out.println("Success: Correct page after changing maximum attachment size");
        } else {
            System.out.println("Error: Incorrect page after changing maximum attachment size" + "this is the expected: " + currentUrl);
        }
    }

    @Then("getting error for can not upload the file")
    public gettinErrorCanNotUpload(){
        WebElement element = driver.findElement(By.xpath("/html/body/div[11]/div[3]/div/div[2]/div/div[1]"));
        String text = element.getText();
        if (text.equals("The file 109291 Australian Matilda tank in Brunei Bay.jpg is too large. The maximum size you can upload is 10 KB.")){
           System.out.println("The text is correct!"); 
        }
        else {
            System.out.println("The text is incorrect. Expected: 'The text I expect to see', actual: '" + text + "'");
        }

    }



}
