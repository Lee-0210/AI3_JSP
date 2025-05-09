package dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "map")
@XmlAccessorType(XmlAccessType.FIELD)
public class MapWrapper {
	
	@XmlElement(name = "entry")
	private List<Entry> entries = new ArrayList<>();
	
	// 내부 Entry 클래스
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Entry {
		private String key;
		private Object value;
		
		public Entry() {
		}
		
		public Entry(String key, Object value) {
			super();
			this.key = key;
			this.value = value;
		}
	}

	public MapWrapper() {
		
	}
	
	public MapWrapper(Map<String, Object> map) {
		map.entrySet()
		   .stream()
		   .forEach(e -> entries.add(new Entry(e.getKey(), e.getValue())));
	}

	public MapWrapper(List<Entry> entries) {
		this.entries = entries;
	}
	
	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<>();
		entries.stream()
			   .forEach(e -> map.put(e.key, e.value));
		return map;
	}
	
	
}
