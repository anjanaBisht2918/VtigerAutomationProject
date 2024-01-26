package genericUtility;

public class BaseClass {

	public WebDriver driver;
	public FileUtility fUtils = new FileUtility();
	public ExcelUtility eUtils = new ExcelUtility();
	public WebDriverUtility wUtils = new WebDriverUtility();
	public DataBaseUtility dbUtils = new DataBaseUtility();

	public static WebDriver sDriver;
	public Connection connection;

	@BeforeSuite
	public void bsConfig() throws SQLException {
		// 1. Creating an object of Driver of MY SQL vendor
		Driver dataBaseDriver = new Driver();
		// 2. Registering driver to JDBC API
		DriverManager.registerDriver(dataBaseDriver);
		// 3. Establishing connection with the data base
		connection = DriverManager.getConnection(IPathConstant.DATABASE_URL, IPathConstant.DATABASE_USERNAME,
				IPathConstant.DATABASE_PASSWORD);
		System.out.println("Data Base Connection has been exstablish");
	}

	@BeforeTest
	public void btConfig() {
		System.out.println("Parallel Execution has been started");
	}

	@BeforeClass
	public void bcConfig() throws IOException {

		String browser = fUtils.fetchDataFromPropertyFile("browser");
		String url = fUtils.fetchDataFromPropertyFile("url");

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}

		else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}

		else
			System.out.println("The browser is not present");
		sDriver = driver;
		wUtils.maximizeTheWindow(driver);
		wUtils.implicitWait(driver);
		driver.get(url);

	}

	@BeforeMethod
	public void bmConfig() throws IOException {

		String username = fUtils.fetchDataFromPropertyFile("username");
		String password = fUtils.fetchDataFromPropertyFile("password");

		LoginPage login = new LoginPage(driver);
		login.loginAction(username, password);

		System.out.println("Login is Successfull");

	}

	@AfterMethod
	public void amConfig() {
		HomePage home = new HomePage(driver);
		home.logoutAction();

	}

	@AfterClass
	public void acConfig() {
		driver.quit();
	}

	@AfterTest
	public void atConfig() {
		System.out.println("Close the Parallel Execution");
	}

	@AfterSuite
	public void asConfig() throws SQLException {
		connection.close();

		System.out.println("The Data base has been closed");
	}
}
