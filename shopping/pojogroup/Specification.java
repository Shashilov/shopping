package com.shopping.pojogroup;

import java.io.Serializable;
import java.util.List;

import com.shopping.pojo.TbSpecification;
import com.shopping.pojo.TbSpecificationOption;

public class Specification implements Serializable{
private TbSpecification tbSpecification;
private List<TbSpecificationOption> specificationOptionlist;
public TbSpecification getTbSpecification() {
	return tbSpecification;
}
public void setTbSpecification(TbSpecification tbSpecification) {
	this.tbSpecification = tbSpecification;
}
public List<TbSpecificationOption> getSpecificationOptionlist() {
	return specificationOptionlist;
}
public void setSpecificationOptionlist(List<TbSpecificationOption> specificationOptionlist) {
	this.specificationOptionlist = specificationOptionlist;
}  

}
