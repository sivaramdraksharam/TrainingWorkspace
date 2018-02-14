package io.thrill.bookmark.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import io.thrill.bookmark.partner.Sharable;

@Entity
@Table(name="weblinks")
@PrimaryKeyJoinColumn(name="id")
public class WebLink extends Bookmark implements Sharable{
	
	@Column(name="url")
	private String url;
	
	@Column(name="host")
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

	@Override
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
