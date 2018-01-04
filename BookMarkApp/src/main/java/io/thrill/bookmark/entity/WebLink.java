package io.thrill.bookmark.entity;



import io.thrill.bookmark.partner.Sharable;

public class WebLink extends Bookmark implements Sharable {
	private String url;
	private String host;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public String toString() {
		return "WebLink [url=" + url + ", host=" + host + ", Title" +getTitle() +"]";
	}

	@Override
	public boolean isKidFriendlyEligible() {
		if(url.toLowerCase().contains("erotic") || getTitle().toLowerCase().contains("erotic")) {
			return false;
		}else if(host.toLowerCase().contains("adult") ) {
			return false;
		}
		return true;
	}

	public String getData() {
		StringBuilder builder = new StringBuilder();
		builder.append("<response>");
		builder.append("<type>WebLink</type>");
		builder.append("<title>").append(getTitle()).append("/title");		
		builder.append("<url>").append(url).append("/url");
		builder.append("<host>").append(host).append("/host");
		builder.append("</response>");
		return builder.toString();
	}
	
	
}
