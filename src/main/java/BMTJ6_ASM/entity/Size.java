package BMTJ6_ASM.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Size")
public class Size {
	@Id
	Integer IDSize;
	int Size;
	@JsonIgnore
	@OneToMany(mappedBy = "size")
	List<DSSP> dsSP_theoSize;
	
	public Integer getIDSize() {
		return IDSize;
	}
	
	public void setIDSize(Integer iDSize) {
		IDSize = iDSize;
	}
	
	public int getSize() {
		return Size;
	}
	
	public void setSize(int size) {
		Size = size;
	}
	
	public List<DSSP> getDsSP_theoSize() {
		return dsSP_theoSize;
	}
	
	public void setDsSP_theoSize(List<DSSP> dsSP_theoSize) {
		this.dsSP_theoSize = dsSP_theoSize;
	}

	public Size(Integer iDSize, int size, List<DSSP> dsSP_theoSize) {
		IDSize = iDSize;
		Size = size;
		this.dsSP_theoSize = dsSP_theoSize;
	}

	public Size() {
		
	}
	
}
