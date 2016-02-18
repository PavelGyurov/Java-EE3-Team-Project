package shop.products;

import shop.Product;
import shop.enums.MemoryClass;
import shop.enums.MemoryType;

public class Memory extends Product {
	private int memoryCapacity;
	private MemoryClass memoryClass;
	private MemoryType memoryType;
	private int readingSpeed;
	private int writingSpeed;

	public Memory(String name, String description, String model, int amount,
			double price, int warrantyMonths, int memoryCapacity,
			MemoryClass memoryClass, MemoryType memoryType, int readingSpeed, int writingSpeed) {
		super(name, description, model, amount, price, warrantyMonths);
		this.memoryCapacity = memoryCapacity;
		this.memoryClass = memoryClass;
		this.memoryType = memoryType;
		this.readingSpeed = readingSpeed;
		this.writingSpeed = writingSpeed;
	}

	public int getCapacity() {
		return memoryCapacity;
	}

	public MemoryClass getMemoryClass() {
		return memoryClass;
	}

	public int getReadingSpeed() {
		return readingSpeed;
	}

	public int getWritingSpeed() {
		return writingSpeed;
	}

	public int getMemoryCapacity() {
		return memoryCapacity;
	}

	public void setMemoryCapacity(int memoryCapacity) {
		this.memoryCapacity = memoryCapacity;
	}

	public MemoryType getMemoryType() {
		return memoryType;
	}

	public void setMemoryType(MemoryType memoryType) {
		this.memoryType = memoryType;
	}

	public void setMemoryClass(MemoryClass memoryClass) {
		this.memoryClass = memoryClass;
	}

	public void setReadingSpeed(int readingSpeed) {
		this.readingSpeed = readingSpeed;
	}

	public void setWritingSpeed(int writingSpeed) {
		this.writingSpeed = writingSpeed;
	}

}
