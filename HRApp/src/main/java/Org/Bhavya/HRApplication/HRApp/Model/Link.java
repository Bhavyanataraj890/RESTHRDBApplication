package Org.Bhavya.HRApplication.HRApp.Model;
public class Link {

	private StringBuffer link;
	private String rel;
	public Link() {
		super();
	}
	public Link(StringBuffer link, String rel) {
		super();
		this.link = link;
		this.rel = rel;
	}
	public StringBuffer getLink() {
		return link;
	}
	public void setLink(StringBuffer link) {
		this.link = link;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
}
