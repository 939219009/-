package com.wym.petshop.model;

public class Product {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.productid
     *
     * @mbg.generated Mon Jun 25 22:12:15 CST 2018
     */
    private String productid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.catid
     *
     * @mbg.generated Mon Jun 25 22:12:15 CST 2018
     */
    private String catid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.name
     *
     * @mbg.generated Mon Jun 25 22:12:15 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.descn
     *
     * @mbg.generated Mon Jun 25 22:12:15 CST 2018
     */
    private String descn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.pic
     *
     * @mbg.generated Mon Jun 25 22:12:15 CST 2018
     */
    private String pic;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.productid
     *
     * @return the value of product.productid
     *
     * @mbg.generated Mon Jun 25 22:12:15 CST 2018
     */
    public String getProductid() {
        return productid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.productid
     *
     * @param productid the value for product.productid
     *
     * @mbg.generated Mon Jun 25 22:12:15 CST 2018
     */
    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.catid
     *
     * @return the value of product.catid
     *
     * @mbg.generated Mon Jun 25 22:12:15 CST 2018
     */
    public String getCatid() {
        return catid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.catid
     *
     * @param catid the value for product.catid
     *
     * @mbg.generated Mon Jun 25 22:12:15 CST 2018
     */
    public void setCatid(String catid) {
        this.catid = catid == null ? null : catid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.name
     *
     * @return the value of product.name
     *
     * @mbg.generated Mon Jun 25 22:12:15 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.name
     *
     * @param name the value for product.name
     *
     * @mbg.generated Mon Jun 25 22:12:15 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.descn
     *
     * @return the value of product.descn
     *
     * @mbg.generated Mon Jun 25 22:12:15 CST 2018
     */
    public String getDescn() {
        return descn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.descn
     *
     * @param descn the value for product.descn
     *
     * @mbg.generated Mon Jun 25 22:12:15 CST 2018
     */
    public void setDescn(String descn) {
        this.descn = descn == null ? null : descn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.pic
     *
     * @return the value of product.pic
     *
     * @mbg.generated Mon Jun 25 22:12:15 CST 2018
     */
    public String getPic() {
        return pic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.pic
     *
     * @param pic the value for product.pic
     *
     * @mbg.generated Mon Jun 25 22:12:15 CST 2018
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }
}