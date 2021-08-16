package learning.elastic.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@Document(indexName = "car")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Car {

	@Id
	private String id;

	private boolean available;

	private String brand;

	private String color;
	
	@Field(type=FieldType.Date,format=DateFormat.date)
	@JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Jakarta")
	private LocalDate firstReleaseDate;
	
	
	private int price;
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	private String type;
	
	@JsonInclude(value=Include.NON_EMPTY)
	private List<String> additionalFeature;
	
	
	@JsonInclude(value=Include.NON_EMPTY)
	private String secretFeature;
	
	@JsonUnwrapped
	private Engine engine;
	
	private List<Tire> tires;
	
	public Car() {

	}

	public Car(String brand, String color, String type) {
		super();
		this.brand = brand;
		this.color = color;
		this.type = type;
	}
	
	
	@JsonInclude(value = Include.NON_EMPTY)
	private List<String> additionalFeatures;

	public List<String> getAdditionalFeatures() {
		return additionalFeatures;
	}

	public void setAdditionalFeatures(List<String> additionalFeatures) {
		this.additionalFeatures = additionalFeatures;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public LocalDate getFirstReleaseDate() {
		return firstReleaseDate;
	}

	public void setFirstReleaseDate(LocalDate firstReleaseDate) {
		this.firstReleaseDate = firstReleaseDate;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getAdditionalFeature() {
		return additionalFeature;
	}

	public void setAdditionalFeature(List<String> additionalFeature) {
		this.additionalFeature = additionalFeature;
	}

	public String getSecretFeature() {
		return secretFeature;
	}

	public void setSecretFeature(String secretFeature) {
		this.secretFeature = secretFeature;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public List<Tire> getTires() {
		return tires;
	}

	public void setTires(List<Tire> tires) {
		this.tires = tires;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", available=" + available + ", brand=" + brand + ", color=" + color
				+ ", firstReleaseDate=" + firstReleaseDate + ", price=" + price + ", type=" + type
				+ ", additionalFeature=" + additionalFeature + ", secretFeature=" + secretFeature + "]";
	}
	
	
	
}
