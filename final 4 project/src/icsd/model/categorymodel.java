package icsd.model;

public class categorymodel {

	public categorymodel() {
		super();
		// TODO Auto-generated constructor stub
	}
	int categoryid;
	String categoryname;

	String categorydesc;
	String categoryimgurl;
	
	public categorymodel(int categoryid, String categoryname, String categorydesc, String categoryimgurl) {
		super();
		this.categoryid = categoryid;
		this.categoryname = categoryname;
		this.categorydesc = categorydesc;
		this.categoryimgurl = categoryimgurl;
	}
	
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getCategorydesc() {
		return categorydesc;
	}
	public void setCategorydesc(String categorydesc) {
		this.categorydesc = categorydesc;
	}
	public String getCategoryimgurl() {
		return categoryimgurl;
	}
	public void setCategoryimgurl(String categoryimgurl) {
		this.categoryimgurl = categoryimgurl;
	}
	@Override
	public String toString() {
		return "categorymodel [categoryid=" + categoryid + ", categoryname=" + categoryname + ", categorydesc="
				+ categorydesc + ", categoryimgurl=" + categoryimgurl + "]";
	}
	
}
