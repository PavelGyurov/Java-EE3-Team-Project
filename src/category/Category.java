package category;

import java.util.List;

import shop.Product;

public abstract class Category {
	private String name;
	private String description;
	private int level;
	private Category parent;
	private List<Category> leaves;
	private List<Product> products;
	
	// constructors
	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Category(String name, String description, int level) {
		this(name, description);
		this.level = level;
	}
	
	public Category(String name, String description, int level, Category parent) {
		this(name, description, level);
		this.parent = parent;
	}
	
	public Category(String name, String description, int level, List<Category> leaves) {
		this(name, description, level);
		this.leaves = leaves;
	}
	
	public Category(String name, String description, int level, Category parent, List<Category> leaves) {
		this(name, description, level, parent);
		this.leaves = leaves;
	}

	// getters/setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public List<Category> getLeaves() {
		return leaves;
	}

	public void setLeaves(List<Category> leaves) {
		this.leaves = leaves;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	// behavior
	public List<Product> getProductsByCategory(Category category) {
		// TODO
		return null;
	}
	
	public List<Category> getCategoryLeaves(Category parentCategory) {
		// TODO
		return null;
	}
	
	public List<Category> getParentCategory(Category leafCategory) {
		// TODO
		return null;
	}
	
	public Category addCategory(Category parentCategory) {
		// TODO
		// category to be added
		return null;
	}
	
	public Category removeCategory(Category category) {
		// TODO
		// category to be removed
		return null;
	}
	
	public Product addProduct(Product product) {
		// TODO
		// product to be added
		return null;
	}
	
	public Product removeProduct(Product product) {
		// TODO
		// product to be removed
		return null;
	}

}
