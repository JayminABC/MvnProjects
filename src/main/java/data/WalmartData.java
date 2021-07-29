package data;

import utilities.Xls_Reader;

public class WalmartData {
	Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\main\\resources\\WalmartData.xlsx");
	public String incorrectemail = xls.getCellData("Sheet1", "username", 2);
	public String incorrectpassword = xls.getCellData("Sheet1", "password", 2);
	public String correctemail = xls.getCellData("Sheet1", "username", 3);
	public String correctpassword = xls.getCellData("Sheet1", "password", 3);
	public String errmsg = xls.getCellData("Sheet1", "loginerr", 2);
	public String search = xls.getCellData("Sheet1", "search", 2);
	
	
}
