package com.core.exceptions;

/**
 * The type Api field error.
 */
public class ApiFieldError {

    private String field;
    private String code;
    private Object rejectedValue;

    /**
     * Instantiates a new Api field error.
     *
     * @param field         the field
     * @param code          the code
     * @param rejectedValue the rejected value
     */
    public ApiFieldError(String field, String code, Object rejectedValue) {
        this.field = field;
        this.code = code;
        this.rejectedValue = rejectedValue;
    }

    /**
     * Gets field.
     *
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * Sets field.
     *
     * @param field the field
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets rejected value.
     *
     * @return the rejected value
     */
    public Object getRejectedValue() {
        return rejectedValue;
    }

    /**
     * Sets rejected value.
     *
     * @param rejectedValue the rejected value
     */
    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

}
