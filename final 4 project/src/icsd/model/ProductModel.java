package icsd.model;

public class ProductModel {
	String categoryid,prodid,productname,proddesc,prodimgurl;
	int qty;
	double price;
	@Override
	public String toString() {
		return "ProductModel [categoryid=" + categoryid + ", prodid=" + prodid + ", productname=" + productname
				+ ", proddesc=" + proddesc + ", prodimgurl=" + prodimgurl + ", qty=" + qty + ", price=" + price + "]";
	}
	public ProductModel(String categoryid, String prodid, String productname, String proddesc, String prodimgurl,
			int qty, double price) {
		super();
		this.categoryid = categoryid;
		this.prodid = prodid;
		this.productname = productname;
		this.proddesc = proddesc;
		this.prodimgurl = prodimgurl;
		this.qty = qty;
		this.price = price;
	}
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	public String getProdid() {
		return prodid;
	}
	public void setProdid(String prodid) {
		this.prodid = prodid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProddesc() {
		return proddesc;
	}
	public void setProddesc(String proddesc) {
		this.proddesc = proddesc;
	}
	public String getProdimgurl() {
		return prodimgurl;
	}
	public void setProdimgurl(String prodimgurl) {
		this.prodimgurl = prodimgurl;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
