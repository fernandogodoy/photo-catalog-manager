package br.fsg.filereader.model;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.fsg.filereader.type.Money;

@Entity
@SequenceGenerator(name = "dir_generator", sequenceName ="dir_seq" , initialValue = 1, allocationSize = 1)
public class Directory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dir_generator")
    private Long id;

    private String description;

    @OneToMany(mappedBy = "directory", targetEntity = Product.class)
    private List<Product> products = new ArrayList<>();

	private Money value;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    
    public Money getValue() {
		return value;
	}
    
    public Directory withDescrition(Path path, String folder){
        Path resolve = path.resolve(folder);
        this.description = resolve.toString();
        return this;
    }
    
    public Path getPath() {
    	return Paths.get(description);
    }
    
	public Directory withValue(Money value) {
		this.value = value;
		return this;
	}

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
    
    public void add(Product product){
        this.products.add(product);
    }
    
    @Override
    public String toString() {
    	return  "Id: " + id + ", description: " + description;
    }



}
