package com.enjoylearning.mybatis.entity;

import java.math.BigDecimal;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_health_report_female
 */
public class THealthReportFemale extends BaseEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_health_report_female.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_health_report_female.item
     *
     * @mbg.generated
     */
    private String item;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_health_report_female.score
     *
     * @mbg.generated
     */
    private BigDecimal score;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_health_report_female.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_health_report_female.id
     *
     * @return the value of t_health_report_female.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_health_report_female.id
     *
     * @param id the value for t_health_report_female.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_health_report_female.item
     *
     * @return the value of t_health_report_female.item
     *
     * @mbg.generated
     */
    public String getItem() {
        return item;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_health_report_female.item
     *
     * @param item the value for t_health_report_female.item
     *
     * @mbg.generated
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_health_report_female.score
     *
     * @return the value of t_health_report_female.score
     *
     * @mbg.generated
     */
    public BigDecimal getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_health_report_female.score
     *
     * @param score the value for t_health_report_female.score
     *
     * @mbg.generated
     */
    public void setScore(BigDecimal score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_health_report_female.user_id
     *
     * @return the value of t_health_report_female.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_health_report_female.user_id
     *
     * @param userId the value for t_health_report_female.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}